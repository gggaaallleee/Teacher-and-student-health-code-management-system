package main.models;

public class account {
    //id,workNo,pwd,role
    private String id;
    private String workNo;
    private String pwd;
    private String role;

    public account(String id, String workNo, String pwd, String role) {
        this.id = id;
        this.workNo = workNo;
        this.pwd = pwd;
        this.role = role;
    }

    public account() {
        this.id = "";
        this.workNo = "";
        this.pwd = "";
        this.role = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
