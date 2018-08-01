package quanlysv.view;

import java.util.ArrayList;
import java.util.Scanner;

import quanlysv.entity.Diem;
import quanlysv.entity.SinhVien;

public class QuanLySinhVienView {
	private Scanner sc = new Scanner(System.in);

	public String menu() {
		System.out.println("/***********************************/");
		System.out.println("/****************MENU***************/");
		System.out.println("1. Thêm sinh viên.");
		System.out.println("2. Thêm điểm cho sinh viên.");
		System.out.println("3. Sửa thông tin sinh vien theo MASV.");
		System.out.println("4. Xóa 1 sinh vien theo MASV.");
		System.out.println("5. Sửa điểm 1 sinh vien theo MASV và MONHOC.");
		System.out.println("6. Xóa điểm 1 sinh viên theo MASV và MONHOC.");
		System.out.println("7. Hiển thị hết tất cả sinh vien.");
		System.out.println("8. Hiển thị thông tin sinh vien theo TEN.");
		System.out.println("0. Kết thúc chương trình .");
		System.out.println("/***********************************/");

		System.out.print("Moi ban lua chon : ");
		return sc.nextLine();

	}
	/**
	 * Thêm mới 1 sinh viên
	 * @return
	 */
	public SinhVien addSinhVien() {
		SinhVien sinhvien = new SinhVien();
		String maSV = null;
		String tenSV = null;
		String pass = null;
		// Nhap gia tri tu ban phim
		System.out.println("Moi nhap ten sinh vien:");
		System.out.println("Nhap ma SV:");
		maSV = sc.nextLine();
		System.out.println("Nhap ten sinh vien:");
		tenSV = sc.nextLine();
		System.out.println("Nhap pass:");
		pass = sc.nextLine();
		// Gan gia tri
		sinhvien.setMaSinhVien(maSV);
		sinhvien.setTenSinhVien(tenSV);
		sinhvien.setPassSinhVien(pass);
		return sinhvien;
	}
	/**
	 * Thêm điểm 1 sinh viên
	 * @return
	 */
	public SinhVien nhapDiemSinhVien() {
		SinhVien sinhvien = new SinhVien();
		Diem diem;
		String maSV = null;
		String monHoc = null;
		int diem1 = 0;
		System.out.println("Moi nhap diem sinh vien:");
		System.out.println("Nhap ma SV:");
		maSV = sc.nextLine();
		System.out.println("Nhap ten mon hoc:");
		monHoc = sc.nextLine();
		System.out.println("Nhap diem:");
		diem1 = sc.nextInt();
		// Gan gia tri
		sinhvien.setMaSinhVien(maSV);
		diem = new Diem();
		diem.setDiem(diem1);
		diem.setMonHoc(monHoc);
		sinhvien.setDiem(diem);

		return sinhvien;
	}
	/**
	 * Update 1 sinh viên theo Mã SV
	 * @return
	 */
	public SinhVien updateSinhVien() {
		SinhVien sinhvien = new SinhVien();
		String maSV = null;
		String tenSV = null;
		String pass = null;
		// Nhap gia tri tu ban phim
		System.out.println("Moi nhap ten sinh vien:");
		System.out.println("Nhap ma SV:");
		maSV = sc.nextLine();
		System.out.println("Nhap ten sinh vien:");
		tenSV = sc.nextLine();
		System.out.println("Nhap pass:");
		pass = sc.nextLine();
		// Gan gia tri
		sinhvien.setMaSinhVien(maSV);
		sinhvien.setTenSinhVien(tenSV);
		sinhvien.setPassSinhVien(pass);
		return sinhvien;

	}
	/**
	 * Xóa 1 sinh viên theo Mã SV
	 * @return
	 */
	public SinhVien deletelSinhVien() {
		SinhVien sinhvien = new SinhVien();
		String maSV = null;
		// Nhap gia tri tu ban phim
	
		System.out.println("Nhap ma can xoa SV:");
		maSV = sc.nextLine();
		//Gan gia tri
		sinhvien.setMaSinhVien(maSV);
		return sinhvien;
	}
	/**
	 * Upadate điểm 1 sinh viên theo mã SV và môn h�?c
	 * @return
	 */
	public SinhVien updateDiemSinhVien() {
		SinhVien sinhvien = new SinhVien();
		Diem diem;
		String maSV = null;
		String monHoc = null;
		int diem1 = 0;
		System.out.println("Moi nhap diem sinh vien:");
		System.out.println("Nhap ma SV:");
		maSV = sc.nextLine();
		System.out.println("Nhap ten mon hoc:");
		monHoc = sc.nextLine();
		System.out.println("Nhap diem can sua:");
		diem1 = sc.nextInt();
		// Gan gia tri
		sinhvien.setMaSinhVien(maSV);
		diem = new Diem();
		diem.setDiem(diem1);
		diem.setMonHoc(monHoc);
		sinhvien.setDiem(diem);
		
		return sinhvien;
		
	}
	/**
	 *  Xóa điểm 1 sinh viên theo Mã SV và theo Môn h�?c
	 * @return
	 */
	public SinhVien deletelDiemSinhVien() {
		SinhVien sinhvien = new SinhVien();
		Diem diem;
		String maSV = null;
		String monHoc= null;
		// Nhap gia tri tu ban phim
		
		System.out.println("Nhap ma can xoa SV:");
		maSV = sc.nextLine();
		System.out.println("Nhap mon hoc can xoa");
		monHoc= sc.nextLine();
		//Gan gia tri
		sinhvien.setMaSinhVien(maSV);
		diem = new Diem();
		diem.setMonHoc(monHoc);
		sinhvien.setDiem(diem);
		return sinhvien;
		
	}
	/**
	 * Hien thi danh sach tat ca sinh vien
	 * @param listSv
	 */
	public void displaySinhVien(ArrayList<SinhVien> listSv) {
		String masv;
		
		
		System.out.printf("%-5s|%-30s|%-20s|%-20s|%-10s \n", "MaSV", "Ho va ten", "Password", "Ten mon hoc", "Diem");
		for (SinhVien sinhvien1 : listSv) {
			System.out.printf("%-5s|%-30s|%-20s|%-20s|%-10s \n", sinhvien1.getMaSinhVien(), sinhvien1.getTenSinhVien(),
					sinhvien1.getPassSinhVien(), sinhvien1.getDiem().getMonHoc(), sinhvien1.getDiem().getDiem());
		}
	}
	/**
	 * Hien thi danh sach tat ca sinh vien theo Ten
	 * @param listSv
	 */
	public void displaySinhVienTheoTen(ArrayList<SinhVien> listSv) {
		
		System.out.printf("%-5s|%-30s|%-20s|%-20s|%-10s \n", "MaSV", "Ho va ten", "Password", "Ten mon hoc", "Diem");
		for (SinhVien sinhvien1 : listSv) {
			System.out.printf("%-5s|%-30s|%-20s|%-20s|%-10s \n", sinhvien1.getMaSinhVien(), sinhvien1.getTenSinhVien(),
					sinhvien1.getPassSinhVien(), sinhvien1.getDiem().getMonHoc(), sinhvien1.getDiem().getDiem());
		}
	}
	public SinhVien hienThiTheoTen() {
		SinhVien sinhvien = new SinhVien();
		String tenSv = null;
		System.out.println("Moi nhap ten sinh vien:");
		tenSv=sc.nextLine();
		sinhvien.setTenSinhVien(tenSv);
		return sinhvien;
	}
}
