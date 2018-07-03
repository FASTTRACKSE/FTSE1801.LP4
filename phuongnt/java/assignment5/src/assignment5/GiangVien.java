package assignment5;

import java.util.Scanner;

public class GiangVien extends CanBo {

	private String khoa, trinhDo;
	private int soTiet;

	public GiangVien() {

	}

	public GiangVien(String khoa, String trinhDo, int soTiet) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTiet = soTiet;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTiet() {
		return soTiet;
	}

	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}

	public void nhapGiangVien(Scanner sc) {
		super.nhapCanBo(sc);
		sc.nextLine();
		System.out.print("Nhập khoa của Giảng Viên:");
		String khoa = sc.nextLine();
		setKhoa(khoa);

		int choose;
		do {
			System.out.print("Nhập trình độ (1 - Cử nhân, 2 - Thạc sĩ, 3 - Tiến sĩ): ");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				trinhDo = "cử nhân";
				this.setPhuCap(300);
				break;
			case 2:
				trinhDo = "thạc sĩ";
				this.setPhuCap(500);
				break;
			case 3:
				trinhDo = "tiến sĩ";
				this.setPhuCap(1000);
				break;
			default:
				System.out.println("Chọn không đúng!");
				break;
			}
		} while (choose < 1 || choose > 3);
		setTrinhDo(trinhDo);

		System.out.print("Nhập số tiết dạy của giảng viên: ");
		int soTiet = sc.nextInt();
		setSoTiet(soTiet);
	}

	@Override
	public double tinhLuong() {
		double luong = getHeSoLuong() * 730 + getPhuCap() + getSoTiet() * 45;
		return luong;
	}

	public void xuatGiangVien() {
		super.xuatCanBo();
		System.out.println("Khoa giảng viên: " + getKhoa());
		System.out.println("Trình độ giảng viên: " + getTrinhDo());
		System.out.println("tổng số tiết dạy của giảng viên: " + getSoTiet());
		System.out.println("lương của giảng viên: " + tinhLuong());
	}
}
