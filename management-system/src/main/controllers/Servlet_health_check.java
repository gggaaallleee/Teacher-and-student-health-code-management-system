package main.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.alibaba.fastjson.JSON;
import main.Dao.impl.Student_manage_impl;
import main.Dao.impl.Teacher_manage_impl;
import main.Dao.impl.health_check_manage_impl;
import main.models.Student;
import main.models.Teacher;
import main.models.health_check;
import main.models.respond_json;


@WebServlet({"/Addhealth_check.do", "/Findhealth_check.do", "/Deletehealth_check.do", "/Updatehealth_check.do", "/BatchAddhealth_check.do"})
public class Servlet_health_check extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected String check_daily_healthcode(String is_in_danger,String is_abroad,String is_contact,String is_confirmed,String vaccine,String[] healthStatus){
        if(is_in_danger.equals("yes")||is_abroad.equals("yes")||(healthStatus.length == 1)){
            return "yellow";
        }
        else if(is_confirmed.equals("yes")||is_contact.equals("yes")||(healthStatus.length >= 2)){
            return "red";
        }
        else if(is_in_danger.equals("no")&&is_abroad.equals("no")&&is_confirmed.equals("no")&&is_contact.equals("no")){
            if(!vaccine.equals("0")){
                return "blue";
            }
            else{
                return "green";
            }
        }
        else{
            return "error";
        }
    }

    protected String check_healthcode_updates(Student student){
        if(student.getHealthCode().equals("red")){
            if(student.getCheckdays() >= 7){
                return "yellow";
            }
            else{
                return "red";
            }
        }
        else if(student.getHealthCode().equals("yellow")){
            if(student.getCheckdays() >= 7){
                return "green";
            }
            else{
                return "yellow";
            }
        }
        else{
            return "notdone";
        }

    }

    protected String check_healthcode_updatet(Teacher teacher){
        if(teacher.getHealthCode().equals("red")){
            if(teacher.getCheckdays() >= 7){
                return "yellow";
            }
            else{
                return "red";
            }
        }
        else if(teacher.getHealthCode().equals("yellow")){
            if(teacher.getCheckdays() >= 7){
                return "green";
            }
            else{
                return "yellow";
            }
        }
        else{
            return "notdone";
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("once");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        health_check_manage_impl health_checkDao = new health_check_manage_impl();
        if (uri.endsWith("Addhealth_check.do")) {
            //session
            String identity = request.getSession().getAttribute("identity").toString();
            System.out.println(identity);
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String number = request.getParameter("number");
            String phone = request.getParameter("phone");
            String is_in_danger = request.getParameter("is_in_danger");
            String is_abroad = request.getParameter("is_abroad");
            String is_contact = request.getParameter("is_contact");
            String is_confirmed = request.getParameter("is_confirmed");
            String vaccine = request.getParameter("vaccine");
            String[] healthStatus = request.getParameterValues("healthStatus");
            System.out.println(healthStatus.length);
            //对healthStatus进行处理，如果选中则置1未选中则置0，生成仅包括0和1的字符串，并保存到health_status中
            //建立list正常,发烧,乏力,干咳,鼻塞,流涕,咽痛,腹泻的列表，如果healthStatus中有则置1，没有则置0
            String health_status = "";
            String[] healthStatusList = {"正常","发烧","乏力","干咳","鼻塞","流涕","咽痛","腹泻"};
            for(int i = 0;i < healthStatusList.length;i++){
                int flag = 0;
                for(int j = 0;j < healthStatus.length;j++){
                    if(healthStatusList[i].equals(healthStatus[j])){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    health_status += "1";
                }
                else{
                    health_status += "0";
                }
            }
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
                System.out.println("添加成功");
                System.out.println(identity);
                if(identity.equals("student")){
                    Student_manage_impl studentDao = new Student_manage_impl();
                    List<Student> tmp = studentDao.findStudent("idcard",id);
                    Student student = tmp.get(0);
                    student.setCheckdays(student.getCheckdays()+1);
                    String check_result = check_daily_healthcode(is_in_danger,is_abroad,is_contact,is_confirmed,vaccine,healthStatus);
                    if(!check_result.equals("green")) student.setCheckdays(0);
                    //如果student的healthcode为green，而checkresult不为green，则将student的healthcode设置为checkresult；如果student的healthcode不为green，则不操作
                    if(student.getHealthCode().equals("green")){
                        if(!check_result.equals("green")) student.setHealthCode(check_result);
                    }

                    String check_result_update = check_healthcode_updates(student);
                    if(!check_result_update.equals("notdone")) student.setHealthCode(check_result_update);
                    student.setDailycheck("yes");
                    studentDao.updateStudent(student);
                    request.getRequestDispatcher("healthy_enter.jsp").forward(request, response);
                }
                else{
                    Teacher_manage_impl teacherDao = new Teacher_manage_impl();
                    List<Teacher> tmp = teacherDao.findTeacher("idcard",id);
                    Teacher teacher = tmp.get(0);
                    teacher.setCheckdays(teacher.getCheckdays()+1);
                    String check_result = check_daily_healthcode(is_in_danger,is_abroad,is_contact,is_confirmed,vaccine,healthStatus);
                    if(!check_result.equals("green")) teacher.setCheckdays(0);
                    //如果student的healthcode为green，而checkresult不为green，则将student的healthcode设置为checkresult；如果student的healthcode不为green，则不操作
                    if(teacher.getHealthCode().equals("green")){
                        if(!check_result.equals("green")) teacher.setHealthCode(check_result);
                    }
                    String check_result_update = check_healthcode_updatet(teacher);
                    if(!check_result_update.equals("notdone")) teacher.setHealthCode(check_result_update);
                    teacher.setDailycheck("yes");
                    teacherDao.updateTeacher(teacher);
                    request.getRequestDispatcher("healthy_enter.jsp").forward(request, response);
                }
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
        else if (uri.endsWith("Findhealth_check.do")) {
            // String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            //如果way和thing有值的话调用findStudent，否则调用findAllStudent
            String way = request.getParameter("way");
            String thing = request.getParameter("thing");
            if(!"".equals(way) && !"".equals(thing)){
                try {
                    List<health_check> health_checks = health_checkDao.findhealth_check(way, thing);
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.setAttribute("health_checks", health_checks);
                    request.getRequestDispatcher("health_check_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
            else {
                try {
                    List<health_check> health_checks = health_checkDao.findAllhealth_check();
                    respond_json respond = new respond_json(0,"success");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    request.setAttribute("health_checks", health_checks);
                    request.getRequestDispatcher("health_check_manage.jsp").forward(request, response);
                } catch (Exception e) {
                    respond_json respond = new respond_json(1,"failed");
                    String json = JSON.toJSONString(respond);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                    e.printStackTrace();
                }
            }
        }
        else if ( uri.endsWith("Deletehealth_check.do")) {
            String id = request.getParameter("id");
            try {
                health_checkDao.deletehealth_check(id);
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

    }
}
