package mangSinhVien;

public class mangSinhVien {

	private String name;
	private int age;
	private String add;
	private double gpa;
	private String type;

	public mangSinhVien() {
	}

	public mangSinhVien(String name, int age, String add, double gpa, String type) {
		super();
		this.name = name;
		this.age = age;
		this.add = add;
		this.gpa = gpa;
		this.type = type;
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

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
