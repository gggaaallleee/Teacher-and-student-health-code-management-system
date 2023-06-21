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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String type = request.getParameter("type");//待定

        if(type=="teacher"){
            Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
            String type1 = "name";
            String type2 = "workNo";
            String type3 = "idCard";
            //username与workNo对应，password与idCard后八位对应，name与iname对应,利用 Teacher_manage_impl内的find type thing
            //若匹配则将username存入session中，跳转到user.jsp
            //若不匹配则跳转到回login_user.jsp，
            //判断方式是查找name，然后把数据库内字段中的workNo和idCard后八位取出来，与前端传来的username和password进行比较


            List<Teacher> list = new ArrayList<Teacher>();
            list = teacher_manage.findTeacher(type1,name);
            if (list.size() == 0) {
                request.setAttribute("msg","姓名不存在");
                request.getRequestDispatcher("web_jsp/login_user.jsp").forward(request,response);
            } else {
                if (list.get(0).getWorkNo().equals(username) && list.get(0).getIdCard().substring(10,18).equals(password)) {
                    request.getSession().setAttribute("username",username);
                    request.getSession().setAttribute("identity",type);
                    request.getRequestDispatcher("web_jsp/user.jsp").forward(request,response);
                } else {
                    request.setAttribute("msg","密码错误");
                    request.getRequestDispatcher("web_jsp/login_user.jsp").forward(request,response);
                }

            }
        }
        else if(type=="student"){
            //username与学号对应，password与身份证后八位对应，name与iname对应,利用 Student_manage_impl内的find type thing
            //若匹配则将username存入session中，跳转到user.jsp
            //若不匹配则跳转到回login_user.jsp，session中包含登陆失败的信息
            //判断方式是查找name，然后把数据库内字段中的workNo和idCard后八位取出来，与前端传来的username和password进行比较
            Student_manage_impl student_manage = new Student_manage_impl();
            String type1 = "name";
            String type2 = "workNo";
            String type3 = "idCard";
            List<Student> list = new ArrayList<Student>();
            list = student_manage.findStudent(type1,name);
            if (list.size() == 0) {
                request.setAttribute("msg","姓名不存在");
                request.getRequestDispatcher("web_jsp/login_user.jsp").forward(request,response);
            } else {
                if (list.get(0).getWorkNo().equals(username) && list.get(0).getIdCard().substring(10,18).equals(password)) {
                    request.getSession().setAttribute("username",username);
                    request.getRequestDispatcher("web_jsp/user.jsp").forward(request,response);
                } else {
                    request.setAttribute("msg","密码错误");
                    request.getRequestDispatcher("web_jsp/login_user.jsp").forward(request,response);
                }

            }
        }
        else{
            request.setAttribute("msg","身份错误");
            request.getRequestDispatcher("web_jsp/login_user.jsp").forward(request,response);//待定
        }

    }
}
