package Lap7;

import java.io.Serializable;

public class nhanvien implements Serializable {
	private String name;
	private String email;
	private String numberPhone;
	private String CMND;

	public nhanvien() {
	}

	public nhanvien(String name, String email, String numberPhone, String cMND) {
		super();
		this.name = name;
		this.email = email;
		this.numberPhone = numberPhone;
		CMND = cMND;
	}

	public void output() {
		System.out.println(name + " " + email + " " + numberPhone + " " + CMND);
	}
}
