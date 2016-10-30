package com.weikun.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/30.
 */
public class BBSUser implements Serializable{
    private int id;
    private String usename;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
