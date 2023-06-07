package main.models;

public class Major {
    //Mid,Mname,Mcollege
    private String name;

    private String college;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Major(){
        this.name = "";
        this.college = "";
    }

    public Major(String name, String college) {
        this.name = name;
        this.college = college;
    }


}
