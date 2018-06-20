package quanlysv.quanly;

public class SinhVien {
	private int id;
	private String name;
	private int age;
	private String address;
	private double gba;

	

	public SinhVien(int id, String name, int age, String address, double gba) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gba = gba;
	}
	

	public SinhVien() {
		
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

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGba() {
		return gba;
	}

	public void setGba(double gba) {
		this.gba = gba;
	}

}
