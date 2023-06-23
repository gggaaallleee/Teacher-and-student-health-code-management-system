package main.controllers;
import javax.servlet.http.Part;

//导入jar包 地址是https://mvnrepository.com/artifact/net.sourceforge.jexcelapi/jxl
import java.io.InputStream;
import com.alibaba.fastjson.JSON;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import main.Dao.impl.Student_manage_impl;
import main.models.Student;
import main.models.respond_json;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@MultipartConfig
@WebServlet({"/AddStudent.do", "/FindStudent.do", "/DeleteStudent.do", "/UpdateStudent.do", "/AddStudentBatch.do"})
public class Servlet_student_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student_manage_impl studentDao = new Student_manage_impl();
        String uri = request.getRequestURI();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //INSERT INTO Student(id,name,idCard,studentNo,college,major,classNo,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?,?)
        if(uri.endsWith("/AddStudent.do")){
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String studentNo = request.getParameter("studentNo");
            String college = request.getParameter("college");
            String major = request.getParameter("major");
            String classNo = request.getParameter("classNo");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            int checkdays = 0;
            healthCode = "green";
            dailycheck = "no";
            Student student = new Student();
            student.setName(name);
            student.setIdCard(idCard);
            student.setStudentNo(studentNo);
            student.setCollege(college);
            student.setMajor(major);
            student.setClassNo(classNo);
            student.setHealthCode(healthCode);
            student.setDailycheck(dailycheck);
            student.setCheckdays(checkdays);
            student.setCheckdays(0);
            try {
                studentDao.addStudent(student);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Servlet_refresh_student").forward(request,response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/UpdateStudent.do")){
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String studentNo = request.getParameter("studentNo");
            String college = request.getParameter("college");
            String major = request.getParameter("major");
            String classNo = request.getParameter("classNo");
            List<Student> students = studentDao.findStudent("studentNo",studentNo);
            Student student1 = students.get(0);
            int checkdays= student1.getCheckdays();
            String healthCode = student1.getHealthCode();
            String dailycheck = student1.getDailycheck();
            Student student = new Student();
            student.setName(name);
            student.setIdCard(idCard);
            student.setStudentNo(studentNo);
            student.setCollege(college);
            student.setMajor(major);
            student.setClassNo(classNo);
            student.setHealthCode(healthCode);
            student.setDailycheck(dailycheck);
            student.setCheckdays(checkdays);
            try {
                studentDao.updateStudent(student);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                System.out.println(json);
                System.out.println("success");
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Servlet_refresh_student").forward(request,response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                System.out.println(json);
                System.out.println("failed");
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/DeleteStudent.do")){
            String id = request.getParameter("StudentNo");
            try {
                studentDao.deleteStudent(id);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Servlet_refresh_student").forward(request,response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/FindStudent.do")){
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent
            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(!"".equals(way) && !"".equals(thing)){
                try {
                    request.setAttribute("studentlist", studentDao.findStudent(way,thing));
                    studentDao.findStudent(way,thing);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else{
                try {
                    List<Student> s= studentDao.findAllStudent();
                    request.setAttribute("studentlist",s);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
        }
        else if (uri.endsWith("/AddStudentBatch.do")) {
            //接受前端传过来的文件流，是txt文件，txt文件内每行字段以空格分割，每行结尾为分号，进行批量添加
            //INSERT INTO Student(id,name,idCard,studentNo,college,major,classNo,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?,?)
            Part filePart = request.getPart("file"); // "file"是文件在表单中的字段名
            // 将文件转换为Excel Workbook
            InputStream fileContent = filePart.getInputStream();
            Workbook workbook = null;
            try {
                workbook = Workbook.getWorkbook(fileContent);
            } catch (BiffException e) {
                throw new RuntimeException(e);
            }
            Sheet sheet = workbook.getSheet(0);
            if(!"name".equals(sheet.getCell(0,0).getContents()) || !"idCard".equals(sheet.getCell(1,0).getContents()) || !"studentNo".equals(sheet.getCell(2,0).getContents()) || !"college".equals(sheet.getCell(3,0).getContents()) || !"major".equals(sheet.getCell(4,0).getContents()) || !"class".equals(sheet.getCell(5,0).getContents())){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Student_table.jsp").forward(request,response);
            }
            for (int i = 1; i < sheet.getRows(); i++) {
                // 创建一个新的Student对象
                Student student = new Student();
                // 设置Student对象的各个字段
                student.setName(sheet.getCell(0, i).getContents());
                student.setIdCard(sheet.getCell(1, i).getContents());
                student.setStudentNo(sheet.getCell(2, i).getContents());
                student.setCollege(sheet.getCell(3, i).getContents());
                student.setMajor(sheet.getCell(4, i).getContents());
                student.setClassNo(sheet.getCell(5, i).getContents());
                student.setHealthCode("green");
                student.setDailycheck("no");
                student.setCheckdays(0);
                try {
                    studentDao.addStudent(student);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1, "failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            respond_json respond = new respond_json(0,"success");
            String json = JSON.toJSONString(respond);
            response.setContentType("application/json");
            response.getWriter().write(json);
            request.getRequestDispatcher("/Servlet_refresh_student").forward(request,response);
            fileContent.close();


        }
        else{
            System.out.println("Error: Servlet_student_manage.java");
        }

    }
}
