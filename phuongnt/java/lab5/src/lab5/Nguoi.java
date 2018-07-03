package lab5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Phươngnt
 *
 */
public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	private int soCMND;

	public Nguoi() {
	}

	public Nguoi(String hoTen, Date ngaySinh, int soCMND) {
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
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		return date.format(ngaySinh);
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(int soCMND) {
		this.soCMND = soCMND;
	}

	public void nhapThongTin(Scanner sc) {
		System.out.println("Nhập họ tên khách hàng: ");
		hoTen = sc.nextLine();
		System.out.println("Nhập ngày, tháng, năm sinh: (dd/mm/yyyy): ");
		// ngaySinh = sc.nextLine();
		String dateInput = sc.nextLine();
		this.ngaySinh = chuyenStringDate(dateInput);
		System.out.println("Nhập số CMND khách hàng: ");
		soCMND = sc.nextInt();

	}

	public Date chuyenStringDate(String str) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = dateFormat.parse(str);
		} catch (Exception e) {
			System.out.println("Lỗi định dạng thời gian!");
		}

		return date;

	}

	public void hienThongTin() {
		System.out.println("Họ tên khách hàng: " + hoTen);
		System.out.println("Ngày, tháng, năm sinh: " + getNgaySinh());
		System.out.println("Số CMND khách hàng: " + soCMND);
	}

}