package main.controllers;

import main.Dao.impl.Student_manage_impl;
import main.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/AddStudent.do", "/FindStudent.do", "/DeleteStudent.do", "/UpdateStudent.do", "/BatchAddStudent.do"})
public class Servlet_student_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student_manage_impl studentDao = new Student_manage_impl();
        String uri = request.getRequestURI();
        //INSERT INTO Student(id,name,idCard,studentNo,college,major,classNo,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?,?)
        if(uri.endsWith("/AddStudent.do")){
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String studentNo = request.getParameter("studentNo");
            String college = request.getParameter("college");
            String major = request.getParameter("major");
            String classNo = request.getParameter("classNo");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setIdCard(idCard);
            student.setStudentNo(studentNo);
            student.setCollege(college);
            student.setMajor(major);
            student.setClassNo(classNo);
            student.setHealthCode(healthCode);
            student.setDailycheck(dailycheck);
            try {
                studentDao.addStudent(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/UpdateStudent.do")){
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String idCard = request.getParameter("idCard");
            String studentNo = request.getParameter("studentNo");
            String college = request.getParameter("college");
            String major = request.getParameter("major");
            String classNo = request.getParameter("classNo");
            String healthCode = request.getParameter("healthCode");
            String dailycheck = request.getParameter("dailycheck");
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setIdCard(idCard);
            student.setStudentNo(studentNo);
            student.setCollege(college);
            student.setMajor(major);
            student.setClassNo(classNo);
            student.setHealthCode(healthCode);
            student.setDailycheck(dailycheck);
            try {
                studentDao.updateStudent(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/DeleteStudent.do")){
            String id = request.getParameter("id");
            try {
                studentDao.deleteStudent(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/FindStudent.do")){
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent

            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(way != null && thing != null){
                try {
                    studentDao.findStudent(way,thing);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    studentDao.findAllStudent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if (uri.endsWith("/BatchAddStudent.do")){
            //接受前端传过来的文件流，是txt文件，txt文件内每行字段以空格分割，每行结尾为分号，进行批量添加
            //INSERT INTO Student(id,name,idCard,studentNo,college,major,classNo,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?,?)
            String txt = request.getParameter("txt");
            String[] lines = txt.split(";");
            for(String line : lines){
                String[] fields = line.split(" ");
                Student student = new Student();
                student.setId(fields[0]);
                student.setName(fields[1]);
                student.setIdCard(fields[2]);
                student.setStudentNo(fields[3]);
                student.setCollege(fields[4]);
                student.setMajor(fields[5]);
                student.setClassNo(fields[6]);
                student.setHealthCode(fields[7]);
                student.setDailycheck(fields[8]);
                try {
                    studentDao.addStudent(student);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("Error: Servlet_student_manage.java");
        }

    }
}