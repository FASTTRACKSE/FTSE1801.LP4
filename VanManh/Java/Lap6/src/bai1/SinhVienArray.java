package bai1;

public class SinhVienArray {
	private String name;
	private int age;
	private String address;
	private double gpa;
	private String maSinhVien;

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
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

	public SinhVienArray(String name, String maSinhVien, int age, String address, double gpa) {
		this.name = name;
		this.maSinhVien = maSinhVien;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public SinhVienArray() {
	}
}
