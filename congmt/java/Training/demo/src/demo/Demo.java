package demo;

public class Demo {
	private int id;
	private String name;
	private int age;
	private String address;
	private double gpa;
	
	public Demo() {

		id = 1;
		name = " Thành Công";
		age = 25;

	}
	public Demo(int id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age = age;

	}

	public Demo(int id, String name, int age, String address, double gpa) {

		this();
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
	public int getAge() {
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
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public static void main(String[] args) {
		Demo sv1=new Demo(1,"Công",25,"Đn",8);
		Demo sv2=new Demo();
		System.out.println( sv1.id);
		System.out.println( sv1.name);
		System.out.println( sv1.age);
		System.out.println( sv1.address);
		System.out.println( sv1.gpa);
		
		
	}
}
