package QuanlySinhVien.sinhvien;

public class SinhVien {
	private int id;
	private String name;
	private int old;
	private String address;
	private double gpa;
	public SinhVien(int id,String name, int old,String address,double gpa) {
		this.id = id;
		this.name = name;
		this.old = old;
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
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
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
