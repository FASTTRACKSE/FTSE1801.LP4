package lab3;

import java.util.Scanner;

public class SanPham {
	private String tenSP;
	private double donGia;
	private double giamGia;

	public SanPham() {
	}

	public SanPham(String tenSP, double donGia, double giamGia) {
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public SanPham(String tenSP, double donGia) {
		this(tenSP, donGia, 0);
	}



	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getThueNhapKhau() {
		return donGia * 10 / 100;
	}

	public void xuat() {
		System.out.println("Tên sản phẩm: " + tenSP);
		System.out.println("�?ơn giá: " + donGia);
		System.out.println("Giảm giá: " + giamGia);
		System.out.println("Thuế nhập khẩu: " + getThueNhapKhau());
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập sản phẩm: ");
		tenSP = sc.nextLine();
		System.out.println("Nhập đơn giá: ");
		donGia = sc.nextDouble();
		System.out.println("Nhập giảm giá: ");
		giamGia = sc.nextDouble();
	}

	public static void main(String[] args) {
//		SanPham sp1 = new SanPham();
//		sp1.nhap();
//		sp1.xuat();
//		SanPham sp2 = new SanPham();
//		sp2.nhap();
//		sp2.xuat();
		SanPham sp3 = new SanPham("iphoneX", 30000000);
		sp3.xuat();
		sp3.getThueNhapKhau();
	}
}
