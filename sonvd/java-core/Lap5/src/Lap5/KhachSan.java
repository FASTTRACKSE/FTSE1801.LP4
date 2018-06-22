package Lap5;

import java.util.Scanner;

public class KhachSan {
	private int soNgaytro;
	private String loaiP;
	private double giaP;
	Nguoi nguoi;

	public KhachSan() {

	}

	public KhachSan(int soNgaytro, String loaiP, double giaP, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiP = loaiP;
		this.giaP = giaP;
		this.nguoi = nguoi;
	}

	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin(sc);
		System.out.print("Nhập số ngày thuê: ");
		this.soNgaytro = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhập loại phòng thuê: ");
		this.loaiP = sc.nextLine();
		System.out.print("Nhập giá phòng: ");
		this.giaP = sc.nextDouble();
		sc.nextLine();
	}

	public void hienThongTin() {
		nguoi.hienThongTin();
		System.out.println("Số ngày thuê: " + this.soNgaytro);
		System.out.println("Loại phòng: " + this.loaiP);
		System.out.println("Giá phòng: " + this.giaP);
	}

	public double thanhTien() {
		return this.soNgaytro * this.giaP;
	}

	public Nguoi getKhach() {
		return this.nguoi;
	}

	public void xoa() {
		this.nguoi = new Nguoi();// xoa thong tin ve nguoi
		this.soNgaytro = 0;
		this.loaiP = null;
		this.giaP = 0;
	}

}
