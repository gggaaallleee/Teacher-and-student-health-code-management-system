package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import main.Dao.impl.major_manage_impl;
import main.models.Major;

@WebServlet({"/AddMajor.do", "/FindMajor.do", "/DeleteMajor.do", "/UpdateMajor.do", "/BatchAddMajor.do"})
public class Servlet_Major_manage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String sql = "UPDATE Major SET name=?,college=? WHERE id=?";
        // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
        //如果way和thing有值的话调用findStudent，否则调用findAllStudent
        //传入txt

        String uri = request.getRequestURI();
        major_manage_impl majorDao = new major_manage_impl();
        if (uri.endsWith("AddMajor.do")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String college = request.getParameter("college");
            Major major = new Major();
            major.setId(id);
            major.setName(name);
            major.setCollege(college);
            try {
                majorDao.addMajor(major);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("FindMajor.do")) {
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent

            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(way!=null&&thing!=null){
                try {
                    List<Major> majors = majorDao.findMajor(way, thing);
                    request.setAttribute("majors", majors);
                    request.getRequestDispatcher("major_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    List<Major> majors = majorDao.findAllMajor();
                    request.setAttribute("majors", majors);
                    request.getRequestDispatcher("major_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            } else if (uri.endsWith("DeleteMajor.do")) {
                String id = request.getParameter("id");
                try {
                    majorDao.deleteMajor(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (uri.endsWith("UpdateMajor.do")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String college = request.getParameter("college");
                Major major = new Major();
                major.setId(id);
                major.setName(name);
                major.setCollege(college);
                try {
                    majorDao.updateMajor(major);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (uri.endsWith("BatchAddMajor.do")) {
                String txt = request.getParameter("txt");
                String[] lines = txt.split("\n");
                for (String line : lines) {
                    String[] items = line.split(" ");
                    Major major = new Major();
                    major.setId(items[0]);
                    major.setName(items[1]);
                    major.setCollege(items[2]);
                    try {
                        majorDao.addMajor(major);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
