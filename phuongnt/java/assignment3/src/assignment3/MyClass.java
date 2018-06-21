package assignment3;

import java.util.HashMap;
import java.util.Scanner;
import quanLySv.sinhVien.SinhVien;

public class MyClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// NhanVien nv = new NhanVien();
		// System.out.print("Nhập tên NV: ");
		// String HoTen = sc.nextLine();
		// nv.setHoTen(HoTen);
		// System.out.print("Nhập lương : ");
		// double Luong = sc.nextDouble();
		// nv.setLuong(Luong);
		// System.out.println("Tên nhân viên: " + nv.getHoTen());
		// System.out.println("Lương nhân viên: " + nv.getLuong());
		// System.out.println("Thuế thu nhập: " + nv.getThuNhap());
		//
		// // Trưởng Phòng.
		// TruongPhong tp = new TruongPhong();
		// System.out.print("Nhập tên Trưởng Phòng: ");
		//
		// tp.setHoTen(sc.nextLine());
		// sc.nextLine();
		// System.out.print("Nhập lương : ");
		// tp.setLuong(sc.nextDouble());
		// System.out.print("Tiền trách nhiệm: ");
		// tp.setTienTrachNhiem(sc.nextDouble());
		// System.out.println("Tên trưởng phòng: " + tp.getHoTen());
		// System.out.println("Lương trưởng phòng: " + tp.getLuong());
		// System.out.println("Tiền trách nhiệm : " + tp.getTienTrachNhiem());
		// System.out.println("thuế thu nhập: " + tp.getThuNhap());
		//
		// // lao công.
		// laoCong lc = new laoCong();
		// System.out.print("Nhập tên lao công: ");
		//
		// lc.setHoTen(sc.nextLine());
		// sc.nextLine();
		// System.out.print("Nhập lương : ");
		// lc.setLuong(sc.nextDouble());
		// System.out.print("Tiền làm thêm: ");
		// lc.setTienLamThem(sc.nextDouble());
		// System.out.println("Tên trưởng phòng: " + lc.getHoTen());
		// System.out.println("Lương trưởng phòng: " + lc.getLuong());
		// System.out.println("Tiền làm thêm : " + lc.getTienLamThem());
		// System.out.println("thuế thu nhập: " + lc.getThuNhap());

		// ChuNhat cn = new ChuNhat(10, 20);
		// cn.xuat();
		// Vuong hv = new Vuong(4);
		// hv.xuat();

//		DongVat dv = new DongVat("Sư Tử", 4, 2, "gào gào");
//		dv.in();
//		Nhen nhen = new Nhen("Nhện", 8, 6, "gâu gâu");
//		nhen.in();
//		Cua cua = new Cua("Cua", 8, 2, "ẹc ẹc", 8);
//
//		cua.in();
//		Ca ca = new Ca("Cá", 0, 2, "chịu", 1);
//
//		ca.in();
//		Meo meo = new Meo("Mèo", 4, 2, "meo meo", 6);
//
//		meo.in();
		
//		HinhTron ht = new HinhTron(3);
//		ht.xuat();
		
		
	HashMap<String, SinhVien> mapSinhVien = new HashMap<String, SinhVien>();
	SinhVien sv1 = new SinhVien("ftse1", "phuong", 23, "Da Nang", 10);
	SinhVien sv2 = new SinhVien("ftse2", "phuong1", 23, "Da Nang", 10);
	SinhVien sv3 = new SinhVien("ftse3", "phuong2", 23, "Da Nang", 10);
	
	mapSinhVien.put(sv1.getId(), sv1);
	mapSinhVien.put(sv2.getId(), sv2);
	mapSinhVien.put(sv3.getId(), sv3);
	
	
	
	SinhVien sv4 =  mapSinhVien.get("sinh vien 2");
	if(sv4 != null)
		System.out.println(sv4.getName()+ "-"+sv4.getId());
	
	String key = "ftse3";
	SinhVien sv5 =  mapSinhVien.get(key);
	if(sv5 != null)
		System.out.println(sv5.getName()+ "-"+sv5.getId());
	}
	

}
