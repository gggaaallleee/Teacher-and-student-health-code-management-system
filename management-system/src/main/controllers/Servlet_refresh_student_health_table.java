package main.controllers;

import main.Dao.impl.Student_manage_impl;
import main.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet_refresh_student_health_table")
public class Servlet_refresh_student_health_table extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student_manage_impl student_manage = new Student_manage_impl();
        List<Student> student_list = new ArrayList<Student>();
        student_list = student_manage.findAllStudent();
        request.setAttribute("student_list",student_list);
        request.getRequestDispatcher("health_table1.jsp").forward(request,response);
    }
}
