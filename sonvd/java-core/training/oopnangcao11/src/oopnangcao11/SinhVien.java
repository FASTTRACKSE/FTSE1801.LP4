package oopnangcao11;

public class SinhVien {
	private String id;
	private String name;
	private int age;
	private double gpa;
	
	public SinhVien() {
		id ="ftse005";
		name = "Hoi";
		
	}
	
	public SinhVien(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SinhVien(String id, String name, int age, double gpa) {
		this(id,name);
		this.age = age;
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
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		System.out.println(sv.id);
		System.out.println(sv.name);
		
	}
}
