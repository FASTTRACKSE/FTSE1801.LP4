package quan_ly_can_bo;

import java.util.Scanner;

public class NhanVienHanhChinh extends CanBo {

	/**
	 * then nhan vien hanh chinh
	 * 
	 * @param input
	 * @param nhanVienHanhChinh
	 */
	public void addNhanVienHanhChinh(Scanner input, NhanVienHanhChinh nhanVienHanhChinh) {

		input.nextLine();
		System.out.print("Nhap ten nhan vien : ");
		String name = input.nextLine();
		System.out.print("nhap phong ban nhan vien : ");
		String phongBan = input.nextLine();

		System.out.print("Chon chuc vu nhan vien : (1: Truong phong | 2: Pho phong | 3: Nhan vien) ");
		int trinhDo = input.nextInt();
		switch (trinhDo) {
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

		System.out.print("Nhap so ngay cong : ");
		int soNgayCong = input.nextInt();
		System.out.print("Nhap he so luong : ");
		double heSoLuong = input.nextDouble();

		nhanVienHanhChinh.setTen(name);
		nhanVienHanhChinh.setDonVi(phongBan);
		nhanVienHanhChinh.setThoiGianTinhLuong(soNgayCong);
		nhanVienHanhChinh.setHeSoLuong(heSoLuong);
		nhanVienHanhChinh.setLuong(heSoLuong * 730 + nhanVienHanhChinh.getPhuCap() + soNgayCong * 45);
		nhanVienHanhChinh.setNganh("Nhan vien");
	}

}
