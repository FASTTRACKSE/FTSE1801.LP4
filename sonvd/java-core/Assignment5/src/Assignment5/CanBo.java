package Assignment5;

import java.util.Scanner;

/**
 * Thong tin can bo
 * 
 * @author SonVD
 *
 */
public class CanBo {
	private String hoTen;
	private String loaiCanBo;
	private double phuCap;
	private double heSoLuong;

	public CanBo(String hoTen, String loaiCanBo, double phuCap, double heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.loaiCanBo = loaiCanBo;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
	}

	public CanBo() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLoaiCanBo() {
		return loaiCanBo;
	}

	public void setLoaiCanBo(String loaiCanBo) {
		this.loaiCanBo = loaiCanBo;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	/**
	 * Tinh luong cua can bo
	 * 
	 * @return 0
	 */
	public double luong() {
		return 0;
	}

	/**
	 * Input information CanBo
	 */
	public void inputCanBo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập họ và tên: ");
		hoTen = input.nextLine();
		System.out.println("Nhập hệ số lương: ");
		heSoLuong = input.nextDouble();
	}

	/**
	 * Output information CanBo
	 */
	public void outputCanBo() {
		System.out.println(
				"Họ và tên: " + hoTen + "\nHệ số lương: " + heSoLuong + "\nPhụ cấp: " + phuCap + "\nLương: " + luong());
	}

}
