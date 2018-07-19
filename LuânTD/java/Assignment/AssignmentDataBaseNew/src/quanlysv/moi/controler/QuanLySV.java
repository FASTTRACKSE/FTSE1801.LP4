package quanlysv.moi.controler;

import quanlysv.moi.view.QuanLySVView;

public class QuanLySV {
	QuanLySVView quanLySVView;

	public QuanLySV() {
		quanLySVView = new QuanLySVView();
	}

	public static void main(String[] args) {
		String choose = null;
		QuanLySV qLySinhVien = new QuanLySV();
		while (true) {
			choose = qLySinhVien.quanLySVView.menu();
			switch (choose) {
			case "1":
				qLySinhVien.quanLySVView.addSinhVien();
				break;
			case "2":
				qLySinhVien.quanLySVView.addDiem();
				break;
			case "3":
				qLySinhVien.quanLySVView.updateSV();
				break;
			case "4":
				qLySinhVien.quanLySVView.deleteSV();
				break;
			case "5":
				qLySinhVien.quanLySVView.updateDiemByMaSVAndMonHoc();
				break;
			case "6":
				qLySinhVien.quanLySVView.deleteDiemByMaSVAndMonHoc();
				break;
			case "7":
				qLySinhVien.quanLySVView.showAllSinhVien();
				break;
			case "8":
				qLySinhVien.quanLySVView.showSinhVienByName();
				break;
			case "0":

				break;
			default:
				System.out.println("Nhap sai. Nhap lai");
				break;
			}
		}

	}

}
