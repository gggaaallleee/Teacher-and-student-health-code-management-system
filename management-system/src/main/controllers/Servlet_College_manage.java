package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import main.Dao.impl.college_manage_impl;
import main.models.College;
import main.models.respond_json;

@WebServlet({"/AddCollege.do", "/FindCollege.do", "/DeleteCollege.do", "/UpdateCollege.do", "/BatchAddCollege.do"})
public class Servlet_College_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// "INSERT INTO College(id,name) VALUES(?,?)";

        String uri = request.getRequestURI();
        college_manage_impl collegeDao = new college_manage_impl();
        if (uri.endsWith("AddCollege.do")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            College college = new College();
            college.setId(id);
            college.setName(name);
            try {
                collegeDao.addCollege(college);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                               e.printStackTrace();
                               respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
        else if (uri.endsWith("FindCollege.do")) {
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent

            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(!"".equals(way) && !"".equals(thing)){
                try {
                    List<College> colleges = collegeDao.findCollege(way, thing);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.setAttribute("colleges", colleges);
                    request.getRequestDispatcher("college_manage.jsp").forward(request, response);
                } catch (Exception e) {
                                   e.printStackTrace();
                                   respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                }
            }
            else{
                try {
                    List<College> colleges = collegeDao.findAllCollege();
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.setAttribute("colleges", colleges);
                    request.getRequestDispatcher("college_manage.jsp").forward(request, response);
                } catch (Exception e) {
                                   e.printStackTrace();
                                   respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                }
            }
        }
        else if (uri.endsWith("DeleteCollege.do")) {
            String id = request.getParameter("id");
            try {
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
                collegeDao.deleteCollege(id);
            } catch (Exception e) {
                               e.printStackTrace();
                               respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
        else if (uri.endsWith("UpdateCollege.do")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            College college = new College();
            college.setId(id);
            college.setName(name);
            try {
                collegeDao.updateCollege(college);
                respond_json respond = new respond_json(0,"success");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                               e.printStackTrace();
                               respond_json respond = new respond_json(1,"failed");
                String json = JSON.toJSONString(respond);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
        else if (uri.endsWith("BatchAddCollege.do")) {
            String txt = request.getParameter("txt");
            String[] lines = txt.split("\n");
            for (String line : lines) {
                String[] items = line.split(" ");
                College college = new College();
                college.setId(items[0]);
                college.setName(items[1]);
                try {
                    collegeDao.addCollege(college);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                } catch (Exception e) {
                    e.printStackTrace();
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                }
            }
        }
    }
}
