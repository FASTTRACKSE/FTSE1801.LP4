package quan_ly_can_bo;

import java.util.Scanner;

public class GiangVien extends CanBo {

	/**
	 * Them giang vien
	 * 
	 * @param giangvien
	 * @param input
	 */
	public void addGiangVien(Scanner input, GiangVien giangVien) {
		boolean kiemTra;
		int choose = 0;
		String chooseStr = null;
		String name = null;
		String khoa = null;
		int soTiet = 0;
		double heSoLuong = 0.0;

		// Kiem tra nhap ten giang vien khong duoc rong va khong qua 40 ki tu
		do {
			kiemTra = false;
			System.out.print("Nhap ten giang vien : ");
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

		// khoa khong duoc de trong
		do {
			kiemTra = false;
			System.out.print("nhap khoa giang vien : ");
			khoa = input.nextLine();
			if (khoa.isEmpty()) {
				System.out.println("Phong ban khong duoc de trong");
				kiemTra = true;
			}
		} while (kiemTra);

		// Kiem tra nhap trinh do giang vien chi duoc cu nhan, thac si or tien si
		do {
			kiemTra = false;
			System.out.print("Chon trinh do giang vien : (1: Cu nhan | 2: Thac si | 3: Tien si) ");
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
			giangVien.setTrinhDo("Cu nhan");
			giangVien.setPhuCap(300);
			break;
		case 2:
			giangVien.setTrinhDo("Thac si");
			giangVien.setPhuCap(500);
			break;
		case 3:
			giangVien.setTrinhDo("Tien si");
			giangVien.setPhuCap(1000);
			break;
		}

		// Kiem tra nhap so tiet phai la so va khong duoc am
		do {
			try {
				kiemTra = false;
				System.out.print("Nhap so tiet day : ");
				String soTietStr = input.nextLine();
				soTiet = Integer.parseInt(soTietStr);
				if (soTiet <= 0) {
					throw new Exception("So tiet khong duoc am");
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

		giangVien.setTen(name);
		giangVien.setDonVi(khoa);
		giangVien.setThoiGianTinhLuong(soTiet);
		giangVien.setHeSoLuong(heSoLuong);
		giangVien.setLuong(heSoLuong * 730 + giangVien.getPhuCap() + soTiet * 45);
		giangVien.setNganh("Giang vien");
	}

}
