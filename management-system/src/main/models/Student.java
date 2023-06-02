package main.models;

import java.util.HashMap;

public class Student {
    private String id;
    private String name;
    private String idCard;



    private String studentNo;
    private String college;
    private String major;
    private String classNo;
    private String healthCode;
    private boolean dailycheck;

    public Student() {
        this.id = "";
        this.name = "";
        this.idCard = "";
        this.studentNo = "";
        this.college = "";
        this.major = "";
        this.classNo = "";
        this.healthCode = "";
        this.dailycheck = false;
    }
    public Student(String id,String name, String idCard, String studentNo, String college, String major, String classNo, String healthCode, boolean dailycheck) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.studentNo = studentNo;
        this.college = college;
        this.major = major;
        this.classNo = classNo;
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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getHealthCode() {
        return healthCode;
    }

    public void setHealthCode(String healthCode) {
        this.healthCode = healthCode;
    }

    public boolean isDailycheck() {
        return dailycheck;
    }

    public void setDailycheck(boolean dailycheck) {
        this.dailycheck = dailycheck;
    }
}
