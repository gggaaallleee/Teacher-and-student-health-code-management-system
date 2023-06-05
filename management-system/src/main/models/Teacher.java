package main.models;

import java.util.HashMap;

public class Teacher {
    private String id;
    private String name;
    private String idCard;
    private String workNo;
    private String college;
    private String role;
    private String healthCode;
    private String dailycheck;


    public Teacher(){
        this.id = "";
        this.name = "";
        this.idCard = "";
        this.workNo = "";
        this.college = "";
        this.role = "";
        this.healthCode = "";
        this.dailycheck = "";
    }
    public Teacher(String id, String name, String idCard, String workNo, String college, String role, String healthCode, String dailycheck) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.workNo = workNo;
        this.college = college;
        this.role = role;
        this.healthCode = healthCode;
        this.dailycheck = dailycheck;
    }

    // getter and setter ...
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHealthCode() {
        return healthCode;
    }

    public void setHealthCode(String healthCode) {
        this.healthCode = healthCode;
    }

    public String isDailycheck() {
        return dailycheck;
    }

    public void setDailycheck(String dailycheck) {
        this.dailycheck = dailycheck;
    }
}