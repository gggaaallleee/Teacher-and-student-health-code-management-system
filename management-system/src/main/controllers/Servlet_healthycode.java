package main.controllers;

import main.Dao.impl.Student_manage_impl;
import main.Dao.impl.Teacher_manage_impl;
import main.Dao.impl.health_check_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_healthycode")
public class Servlet_healthycode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        health_check_manage_impl health_check_manage = new health_check_manage_impl();
        //session读username
        String num = (String) request.getSession().getAttribute("username");
        //identity
        String identity = (String) request.getSession().getAttribute("identity");
        if(identity.equals("teacher")){
            Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
            //String name, String idCard, String workNo, String college, String healthCode, String dailycheck, String role, int checkdays
            String name = teacher_manage.findTeacher("workNo",num).get(0).getName();
            String idCard = teacher_manage.findTeacher("workNo",num).get(0).getIdCard();
            String workNo = teacher_manage.findTeacher("workNo",num).get(0).getWorkNo();
            String college = teacher_manage.findTeacher("workNo",num).get(0).getCollege();
            String healthCode =teacher_manage.findTeacher("workNo",num).get(0).getHealthCode();
            String dailycheck = teacher_manage.findTeacher("workNo",num).get(0).getDailycheck();
            String role = teacher_manage.findTeacher("workNo",num).get(0).getRole();

            int checkdays = teacher_manage.findTeacher("workNo",num).get(0).getCheckdays();
            request.setAttribute("name",name);
            request.setAttribute("idCard",idCard);
            request.setAttribute("workNo",workNo);
            request.setAttribute("college",college);
            request.setAttribute("healthCode",healthCode);
            request.setAttribute("dailycheck",dailycheck);
            request.setAttribute("role",role);
            request.setAttribute("checkdays",checkdays);
            request.setAttribute("identity","teacher");
        }
        else if(identity.equals("student")){
            //String name, String idCard, String StudentNo, String college, String major, String classNo, String healthCode, String dailycheck, int checkdays
            Student_manage_impl student_manage = new Student_manage_impl();
            String name = student_manage.findStudent("StudentNo",num).get(0).getName();
            String idCard = student_manage.findStudent("StudentNo",num).get(0).getIdCard();
            String StudentNo = student_manage.findStudent("StudentNo",num).get(0).getStudentNo();
            String college = student_manage.findStudent("StudentNo",num).get(0).getCollege();
            String major = student_manage.findStudent("StudentNo",num).get(0).getMajor();
            String classNo = student_manage.findStudent("StudentNo",num).get(0).getClassNo();
            String healthCode = student_manage.findStudent("StudentNo",num).get(0).getHealthCode();
            String dailycheck = student_manage.findStudent("StudentNo",num).get(0).getDailycheck();

            int checkdays = student_manage.findStudent("StudentNo",num).get(0).getCheckdays();
            request.setAttribute("name",name);
            request.setAttribute("idCard",idCard);
            request.setAttribute("workNo",StudentNo);
            request.setAttribute("college",college);
            request.setAttribute("major",major);
            request.setAttribute("classNo",classNo);
            request.setAttribute("healthCode",healthCode);
            request.setAttribute("dailycheck",dailycheck);
            request.setAttribute("checkdays",checkdays);
            request.setAttribute("identity","student");
            System.out.println(healthCode);
        }

        request.getRequestDispatcher("healthy_code.jsp").forward(request,response);
    }
}
