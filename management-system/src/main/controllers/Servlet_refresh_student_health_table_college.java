package main.controllers;

import main.Dao.impl.Student_manage_impl;
import main.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet_refresh_student_health_table_college")
public class Servlet_refresh_student_health_table_college extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tmpcollege = (String) session.getAttribute("tmpcollege");
        Student_manage_impl student_manage = new Student_manage_impl();
        List<Student> student_list = new ArrayList<Student>();
        student_list = student_manage.findStudent("college",tmpcollege);
        request.setAttribute("student_list",student_list);
        request.getRequestDispatcher("health_table_student_college.jsp").forward(request,response);
    }
}
