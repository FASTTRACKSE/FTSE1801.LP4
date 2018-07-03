package Lap5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	private String soCMND;

	public Nguoi() {
	}

	public Nguoi(String hoTen, Date ngaySinh, String soCMND) {
		super();
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

	public Date getNgaySinh() {
		return ngaySinh;
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

	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập họ và tên: ");
		hoTen = sc.nextLine();
		System.out.println("Nhập ngày sinh: ");
		String date = sc.nextLine();
		ngaySinh = chuyenStringData(date);
		System.out.println("Nhập chứng minh nhân dân: ");
		soCMND = sc.nextLine();
	}
	
	public Date chuyenStringData(String str) {
		Date date = null;
		SimpleDateFormat birthday = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = birthday.parse(str);
		} catch (Exception e) {
			System.out.println("Lỗi định dạng ngày.");
		}
		return date;
	}
	
	public void hienThiThongTin() {
		System.out.println("Họ và tên khách hàng: " + hoTen);
		SimpleDateFormat birthday2 = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Ngày sinh: " +birthday2.format(ngaySinh));
		System.out.println("Số chứng minh nhân dân: " + soCMND);
	}
}
