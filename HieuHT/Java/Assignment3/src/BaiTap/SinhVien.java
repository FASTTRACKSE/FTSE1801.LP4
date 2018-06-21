package BaiTap;

import java.util.ArrayList;

public class SinhVien {
	private String id;
	private String name;
	private int old;
	private String address;
	private double gpa;

	public SinhVien() {
		this.id = id;
		this.name = name;
		this.old = old;
		this.address = address;
		this.gpa = gpa;

	}

	public SinhVien(String id, String name, int old, String address, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.address = address;
		this.gpa = gpa;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String xuat() {
		return "Ten: "+name +"; tuoi: "+old;
	}
	
	public static void main(String[] args) {
		ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();
		SinhVien sv1 = new SinhVien("ftse1", "phuong", 23, "da nang", 6);
		SinhVien sv2 = new SinhVien("ftse2", "hieu", 22, "quang nam", 5);
		listSv.add(sv1);
		listSv.add(sv2);
		for(SinhVien sv:listSv) {
			System.out.println(sv.xuat());
		}
	}
}