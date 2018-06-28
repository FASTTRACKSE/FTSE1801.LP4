package bai2;

import java.util.Scanner;

public class PhongTro {
	private int soNgaytro;
	private String loaiPhong;
	private double giaPhong;
	Nguoi nguoi;

	public PhongTro() {

	}

	public PhongTro(int soNgaytro, String loaiPhong, double giaPhong, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.nguoi = nguoi;
	}
	
	/**
	 * nhap thong tin phong tro
	 * @param sc
	 */
	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin(sc);
		System.out.print("Nhap so ngay tro: ");
		this.soNgaytro = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap loai phong tro (1: Phong vip, Gia : 1500 | 2: Phong trung binh, gia: 1000 | 3: Phong gia re, gia : 500) ");
		int loaiPhong = sc.nextInt();
		switch (loaiPhong) {
		case 1:
			this.loaiPhong = "Phong vip";
			this.giaPhong = 1500;
			break;
		case 2: 
			this.loaiPhong = "Phong trung binh";
			this.giaPhong = 1000;
			break;
		case 3: 
			this.loaiPhong = "Phong gia re";
			this.giaPhong = 500;
			break;
		default:
			System.out.println("Nhap sai, moi ban nhap lai");
			break;
		}
		System.out.println();
	}

	/**
	 * Hien thong tin phong tro va thong tin nguoi
	 */
	public void hienThongTin() {
		nguoi.hienThongTin();
		System.out.println("So ngay tro: " + this.soNgaytro);
		System.out.println("Loai phong: " + this.loaiPhong);
		System.out.println("Gia phong: " + this.giaPhong);
		System.out.println();
	}

	public double tinhTienTro() {
		return this.soNgaytro * this.giaPhong;
	}

	public Nguoi getKhach() {
		return this.nguoi;
	}
}
