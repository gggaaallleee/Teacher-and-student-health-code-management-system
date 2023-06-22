package main.controllers;

import main.Dao.impl.user_manage_impl;
import main.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet_refresh_schoolsetting_school")
public class Servlet_refresh_schoolsetting_school extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user_manage_impl user_manage = new user_manage_impl();
        List<User> user_list = user_manage.findAllUser();
        request.setAttribute("user_list", user_list);
        request.getRequestDispatcher("schoolSetting_table_school.jsp").forward(request, response);
    }
}
