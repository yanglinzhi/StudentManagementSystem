package com.studentManagementSystem.bean;

/**
 * @author ylz
 * @date 2022/7/12 15:22
 */
public class User {
    private int u_id;
    private String u_pwd;
    private String u_phone;

    public int getU_role() {
        return u_role;
    }

    public void setU_role(int u_role) {
        this.u_role = u_role;
    }

    private int u_role;
    private int isdelete;

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    private String u_name;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public User(int u_id,String u_name, String u_pwd, String u_phone, int u_role, int isdelete) {
        this.u_id = u_id;
        this.u_pwd = u_pwd;
        this.u_phone = u_phone;
        this.u_role = u_role;
        this.isdelete = isdelete;
        this.u_name = u_name;
    }

    public User(){

    }
}
