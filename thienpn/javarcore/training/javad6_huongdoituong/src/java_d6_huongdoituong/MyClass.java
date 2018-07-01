package java_d6_huongdoituong;

import java.util.Scanner;

public class MyClass extends NhanVien{

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		NhanVien nv = new NhanVien();
//		System.out.print("Nhập tên: ");
//		String HoTen = sc.nextLine();
//		nv.setHoTen(HoTen);
//		System.out.print("Nhập lương : ");
//		double Luong = sc.nextDouble();
//		nv.setLuong(Luong);
//		System.out.println("Tên nhân viên: " + nv.getHoTen());
//		System.out.println("Lương nhân viên: " + nv.getLuong());
//		System.out.println("thuế thu nhập: " + nv.getthueThuNhap());
//		System.out.println("\n\n");
//
//		// Trưởng Phòng.
//		TruongPhong tp = new TruongPhong();
//		System.out.print("Nhập tên Trưởng Phòng: ");
//
//		tp.setHoTen(sc.nextLine());
//		sc.nextLine();
//		System.out.print("Nhập lương : ");
//		tp.setLuong(sc.nextDouble());
//		System.out.print("Tiền trách nhiệm: ");
//		tp.setTrachNhiem(sc.nextDouble());
//		System.out.println("Tên trưởng phòng: " + tp.getHoTen());
//		System.out.println("Lương trưởng phòng: " + tp.getLuong());
//		System.out.println("Tiền trách nhiệm : " + tp.getTrachNhiem());
//		System.out.println("thuế thu nhập: " + tp.getthueThuNhap());
//		System.out.println("\n\n");
//		// lao công.
//		LaoCong lc = new LaoCong();
//		System.out.print("Nhập tên lao công: ");
//
//		lc.setHoTen(sc.nextLine());
//		sc.nextLine();
//		System.out.print("Nhập lương : ");
//		lc.setLuong(sc.nextDouble());
//		System.out.print("Tiền làm thêm: ");
//		lc.setTienLamThem(sc.nextDouble());
//		System.out.println("Tên trưởng phòng: " + lc.getHoTen());
//		System.out.println("Lương trưởng phòng: " + lc.getLuong());
//		System.out.println("Tiền làm thêm : " + lc.getTienLamThem());
//		System.out.println("thuế thu nhập: " + lc.getthueThuNhap());
		ChuNhat cn = new ChuNhat(6, 2);
		cn.xuat();
		HinhVuong hv = new HinhVuong(3);
		hv.xuat();
		System.out.println("\n");
		sinhvienFPT svIT = new SinhVienIT("Sơn", "cntt", 6, 7, 8);
		svIT.xuat();
		System.out.println("\n");
		sinhvienFPT svBiz = new SinhVienBiz("Hợi", "marketing", 8, 8);
		svBiz.xuat();
	}
}
