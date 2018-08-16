package java_d6_huongdoituong;

import java.util.Scanner;

public class Sinh_Vien {
	// thuộc tính
	String HoTen;
	double diemTB;
	String xeploai;

	Sinh_Vien() {
		HoTen = "Nguyễn Quốc Cường";
		diemTB = 9.5;
	}

	Sinh_Vien(String HoTen, double diemTB) {
		this.HoTen = HoTen;
		this.diemTB = diemTB;

	}

	// phương thức.
	void setHoTen(String HoTen) {
		this.HoTen = HoTen;
	}

	void setdiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	String getHoTen() {
		return HoTen;
	}

	double getdiemTB() {
		return diemTB;
	}

	String xeploai() {
		if (diemTB < 5) {
			xeploai = "yếu";
		} else if (diemTB < 6.5) {
			xeploai = "trung bình";
		} else if (diemTB < 7.5) {
			xeploai = "khá";
		} else if (diemTB < 9) {
			xeploai = "giỏi";
		} else {
			xeploai = "xuất sắc";
		}
		return xeploai;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Sinh_Vien sv = new Sinh_Vien();
		System.out.println("Nhập tên SV: ");
		String HoTen = sc.nextLine();
		sv.setHoTen(HoTen);
		System.out.println("nhập điểm TB: ");
		double diemTB = sc.nextDouble();
		sv.setdiemTB(diemTB);
		System.out.println("ho tên Sv: " + sv.getHoTen());
		System.out.println("diemTB Sv: " + sv.getdiemTB());
		System.out.println("xep loại: " + sv.xeploai());

		Sinh_Vien sv1 = new Sinh_Vien("Phạm Anh Quốc", 7.4);
		System.out.println("ho tên Sv: " + sv1.getHoTen());
		System.out.println("diemTB Sv: " + sv1.getdiemTB());
		System.out.println("xep loại: " + sv1.xeploai());

		Sinh_Vien sv2 = new Sinh_Vien();
		System.out.println("ho tên Sv: " + sv2.HoTen);
		System.out.println("diemTB Sv: " + sv2.diemTB);
		System.out.println("xep loại: " + sv2.xeploai());
	}

}
