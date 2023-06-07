package main.controllers;

import main.Dao.impl.Teacher_manage_impl;
import main.models.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
            String role = request.getParameter("role");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setIdCard(idCard);
            teacher.setWorkNo(workNo);
            teacher.setCollege(college);
            teacher.setHealthCode(healthCode);
            teacher.setDailycheck(dailycheck);
            try {
                teacherDao.addTeacher(teacher);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (uri.endsWith("/UpdateTeacher.do")){
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String workNo = request.getParameter("workNo");
            String college = request.getParameter("college");
            String role = request.getParameter("role");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setIdCard(idCard);
            teacher.setWorkNo(workNo);
            teacher.setCollege(college);
            teacher.setHealthCode(healthCode);
            teacher.setDailycheck(dailycheck);
            try {
                teacherDao.updateTeacher(teacher);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(uri.endsWith("/DeleteTeacher.do")){
            String id = request.getParameter("workNo");
            try {
                teacherDao.deleteTeacher(id);
            } catch (Exception e) {
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
                    request.setAttribute("teachers", teacherDao.findTeacher(way,thing));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    request.setAttribute("teachers", teacherDao.findAllTeacher());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if(uri.endsWith("/BatchAddTeacher.do")){
            //接受前端传过来的文件流，是txt文件，txt文件内每行字段以空格分割，每行结尾为分号，进行批量添加


            String txt = request.getParameter("txt");
            String[] lines = txt.split(";");
            for(String line:lines){
                String[] fields = line.split(" ");
                Teacher teacher = new Teacher();
                teacher.setName(fields[0]);
                teacher.setIdCard(fields[1]);
                teacher.setWorkNo(fields[2]);
                teacher.setCollege(fields[3]);
                teacher.setHealthCode(fields[4]);
                teacher.setDailycheck(fields[5]);
                try {
                    teacherDao.addTeacher(teacher);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
