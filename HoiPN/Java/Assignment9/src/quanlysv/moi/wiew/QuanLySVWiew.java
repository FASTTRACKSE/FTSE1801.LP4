package quanlysv.moi.wiew;

import java.util.Scanner;

import quanlysv.moi.model.entity.Diem;
import quanlysv.moi.model.entity.SinhVien;

public class QuanLySVWiew {
	private Scanner sc = new Scanner(System.in);

	public String menu() {
		System.out.println("1. Thêm sinh viên mới.");
		System.out.println("2. Sửa điểm sinh viên.");
		System.out.println("3. Sưả thông tin sinh viên theo mã sinh viên.");
		System.out.println("4. Xóa sinh viên theo mã.");
		System.out.println("5. xóa điểm sinh viên theo mã môn học.");
		System.out.println("6. Hiển thi tất cả sinh viên.");
		System.out.println("7. Hiển thị sinh viên theo tên.");
		System.out.println("0. Kết thúc chương trình.");

		return sc.nextLine();
	}

	public SinhVien nhapInfoSinhVien() {
		System.out.println("Nhap thong tin theo thu tu ma sinh vien, ten,pass.");
		SinhVien sinhvien = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), null);
		return sinhvien;
	}

	public SinhVien nhapDiemSinhVien() {
		System.out.println("Nhap thong tin theo thu tu ma sinh vien, mon hoc,diem.");

		SinhVien sinhVien = new SinhVien(sc.nextLine(), null, null,
				new Diem(sc.nextLine(), Integer.parseInt(sc.nextLine())));
		return sinhVien;
	}

	public SinhVien themSinhVien() {
		System.out.println("Nhap mã thông tin cần sửa, tên sinh viên mới, pass mới: ");
		SinhVien sinhvien = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), null);
		return sinhvien;
	}

	public SinhVien xoaDiem() {
		SinhVien sinhvien = new SinhVien();
		Diem diem = new Diem();
		System.out.println("Nhap mã sinh vien va mon hoc cần xoá diem: ");
		sinhvien.setMaSinhVien(sc.nextLine());
		diem.setMonHoc(sc.nextLine());
		sinhvien.setDiem(diem);
		return sinhvien;
	}
	
	public String xoaSinhVien() {
		System.out.println("Nhap mã sinh vien cần xoá : ");
		return sc.nextLine();
		
	}
	
	public String showSinhVien() {
		System.out.println("Nhap tên sinh vien cần hiển thị : ");
		return sc.nextLine();
		
	}
	
	
}
