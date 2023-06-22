package main.controllers;

import main.Dao.impl.Teacher_manage_impl;
import main.Dao.impl.user_manage_impl;
import main.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import main.Dao.impl.Student_manage_impl;

@WebServlet("/Servlet_login_management")
public class Servlet_login_management extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user_manage_impl user_manage = new user_manage_impl();
        List<User> list = new ArrayList<User>();
        list = user_manage.findUser("username",username);
        if (list.size() == 0) {
            //request.setAttribute("msg","用户名不存在");
            System.out.println("用户名不存在");
            request.getRequestDispatcher("user_login.jsp").forward(request,response);
        } else {
            System.out.println("用户存在");
            String sha256Str = getSha256Str(password);
            System.out.println(sha256Str);
            System.out.println(list.get(0).getPassword());
            if (list.get(0).getPassword().equals(sha256Str)) {
                request.getSession().setAttribute("username",username);
                request.getSession().setAttribute("level",list.get(0).getLevel());
                System.out.println("登录成功");
                if(list.get(0).getLevel() == 0 ){
                    Student_manage_impl student_manage = new Student_manage_impl();
                    List<main.models.Student> student_list = new ArrayList<main.models.Student>();
                    student_list = student_manage.findAllStudent();
                    request.setAttribute("studentlist",student_list);
                    Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
                    List<main.models.Teacher> teacher_list = new ArrayList<main.models.Teacher>();
                    teacher_list = teacher_manage.findAllTeacher();
                    request.setAttribute("teacherlist",teacher_list);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }


            } else {
                request.setAttribute("msg","密码错误");
                System.out.println("密码错误");
                request.getRequestDispatcher("user_login.jsp").forward(request,response);
            }
        }
    }
}
