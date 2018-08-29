package model.dao;

import model.entity.User;

public class UserDao {
	 public User getUser(String userName, String passWord) {
		 User user = null;
		 if("cong".equals(userName)&& "123".equals(passWord)) {
			 user = new User();
			 user.setUserName("cong");
			 user.setPassWord("123");
			 user.setFullName("Mai Thanh Cong");
			 user.setOld("25");
		 }
		return user;
	 }
}
