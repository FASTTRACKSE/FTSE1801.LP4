package model.bo;

import model.dao.UserDao;
import model.entity.User;
	
public class UserBo {
	private UserDao userDao = new UserDao();
	public boolean checkExsitUser(String userName, String passWord) {
		return userDao.getUser(userName, passWord)!= null;
	}
}
