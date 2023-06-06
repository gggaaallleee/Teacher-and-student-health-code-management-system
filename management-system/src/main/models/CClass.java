package main.models;

public class CClass {
    //Cid,Cname,CstudentNo,Cmajor
    private String id;
    private String name;
    private String Cmajor;

    public CClass(){
        this.id = "";
        this.name = "";
        this.Cmajor = "";
    }
    public CClass(String id, String name ,String Cmajor) {
        this.id = id;
        this.name = name;
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


    public String getCmajor() {
        return Cmajor;
    }

    public void setCmajor(String cmajor) {
        Cmajor = cmajor;
    }

}
