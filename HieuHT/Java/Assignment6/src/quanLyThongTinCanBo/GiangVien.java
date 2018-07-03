package quanLyThongTinCanBo;

import java.util.Scanner;

public class GiangVien extends CanBo {

	/**
	 * Thên giảng viên
	 * 
	 * @ giangvien
	 * @ input
	 */
	public void addGiangVien(Scanner input, GiangVien giangVien) {
		boolean kiemTra;
		int choose = 0;
		String chooseStr = null;
		String name = null;
		String khoa = null;
		int soTiet = 0;
		double heSoLuong = 0.0;

		// Kiểm tra nhập tên giảng viên không được rỗng và không quá 40 kí tự
		do {
			kiemTra = false;
			System.out.print("Nhập tên giảng viên : ");
			name = input.nextLine();
			try {
				if (name.isEmpty()) {
					throw new Exception("Tên không được để rỗng");
				} else if (name.length() > 40) {
					throw new Exception("Tên không được quá 40 kí tự");
				} else {
					for (int i = 0; i < name.length(); i++) {
						if (!Character.isLetter(name.charAt(i)) && !Character.isWhitespace(name.charAt(i))) {
							throw new Exception("Tên không được nhập số");
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		// khoa không được để trống
		do {
			kiemTra = false;
			System.out.print("Nhập khoa giảng viên : ");
			khoa = input.nextLine();
			if (khoa.isEmpty()) {
				System.out.println("Phòng ban không được để trống");
				kiemTra = true;
			}
		} while (kiemTra);

		// Kiểm tra nhập trình độ giảng viên chỉ được cử nhân, thạc sĩ hoặc tiến sĩ
		do {
			kiemTra = false;
			System.out.print("Chọn tình độ giảng viên : (1: Cử nhân | 2: Thạc sĩ | 3: Tiến sĩ) ");
			chooseStr = input.nextLine();
			try {
				choose = Integer.parseInt(chooseStr);
				if (choose != 1 && choose != 2 && choose != 3) {
					throw new Exception("Chỉ được chọn 1 hoặc 2 hoặc 3");
				}
			} catch (NumberFormatException e) {
				System.out.println("Không được nhập giá trị ngoài số và để trống");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);
		switch (choose) {
		case 1:
			giangVien.setTrinhDo("Cử nhân");
			giangVien.setPhuCap(300);
			break;
		case 2:
			giangVien.setTrinhDo("Thạc sĩ");
			giangVien.setPhuCap(500);
			break;
		case 3:
			giangVien.setTrinhDo("Tiến sĩ");
			giangVien.setPhuCap(1000);
			break;
		}

		// Kiểm tra số tiết là phải số và không âm
		do {
			try {
				kiemTra = false;
				System.out.print("Nhập số tiết dạy : ");
				String soTietStr = input.nextLine();
				soTiet = Integer.parseInt(soTietStr);
				if (soTiet <= 0) {
					throw new Exception("Số tiết không được âm");
				}
			} catch (NumberFormatException e) {
				System.out.println("Chỉ được nhập số và không để trống");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		// Hệ số lương chỉ được nhập số thực và không âm
		do {
			try {
				kiemTra = false;
				System.out.print("Nhập hệ số lương : ");
				String heSoLuongStr = input.nextLine();
				heSoLuong = Double.parseDouble(heSoLuongStr);
				String pantter = "[0-9]+\\.[0-9]+";
				if (!heSoLuongStr.matches(pantter)) {
					throw new Exception("Hệ số lương phải là số thực");
				} else if (heSoLuong <= 0) {
					throw new Exception("Hệ số lương không âm");
				}
			} catch (NumberFormatException e) {
				System.out.println("Hệ số lương không được âm");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		giangVien.setTen(name);
		giangVien.setDonVi(khoa);
		giangVien.setThoiGianTinhLuong(soTiet);
		giangVien.setHeSoLuong(heSoLuong);
		giangVien.setLuong(heSoLuong * 730 + giangVien.getPhuCap() + soTiet * 45);
		giangVien.setNganh("Giảng viên");
	}

}