package Bai2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Nguoi Class
 * 
 * @author CôngMT
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void setSoCMND(int soCMND) {
		this.soCMND = soCMND;
	}

	public int getSoCMND() {
		return this.soCMND;
	}

	public Date chuyenStringDate(String str) {
		Date ns = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			ns = sdf.parse(str);
		} catch (Exception e) {
			System.out.println("Loi dinh dang thoi gian.!");
		}
		return ns;
	}

}
