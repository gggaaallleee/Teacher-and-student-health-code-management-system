package main.models;

import java.util.HashMap;

public class Teacher {
    private String name;
    private String idCard;
    private String workNo;
    private String college;
    private String healthCode;
    private String dailycheck;


    public Teacher(){
        this.name = "";
        this.idCard = "";
        this.workNo = "";
        this.college = "";
        this.healthCode = "";
        this.dailycheck = "";
    }
    public Teacher(String name, String idCard, String workNo, String college,  String healthCode, String dailycheck) {
        this.name = name;
        this.idCard = idCard;
        this.workNo = workNo;
        this.college = college;
        this.healthCode = healthCode;
        this.dailycheck = dailycheck;
    }

    // getter and setter ...

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