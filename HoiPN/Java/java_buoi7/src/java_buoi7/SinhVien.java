package java_buoi7;

import java.util.Scanner;

public class SinhVien {
	String hoTen;
	double diemTB;
	String xepLoai;
	
	SinhVien(){
		hoTen ="Phạm Ngọc";
		diemTB = 10;
	}
	
	SinhVien(String hoTen,double diemTB){
		this.hoTen = hoTen;
		this.diemTB = diemTB;
	}
	void sethoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	void setdiemTB(double diemTB) {
		this.diemTB= diemTB;
	}
	String gethoTen() {
		return hoTen;
	}
	double getdiemTB() {
		return diemTB;
	}
	String getxepLoai() {
		if(diemTB>8) {
			xepLoai = "Giỏi";
		}else if(diemTB>7) {
			xepLoai = "Khá";
		}else if(diemTB>5) {
			xepLoai ="TB";
		}else {
			xepLoai = "Yếu";
		}
		return xepLoai;
	}

	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien();
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập họ và tên: ");
		sv1.sethoTen(sc.nextLine());
		System.out.println("Nhập điểm trung bình: ");
		sv1.setdiemTB(sc.nextDouble());
		System.out.printf("%3s|  %-20s| %10s| %10s \n","STT","Họ Tên","ĐTB","xếp loại");
		System.out.printf("%3s|  %-20s| %10s| %10s \n","1",sv1.gethoTen(),sv1.getdiemTB(),sv1.getxepLoai());
		
		SinhVien sv2 = new SinhVien();
		System.out.printf("%3s|  %-20s| %10s| %10s \n","1",sv2.gethoTen(),sv2.getdiemTB(),sv2.getxepLoai());

		SinhVien sv3 = new SinhVien("Phạm",9);
		System.out.printf("%3s|  %-20s| %10s| %10s \n","1",sv3.gethoTen(),sv3.getdiemTB(),sv3.getxepLoai());

		
	}
}
