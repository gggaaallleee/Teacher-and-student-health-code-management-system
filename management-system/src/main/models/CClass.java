package main.models;

public class CClass {
    //Cid,Cname,CstudentNo,Cmajor
    private String name;
    private String Cmajor;

    public CClass(){
        this.name = "";
        this.Cmajor = "";
    }
    public CClass(String name ,String Cmajor) {
        this.name = name;
        this.Cmajor = Cmajor;
    }

    // getter and setter ...


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
