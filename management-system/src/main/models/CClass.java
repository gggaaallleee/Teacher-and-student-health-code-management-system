package main.models;

public class CClass {
    //Cid,Cname,CstudentNo,Cmajor
    private String id;
    private String name;
    private String studentNo;
    private String Cmajor;

    public CClass(){
        this.id = "";
        this.name = "";
        this.studentNo = "";
        this.Cmajor = "";
    }
    public CClass(String id, String name, String studentNo ,String Cmajor) {
        this.id = id;
        this.name = name;
        this.studentNo = studentNo;
        this.Cmajor = Cmajor;
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

    public String getCmajor() {
        return Cmajor;
    }

    public void setCmajor(String cmajor) {
        Cmajor = cmajor;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
