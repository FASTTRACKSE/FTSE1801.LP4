package java_tuan2;

import java.util.Scanner;

abstract public class SinhVienFPT {
	 abstract public double getDiemTB();
	private String hoTen;
	private String nganh;
	public SinhVienFPT(String hoTen, String nganh) {
	
		this.hoTen = hoTen;
		this.nganh = nganh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	 String getHocLuc() {
		if(getDiemTB()<5) {
			return"Yếu";
		}
		else if(getDiemTB()<6.5) {
			return"Trung bình.";
		}
		else if(getDiemTB()<7.5) {
			return"Khá.";
		}
		else if(getDiemTB()<9) {
			return"Giỏi.";
		}
		else {
			return"Xuất sắc.";
		}
	}
	public  void xuat() {
		
		System.out.printf("%-3s|%-20s|%10s|%-15s|%-15s \n","STT","Họ và tên","Ngành","Điểm TB","Xếp loại");
		System.out.printf("%-3s|%-20s|%10s|%-15s|%-15s \n","1.", getHoTen(),getNganh(),getDiemTB(),getHocLuc());
		
		
	}
	

}
