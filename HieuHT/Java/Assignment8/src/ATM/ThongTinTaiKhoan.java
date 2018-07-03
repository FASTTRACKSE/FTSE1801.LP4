package ATM;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ThongTinTaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ID;
	private String ten;
	private int soDuTK;
	private String loaiTienTe;
	private String trangThaiTK;

	public ThongTinTaiKhoan() {
	}

	public ThongTinTaiKhoan(String ID, String ten, int soDuTK, String loaiTienTe, String trangThaiTK) {
		this.ID = ID;
		this.ten = ten;
		this.soDuTK = soDuTK;
		this.loaiTienTe = loaiTienTe;
		this.trangThaiTK = trangThaiTK;
	}

	public String toString() {
		return (ID + "\n" + ten + "\n" + soDuTK + "\n" + loaiTienTe + "\n" + trangThaiTK);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int ID = 0;
		String ten = null;
		String soDuTK = null;
		String loaiTienTe = null;
		String trangThaiTK = null;
		boolean kiemTra;
		int tieptuc;
		ArrayList<ThongTinTaiKhoan> listThongTin = new ArrayList<ThongTinTaiKhoan>();
		// Nhập mã tài khoản
		do {
			System.out.print("Nhập mã tài khoản: ");
			ID = sc.nextInt();
			kiemTra = false;
		} while (kiemTra);

		do {

			// Nhập tên
			do {
				String pantter = "([A-Z][a-z]* )*([A-Z][a-z]*)";
				System.out.print("Nhap ten : ");
				ten = sc.nextLine();
				if (ten.matches(pantter)) {
					System.out.println("Bạn đã chọn đúng.");
					kiemTra = false;
				} else {
					System.out.println("Nhập sai, mời nhập lại.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhập số dư tài khoản
			do {
				String pattern = "([+])";
				System.out.print("Nhập số dư tài khoản: ");
				soDuTK = sc.nextLine();
				if (soDuTK.matches(pattern)) {
					System.out.println("Bạn đã nhập đúng.");
					kiemTra = false;
				} else {
					System.out.println("Nhập sai số, mời nhập lại.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhập loại tiền tệ
			do {
				String pantter = "([A-Z])";
				System.out.print("Nhập loại tiền tệ: ");
				loaiTienTe = sc.nextLine();
				if (ten.matches(pantter)) {
					System.out.println("Bạn đã chọn đúng.");
					kiemTra = false;
				} else {
					System.out.println("Nhập sai loại, mời nhập lại.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhập trạng thái tài khoản
			do {
				System.out.print("Nhập trạng thái tài khoản: ");
				trangThaiTK = sc.nextLine();
			} while (kiemTra);
			ThongTinTaiKhoan ThongTin = new ThongTinTaiKhoan(soDuTK, ten, ID, loaiTienTe, trangThaiTK);
			listThongTin.add(null);

			System.out.println("Bạn có muốn nhập tiếp (1: có | 0: không)");
			tieptuc = sc.nextInt();
			sc.nextLine();
		} while (tieptuc == 1);
		sc.close();
	}
}
