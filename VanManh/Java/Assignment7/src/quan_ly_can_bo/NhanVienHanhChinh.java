package quan_ly_can_bo;

import java.io.Serializable;
import java.util.Scanner;

public class NhanVienHanhChinh extends CanBo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * then nhan vien hanh chinh
	 * 
	 * @param input
	 * @param nhanVienHanhChinh
	 */
	public void addNhanVienHanhChinh(Scanner input, NhanVienHanhChinh nhanVienHanhChinh) {
		boolean kiemTra;
		int choose = 0;
		String chooseStr = null;
		String name = null;
		String phongBan = null;
		int soNgayCong = 0;
		double heSoLuong = 0.0;

		// Kiem tra nhap ten vhan vien khong duoc rong va khong qua 40 ki tu
		do {
			kiemTra = false;
			System.out.print("Nhap ten nhan vien : ");
			name = input.nextLine();
			try {
				if (name.isEmpty()) {
					throw new Exception("Ten khong duoc de rong");
				} else if (name.length() > 40) {
					throw new Exception("Ten khong duoc dai hon 40 ki tu");
				} else {
					for (int i = 0; i < name.length(); i++) {
						if (!Character.isLetter(name.charAt(i)) && !Character.isWhitespace(name.charAt(i))) {
							throw new Exception("Ten khong duoc nhap so");
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		// Phong ban khong duoc de trong
		do {
			kiemTra = false;
			System.out.print("nhap phong ban nhan vien : ");
			phongBan = input.nextLine();
			if (phongBan.isEmpty()) {
				System.out.println("Phong ban khong duoc de trong");
				kiemTra = true;
			}
		} while (kiemTra);

		// Kiem tra nhap chuc vu nhan vien chi duoc Truong phong, Pho phong or Nhan vien
		do {
			kiemTra = false;
			System.out.print("Chon chuc vu nhan vien : (1: Truong phong | 2: Pho phong | 3: Nhan vien) ");
			chooseStr = input.nextLine();
			try {
				choose = Integer.parseInt(chooseStr);
				if (choose != 1 && choose != 2 && choose != 3) {
					throw new Exception("Chi duoc chon 1 hoac 2 hoac 3");
				}
			} catch (NumberFormatException e) {
				System.out.println("Khong duoc nhap gia tri ngoai so va de trong");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);
		switch (choose) {
		case 1:
			nhanVienHanhChinh.setTrinhDo("Truong phong");
			nhanVienHanhChinh.setPhuCap(2000);
			break;
		case 2:
			nhanVienHanhChinh.setTrinhDo("Pho phong");
			nhanVienHanhChinh.setPhuCap(1000);
			break;
		case 3:
			nhanVienHanhChinh.setTrinhDo("Nhan vien");
			nhanVienHanhChinh.setPhuCap(500);
			break;
		default:
			System.out.println("Chon sai trinh do, moi ban nhap lai.");
			break;
		}

		// Kiem tra nhap so ngay cong phai la so va khong duoc am
		do {
			try {
				kiemTra = false;
				System.out.print("Nhap so ngay cong : ");
				String soNgayCongStr = input.nextLine();
				soNgayCong = Integer.parseInt(soNgayCongStr);
				if (soNgayCong <= 0) {
					throw new Exception("So ngay cong duoc am");
				}
			} catch (NumberFormatException e) {
				System.out.println("Chi duoc nhap so va khong duoc de trong");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		// He so luong chi duoc nhap so thuc va khong am
		do {
			try {
				kiemTra = false;
				System.out.print("Nhap he so luong : ");
				String heSoLuongStr = input.nextLine();
				heSoLuong = Double.parseDouble(heSoLuongStr);
				String pantter = "[0-9]+\\.[0-9]+";
				if (!heSoLuongStr.matches(pantter)) {
					throw new Exception("He so luong phai la so thuc");
				} else if (heSoLuong <= 0) {
					throw new Exception("He so luong khong duoc am");
				}
			} catch (NumberFormatException e) {
				System.out.println("He so luong khong duoc nhap chu");
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
		nhanVienHanhChinh.setNganh("Nhan vien");
	}

}
