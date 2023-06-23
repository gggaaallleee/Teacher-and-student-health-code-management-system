package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSON;
import main.Dao.impl.Teacher_manage_impl;
import main.Dao.impl.user_manage_impl;
import main.models.Teacher;
import main.models.User;
import main.models.respond_json;

import java.util.List;
@WebServlet({"/AddUser.do","/AddUser_school.do", "/FindUser.do", "/DeleteUser.do", "/DeleteUser_school.do","/UpdateUser.do","/UpdateUser_school.do", "/BatchAddUser.do"})
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        user_manage_impl userDao = new user_manage_impl();
        String uri = request.getRequestURI();
        //String username, String password, int level
        if(uri.endsWith("AddUser.do")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String level = request.getParameter("level");
            User user = new User();
            user.setUsername(username);
            user.setPassword(getSha256Str(password));
            //如果level为系统管理员，则失败，你不能设置系统管理员，如果为校级管理员，则设置转化level为数字1，如果为院级管理员，则设置转化level为数字2，如果为普通教师，则失败，返回错误信息普通教师不是管理员，请走删除
            if(level.equals("系统管理员")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(level.equals("校级管理员")){
                user.setLevel(1);
                try {
                    userDao.addUser(user);
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> teachers = teacherDao.findTeacher("workNo",username);
                    Teacher teacher = teachers.get(0);
                    teacher.setRole(level);
                    teacherDao.updateTeacher(teacher);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else if(level.equals("院级管理员")){
                user.setLevel(2);
                try {
                    userDao.addUser(user);
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> teachers = teacherDao.findTeacher("workNo",username);
                    Teacher teacher = teachers.get(0);
                    teacher.setRole(level);
                    teacherDao.updateTeacher(teacher);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else if(level.equals("普通教师")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else{
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
        if(uri.endsWith("AddUser_school.do")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String level = request.getParameter("level");
            User user = new User();
            user.setUsername(username);
            user.setPassword(getSha256Str(password));
            //如果level为系统管理员，则失败，你不能设置系统管理员，如果为校级管理员，则设置转化level为数字1，如果为院级管理员，则设置转化level为数字2，如果为普通教师，则失败，返回错误信息普通教师不是管理员，请走删除
            if(level.equals("系统管理员")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(level.equals("校级管理员")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(level.equals("院级管理员")){
                user.setLevel(2);
                try {
                    userDao.addUser(user);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> teachers = teacherDao.findTeacher("workNo",username);
                    Teacher teacher = teachers.get(0);
                    teacher.setRole(level);
                    teacherDao.updateTeacher(teacher);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else if(level.equals("普通教师")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else{
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
        else if (uri.endsWith("/UpdateUser.do")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String level = request.getParameter("level");
            User user = new User();
            user.setUsername(username);
            user.setPassword(getSha256Str(password));

            if(level.equals("系统管理员")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(level.equals("校级管理员")){
                user.setLevel(1);
                try {
                    userDao.updateUser(user);
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> teachers = teacherDao.findTeacher("workNo",username);
                    Teacher teacher = teachers.get(0);
                    teacher.setRole(level);
                    teacherDao.updateTeacher(teacher);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else if(level.equals("院级管理员")){
                user.setLevel(2);
                try {
                    userDao.updateUser(user);
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> teachers = teacherDao.findTeacher("workNo",username);
                    Teacher teacher = teachers.get(0);
                    teacher.setRole(level);
                    teacherDao.updateTeacher(teacher);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else if(level.equals("普通教师")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else{
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
        else if (uri.endsWith("/UpdateUser_school.do")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String level = request.getParameter("level");
            User user = new User();
            user.setUsername(username);
            user.setPassword(getSha256Str(password));

            if(level.equals("系统管理员")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(level.equals("校级管理员")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(level.equals("院级管理员")){
                user.setLevel(2);
                try {
                    userDao.updateUser(user);
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> teachers = teacherDao.findTeacher("workNo",username);
                    Teacher teacher = teachers.get(0);
                    teacher.setRole(level);
                    teacherDao.updateTeacher(teacher);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else if(level.equals("普通教师")){
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else{
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
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
                request.getRequestDispatcher("/Servlet_refresh_schoolsetting").forward(request,response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/DeleteUser_school.do")){
            String username = request.getParameter("username");
            try {
                userDao.deleteUser(username);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("/Servlet_refresh_schoolsetting_school").forward(request,response);
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
        else if (uri.endsWith("/AddUserBatch.do")){
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
