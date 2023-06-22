package main.controllers;

import main.Dao.impl.major_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_refresh_major")
public class Servlet_refresh_major extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            major_manage_impl major_manage = new major_manage_impl();
            request.setAttribute("major_list",major_manage.findAllMajor());
            request.getRequestDispatcher("major_manage_table.jsp").forward(request,response);
    }
}
