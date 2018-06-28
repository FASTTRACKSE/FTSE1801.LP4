package bai2;

import java.util.Scanner;
import java.util.ArrayList;

public class QuanLyKhachSan {
	ArrayList<PhongTro> listPhong;

	public QuanLyKhachSan() {
		listPhong = new ArrayList<PhongTro>();
	}

	/**
	 * Them khach tro
	 * 
	 * @param phongTro
	 * @param n
	 * @param sc
	 */
	public void addKhachTro(PhongTro phongTro, int n, Scanner sc) {
		for (int i = 0; i < n; i++) {
			phongTro = new PhongTro();
			phongTro.nhapThongTin(sc);
			listPhong.add(phongTro);
		}
	}

	/**
	 * hien thi danh sach khach tro
	 */
	public void showDanhSachTro() {
		for (int i = 0; i < listPhong.size(); i++) {
			listPhong.get(i).hienThongTin();
		}
	}

	/**
	 * Can cu so cmnd tim nguoi tinh tien tro
	 * 
	 * @param phongTro
	 * @param cmnd
	 */
	public void tinhTienTro(PhongTro phongTro, String cmnd) {
		phongTro = null;
		for (int i = 0; i < listPhong.size(); i++) {
			if (listPhong.get(i).getKhach().getSoCMND().equals(cmnd)) {
				phongTro = listPhong.get(i);
				break;
			}
		}
		if (phongTro != null) {
			phongTro.tinhTienTro();
			phongTro.hienThongTin();
			System.out.println("Tien tro : " + phongTro.tinhTienTro());
			System.out.println();
		} else {
			System.out.println("Nhap sai so cmnd");
		}
	}

	/**
	 * Can cu so cmnd xoa khach tro
	 * @param phongTro
	 * @param cmnd
	 */
	public void deleteKhachTro(PhongTro phongTro, String cmnd) {
		phongTro = null;
		for (int i = 0; i < listPhong.size(); i++) {
			if (listPhong.get(i).getKhach().getSoCMND().equals(cmnd)) {
				phongTro = listPhong.get(i);
				break;
			}
		}
		if (phongTro != null) {
			listPhong.remove(phongTro);
		} else {
			System.out.println("Nhap sai so cmnd");
		}
	}

	public static void main(String[] args) {
		QuanLyKhachSan quanLy = new QuanLyKhachSan();
		Scanner sc = new Scanner(System.in);
		int n, luaChon;
		PhongTro phongTro = new PhongTro();
	
		while(true) {
			System.out.println("/***********************************/");
			System.out.println("1. Them khach tro.");
			System.out.println("2. Hien thi danh sach khach tro .");
			System.out.println("3. TInh tien tro cua khach tro .");
			System.out.println("4. Kết thúc");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = sc.nextInt();
			System.out.println();
			
			switch (luaChon) {
			case 1:
				System.out.println("Nhap so khach tro : ");
				n = sc.nextInt();
				sc.nextLine();
				quanLy.addKhachTro(phongTro, n, sc);
				break;
			case 2:
				quanLy.showDanhSachTro();
				break;
				
			case 3:
				System.out.println("Nhap so cmnd cua khach tro : ");
				sc.nextLine();
				String cmnd = sc.nextLine();
				quanLy.tinhTienTro(phongTro, cmnd);
				quanLy.deleteKhachTro(phongTro, cmnd);
				break;
			case 4:
				System.out.println("Ket thuc chuong trinh");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Nhap sai, moi ban nhap lai.");
				break;
			}
		}
		
	}
}
