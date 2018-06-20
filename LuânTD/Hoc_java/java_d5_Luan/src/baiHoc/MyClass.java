package baiHoc;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten truong phong: ");
		String name = sc.nextLine();
		System.out.print("Nhap luong truong phong: ");
		double money = sc.nextDouble();
		System.out.print("Nhap tien trach nhiem: ");
		int money1 = sc.nextInt();
		TruongPhong tp = new TruongPhong();
		tp.setHoTen(name);
		tp.setLuong(money);
		tp.setTrachNhiem(money1);
		System.out.println(tp.getHoTen() + " | " + tp.getLuong() + " | " + tp.getTrachNhiem() + " | " + tp.thueThuNhap());
		System.out.println();
		sc.nextLine();

		System.out.print("Nhap ten lao cong: ");
		String namelc = sc.nextLine();
		System.out.print("Nhap luong lao cong: ");
		double moneylc = sc.nextDouble();
		System.out.print("Nhap tien lam them: ");
		int money1lc = sc.nextInt();
		LaoCong lc = new LaoCong();
		lc.setHoTen(namelc);
		lc.setLuong(moneylc);
		lc.setLamthem(money1lc);
		System.out.println(lc.getHoTen() + " | " + lc.getLuong() + " | " + lc.getLamthem() + " | " + lc.thueThuNhap());
		System.out.println();
		sc.nextLine();

		System.out.print("Nhap ten nhan vien: ");
		String namenv = sc.nextLine();
		System.out.print("Nhap luong nhan vien: ");
		double moneynv = sc.nextDouble();
		NhanVien nv = new NhanVien();
		nv.setHoTen(namenv);
		nv.setLuong(moneynv);
		System.out.println(lc.getHoTen() + " | " + lc.getLuong() + " | " + lc.thueThuNhap());

		sc.close();
	}

}
