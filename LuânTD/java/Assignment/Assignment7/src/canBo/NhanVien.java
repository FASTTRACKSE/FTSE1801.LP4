package canBo;

import java.io.Serializable;
import java.util.Scanner;
/**
 * Class nhan vien
 * @author Luan
 *
 */
public class NhanVien extends CanBo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 *  Tinh luong nhan vien
	 * @return luong nhan vien
	 */
	public double luongNhanVien() {
		return this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoGioLam() * 30;
	}
	/**
	 * Them nhan vien
	 * @param sc scanner
	 * @param nhanVien nhan vien
	 */
	public void nhapNhanVien(Scanner sc, NhanVien nhanVien) {
		boolean kiemtra;
		String hoTen = null;
		int soNgayCong = 0;
		double heSoLuong = 0;
		do {
			sc.nextLine();
			try {
				kiemtra = false;
				System.out.println("Nhap ho ten: ");
				hoTen = sc.nextLine();
				if (hoTen.isEmpty() && hoTen.length() <= 40) {
					throw new Exception("Nhap sai ky tu");
				} else {
					for (int i = 0; i < hoTen.length(); i++) {
						if (!Character.isLetter(hoTen.charAt(i)) && !Character.isWhitespace(hoTen.charAt(i))) {
							throw new Exception("Nhap sai ky tu");
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemtra = true;
			}

		} while (kiemtra);
		System.out.println("Nhap phong ban: ");
		String phongBan = sc.nextLine();
		do {
			sc.nextLine();
			try {
				kiemtra = false;
				System.out.println("Nhap he so tiet: ");
				soNgayCong = sc.nextInt();
				if (soNgayCong < 0) {
					throw new Exception("Nhap sai ky tu");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemtra = true;
			}

		} while (kiemtra);
		do {
			sc.nextLine();
			try {
				kiemtra = false;
				System.out.println("Nhap he so luong: ");
				heSoLuong = sc.nextDouble();
				if (heSoLuong < 0) {
					throw new Exception("Nhap sai ky tu");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemtra = true;
			}

		} while (kiemtra);
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
