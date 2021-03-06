package bai4_parent;

public class SinhVien {
	private String name;
	private int age;
	private String address;
	private double gpa;
	private String xepLoai;

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public SinhVien(String name, int age, String address, double gpa) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public SinhVien() {
	}
}
