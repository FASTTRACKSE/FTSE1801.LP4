package model.entity;

public class User {
	private String userName;
	private String passWord;
	private String fullName;
	private String old;
	public User() {
	}
	
	public User(String userName, String passWord, String fullName, String old) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.old = old;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
}

