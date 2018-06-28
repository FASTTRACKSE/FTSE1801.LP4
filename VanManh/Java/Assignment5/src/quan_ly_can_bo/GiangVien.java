package quan_ly_can_bo;

import java.util.Scanner;

public class GiangVien extends CanBo {

	/**
	 * Them giang vien
	 * 
	 * @param giangvien
	 * @param input
	 */
	public void addGiangVien(Scanner input, GiangVien giangvien) {

		input.nextLine();
		System.out.print("Nhap ten giang vien : ");
		String name = input.nextLine();
		System.out.print("nhap khoa giang vien : ");
		String khoa = input.nextLine();

		System.out.print("Chon trinh do giang vien : (1: Cu nhan | 2: Thac si | 3: Tien si) ");
		int trinhDo = input.nextInt();
		switch (trinhDo) {
		case 1:
			giangvien.setTrinhDo("Cu nhan");
			giangvien.setPhuCap(300);
			break;
		case 2:
			giangvien.setTrinhDo("Thac si");
			giangvien.setPhuCap(500);
			break;
		case 3:
			giangvien.setTrinhDo("Tien si");
			giangvien.setPhuCap(1000);
			break;
		default:
			System.out.println("Nhap sai, moi ban chon lai");
			break;
		}

		System.out.print("Nhap so tiet day : ");
		int soTiet = input.nextInt();
		System.out.print("Nhap he so luong : ");
		double heSoLuong = input.nextDouble();

		giangvien.setTen(name);
		giangvien.setDonVi(khoa);
		giangvien.setThoiGianTinhLuong(soTiet);
		giangvien.setHeSoLuong(heSoLuong);
		giangvien.setLuong(heSoLuong * 730 + giangvien.getPhuCap() + soTiet * 45);
		giangvien.setNganh("Giang vien");
	}

}
