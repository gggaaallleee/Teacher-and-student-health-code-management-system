package main.models;

import java.util.HashMap;

public class Student {
    private String name;
    private String idCard;

    private String StudentNo;
    private String college; //这里链接到学院表
    private String major; //这里链接到专业表
    private String classNo;   //这里链接到班级表
    private String healthCode;
    private String dailycheck;

    public Student() {
        this.name = "";
        this.idCard = "";
        this.StudentNo = "";
        this.college = "";
        this.major = "";
        this.classNo = "";
        this.healthCode = "";
        this.dailycheck = "";
    }
    public Student(String name, String idCard, String StudentNo, String college, String major, String classNo, String healthCode, String dailycheck) {
        this.name = name;
        this.idCard = idCard;
        this.StudentNo = StudentNo;
        this.college = college;
        this.major = major;
        this.classNo = classNo;
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

    public String getStudentNo() {
        return StudentNo;
    }

    public String getWorkNo() {
        return StudentNo;
    }

    public void setWorkNo(String StudentNo) {
        this.StudentNo = StudentNo;
    }

    public void setStudentNo(String StudentNo) {
        this.StudentNo = StudentNo;
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

    public String isDailycheck() {
        return dailycheck;
    }

    public void setDailycheck(String dailycheck) {
        this.dailycheck = dailycheck;
    }
}
