package main.controllers;

import com.alibaba.fastjson.JSON;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import main.Dao.impl.Teacher_manage_impl;
import main.models.Teacher;
import main.models.respond_json;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet({"/AddTeacher.do", "/FindTeacher.do", "/DeleteTeacher.do", "/UpdateTeacher.do", "/BatchAddTeacher.do"})
public class Servlet_Teacher_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //INSERT INTO Teacher(id,name,idCard,workNo,college,role,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?)";
        Teacher_manage_impl teacherDao = new Teacher_manage_impl();
        //get用utf-8接收
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if(uri.endsWith("AddTeacher.do")){
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String workNo = request.getParameter("workNo");
            String college = request.getParameter("college");
            String role = request.getParameter("role");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            int checkdays = 0;
             healthCode = "green";
             dailycheck = "no";

            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setIdCard(idCard);
            teacher.setWorkNo(workNo);
            teacher.setCollege(college);
            teacher.setRole(role);
            teacher.setHealthCode(healthCode);
            teacher.setDailycheck(dailycheck);
            teacher.setCheckdays(checkdays);
            try {
                teacherDao.addTeacher(teacher);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                //请求到refresh
                request.getRequestDispatcher("/Servlet_refresh_teacher").forward(request,response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }

        }
        else if (uri.endsWith("/UpdateTeacher.do")){
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String workNo = request.getParameter("workNo");
            String college = request.getParameter("college");
            String role = request.getParameter("role");
            List<Teacher> teacherlist = teacherDao.findTeacher("workNo",workNo);
            System.out.println(workNo);
            Teacher teacher1 = teacherlist.get(0);
            int checkdays = teacher1.getCheckdays();
            String  healthCode = teacher1.getHealthCode();
            String  dailycheck = teacher1.getDailycheck();
            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setIdCard(idCard);
            teacher.setWorkNo(workNo);
            teacher.setCollege(college);
            teacher.setRole(role);
            teacher.setHealthCode(healthCode);
            teacher.setDailycheck(dailycheck);
            teacher.setCheckdays(checkdays);
            try {
                teacherDao.updateTeacher(teacher);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Servlet_refresh_teacher").forward(request,response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if(uri.endsWith("/DeleteTeacher.do")){
            String id = request.getParameter("workNo");
            try {
                teacherDao.deleteTeacher(id);
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
        else if(uri.endsWith("/FindTeacher.do")){
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent

            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(!"".equals(way) && !"".equals(thing)){
                try {
                    request.setAttribute("teacherlist", teacherDao.findTeacher(way,thing));
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
                    request.setAttribute("teacherlist", teacherDao.findAllTeacher());
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
        else if(uri.endsWith("/BatchAddTeacher.do")){
            //接受前端传过来的文件流，是txt文件，txt文件内每行字段以空格分割，每行结尾为分号，进行批量添加
            System.out.println("thisisright");
            Part filePart = request.getPart("file"); // "file"是文件在表单中的字段名
            // 将文件转换为Excel Workbook
            InputStream fileContent = filePart.getInputStream();
            Workbook workbook = null;
            System.out.println("thisisright");
            try {
                workbook = Workbook.getWorkbook(fileContent);
            } catch (BiffException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thisisright");
            Sheet sheet = workbook.getSheet(0);
            if(!"name".equals(sheet.getCell(0,0).getContents()) || !"idCard".equals(sheet.getCell(1,0).getContents()) || !"workNo".equals(sheet.getCell(2,0).getContents()) || !"college".equals(sheet.getCell(3,0).getContents()) || !"role".equals(sheet.getCell(4,0).getContents()) ){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Teacher_table.jsp").forward(request,response);
            }
            System.out.println("thisisright");
            for (int i = 1; i < sheet.getRows(); i++) {
                if(!"校级管理员".equals(sheet.getCell(4,i).getContents()) && !"院级管理员".equals(sheet.getCell(4,i).getContents()) && !"普通教师".equals(sheet.getCell(4,i).getContents())){
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Teacher_table.jsp").forward(request,response);
                }
            }
            System.out.println("getit");
            for (int i = 1; i < sheet.getRows(); i++) {
                // 创建一个新的Teacher对象
                Teacher teacher = new Teacher();

                // 设置Teacher对象的各个字段
                teacher.setName(sheet.getCell(0, i).getContents());
                teacher.setIdCard(sheet.getCell(1, i).getContents());
                teacher.setWorkNo(sheet.getCell(2, i).getContents());
                teacher.setCollege(sheet.getCell(3, i).getContents());
                teacher.setRole(sheet.getCell(4, i).getContents());
                teacher.setHealthCode("green");
                teacher.setDailycheck("no");
                teacher.setCheckdays(0);
                try {
                    teacherDao.addTeacher(teacher);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
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
            request.getRequestDispatcher("/Servlet_refresh_teacher").forward(request,response);

        }
    }
}
