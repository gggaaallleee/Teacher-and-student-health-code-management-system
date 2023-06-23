package main.controllers;

import main.Dao.impl.user_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet_refresh_schoolsetting")
public class Servlet_refresh_schoolsetting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            user_manage_impl user_manage = new user_manage_impl();
            List<main.models.User> user_list = user_manage.findAllUser();
            request.setAttribute("user_list", user_list);
            request.getRequestDispatcher("schoolSetting_table.jsp").forward(request, response);
    }
}
