package Assignment6;

import java.util.Scanner;

/**
 * Thông tin giảng viên extends CanBo
 * 
 * @author SonVD
 *
 */
public class giangVien extends CanBo {
	private String khoa;
	private String trinhDo;
	private int soTietDay;

	public giangVien() {
	}

	public giangVien(String hoTen, String loaiCanBo, double phuCap, double heSoLuong) {
		super(hoTen, loaiCanBo, phuCap, heSoLuong);
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

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}

	public double luong() {
		return getHeSoLuong() + 730 + getPhuCap() + getSoTietDay() * 45;
	}

	/**
	 * Input information Giang Vien
	 */
	public void inputGiangVien() {
		int choose;
		super.inputCanBo();
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập tên khoa: ");
		khoa = input.nextLine();
		do {
			System.out.println("Chọn trình độ: 1.Cử nhân || 2.Thạc sĩ || 3.Tiến sĩ");
			choose = input.nextInt();
			switch (choose) {
			case 1:
				trinhDo = "Cử nhân";
				this.setPhuCap(300);
				break;
			case 2:
				trinhDo = "Thạc sĩ";
				this.setPhuCap(500);
				break;
			case 3:
				trinhDo = "Tiến sĩ";
				this.setPhuCap(1000);
				break;
			default:
				System.out.println("Chọn sai chức năng.");
				break;
			}
		} while (choose < 1 || choose > 3);
		System.out.println("Nhập số tiết dạy: ");
		soTietDay = input.nextInt();
	}

	/**
	 * Output information Giang Vien
	 */
	public void outputGiangVien() {
		super.outputCanBo();
		System.out.println(
				"Khoa: " + khoa + "\nTrình độ: " + trinhDo + "\nSố tiết dạy: " + soTietDay + "\nLương: " + luong());
	}
}
