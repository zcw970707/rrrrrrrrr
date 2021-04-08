package com.vote.pojo;

public class Users {
    private int vu_user_id;
    private String vu_user_name;
    private String vu_password;
    private String vu_status;//1：管理员   2：普通用户

    public Users() {
    }

    public Users(int vu_user_id, String vu_user_name, String vu_password, String vu_status) {
        this.vu_user_id = vu_user_id;
        this.vu_user_name = vu_user_name;
        this.vu_password = vu_password;
        this.vu_status = vu_status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "vu_user_id=" + vu_user_id +
                ", vu_user_name='" + vu_user_name + '\'' +
                ", vu_password='" + vu_password + '\'' +
                ", vu_status='" + vu_status + '\'' +
                '}';
    }

    public int getVu_user_id() {
        return vu_user_id;
    }

    public void setVu_user_id(int vu_user_id) {
        this.vu_user_id = vu_user_id;
    }

    public String getVu_user_name() {
        return vu_user_name;
    }

    public void setVu_user_name(String vu_user_name) {
        this.vu_user_name = vu_user_name;
    }

    public String getVu_password() {
        return vu_password;
    }

    public void setVu_password(String vu_password) {
        this.vu_password = vu_password;
    }

    public String getVu_status() {
        return vu_status;
    }

    public void setVu_status(String vu_status) {
        this.vu_status = vu_status;
    }
}
