package lab5;

import java.util.ArrayList;
/**
 * 
 * 
 * @author Phươngnt
 *
 */
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
			System.out.println("Đã trả phòng");
		} else {
			System.out.println("sai CMND");
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
			System.out.println("sai CMND");
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
					"Số tiền khách hàng " + phongTro.getKhach().getHoTen() + " phải trả là : " + phongTro.thanhTien());
		} else {
			System.out.println("sai CMND");
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số phòng cần trọ:");
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

	}

	public static void main(String[] args) {
		QuanLyPhongTro quanLyPhongTro = new QuanLyPhongTro();
		quanLyPhongTro.menu();
	}
}