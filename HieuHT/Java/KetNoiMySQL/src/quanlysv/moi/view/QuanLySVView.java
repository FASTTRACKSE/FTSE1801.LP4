package quanlysv.moi.view;

import java.util.Scanner;

import quanlysv.moi.model.entity.Diem;
import quanlysv.moi.model.entity.SinhVien;

public class QuanLySVView {
	private static final SinhVien SinhVien = null;
	private static Scanner sc = new Scanner(System.in);
	static SinhVien sinhVien = new SinhVien();
	public static String menu() {
		System.out.println("                               MENU");
		System.out.println("1. Thêm sinh viên");
		System.out.println("2. Thêm điểm sinh viên");
		System.out.println("3. Sửa thông tin sinh viên theo MASV");
		System.out.println("4. Xóa sinh viên theo MASV");
		System.out.println("5. Sửa điểm 1 sinh viên theo MASV và MONHOC");
		System.out.println("6. Xóa điểm 1 sinh viên theo MASV và MONHOC");
		System.out.println("7. Hiển thị hết tất cả sinh vien theo thông tin: MASV, TEN, MONHOC, DIEM");
		System.out.println("8. Hiển thị thông tin sinh vien theo TEN : MASV, TEN, MONHOC, DIEM");
		System.out.println("\n Mời bạn chọn: ");
	
		return sc.nextLine();
	}
	
	/*
	 * thêm sinh viên
	 */
	public static SinhVien nhapInfoSinhVien() {
		
		String maSV = null;
		String tenSV = null;
		String passSV = null;
		
		System.out.println("Nhập mã số sinh viên: ");
		maSV = sc.nextLine();
		System.out.println("Nhập tên sinh viên: ");
		tenSV = sc.nextLine();
		System.out.println("Nhập password sinh viên: ");
		passSV = sc.nextLine();
		
		sinhVien.setMaSinhVien(maSV);
		sinhVien.setTenSinhVien(tenSV);
		sinhVien.setPassword(passSV);
		return sinhVien;
		
		
	}
	
	/*
	 * Thêm điểm sinh viên
	 */
	public SinhVien nhapDiemSinhVien() {
		Diem diem = new Diem();
		String maSV = null;
		String monHoc = null;
		int diemSV = 0;
		
		System.out.println("Nhập MASV: ");
		maSV = sc.nextLine();
		System.out.println("Nhập môn học: ");
		monHoc = sc.nextLine();
		System.out.println("Nhập điểm: ");
		diemSV = sc.nextInt();
		
		sinhVien.setMaSinhVien(maSV);
		diem.setMonhoc(monHoc);
		diem.setDiem(diemSV);
		sinhVien.setDiem(diem);
		return sinhVien;
	}
	
	/*
	 * Sửa thông tin sinh viên theo MASV
	 */
	public SinhVien updateSV() {
		
		String maSV = null;
		String tenSV = null;
		String passSV = null;
		
		System.out.println("Nhập MASV cần chỉnh sửa: ");
		maSV = sc.nextLine();
		System.out.println("Nhập tên mới cần thay đổi: ");
		tenSV = sc.nextLine();
		System.out.println("Nhập pass mới: ");
		passSV = sc.nextLine();
		
		sinhVien.setMaSinhVien(maSV);
		sinhVien.setTenSinhVien(tenSV);
		sinhVien.setPassword(passSV);
		return sinhVien;
	}
	
	/*
	 * Xóa sinh viên theo MASV
	 */
	public SinhVien deleteSV() {
		
		
		String maSV = null;
		System.out.println("Nhập MASV cần xóa: ");
		maSV = sc.nextLine();
		sinhVien.setMaSinhVien(maSV);
		return sinhVien;
	}
	
	/*
	 * Sửa sinh viên theo MASV và MONHOC
	 */
		public SinhVien update2SV() {
			
			Diem diem = new Diem();
			String maSV = null;
			String monHoc = null;
			int diemSV = 0;
			
			System.out.println("Nhập MASV: ");
			maSV = sc.nextLine();
			System.out.println("Nhập môn học: ");
			monHoc = sc.nextLine();
			System.out.println("Nhập điểm mới cho sinh viên: ");
			diemSV = sc.nextInt();
			
			sinhVien.setMaSinhVien(maSV);
			diem.setMonhoc(monHoc);
			diem.setDiem(diemSV);
			sinhVien.setDiem(diem);
			return sinhVien;
		}
}