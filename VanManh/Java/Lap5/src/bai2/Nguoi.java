package bai2;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	private String soCMND;

	public Nguoi() {

	}

	public Nguoi(String hoTen, Date ngaySinh, String soCMND) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
	}
	
	/**
	 * Nhap thong tin khach tro
	 * @param sc
	 */
	public void nhapThongTin(Scanner sc) {
		sc.nextLine();
		System.out.print("Nhap ho va ten khach hang: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhap ngay sinh(dd-MM-yyyy): ");
		String ns = sc.nextLine();
		this.ngaySinh = chuyenStringDate(ns);
		System.out.print("Nhap so chung minh nhan dan: ");
		this.soCMND = sc.nextLine();
	}
	
	/**
	 * Hien thi thong tin khach tro
	 */
	public void hienThongTin() {
		System.out.println("Ho va Ten: " + this.hoTen);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		System.out.println("Ngay sinh: " + sdf.format(ngaySinh));
		System.out.println("So chung minh nhan dan: " + this.soCMND);
	}
	
	/**
	 * Chuyen ngay sinh tu string sang date
	 * @param str
	 * @return Ngay sinh
	 */
	public Date chuyenStringDate(String str) {
		Date ngaySinh = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			ngaySinh = sdf.parse(str);
		} catch (Exception e) {
			System.out.println("Loi dinh dang thoi gian.!");
		}
		return ngaySinh;
	}

	public String getSoCMND() {
		return this.soCMND;
	}
}
