package bai1_quan_ly_sinh_vien_arrayList;

public class SinhVienArray {
	private String name;
	private int age;
	private String address;
	private double gpa;

	public SinhVienArray() {
	}

	public SinhVienArray(String name, int age, String address, double gpa) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
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

}
