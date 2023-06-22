package main.controllers;

import main.Dao.impl.Teacher_manage_impl;
import main.models.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet_refresh_teacher_health_table_school")
public class Servlet_refresh_teacher_health_table_school extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
        List<Teacher> teacher_list = new ArrayList<Teacher>();
        teacher_list = teacher_manage.findAllTeacher();
        request.setAttribute("teacher_list",teacher_list);
        request.getRequestDispatcher("health_table_teacher.jsp").forward(request,response);
    }
}
