package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import main.Dao.impl.college_manage_impl;
import main.models.College;
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("FindCollege.do")) {
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent

            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(way!=null&&thing!=null){
                try {
                    List<College> colleges = collegeDao.findCollege(way, thing);
                    request.setAttribute("colleges", colleges);
                    request.getRequestDispatcher("college_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    List<College> colleges = collegeDao.findAllCollege();
                    request.setAttribute("colleges", colleges);
                    request.getRequestDispatcher("college_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if (uri.endsWith("DeleteCollege.do")) {
            String id = request.getParameter("id");
            try {
                collegeDao.deleteCollege(id);
            } catch (Exception e) {
                e.printStackTrace();
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
            } catch (Exception e) {
                e.printStackTrace();
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
