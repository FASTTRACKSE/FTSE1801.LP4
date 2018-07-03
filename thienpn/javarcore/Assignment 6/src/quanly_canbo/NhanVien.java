package quanly_canbo;

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

	/**
	 * 
	 * @param Nhập
	 *            thông tin nhân viên
	 */
	public void nhapNhanVien(Scanner sc) {
		boolean kiemTra;
		int soNgayCong = 0;
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
		do {
			kiemTra = false;
			try {
				System.out.print("Nhập số ngày công nhân viên: ");
				soNgayCong = sc.nextInt();
				if (soNgayCong < 0) {
					throw new Exception("Không được nhập số âm");
				}
			} catch (Exception e) {
				kiemTra = true;
				System.out.println(e.getMessage());
			}
		} while (kiemTra);

		setSoNgayCong(soNgayCong);
	}

	/**
	 * tính lương nhân viên
	 */
	public double tinhLuong() {
		double luong = getHeSoLuong() * 730 + getPhuCap() + getSoNgayCong() * 30;
		return luong;

	}

	/**
	 * xuất thông tin nhân viên
	 */
	public void xuatNhanVien() {
		super.xuatCanBo();
		System.out.println("phòng bang nhân viên: " + getPhongBan());
		System.out.println("Chức vụ nhận viên: " + getChucVu());
		System.out.println("Số ngày công nhân viên: " + getSoNgayCong());
		System.out.println("Lương nhân viên: " + tinhLuong());
	}
}
