package main.controllers;

import main.Dao.impl.class_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.List;
import main.models.CClass;
@WebServlet({"/AddClass.do", "/FindClass.do", "/DeleteClass.do", "/UpdateClass.do", "/BatchAddClass.do"})
public class Servlet_Class_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //"INSERT INTO Class(id,name,Cmajor) VALUES(?,?,?)"
        String uri = request.getRequestURI();
        class_manage_impl classDao = new class_manage_impl();
        //进行四个操作的时候同时注意，添加数据要注意Major表的name是否有此处的Cmajor，删除数据时联合student表一起删除
        if(uri.endsWith("AddClass.do")){
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String Cmajor = request.getParameter("Cmajor");
            CClass cClass = new CClass();
            cClass.setId(id);
            cClass.setName(name);
            cClass.setCmajor(Cmajor);
            try {
                classDao.addClass(cClass);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else if (uri.endsWith("/UpdateClass.do")){
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String Cmajor = request.getParameter("Cmajor");
            CClass cClass = new CClass();
            cClass.setId(id);
            cClass.setName(name);
            cClass.setCmajor(Cmajor);
            try {

                classDao.updateClass(cClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/DeleteClass.do")){
            String id = request.getParameter("id");
            try {
                classDao.deleteClass(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/FindClass.do")){
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent
            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(way!=null&&thing!=null){
                try {
                    List<CClass> cClass = classDao.findClass(way,thing);
                    request.setAttribute("cClass",cClass);
                    request.getRequestDispatcher("Class_manage.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    List<CClass> cClass = classDao.findAllClass();
                    request.setAttribute("cClass",cClass);
                    request.getRequestDispatcher("Class_manage.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        else if (uri.endsWith("/BatchAddClass.do")){
            String txt = request.getParameter("txt");
            String[] lines = txt.split(";");
            for (String line:lines) {
                String[] words = line.split(",");
                CClass cClass = new CClass();
                cClass.setId(words[0]);
                cClass.setName(words[1]);
                cClass.setCmajor(words[2]);
                try {
                    classDao.addClass(cClass);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("error");
        }




    }
}
