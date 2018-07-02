import java.io.Serializable;

public class Nhanvien implements Serializable {
	private String name;
	private int phoneNumber;
	private String soCMND;
	private String email;

	public Nhanvien(String name, int phoneNumber, String soCMND, String email) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.soCMND = soCMND;
		this.email = email;
	}

	public String toString() {
		return ("Ten:" + name + "\n SDT:" + phoneNumber + "\nSo CMND:" + soCMND + "\nEmail:" + email);
	}

}
