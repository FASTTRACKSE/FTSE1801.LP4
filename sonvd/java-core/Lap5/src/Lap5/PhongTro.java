package Lap5;

import java.util.Scanner;

public class PhongTro {
	private int soNgayTro;
	private String loaiPhong;
	private double giaPhong;
	Nguoi nguoi;

	public PhongTro(int soNgayTro, String loaiPhong, double giaPhong, Nguoi nguoi) {
		super();
		this.soNgayTro = soNgayTro;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.nguoi = nguoi;
	}

	public PhongTro() {
	}

	public int getSoNgayTro() {
		return soNgayTro;
	}

	public void setSoNgayTro(int soNgayTro) {
		this.soNgayTro = soNgayTro;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public Nguoi getNguoi() {
		return nguoi;
	}

	public void setNguoi(Nguoi nguoi) {
		this.nguoi = nguoi;
	}

	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin();

		System.out.println("Số ngày trọ:  ");
		soNgayTro = sc.nextInt();
		System.out.println("Loại phòng: ");
		loaiPhong = sc.next();
		System.out.println("Giá phòng: ");
		giaPhong = sc.nextDouble();
	}

	public void hienThiThongTin() {
		nguoi.hienThiThongTin();
		System.out.println("Số ngày trọ: " + soNgayTro);
		System.out.println("Loại phòng: " + loaiPhong);
		System.out.println("Giá phòng: " + giaPhong);
	}

	public double thanhTien() {
		return this.soNgayTro * this.giaPhong;
	}

	public Nguoi getKhach() {
		return this.nguoi;
	}

	public void xoaThongTinPhongTro() {
		this.nguoi = null;
		this.soNgayTro = 0;
		this.loaiPhong = null;
		this.giaPhong = 0;
	}

}
