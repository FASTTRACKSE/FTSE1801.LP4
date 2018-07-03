package Assignment5;

import java.util.Scanner;

/**
 * Thông tin cán bộ
 * 
 * @author SonVD
 *
 */
public class CanBo {
	private String hoTen;
	private String loaiCanBo;
	private double phuCap;
	private double heSoLuong;
	private double luong;

	public CanBo() {
	}

	public CanBo(String hoTen, String loaiCanBo, double phuCap, double heSoLuong, double luong) {
		super();
		this.hoTen = hoTen;
		this.loaiCanBo = loaiCanBo;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
		this.luong = luong;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
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
	 * Tính lương của cán bộ
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
