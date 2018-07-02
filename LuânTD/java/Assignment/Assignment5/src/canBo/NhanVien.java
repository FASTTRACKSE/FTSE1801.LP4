package canBo;

import java.util.Scanner;

public class NhanVien extends CanBo {

	public double luongNhanVien() {
		return this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoGioLam() * 30;
	}

	public void nhapNhanVien(Scanner sc, NhanVien nhanVien) {
		sc.nextLine();
		System.out.println("Nhap ho ten: ");
		String hoTen = sc.nextLine();
		System.out.println("Nhap phong ban: ");
		String phongBan = sc.nextLine();
		System.out.println("Nhap so tiet day: ");
		int soNgayCong = sc.nextInt();
		System.out.println("Nhap he so luong: ");
		double heSoLuong = sc.nextDouble();
		System.out.println("Nhap chuc vu:");
		System.out.println("Nhap 1:Truong phong, 2:Pho Phong, 3:Nhan Vien");
		int chucVu = sc.nextInt();
		nhanVien.setHoTen(hoTen);
		nhanVien.setDonVi(phongBan);
		nhanVien.setSoGioLam(soNgayCong);
		nhanVien.setHeSoLuong(heSoLuong);
		nhanVien.setLuong(nhanVien.luongNhanVien());
		switch (chucVu) {
		case 1:
			nhanVien.setTrinhDo("Truong Phong");
			nhanVien.setPhuCap(2000);
			break;

		case 2:
			nhanVien.setTrinhDo("Pho Phong");
			nhanVien.setPhuCap(1000);
			break;

		case 3:
			nhanVien.setTrinhDo("Nhan Vien");
			nhanVien.setPhuCap(500);
			break;
		default:
			System.out.println("Nhap sai, moi ban chon lai");
			break;
		}
	}

}
