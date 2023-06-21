package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSON;
import main.Dao.impl.user_manage_impl;
import main.models.User;
import main.models.respond_json;

import java.util.List;
@WebServlet({"/AddUser.do", "/FindUser.do", "/DeleteUser.do", "/UpdateUser.do", "/BatchAddUser.do"})
public class Servlet_User_manage extends HttpServlet {
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
        user_manage_impl userDao = new user_manage_impl();
        String uri = request.getRequestURI();
        //String username, String password, int level
        if(uri.endsWith("AddUser.do")){
            String username = request.getParameter("username");
                        String password = request.getParameter("password");
            password = getSha256Str(password);
            String level = request.getParameter("level");
            User user = new User();
            user.setUsername(username);
            user.setPassword(getSha256Str(password));
            user.setLevel(Integer.parseInt(level));
            try {
                userDao.addUser(user);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }

        }
        else if (uri.endsWith("/UpdateUser.do")){
            String username = request.getParameter("username");
                        String password = request.getParameter("password");
            password = getSha256Str(password);
            String level = request.getParameter("level");
            User user = new User();
            user.setUsername(username);
            user.setPassword(getSha256Str(password));
            user.setLevel(Integer.parseInt(level));
            try {
                userDao.updateUser(user);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/DeleteUser.do")){
            String username = request.getParameter("username");
            try {
                userDao.deleteUser(username);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/FindUser.do")){
            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            try {
                List<User> users = userDao.findUser(way,thing);
                String json = JSON.toJSONString(users);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();

            }

    }
        else if (uri.endsWith("/BatchAddUser.do")){
            String users = request.getParameter("users");
            List<User> users1 = JSON.parseArray(users,User.class);
            try {
                userDao.batchAddUser(users1);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
    }
}
