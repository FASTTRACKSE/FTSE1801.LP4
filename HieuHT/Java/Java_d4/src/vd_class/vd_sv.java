package vd_class;

import java.util.Scanner;

public class vd_sv {
	String hoten;
	float diemTB;
	String xeploai;
	vd_sv(){
		hoten="Hồ Tấn Hiệu";
		diemTB=8;
	}
	vd_sv(String hoten, float diemTB){
		this.hoten=hoten;
		this.diemTB=diemTB;
	}
	void sethoten(String hoten) {
		this.hoten=hoten;
		
	}
	void setdiemTB(float diemTB) {
		this.diemTB=diemTB;
	}
	String gethoten() {
		return hoten;
	}
	float getdiemTB() {
		return diemTB;
	}
	String xeploai() {
		if(diemTB <5){
			xeploai= " Yếu";

		}
		else if(diemTB<7){
			xeploai= "Trung bình";
		}
		else if(diemTB<7.5){
			xeploai = "Khá";
		}
		else if(diemTB<9){
			xeploai = "Giỏi";
		}
		else {xeploai= "Xuất sắc";}
		return xeploai;
	}
	public static void main(String[]args) {
	vd_sv sv1=new vd_sv();
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Nhập tên sinh viên:");
	String hoten= sc.nextLine();
	sv1.sethoten(hoten);
	System.out.println("Nhập điểm TB của sinh viên:");
	float diemTB=sc.nextFloat();
	sc.nextLine();
	sv1.setdiemTB(diemTB);
	System.out.printf("%-3s|%-20s|%-10s|%-10s| \n","STT", "Họ và tên","điểm TB","Xếp loai");
	System.out.printf("%-3s|%-20s|%-10s|%-10s| \n","1." ,sv1.gethoten(),sv1.getdiemTB(),sv1.xeploai());
	vd_sv sv2=new vd_sv();
	System.out.printf("%-3s|%-20s|%-10s|%-10s| \n","2." ,sv2.gethoten(),sv2.getdiemTB(),sv2.xeploai());
	vd_sv sv3=new vd_sv("Nguyễn Tuấn Phương", 6);
	System.out.println("Nhập tên sinh viên:");
	String hoten1= sc.nextLine();
	sv3.sethoten(hoten1);
	
	System.out.println("Nhập điểm TB của sinh viên:");
	float diemTB1=sc.nextFloat();
	sv1.setdiemTB(diemTB1);
	System.out.printf("%-3s|%-20s|%-10s|%-10s| \n","3." ,sv3.gethoten(),sv3.getdiemTB(),sv3.xeploai());
	
	}
}
