package main.controllers;

import main.Dao.impl.Teacher_manage_impl;
import main.models.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/Servlet_refresh_teacher_college")
public class Servlet_refresh_teacher_college extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tmpcollege session里取值
        HttpSession session = request.getSession();
        String tmpcollege = (String) session.getAttribute("tmpcollege");
        Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
        List<Teacher> teacher_list = new ArrayList<Teacher>();
        teacher_list = teacher_manage.findTeacher("college",tmpcollege);
        request.setAttribute("teacher_list",teacher_list);
        request.getRequestDispatcher("Teacher_table_college.jsp").forward(request,response);
    }
}
