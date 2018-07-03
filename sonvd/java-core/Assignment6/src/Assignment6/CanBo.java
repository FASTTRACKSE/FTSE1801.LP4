package Assignment6;

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
		boolean check = false;
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		do {
			check = false;
			try {
				System.out.print("Nhập họ và tên: ");
				hoTen = input.nextLine();
				if (hoTen.isEmpty()) {
					check = true;
					System.out.println("Không được để khoảng trống. Vui lòng nhập lại họ và tên.");
				} else {
					for (int i = 0; i < hoTen.length(); i++) {
						if (!Character.isLetter(hoTen.charAt(i)) && hoTen.charAt(i) != ' ') {
							check = true;
							System.out.println("Không được nhập số vui lòng nhập chữ.");
							break;
						}
					}

					if (hoTen.length() > 40) {
						check = true;
						System.out.println("Không được nhập quá 40 ký tự.");
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (check);

		do {
			check = false;
			try {

				System.out.println("Nhập hệ số lương ");
				a = input.nextLine();
				if (a.isEmpty())
					throw new Exception("Vui lòng nhập hệ số lương không để rỗng.");
				heSoLuong = Integer.parseInt(a);

				if (heSoLuong < 0) {
					check = true;
					System.out.println("Không được nhập số âm");
				}
			} catch (NumberFormatException er) {
				System.out.println("Vui lòng nhập số không được nhập chữ.");
			} catch (Exception e) {
				check = true;
				System.out.println(e.getMessage());
			}
		} while (check);

	}

	/**
	 * Output information CanBo
	 */
	public void outputCanBo() {
		System.out.println(
				"Họ và tên: " + hoTen + "\nHệ số lương: " + heSoLuong + "\nPhụ cấp: " + phuCap + "\nLương: " + luong());
	}

}
