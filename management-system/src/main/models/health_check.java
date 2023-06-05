package main.models;

public class health_check {
    //姓名、身份证号、工号或学号、手机号,是否去过重点疫区？,是否去过国外？,是否接触过新冠确诊病人或疑似病人？,被卫生部门确认为新冠肺炎确诊病例或疑似病例,新冠疫苗打了几针，健康状况（八个值的数组）
    private String name;
    private String id;
    private String number;
    private String phone;
    private String is_in_danger;
    private String is_abroad;
    private String is_contact;
    private String is_confirmed;
    private String vaccine;
    private String health_status;

    public health_check() {
        this.name = "";
        this.id = "";
        this.number = "";
        this.phone = "";
        this.is_in_danger = "";
        this.is_abroad = "";
        this.is_contact = "";
        this.is_confirmed = "";
        this.vaccine = "";
        this.health_status = "";
    }

    public health_check(String name, String id, String number, String phone, String is_in_danger, String is_abroad, String is_contact, String is_confirmed, String vaccine, String health_status) {
        this.name = name;
        this.id = id;
        this.number = number;
        this.phone = phone;
        this.is_in_danger = is_in_danger;
        this.is_abroad = is_abroad;
        this.is_contact = is_contact;
        this.is_confirmed = is_confirmed;
        this.vaccine = vaccine;
        this.health_status = health_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIs_in_danger() {
        return is_in_danger;
    }

    public void setIs_in_danger(String is_in_danger) {
        this.is_in_danger = is_in_danger;
    }

    public String getIs_abroad() {
        return is_abroad;
    }

    public void setIs_abroad(String is_abroad) {
        this.is_abroad = is_abroad;
    }

    public String getIs_contact() {
        return is_contact;
    }

    public void setIs_contact(String is_contact) {
        this.is_contact = is_contact;
    }

    public String getIs_confirmed() {
        return is_confirmed;
    }

    public void setIs_confirmed(String is_confirmed) {
        this.is_confirmed = is_confirmed;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }
}
