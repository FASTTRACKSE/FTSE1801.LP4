package lab5.bai2_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class for contain info some person
 * 
 * @author GaLonTon
 *
 */
public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	private String soCMND;
	private int soThuTu;

	public Nguoi() {
	}

	public Nguoi(String hoTen, Date ngaySinh, String soCMND) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		return sdf1.format(ngaySinh);
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public Date chuyenStringDate(String str) {
		Date ns = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			ns = sdf.parse(str);
		} catch (Exception e) {
			System.out.println("Loi dinh dang thoi gian.!");
		}
		
//		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//		System.out.println( sdf1.format(ns));
		return ns;
	}

	public void nhapThongTin(Scanner sc) {
		System.out.println("Nhập số thứ tự: ");
		soThuTu = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap họ và tên người ở trọ: ");
		hoTen = sc.nextLine();
		System.out.println("Nhập ngày sinh người ở trọ: ");
		String str = sc.nextLine();
		setNgaySinh(chuyenStringDate(str));
		System.out.println("Nhap so CMND nguoi tro: ");
		soCMND = sc.nextLine();

	}
}
