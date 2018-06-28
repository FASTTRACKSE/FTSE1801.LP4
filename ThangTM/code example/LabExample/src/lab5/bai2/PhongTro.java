package lab5.bai2;

import java.util.Scanner;

/**
 * Class for contain info Home stay
 * 
 * @author GaLonTon
 *
 */
public class PhongTro {
	private int soNgaytro;
	private String loaiP;
	private double giaP;
	Nguoi nguoi;

	public PhongTro() {

	}

	public PhongTro(int soNgaytro, String loaiP, double giaP, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiP = loaiP;
		this.giaP = giaP;
		this.nguoi = nguoi;
	}

	/**
	 * Set thong tin nguoi thue va so ngay tro
	 * 
	 * @param sc dung cho viec doc data tu ban phim
	 */
	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin(sc);

		System.out.print("Nhap so ngay tro: ");
		this.soNgaytro = sc.nextInt();

		sc.nextLine();
		System.out.print("Nhap loai phong tro: ");
		this.loaiP = sc.nextLine();

		System.out.print("Nhap gia phong: ");
		this.giaP = sc.nextDouble();
		sc.nextLine();
	}

	/**
	 * Hien thi tat ca thong tin cua phong tro Bao gom thong nguoi tro va loai phong
	 * tro
	 */
	public void hienThongTin() {
		nguoi.hienThongTin();
		System.out.println("So ngay tro: " + this.soNgaytro);
		System.out.println("Loai phong: " + this.loaiP);
		System.out.println("Gia phong: " + this.giaP);
	}

	/**
	 * Tinh so tien da o tro
	 * 
	 * @return tong tien o tro
	 */
	public double thanhTien() {
		return this.soNgaytro * this.giaP;
	}

	/**
	 * Get thong tin khach hang dang o phong tro hien tai
	 * 
	 * @return nguoi o tro
	 */
	public Nguoi getKhach() {
		return this.nguoi;
	}

	/**
	 * Ham xoa thong tin cua nguoi thue tro khi tra phong
	 */
	public void xoaThongTinPhongTro() {
		this.nguoi = null;
		this.soNgaytro = 0;
		this.loaiP = null;
		this.giaP = 0;
	}

}
