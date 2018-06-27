package sinhVien;

public class SinhVien {
	private String fistName;
	private String lastName;
	private int age;

	public SinhVien() {
	}

	public SinhVien(String fistName, String lastName, int age) {
		super();
		this.fistName = fistName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
