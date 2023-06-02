package main.models;

public class Major {
    //Mid,Mname,Mcollege
    private String id;
    private String name;

    private String college;

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Major(){
        this.id = "";
        this.name = "";
        this.college = "";
    }

    public Major(String id, String name, String college) {
        this.id = id;
        this.name = name;
        this.college = college;
    }


}
