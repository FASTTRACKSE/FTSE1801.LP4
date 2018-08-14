package quanlysv.moi.controler;

import java.util.ArrayList;

import quanlysv.moi.model.SinhVienDAO;
import quanlysv.moi.model.entity.SinhVien;
import quanlysv.moi.view.QuanLySVView;

public class QuanLy_SV {
	SinhVienDAO sinhVienDAO;
	QuanLySVView quanLySvView;

	public QuanLy_SV() {
		sinhVienDAO = new SinhVienDAO();
		quanLySvView = new QuanLySVView();
	}

	/*
	 * Hiển thị danh sách sinh viên
	 */
	public void displayAllSV() {
		ArrayList<SinhVien> listSv = sinhVienDAO.getAllSinhVien();
		for (SinhVien sinhVien : listSv) {
			System.out.println(sinhVien.getMaSinhVien() + "-" + sinhVien.getTenSinhVien() + "-"
					+ sinhVien.getDiem().getMonhoc() + "-" + sinhVien.getDiem().getDiem());
		}
	}

	/*
	 * Thêm sinh viên
	 */
	public void addSinhVien() {
		SinhVien sinhVien = QuanLySVView.nhapInfoSinhVien();

		if (sinhVienDAO.addSinhVien(sinhVien)) {
			System.out.println("Thêm vào thành công");
		} else {
			System.out.println("Thêm vào thất bại");
		}
	}

	/*
	 * Thêm điểm sinh viên
	 */
	public void addDiemSinhVien() {
		SinhVien sinhVien = quanLySvView.nhapDiemSinhVien();

		if (sinhVienDAO.addDiemSinhVien(sinhVien)) {
			System.out.println("Thêm vào thành công");
		} else {
			System.out.println("Thêm vào thất bại");
		}
	}

	/*
	 * Cập nhật sinh viên
	 */
	public void updateSV() {
		SinhVien sinhVien = quanLySvView.updateSV();

		if (sinhVienDAO.updateSV(sinhVien)) {
			System.out.println("Cập nhật thành công");
		} else {
			System.out.println("Cập nhật thất bại");
		}
	}

	/*
	 * Xóa sinh viên theo MASV
	 */
	public void deleteSV() {
		SinhVien sinhVien = quanLySvView.deleteSV();

		if (sinhVienDAO.deleteSV(sinhVien)) {
			System.out.println("Xóa thành công");
		} else {
			System.out.println("Xóa thất bại");
		}
	}

	/*
	 * Sửa sinh viên theo MASV và MONHOC
	 */
	public void update2SV() {
		SinhVien sinhVien = quanLySvView.update2SV();
		
		if (sinhVienDAO.update2SV(sinhVien)) {
			System.out.println("Chỉnh sửa thành công");
		} else {
			System.out.println("Chỉnh sửa thất bại");
		}
	}

	public void menu() {
		while (true) {
			String choose = QuanLySVView.menu();
			switch (choose) {
			case "1":
				addSinhVien();
				break;
			case "2":
				addDiemSinhVien();
				break;
			case "3":
				updateSV();
				break;
			case "4":
				deleteSV();
				break;
			case "5":
				update2SV();
				break;
			case "7":
				displayAllSV();
				break;
			default:
				System.out.println("Xin chon lai");
				break;
			}
		}
	}

	public static void main(String[] args) {
		QuanLy_SV qlSV = new QuanLy_SV();
		qlSV.menu();
	}
}