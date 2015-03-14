package com;

public class LoginToDB implements ActionInter {

	@Override
	public boolean login(User user) throws Exception {

		System.out.println("invocate login in loginToDB");

		if (user.getUsername().equals("123")) {
			System.out.println("return true");
			return true;
		} else {
			System.out.println("return false");
			return false;
		}
	}
}
