package canBo;

import java.util.Scanner;
/**
 * 
 * @author Luan
 *
 */

public class GiangVien extends CanBo {
/**
 * 
 * @return luong giang vien
 */
	public double luongGiangVien() {
		return this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoGioLam() * 30;
	}
/**
 * 
 * @param sc scanner
 * @param nhap thong tin giang vien
 */
	public void nhapGiangVien(Scanner sc, GiangVien giangVien) {
		boolean kiemtra;
		String hoTen=null;
		int soTiet=0;
		double heSoLuong=0;
		do {
			sc.nextLine();
			try {
				kiemtra=false;
				System.out.println("Nhap ho ten: ");
				hoTen = sc.nextLine();
				if (hoTen.isEmpty()&& hoTen.length()<=40) {
					throw new Exception("Nhap sai ky tu");
				} else {
					for (int i = 0; i < hoTen.length(); i++) {
						if (!Character.isLetter(hoTen.charAt(i))
								&& !Character.isWhitespace(hoTen.charAt(i))) {
							throw new Exception("Nhap sai ky tu");
						}
					}
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				kiemtra=true;
			}
			
		}while(kiemtra);
		System.out.println("Nhap khoa: ");
		String khoa = sc.nextLine();
		do {
			sc.nextLine();
			try {
				kiemtra=false;
				System.out.println("Nhap he so tiet: ");
				soTiet = sc.nextInt();
				if (soTiet<0) {
					throw new Exception("Nhap sai ky tu");
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				kiemtra=true;
			}
			
		}while(kiemtra);
		do {
			sc.nextLine();
			try {
				kiemtra=false;
				System.out.println("Nhap he so luong: ");
				heSoLuong = sc.nextDouble();
				if (heSoLuong<0) {
					throw new Exception("Nhap sai ky tu");
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				kiemtra=true;
			}
			
		}while(kiemtra);
		
		System.out.println("Nhap trinh do: ");
		System.out.println("Nhap 1:Cu Nhan, 2:Thac Si, 3: Tien Si");
		int trinhDo = sc.nextInt();
		giangVien.setHoTen(hoTen);
		giangVien.setDonVi(khoa);
		giangVien.setSoGioLam(soTiet);
		giangVien.setHeSoLuong(heSoLuong);
		giangVien.setLuong(giangVien.luongGiangVien());
		switch (trinhDo) {
		case 1:
			giangVien.setTrinhDo("Cu Nhan");
			giangVien.setPhuCap(300);
			break;

		case 2:
			giangVien.setTrinhDo("Thac Si");
			giangVien.setPhuCap(500);
			break;

		case 3:
			giangVien.setTrinhDo("Tien Si");
			giangVien.setPhuCap(1000);
			break;
		default:
			System.out.println("Nhap sai, moi ban chon lai");
			break;
		}
	}

}
