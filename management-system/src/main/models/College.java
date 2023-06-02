package main.models;

public class College {
    //id ,name
    private String id;
    private String name;

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

    public College(){
        this.id = "";
        this.name = "";
    }

    public College(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
