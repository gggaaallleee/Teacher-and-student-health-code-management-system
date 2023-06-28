package main.controllers;

import main.Dao.impl.class_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_refresh_class")
public class Servlet_refresh_class extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        class_manage_impl cclass_manage = new class_manage_impl();
        request.setAttribute("cclass_list",cclass_manage.findAllClass());
        request.getRequestDispatcher("CClass_manage_table.jsp").forward(request,response);
    }
}
