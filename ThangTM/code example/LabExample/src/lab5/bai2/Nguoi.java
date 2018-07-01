package lab5.bai2;

import java.util.Date;
import java.util.Scanner;

/**
 * Class for contain info some person
 * @author GaLonTon
 *
 */
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

	public void nhapThongTin(Scanner sc) {
		System.out.println("Nhap ho ten nguoi tro: ");
		hoTen = sc.nextLine();
		// ngaySinh = 
		System.out.println("Nhap so CMND nguoi tro: ");
		soCMND = sc.nextLine();
	}

	public void hienThongTin() {
		System.out.println("Ho ten khach thue tro : " + hoTen);
		System.out.println("So CMND khach thue tro : " + soCMND);
	}

}
