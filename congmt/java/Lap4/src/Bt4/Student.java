package Bt4;

/**
 * Student class
 * 
 * @author viettuts.vn
 */
public class Student {
	private int id;
	private String name;
	private byte age;
	private String address;
	/* điểm trung bình của sinh viên */
	private double gpa;

	public Student() {
	}

	public Student(int id, String name, byte age, String address, float gpa) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
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

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	String getHocLuc() {
		if(getGpa()<5) {
			return"Yếu";
		}
		else if(getGpa()<6.5) {
			return"Trung bình.";
		}
		else if(getGpa()<7.5) {
			return"Khá.";
		}
		else if(getGpa()<9) {
			return"Giỏi.";
		}
		else {
			return"Xuất sắc.";
		}
	}

}
