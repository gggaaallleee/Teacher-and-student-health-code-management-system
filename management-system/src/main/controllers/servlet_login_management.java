package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public static String getSha256Str(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
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
            String sha256Str = getSha256Str(password);
            if (list.get(0).getPassword().equals(sha256Str)) {
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
