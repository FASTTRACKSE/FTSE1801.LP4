package canBo;

import java.util.Scanner;

public class GiangVien extends CanBo {

	public double luongGiangVien() {
		return this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoGioLam() * 30;
	}

	public void nhapGiangVien(Scanner sc, GiangVien giangVien) {
		sc.nextLine();
		System.out.println("Nhap ho ten: ");
		String hoTen = sc.nextLine();
		System.out.println("Nhap khoa: ");
		String khoa = sc.nextLine();
		System.out.println("Nhap so tiet day: ");
		int soTiet = sc.nextInt();
		System.out.println("Nhap he so luong: ");
		double heSoLuong = sc.nextDouble();
		System.out.println("Nhap trinh do: ");
		System.out.println("Nhap 1:Cu Nhan, 2:Thac Si, 3: Tien Si");
		int trinhDo = sc.nextInt();
		giangVien.setHoTen(hoTen);
		giangVien.setDonVi(khoa);
		giangVien.setSoGioLam(soTiet);
		giangVien.setHeSoLuong(heSoLuong);
		giangVien.setLuong(giangVien.luongGiangVien());
		switch (trinhDo) {
		case 1:
			giangVien.setTrinhDo("Cu Nhan");
			giangVien.setPhuCap(300);
			break;

		case 2:
			giangVien.setTrinhDo("Thac Si");
			giangVien.setPhuCap(500);
			break;

		case 3:
			giangVien.setTrinhDo("Tien Si");
			giangVien.setPhuCap(1000);
			break;
		default:
			System.out.println("Nhap sai, moi ban chon lai");
			break;
		}
	}

}
