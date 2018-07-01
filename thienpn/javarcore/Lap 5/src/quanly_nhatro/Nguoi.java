package quanly_nhatro;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Nguoi {
	private String name;
	private Date ngaysinh;
	private String SCMND;

	public Nguoi() {

	}

	public Nguoi(String name, Date ngaysinh, String sCMND) {
		super();
		this.name = name;
		this.ngaysinh = ngaysinh;
		SCMND = sCMND;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSCMND() {
		return SCMND;
	}

	public void setSCMND(String sCMND) {
		SCMND = sCMND;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập họ tên khách hàng: ");
		this.name = sc.nextLine();
		System.out.println("nhập ngày sinh khách hàng:");
		String ns = sc.nextLine();
		this.ngaysinh = chuyenStringDate(ns);
		System.out.println("Nhập số CMND khách hàng: ");
		this.SCMND = sc.nextLine();

	}

	public void InThongTin() {
		System.out.println("Ho va Ten: " + this.name);
		System.out.println("Ngay sinh: " + this.ngaysinh);
		System.out.println("So chung minh nhan dan: " + this.SCMND);
	}

	public Date chuyenStringDate(String str) {
		Date ns = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			ns = (Date) sdf.parse(str);
		} catch (Exception e) {

		}
		return ns;
	}

}
