package Assignment5;

import java.util.Scanner;

/**
 * Thong tin nhan vien
 * 
 * @author SonVD
 *
 */
public class nhanVien extends CanBo {
	private String phongBan;
	private int soNgayCong;
	private String chucVu;

	public nhanVien() {
	}

	public nhanVien(String hoTen, String loaiCanBo, double phuCap, double heSoLuong) {
		super(hoTen, loaiCanBo, phuCap, heSoLuong);
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public double luong() {
		return getHeSoLuong() * 730 + getPhuCap() + getSoNgayCong() * 30;
	}

	/**
	 * Input information Nhan Vien
	 */
	public void inputNhanVien() {
		super.inputCanBo();
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập phòng ban: ");
		phongBan = input.nextLine();
		System.out.println("Nhập số ngày công: ");
		soNgayCong = input.nextInt();
		int choose;
		do {
			System.out.println("Chọn chức vụ: 1.Trưởng phòng || 2.Phó phòng || 3.Nhân viên");
			choose = input.nextInt();
			switch (choose) {
			case 1:
				chucVu = "Trưởng phòng";
				this.setPhuCap(2000);
				break;
			case 2:
				chucVu = "Phó phòng";
				this.setPhuCap(1000);
				break;
			case 3:
				chucVu = "Nhân viên";
				this.setPhuCap(500);
				break;
			default:
				System.out.println("Chọn sai chức năng.");
				break;
			}
		} while (choose < 1 || choose > 3);
	}

	/**
	 * Output information Nhan Vien
	 */
	public void outputNhanVien() {
		super.outputCanBo();
		System.out.println("Phòng ban: " + phongBan + "\nSố ngày công: " + soNgayCong + "\nChức vụ: " + chucVu
				+ "\nLương: " + luong());
	}
}
