package main.controllers;

import com.alibaba.fastjson.JSON;
import main.Dao.impl.class_manage_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.List;
import main.models.CClass;
import main.models.respond_json;

@WebServlet({"/AddClass.do", "/FindClass.do", "/DeleteClass.do", "/UpdateClass.do", "/BatchAddClass.do"})
public class Servlet_Class_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //"INSERT INTO Class(id,name,Cmajor) VALUES(?,?,?)"
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        class_manage_impl classDao = new class_manage_impl();
        //进行四个操作的时候同时注意，添加数据要注意Major表的name是否有此处的Cmajor，删除数据时联合student表一起删除
        if(uri.endsWith("AddClass.do")){
            String name = request.getParameter("name");
            String Cmajor = request.getParameter("Cmajor");
            CClass cClass = new CClass();
            cClass.setName(name);
            cClass.setCmajor(Cmajor);
            //如果不报错，返回json格式中的状态，为result：true
            try {
                classDao.addClass(cClass);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("Servlet_refresh_class").forward(request, response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }


        }
        else if (uri.endsWith("/UpdateClass.do")){
            String name = request.getParameter("name");
            String Cmajor = request.getParameter("Cmajor");
            CClass cClass = new CClass();
            cClass.setName(name);
            cClass.setCmajor(Cmajor);
            try {
                classDao.updateClass(cClass);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                request.getRequestDispatcher("Servlet_refresh_class").forward(request, response);
            } catch (Exception e) {
                respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("/DeleteClass.do")){
            String name = request.getParameter("name");
            try {
                classDao.deleteClass(name);
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
        else if (uri.endsWith("/FindClass.do")){
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent
            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(!"".equals(way) && !"".equals(thing)){
                try {
                    List<CClass> cClass = classDao.findClass(way,thing);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.setAttribute("cClass",cClass);
                    request.getRequestDispatcher("Class_manage.jsp").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else{
                try {
                    List<CClass> cClass = classDao.findAllClass();
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.setAttribute("cClass",cClass);
                    request.getRequestDispatcher("Class_manage.jsp").forward(request,response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
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
                cClass.setName(words[0]);
                cClass.setCmajor(words[1]);
                try {
                    classDao.addClass(cClass);
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
        else{
            System.out.println("error");
        }




    }
}
