package main.models;

public class CClass {
    //Cid,Cname,CstudentNo
    private String id;
    private String name;
    private String studentNo;

    public CClass(){
        this.id = "";
        this.name = "";
        this.studentNo = "";
    }
    public CClass(String id, String name, String studentNo) {
        this.id = id;
        this.name = name;
        this.studentNo = studentNo;
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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
