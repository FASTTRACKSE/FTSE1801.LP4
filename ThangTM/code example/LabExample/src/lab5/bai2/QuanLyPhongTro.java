package lab5.bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyPhongTro {
	private ArrayList<PhongTro> listPhongTro;

	public QuanLyPhongTro() {
		listPhongTro = new ArrayList<PhongTro>();
	}

	public void choThuePhong(PhongTro phongTro) {
		listPhongTro.add(phongTro);
	}

	public void traPhong(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			listPhongTro.remove(phongTro);
			System.out.println("da tra phong");
		} else {
			System.out.println("sai CMND cmnr");
		}
	}

	public void layThongTinPhongTro(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			phongTro.hienThongTin();
		} else {
			System.out.println("sai CMND cmnr");
		}
	}

	public void tinhTienTraPhong(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			System.out.println(
					"So tien khach " + phongTro.getKhach().getHoTen() + " phai tra la : " + phongTro.thanhTien());
		} else {
			System.out.println("sai CMND cmnr");
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so phong can tro :");
		int soPhongChoThue = scanner.nextInt();
		scanner.nextLine();

		// cho thue
		PhongTro phongTro;
		for (int i = 0; i < soPhongChoThue; i++) {
			phongTro = new PhongTro();
			phongTro.nhapThongTin(scanner);
			choThuePhong(phongTro);
		}

		// hien thi thong tin
		for (int i = 0; i < listPhongTro.size(); i++) {
			listPhongTro.get(i).hienThongTin();
		}

		// tinh tien phong cua 1 khach
		tinhTienTraPhong("20159");
		// tra phong cua 1 khach
		traPhong("20159");
	}

	public static void main(String[] args) {
		QuanLyPhongTro quanLyPhongTro = new QuanLyPhongTro();
		quanLyPhongTro.menu();
	}
}
