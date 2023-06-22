package main.controllers;

import main.Dao.impl.Student_manage_impl;
import main.Dao.impl.Teacher_manage_impl;
import main.models.Teacher;
import main.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/Servlet_login_user")
public class Servlet_login_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        //如果name位null就赋值为“null”
        String type = request.getParameter("type");//待定
        if(type == null){
            type = "null";
        }
        if(type.equals("teacher")){
            Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
            String type1 = "name";
            String type2 = "workNo";
            String type3 = "idCard";
            List<Teacher> list = new ArrayList<Teacher>();
            list = teacher_manage.findTeacher(type1,name);
            if (list.size() == 0) {
                request.setAttribute("msg","姓名不存在");
                request.getRequestDispatcher("user_login.jsp").forward(request,response);
            } else {
                if (list.get(0).getWorkNo().equals(username) && list.get(0).getIdCard().substring(10,18).equals(password)) {
                    request.getSession().setAttribute("username",username);
                    request.getSession().setAttribute("identity",type);
                    request.getRequestDispatcher("healthy_enter.jsp").forward(request,response);
                } else {
                    request.setAttribute("msg","密码错误");
                    request.getRequestDispatcher("user_login.jsp").forward(request,response);
                }

            }
        }
        else if(type.equals("student")){
            Student_manage_impl student_manage = new Student_manage_impl();
            String type1 = "name";
            String type2 = "workNo";
            String type3 = "idCard";
            List<Student> list = new ArrayList<Student>();
            list = student_manage.findStudent(type1,name);
            System.out.println("thisway1");
            if (list.size() == 0) {
                request.setAttribute("msg","姓名不存在");
                System.out.println("thisway2");
                request.getRequestDispatcher("user_login.jsp").forward(request,response);
            } else {
                if (list.get(0).getWorkNo().equals(username) && list.get(0).getIdCard().substring(10,18).equals(password)) {
                    request.getSession().setAttribute("username",username);System.out.println("thisway3");
                    request.getRequestDispatcher("healthy_enter.jsp").forward(request,response);
                } else {
                    System.out.println("thisway4");
                    request.setAttribute("msg","密码错误");
                    request.getRequestDispatcher("user_login.jsp").forward(request,response);
                }
            }
        }


    }
}
