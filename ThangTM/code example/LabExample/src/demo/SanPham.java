package demo;

import java.util.Scanner;

public class SanPham {
	private String tenSp;
	private double donGia;
	private double giamGia;

	public SanPham() {
	}

	public SanPham(String tenSp, double donGia, double giamGia) {
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public SanPham(String tenSp, double donGia) {
		this.tenSp = tenSp;
		this.donGia = donGia;
	}

	public double getThueNhapKhau() {
		return donGia * 10 / 100;
	}

	public void xuat() {
		System.out.println("Ten san pham : " + tenSp);
		System.out.println("Don gia : " + donGia);
		System.out.println("Giam gia : " + giamGia);
		System.out.println("Thue nhap khau : " + getThueNhapKhau());
	}

	public void nhap(Scanner scanner) {
		System.out.println("Nhap ten san pham : ");
		tenSp = scanner.nextLine();

		System.out.println("Nhap gia san pham : ");
		donGia = scanner.nextDouble();

		System.out.println("Nhap gia giam san pham : ");
		giamGia = scanner.nextDouble();
		scanner.nextLine();
	}
}
