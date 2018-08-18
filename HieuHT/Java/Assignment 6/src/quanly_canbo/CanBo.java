package quanly_canbo;

import java.util.Collections;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * 
 * @author Ngọc Thiên
 *
 */
public class CanBo {
	/**
	 * khai báo biến
	 */
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

	public void nhapCanBo(Scanner sc) {
		String HoTen = null;
		float heSoLuong = 0;
		boolean kiemTra;
		do {
			kiemTra = false;
			try {
				System.out.print("Nhập Họ tên:");
				HoTen = sc.nextLine();
				if (HoTen.isEmpty()) {
					kiemTra = true;
					throw new Exception("Không được để rổng họ tên");
				}
				if (HoTen.length() > 40) {
					throw new Exception("Không được nhập quá 40 kí tự");
				}

			} catch (EmptyStackException er) {
				kiemTra = true;
				System.out.println("nhập tên không quá 40 ký tự");
			} catch (Exception e) {
				kiemTra = true;
				System.out.println(e.getMessage());
			}
		} while (kiemTra);

		setHoTen(HoTen);
		do {
			kiemTra = false;
			try {
				System.out.print("Nhập hệ số lương:");
				heSoLuong = sc.nextFloat();
				if (heSoLuong < 0) {

					throw new Exception("Không được nhập số âm");
				}
			} catch (Exception e) {
				kiemTra = true;
				System.out.println(e.getMessage());
			}
		} while (kiemTra);

		setHeSoLuong(heSoLuong);
	}

	public void xuatCanBo() {
		System.out.println("Họ và Ten: " + getHoTen());
		System.out.println("Hệ số lương: " + getHeSoLuong());
	}
}
