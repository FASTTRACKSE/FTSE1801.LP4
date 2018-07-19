package quanlysv.moi.view;

import java.util.ArrayList;
import java.util.Scanner;

import quanlysv.moi.entity.Diem;
import quanlysv.moi.entity.SinhVien;
import quanlysv.moi.modal.SinhVienDAO;

public class QuanLySVView {
	private Scanner sc = new Scanner(System.in);
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
	public String menu() {
		System.out.println("1. Thêm 1 sinh vien mới");
		System.out
				.println("2. Thêm điểm cho sinh viên (nếu mà MASV và MONHOC đã tồn tại thì chỉ cập nhật lại DIEM)");
		System.out.println("3. Sửa thông tin sinh vien theo MASV");
		System.out.println("4. Xóa 1 sinh vien theo MASV");
		System.out.println("5. Sửa điểm 1 sinh vien theo MASV và MONHOC");
		System.out.println("6. Xóa điểm 1 sinh viên theo MASV và MONHOC ");
		System.out.println("7. Hiển thị hết tất cả sinh vien theo thông tin : MASV, TEN, MONHOC, DIEM");
		System.out.println("8. Hiển thị thông tin sinh vien theo TEN : MASV, TEN, MONHOC, DIEM");
		System.out.println("0. Ket thuc!!!");
		System.out.println();
		System.out.print("Chon thao tac : ");
		
		return sc.nextLine();
	}
	
	public void showSinhVienByName() {
		System.out.print("Nhap ten sinh vien can hien thi: ");
		String name = sc.nextLine();
		SinhVien sinhVien = new SinhVien();
		sinhVien.setTenSv(name);
		ArrayList<SinhVien> listSV = sinhVienDAO.getSinhVienByName(sinhVien);
		if (!listSV.isEmpty()) {
			System.out.printf("%-10s%-25s%-15s%-15s%-10s%n", "Ma SV", "Ten SV", "Password", "Mon Hoc", "Diem");
			for (int i=0 ;i< listSV.size(); i++) {
				System.out.printf("%-10s%-25s%-15s%-15s%-10s%n", listSV.get(i).getMaSV(), listSV.get(i).getTenSv(), listSV.get(i).getPass(),
						listSV.get(i).getDiem().getMonHoc(), listSV.get(i).getDiem().getDiem());
			}
		}else {
			System.out.println("khong co sinh vien, kiem tra lai ten sinh vien");
		}
	}
	public void showAllSinhVien() {
		ArrayList<SinhVien> listSV = sinhVienDAO.getAllSinhVien();
		if (!listSV.isEmpty()) {
			System.out.printf("%-10s%-25s%-15s%-15s%-10s%n", "Ma SV", "Ten SV", "Password", "Mon Hoc", "Diem");
			for (int i=0 ;i< listSV.size(); i++) {
				System.out.printf("%-10s%-25s%-15s%-15s%-10s%n", listSV.get(i).getMaSV(), listSV.get(i).getTenSv(), listSV.get(i).getPass(),
						listSV.get(i).getDiem().getMonHoc(), listSV.get(i).getDiem().getDiem());
			}
		}else {
			System.out.println("khong co sinh vien, kiem tra lai ten sinh vien");
		}
	}
	
	public SinhVien themSinhVien() {
		SinhVien sinhVien = new SinhVien();
		
		System.out.print("nhap ma sinh vien: ");
		String maSV = sc.nextLine();
		System.out.print("Nhap ten sinh vien: ");
		String name = sc.nextLine();
		System.out.print("Nhap mat khau: ");
		String pass = sc.nextLine();

		sinhVien.setMaSV(maSV);
		sinhVien.setTenSv(name);
		sinhVien.setPass(pass);
		
		return sinhVien;
	}
	
	public void addSinhVien() {
		if (sinhVienDAO.addSinhVien(themSinhVien())) {
			System.out.println("Nhap sinh vien thanh cong");
		}else {
			System.out.println("That bai");
		}
	}
	
	public SinhVien themDiem() {
		SinhVien sinhVien = new SinhVien();
		Diem diem = new Diem();
		System.out.print("nhap ma sinh vien: ");
		String maSV = sc.nextLine();
		System.out.print("Nhap ten mon hoc: ");
		String monHoc = sc.nextLine();
		System.out.print("Nhap diem: ");
		double point = sc.nextDouble();

		sinhVien.setMaSV(maSV);
		diem.setMonHoc(monHoc);
		diem.setDiem(point);
		sinhVien.setDiem(diem);
		return sinhVien;
	}
	
	public void addDiem() {
		SinhVien sinhVien = themDiem();
		if (sinhVienDAO.updateDiem(sinhVien)) {
			System.out.println("cap nhat thanh cong");
		}else if(sinhVienDAO.addDiemSV(sinhVien)) {
			System.out.println("Them diem thanh cong");
		}else {
			System.out.println("That bai");
		}
	}
	
	public void updateSV() {
		if (sinhVienDAO.updateSV(themSinhVien())) {
			System.out.println("Cap nhat thanh cong");
		}else {
			System.out.println("Cap nhat that bai, kiem tra lai ma sinh vien");
		}
		
	}
	
	public void deleteSV() {
		SinhVien sinhVien = new SinhVien();
		System.out.print("nhap ma sinh vien: ");
		String maSV = sc.nextLine();
		sinhVien.setMaSV(maSV);
		sinhVienDAO.deleteDiemSV(sinhVien);
		if (sinhVienDAO.deleteSV(sinhVien)) {
			System.out.println("Xoa thanh cong");
		}else {
			System.out.println("Xoa that bai");
		}
	}
	
	public void updateDiemByMaSVAndMonHoc() {
		if (sinhVienDAO.updateSVByMaSVAndMonHoc(themDiem())) {
			System.out.println("Cap nhat thanh cong");
		}else {
			System.out.println("Cap nhat that bai, kiem tra lai maSV va monHoc");
		}
	}
	
	public SinhVien addMaSVAndMonHoc() {
		SinhVien sinhVien = new SinhVien();
		Diem diem = new Diem();
		System.out.print("nhap ma sinh vien: ");
		String maSV = sc.nextLine();
		System.out.print("Nhap ten mon hoc: ");
		String monHoc = sc.nextLine();
		sinhVien.setMaSV(maSV);
		diem.setMonHoc(monHoc);
		sinhVien.setDiem(diem);
		return sinhVien;
	}
	
	public void deleteDiemByMaSVAndMonHoc() {
		if (sinhVienDAO.deleteDiemByMaSVAndMonHoc(addMaSVAndMonHoc())) {
			System.out.println("Xoa thanh cong");
		}else{
			System.out.println("Xoa that bai, kiem tra lai ma sinh vien va mon hoc");
		}
	}
	
}
