package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import main.Dao.impl.health_check_manage_impl;
import main.models.health_check;


@WebServlet(name = "Servlet_health_check", value = "/Servlet_health_check")
public class Servlet_health_check extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//String sql = "INSERT INTO health_check(name,id,number,phone,is_in_danger,is_abroad,is_contact,is_confirmed,vaccine,health_status) VALUES(?,?,?,?,?,?,?,?,?,?)";

        String uri = request.getRequestURI();
        health_check_manage_impl health_checkDao = new health_check_manage_impl();
        if (uri.endsWith("Addhealth_check.do")) {
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String number = request.getParameter("number");
            String phone = request.getParameter("phone");
            String is_in_danger = request.getParameter("is_in_danger");
            String is_abroad = request.getParameter("is_abroad");
            String is_contact = request.getParameter("is_contact");
            String is_confirmed = request.getParameter("is_confirmed");
            String vaccine = request.getParameter("vaccine");
            String health_status = request.getParameter("health_status");
            health_check health_check = new health_check();
            health_check.setName(name);
            health_check.setId(id);
            health_check.setNumber(number);
            health_check.setPhone(phone);
            health_check.setIs_in_danger(is_in_danger);
            health_check.setIs_abroad(is_abroad);
            health_check.setIs_contact(is_contact);
            health_check.setIs_confirmed(is_confirmed);
            health_check.setVaccine(vaccine);
            health_check.setHealth_status(health_status);
            try {
                health_checkDao.addhealth_check(health_check);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("Findhealth_check.do")) {
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent

            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(way!=null&&thing!=null){
                try {
                    List<health_check> health_checks = health_checkDao.findhealth_check(way, thing);
                    request.setAttribute("health_checks", health_checks);
                    request.getRequestDispatcher("health_check_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    List<health_check> health_checks = health_checkDao.findAllhealth_check();
                    request.setAttribute("health_checks", health_checks);
                    request.getRequestDispatcher("health_check_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if ( uri.endsWith("Deletehealth_check.do")) {
            String id = request.getParameter("id");
            try {
                health_checkDao.deletehealth_check(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("Updatehealth_check.do")) {
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String number = request.getParameter("number");
            String phone = request.getParameter("phone");
            String is_in_danger = request.getParameter("is_in_danger");
            String is_abroad = request.getParameter("is_abroad");
            String is_contact = request.getParameter("is_contact");
            String is_confirmed = request.getParameter("is_confirmed");
            String vaccine = request.getParameter("vaccine");
            String health_status = request.getParameter("health_status");
            health_check health_check = new health_check();
            health_check.setName(name);
            health_check.setId(id);
            health_check.setNumber(number);
            health_check.setPhone(phone);
            health_check.setIs_in_danger(is_in_danger);
            health_check.setIs_abroad(is_abroad);
            health_check.setIs_contact(is_contact);
            health_check.setIs_confirmed(is_confirmed);
            health_check.setVaccine(vaccine);
            health_check.setHealth_status(health_status);
            try {
                health_checkDao.updatehealth_check(health_check);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.endsWith("BatchAddhealth_check.do")){
            String txt = request.getParameter("txt");
            String[] lines = txt.split("\n");
            for (String line : lines) {
                String[] items = line.split(" ");
                health_check health_check = new health_check();
                health_check.setName(items[0]);
                health_check.setId(items[1]);
                health_check.setNumber(items[2]);
                health_check.setPhone(items[3]);
                health_check.setIs_in_danger(items[4]);
                health_check.setIs_abroad(items[5]);
                health_check.setIs_contact(items[6]);
                health_check.setIs_confirmed(items[7]);
                health_check.setVaccine(items[8]);
                health_check.setHealth_status(items[9]);
                try {
                    health_checkDao.addhealth_check(health_check);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
