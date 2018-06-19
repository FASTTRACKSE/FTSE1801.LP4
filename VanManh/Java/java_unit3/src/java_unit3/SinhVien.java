package java_unit3;

import java.util.Scanner;

public class SinhVien {
	String hoTen;
	double diemTB;
	SinhVien(String hoTen, double diemTB) {
		this.hoTen = hoTen;
		this.diemTB = diemTB;
	}
	
	SinhVien(){
		hoTen = "Luân";
		diemTB = 8;
	}
	
	void setTen(String hoTen) {
		this.hoTen = hoTen;
	}
	void setDiem(double diemTB) {
		this.diemTB = diemTB;
	}
	
	
	String getTen() {
		return hoTen;
	}	
	
	double getDiem() {
		return diemTB;
	}
	
	String xepLoai(double diemTB) {
		String xepLoai;
		if(diemTB<5) {
			xepLoai = "Yếu";
		}else if(diemTB<6.5) {
			xepLoai = "Trung bình";
		}else if(diemTB<7.5) {
			xepLoai = "Khá";
		}else if(diemTB<9) {
			xepLoai = "Giỏi";
		}else {
			xepLoai = "Xuất sắc";
		}
		return xepLoai;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập họ tên : ");
		String hoTen = input.nextLine();
		System.out.println("Nhập điểm trung bình : ");
		double diemTB = input.nextDouble();
		input.close();
		SinhVien sv1 = new SinhVien(hoTen, diemTB);
		sv1.setTen(hoTen);
		sv1.setDiem(diemTB);
		System.out.println(sv1.getTen() + "-" + sv1.getDiem() + "-" +	sv1.xepLoai(diemTB));
		
		SinhVien sv2 = new SinhVien();
		System.out.println(sv2.getTen() + "-" + sv2.getDiem() + "-" +	sv2.xepLoai(sv2.getDiem()));
	
		
	}
}
