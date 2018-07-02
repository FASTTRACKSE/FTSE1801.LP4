

/**
 * Student class
 * 
 * @author CôngMT
 */
public class Student {
	private String id;
	private String name;
	private int age;
	private String address;
	/* điểm trung bình của sinh viên */
	private float gpa;

	public Student() {
	}

	public Student(String id, String name, int age, String address, float gpa) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
}
