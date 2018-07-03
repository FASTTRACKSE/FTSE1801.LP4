package QuanLyCanBo;

import java.util.Scanner;

public class NhanVien extends CanBo {
	private String phongBan, chucVu;
	private int soNgayCong;

	public NhanVien() {

	}

	public NhanVien(String phongBan, String chucVu, int soNgayCong) {
		super();
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public void nhapNhanVien(Scanner sc) {
		super.nhapCanBo(sc);
		sc.nextLine();
		System.out.print("Nhập phòng ban của nhân viên: ");
		String phongBan = sc.nextLine();
		setPhongBan(phongBan);

		int choose;
		do {
			System.out.print("Nhập chức vụ (1 - trưởng phòng, 2 - phó phòng, 3 - nhân viên): ");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				chucVu = "trưởng phòng";
				this.setPhuCap(2000);
				;
				break;
			case 2:
				chucVu = "phó phòng";
				this.setPhuCap(1000);
				break;
			case 3:
				chucVu = "nhân viên";
				this.setPhuCap(500);
				break;
			default:
				System.out.println("Chọn không đúng!");
				break;
			}
		} while (choose < 1 || choose > 3);
		setChucVu(chucVu);

		System.out.print("Nhập số ngày công nhân viên: ");
		int soNgayCong = sc.nextInt();
		setSoNgayCong(soNgayCong);
	}

	public double tinhLuong() {
		double luong = getHeSoLuong() * 730 + getPhuCap() + getSoNgayCong() * 30;
		return luong;

	}

	public void xuatNhanVien() {
		super.xuatCanBo();
		System.out.println("Phòng bang nhân viên: " + getPhongBan());
		System.out.println("Chức vụ nhận viên: " + getChucVu());
		System.out.println("Số ngày công nhân viên: " + getSoNgayCong());
		System.out.println("Lương nhân viên: " + tinhLuong());
	}
}