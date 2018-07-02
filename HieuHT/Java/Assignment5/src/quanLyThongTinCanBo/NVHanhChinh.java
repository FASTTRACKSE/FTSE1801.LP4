package quanLyThongTinCanBo;

import java.util.Scanner;

public class NVHanhChinh extends CanBo {

	/**
	 * Thêm nhân viên hành chính
	 * 
	 * @param input
	 * @param nhanVienHanhChinh
	 */
	public void addNhanVienHanhChinh(Scanner input, NVHanhChinh nhanVienHanhChinh) {
		boolean kiemTra;
		int choose = 0;
		String chooseStr = null;
		String name = null;
		String phongBan = null;
		int soNgayCong = 0;
		double heSoLuong = 0.0;

		// Kiểm tra tên nhân viên không được rỗng và không quá 50 kí tự
		do {
			kiemTra = false;
			System.out.print("Nhập tên nhân viên : ");
			name = input.nextLine();
			try {
				if (name.isEmpty()) {
					throw new Exception("Tên không được để rỗng");
				} else if (name.length() > 40) {
					throw new Exception("Tên không được nhiều hơn 50 kí tự");
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

		// Phòng ban không được để trống
		do {
			kiemTra = false;
			System.out.print("Nhập phòng ban nhân viên : ");
			phongBan = input.nextLine();
			if (phongBan.isEmpty()) {
				System.out.println("Phòng ban không được để trống");
				kiemTra = true;
			}
		} while (kiemTra);

		// Kiểm tra nhập chức vụ nhân viên chỉ được Trưởng phòng, phó phòng và nhân viên
		do {
			kiemTra = false;
			System.out.print("Chọn chức vụ nhân viên : (1: Trưởng phòng | 2: Phó phòng | 3: Nhân viên) ");
			chooseStr = input.nextLine();
			try {
				choose = Integer.parseInt(chooseStr);
				if (choose != 1 && choose != 2 && choose != 3) {
					throw new Exception("Chỉ được chon 1 hoặc 2 hoặc 3");
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
			nhanVienHanhChinh.setTrinhDo("Trưởng phòng");
			nhanVienHanhChinh.setPhuCap(2000);
			break;
		case 2:
			nhanVienHanhChinh.setTrinhDo("Phó phòng");
			nhanVienHanhChinh.setPhuCap(1000);
			break;
		case 3:
			nhanVienHanhChinh.setTrinhDo("Nhân viên");
			nhanVienHanhChinh.setPhuCap(500);
			break;
		default:
			System.out.println("Chọn sai trình độ, mời bạn nhập lại.");
			break;
		}

		// Kiểm tra nhập số ngày công phải là số
		do {
			try {
				kiemTra = false;
				System.out.print("Nhập số ngày công : ");
				String soNgayCongStr = input.nextLine();
				soNgayCong = Integer.parseInt(soNgayCongStr);
				if (soNgayCong <= 0) {
					throw new Exception("Số ngày công không được âm");
				}
			} catch (NumberFormatException e) {
				System.out.println("Chỉ được nhập số và không để trống");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		// Hệ số lương chỉ được nhập số và không âm
		do {
			try {
				kiemTra = false;
				System.out.print("Nhập hệ số lương: ");
				String heSoLuongStr = input.nextLine();
				heSoLuong = Double.parseDouble(heSoLuongStr);
				String pantter = "[0-9]+\\.[0-9]+";
				if (!heSoLuongStr.matches(pantter)) {
					throw new Exception("Hệ số lương phải là số thực");
				} else if (heSoLuong <= 0) {
					throw new Exception("Hệ số lương không được âm");
				}
			} catch (NumberFormatException e) {
				System.out.println("Hệ số lương không được nhập chữ");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		nhanVienHanhChinh.setTen(name);
		nhanVienHanhChinh.setDonVi(phongBan);
		nhanVienHanhChinh.setThoiGianTinhLuong(soNgayCong);
		nhanVienHanhChinh.setHeSoLuong(heSoLuong);
		nhanVienHanhChinh.setLuong(heSoLuong * 730 + nhanVienHanhChinh.getPhuCap() + soNgayCong * 45);
		nhanVienHanhChinh.setNganh("Nhân viên");
	}

}