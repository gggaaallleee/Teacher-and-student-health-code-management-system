package main.controllers;

import main.Dao.impl.Teacher_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet_refresh_teacher")
public class Servlet_refresh_teacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
        List<main.models.Teacher> teacher_list = new ArrayList<main.models.Teacher>();
        teacher_list = teacher_manage.findAllTeacher();
        request.setAttribute("teacherlist",teacher_list);
        request.getRequestDispatcher("Teacher_table.jsp").forward(request,response);
    }
}
