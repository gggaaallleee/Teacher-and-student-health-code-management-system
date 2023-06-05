package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Dao.impl.user_manage_impl;
import main.models.Student;
import main.models.User;

@WebServlet("/servlet_login_management")
public class servlet_login_management extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //读取User中的password与访问user数据库的username的passwprd进行匹配，若匹配则将username，level存入session中，跳转到manage.jsp
        //若不匹配则跳转到回login.jsp，session中包含登陆失败的信息

        user_manage_impl user_manage = new user_manage_impl();
        String type = "username";
        List<User> list = new ArrayList<User>();
        list = user_manage.findUser(type,username);
        if (list.size() == 0) {
            request.setAttribute("msg","用户名不存在");
            request.getRequestDispatcher("web_jsp/login.jsp").forward(request,response);
        } else {
            if (list.get(0).getPassword().equals(password)) {
                request.getSession().setAttribute("username",username);
                request.getSession().setAttribute("level",list.get(0).getLevel());
                request.getRequestDispatcher("web_jsp/manage.jsp").forward(request,response);
            } else {
                request.setAttribute("msg","密码错误");
                request.getRequestDispatcher("web_jsp/login.jsp").forward(request,response);
            }
        }










    }
}
