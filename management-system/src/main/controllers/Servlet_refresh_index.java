package main.controllers;

import main.Dao.impl.Student_manage_impl;
import main.Dao.impl.Teacher_manage_impl;
import main.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/Servlet_refresh_index","/Servlet_refresh_index_school","/Servlet_refresh_index_college"})
public class Servlet_refresh_index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if(uri.endsWith("/Servlet_refresh_index")){
            Student_manage_impl student_manage = new Student_manage_impl();
            List<Student> student_list = new ArrayList<Student>();
            student_list = student_manage.findAllStudent();
            request.setAttribute("studentlist",student_list);
            Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
            List<main.models.Teacher> teacher_list = new ArrayList<main.models.Teacher>();
            teacher_list = teacher_manage.findAllTeacher();
            request.setAttribute("teacherlist",teacher_list);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if(uri.endsWith("/Servlet_refresh_index_school")){
            Student_manage_impl student_manage = new Student_manage_impl();
            List<Student> student_list = new ArrayList<Student>();
            student_list = student_manage.findAllStudent();
            request.setAttribute("studentlist",student_list);
            Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
            List<main.models.Teacher> teacher_list = new ArrayList<main.models.Teacher>();
            teacher_list = teacher_manage.findAllTeacher();
            request.setAttribute("teacherlist",teacher_list);
            request.getRequestDispatcher("index_school.jsp").forward(request,response);
        }
        else if(uri.endsWith("/Servlet_refresh_index_college")){
            String tmpcollege = request.getSession().getAttribute("tmpcollege").toString();
            Teacher_manage_impl teacher_manage = new Teacher_manage_impl();
            List<main.models.Teacher> teacher_list = new ArrayList<main.models.Teacher>();
            teacher_list = teacher_manage.findTeacher("college",tmpcollege);
            request.setAttribute("teacherlist",teacher_list);
            Student_manage_impl student_manage = new Student_manage_impl();
            List<main.models.Student> student_list = new ArrayList<main.models.Student>();
            student_list = student_manage.findStudent("college",tmpcollege);
            request.setAttribute("studentlist",student_list);
            request.getRequestDispatcher("index_college.jsp").forward(request,response);
        }
    }
}
