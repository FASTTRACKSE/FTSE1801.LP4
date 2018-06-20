package java_tuan2_day1;

import java.util.Scanner;

public class MyClass1 {
public static void main(String[] args) {
	KeThuaNhanVien tp=new KeThuaNhanVien();
	Scanner sc=new Scanner(System.in);
	System.out.println("- Nhập tên nhân viên:");
	String ten=sc.nextLine();
	tp.setten(ten);
	System.out.println("- Nhập lương nhân viên:");
	double luong=sc.nextDouble();
	tp.setluong(luong);
	System.out.println("- Nhập tiền trách nhiệm nhân viên:");
	double tienTrachNhiem=sc.nextDouble();
	sc.nextLine();
	tp.setTienTrachNhiem(tienTrachNhiem);
	System.out.printf("%-3s|%-20s|%-20s|%-30s \n","STT","Họ và tên","Lương","Thu nhập");
	System.out.printf("%-3s|%-20s|%-20s|%-30s \n","1." ,tp.getten() , tp.getluong(),tp.getThuNhap());
	LaoCong lc=new LaoCong();
	System.out.println("- Nhập tên nhân viên:");
	String ten1=sc.nextLine();
	lc.setten(ten1);
	System.out.println("- Nhập lương nhân viên:");
	double luong1=sc.nextDouble();
	
	lc.setluong(luong1);
	System.out.println("- Nhập số giờ làm thêm:");
	int soGioLamThem=sc.nextInt();
	lc.setSoGioLamThem(soGioLamThem);
	System.out.printf("%-3s|%-20s|%-20s|%-30s \n","STT","Họ và tên","Lương","Thu nhập");
	System.out.printf("%-3s|%-20s|%-20s|%-30s \n","1." ,lc.getten() , lc.getluong(),lc.getThuNhap());

//	tp.setten("Mai Thành Công");
//	tp.setluong(2000000);
//	tp.setTienTrachNhiem(1000000);
//	tp.xuat();
//	LaoCong lc=new LaoCong();
//	lc.setten("Hợi");
//	lc.setluong(5000000);
//	lc.setSoGioLamThem(1000000);
//	lc.xuat();
	
}
}
