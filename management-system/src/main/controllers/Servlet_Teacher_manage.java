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
        String uri = request.getRequestURI();
        if(uri.endsWith("AddTeacher.do")){
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String workNo = request.getParameter("workNo");
            String college = request.getParameter("college");
            //role
            String role = request.getParameter("role");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            int checkdays = 0;
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
            //role
            String role = request.getParameter("role");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            String checkdays_temp = request.getParameter("checkdays");
            List<Teacher> teacherlist = teacherDao.findTeacher("workNo",workNo);
            Teacher teacher1 = teacherlist.get(0);
            int checkdays;
            if(checkdays_temp.equals(null)){
                checkdays = teacher1.getCheckdays();
            }
            else{
                checkdays = Integer.parseInt(checkdays_temp);
            }
            if(healthCode.equals(null)){
                healthCode = teacher1.getHealthCode();
            }
            if(dailycheck.equals(null)){
                dailycheck = teacher1.getDailycheck();
            }
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


            Part filePart = request.getPart("file"); // "file"是文件在表单中的字段名

            // 将文件转换为Excel Workbook
            InputStream fileContent = filePart.getInputStream();
            Workbook workbook = null;
            try {
                workbook = Workbook.getWorkbook(fileContent);
            } catch (BiffException e) {
                throw new RuntimeException(e);
            }

            // 遍历Workbook中的所有行，并打印出来
            Sheet sheet = workbook.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++) {
                // 创建一个新的Teacher对象
                Teacher teacher = new Teacher();

                // 设置Teacher对象的各个字段
                teacher.setName(sheet.getCell(0, i).getContents());
                teacher.setIdCard(sheet.getCell(1, i).getContents());
                teacher.setWorkNo(sheet.getCell(2, i).getContents());
                teacher.setCollege(sheet.getCell(3, i).getContents());
                //role
                teacher.setRole(sheet.getCell(4, i).getContents());
                teacher.setHealthCode(sheet.getCell(5, i).getContents());
                teacher.setDailycheck(sheet.getCell(6, i).getContents());
                teacher.setCheckdays(0);
                try {
                    teacherDao.addTeacher(teacher);
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
    }
}
