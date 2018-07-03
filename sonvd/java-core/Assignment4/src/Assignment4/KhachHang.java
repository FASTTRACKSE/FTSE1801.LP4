package Assignment4;

import java.util.Scanner;

/**
 * Thông tin khách hàng
 * 
 * @author SonVD
 *
 */
public class KhachHang {
	private String tenChuHo;
	private String diaChi;
	private int maSoCongTo;

	public String getTenChuHo() {
		return tenChuHo;
	}

	public void setTenChuHo(String tenChuHo) {
		this.tenChuHo = tenChuHo;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

	/**
	 * Input information khachHang
	 */
	public void nhapKhachHang() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập tên khách hàng: ");
		tenChuHo = input.nextLine();
		System.out.println("Nhập địa chỉ: ");
		diaChi = input.nextLine();
		System.out.println("Nhập mã số công tơ: ");
		maSoCongTo = input.nextInt();
		input.close();
	}

	/**
	 * Output information khachHang
	 */
	public void hienthiKhachHang() {
		System.out.println("Tên khách hàng: " + tenChuHo + "\nĐịa chỉ: " + diaChi + "\nMã số công tơ: " + maSoCongTo);
	}
}
