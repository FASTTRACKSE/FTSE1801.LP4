package quanly_canbo;

import java.util.Scanner;

/**
 * 
 * @author Ngọc Thiên
 *
 */
public class CanBo {
	private String HoTen;
	private int phuCap;
	private double luong;
	private float heSoLuong;

	public CanBo() {

	}

	public CanBo(String hoTen, int phuCap, double luong, float heSoLuong) {
		super();
		HoTen = hoTen;
		this.phuCap = phuCap;
		this.luong = luong;
		this.heSoLuong = heSoLuong;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double tinhLuong() {
		return 0;
	}

	/**
	 * 
	 * @param Nhập
	 *            thông tin cán bộ
	 */
	public void nhapCanBo(Scanner sc) {

		System.out.print("Nhập Họ tên:");
		String HoTen = sc.nextLine();
		setHoTen(HoTen);
		System.out.print("Nhập hệ số lương:");
		float heSoLuong = sc.nextFloat();
		setHeSoLuong(heSoLuong);
	}

	/**
	 * Xuất thông tin
	 */

	public void xuatCanBo() {
		System.out.println("Họ và Ten: " + getHoTen());
		System.out.println("Hệ số lương: " + getHeSoLuong());
	}
}
