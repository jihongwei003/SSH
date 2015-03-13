package com.hibtest1.entity;

import java.io.Serializable;

public class Users implements Serializable{

	private int id;
    private String loginName;
    private String loginPwd;

    public Users(){
    }
    
    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //loginName
    public String getLoginName() {
        return loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    
    //loginPwd
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
   
}
