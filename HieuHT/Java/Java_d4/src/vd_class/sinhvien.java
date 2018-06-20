package vd_class;

import java.util.Scanner;

public class sinhvien {
	
	String ten;
	int tuoi;
	String diachi;
	String gioitinh;
	long luong;
	
	sinhvien(){
		ten = "Hồ Tấn Hiệu";
		tuoi = 21;
		diachi = "Quảng Nam";
		gioitinh = "Nam";
		luong = 5000000;
	}
	sinhvien(String ten, int tuoi, String diachi, String gioitinh, long luong){
		this.ten= ten;
		this.tuoi= tuoi;
		this.diachi= diachi;
		this.gioitinh= gioitinh;
		this.luong= luong;
	}
	
	void setten(String ten) {
		this.ten = ten;
	}
	void settuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	void setdiachi(String diachi) {
		this.diachi = diachi;
	}
	void setgioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	void setluong (long luong) {
		this.luong = luong;
	}
	String getten(){
		return ten;
	}
	int gettuoi() {
		return tuoi;
	}
	String getdiachi() {
		return diachi;
	}
	String getgioitinh() {
		return gioitinh;
	}
	long getluong() {
		return luong;
	}
	public static void main (String[] args) {
		sinhvien sv1 = new sinhvien();
		System.out.printf("%3s| %-30s| %4s| %10s| %10s| %-8s| \n","STT","Họ Và Tên","Tuổi","Địa chỉ","Giới tính","Lương");
		System.out.printf("%3s| %-30s| %4s| %10s| %10s| %-8s| \n","1",sv1.getten(),sv1.gettuoi(),sv1.getdiachi(),sv1.getgioitinh(),sv1.getluong());
		sinhvien sv2 = new sinhvien("Nguyễn Tuấn Phương",22,"Đà Nẵng","Nam",5000000);
		System.out.printf("%3s| %-30s| %4s| %10s| %10s| %-8s| \n","2",sv2.getten(),sv2.gettuoi(),sv2.getdiachi(),sv2.getgioitinh(),sv2.getluong());
		sinhvien sv3 = new sinhvien("Huỳnh Khánh Hưng",29,"Đà Nẵng","Nam",6000000);
		System.out.printf("%3s| %-30s| %4s| %10s| %10s| %-8s| \n","3",sv3.getten(),sv3.gettuoi(),sv3.getdiachi(),sv3.getgioitinh(),sv3.getluong());
	}
}
