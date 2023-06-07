package main.models;

public class respond_json {
    //状态码，描述
    private int code;
    private String msg;

    public respond_json(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public respond_json(){
        this.code = 0;
        this.msg = "success";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
