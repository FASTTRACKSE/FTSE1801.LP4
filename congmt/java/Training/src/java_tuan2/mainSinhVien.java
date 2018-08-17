package java_tuan2;

import java.util.Scanner;

public class mainSinhVien {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	
	System.out.println("-Nhập tên sinh viên:");
	String hoTen=sc.nextLine();
	System.out.println("-Nhập ngành sinh viên:");
	String nganh=sc.nextLine();
	System.out.println("-Nhập điểm java:");
	double java=sc.nextDouble();
	System.out.println("-Nhập điểm html:");
	double html=sc.nextDouble();
	System.out.println("-Nhập điểm css:");
	double css=sc.nextDouble();
	sc.nextLine();
	
	SinhVienIt sinhvien=new SinhVienIt(hoTen, nganh, java, html, css);
	sinhvien.xuat();
	
	System.out.println("-Nhập tên sinh viên:");
	String hoTen1=sc.nextLine();
	System.out.println("-Nhập ngành sinh viên:");
	String nganh1=sc.nextLine();
	System.out.println("-Nhập điểm Maketting:");
	double diemMaketting=sc.nextDouble();
	System.out.println("-Nhập điểm Sales:");
	double diemSales=sc.nextDouble();
	
	
	SinhVienBiz sinhvien1=new SinhVienBiz(hoTen1, nganh1, diemMaketting,diemSales);
	sinhvien1.xuat();
}
}
