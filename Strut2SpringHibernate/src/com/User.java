package com;

//基于model的驱动
public class User {
	private int id;
	private String loginName;
	private String loginPwd;
	
	//id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
}
