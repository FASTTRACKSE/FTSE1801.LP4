package lap;

public class MangSinhVien {
	private String name;
	private double gpa;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public  MangSinhVien[] listSinhVien = new MangSinhVien[100];

}
