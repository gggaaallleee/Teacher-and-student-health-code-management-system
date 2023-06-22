package main.controllers;

import main.Dao.impl.college_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_refresh_college")
public class Servlet_refresh_college extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        college_manage_impl college_manage = new college_manage_impl();
        request.setAttribute("college_list",college_manage.findAllCollege());
        request.getRequestDispatcher("college_manage_table.jsp").forward(request,response);
    }
}
