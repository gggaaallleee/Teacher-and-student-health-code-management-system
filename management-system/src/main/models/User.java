package main.models;

public class User {
    //id，用户名，密码，权限等级
    private String id;
    private String username;
    private String password;
    private int level;

    public User(String id, String username, String password, int level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public User() {
        this.id = "";
        this.username = "";
        this.password = "";
        this.level = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
// getter and setter ...\

}
