import java.util.Scanner;

public class SinhVien {
	int id;
	String name;
	int age;
	String address;
	double gpa;
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
	public void nhap() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập id: ");
		id = (sc.nextInt());
		System.out.println("Nhập tên sinh viên: ");
		name = (sc.nextLine());
		System.out.println("Nhập tuổi: ");
		age = (sc.nextInt());
		System.out.println("Nhập địa chỉ: ");
		address = (sc.nextLine());
		System.out.println("Nhập điểm trung bình: ");
		gpa = (sc.nextDouble());
		sc.nextLine();
	}
	public 
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien();
		sv1.nhap();

	}
}
