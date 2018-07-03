import java.util.Scanner;

public class GiangVien extends CanBo {

	public void nhapGiangVien(Scanner sc) {
		System.out.print("Nhập họ tên: ");
		String hoTen = sc.next();
		setHoTen(hoTen);
		
		System.out.print("Nhập hệ số lương: ");
		float heSoLuong = sc.nextFloat();
		setHeSoLuong(heSoLuong);
		
		System.out.print("Nhập khoa: ");
		String khoa = sc.next();
		setDonVi(khoa);
		
		int choose;
		do {
			System.out.println("Nhập trình độ, chọn: \n1. Tiến sĩ \n2. Thạc sĩ \n3. Cử nhân");
			choose = sc.nextInt();
			switch (choose) {
				case 1:
					capBac = "Tiến sĩ";
					this.setPhuCap(1000);
					break;
				case 2:
					capBac = "Thạc sĩ";
					this.setPhuCap(500);
					break;
				case 3:
					capBac = "Cử nhân";
					this.setPhuCap(300);
					break;
				default:
					System.out.println("Chọn sai");
					break;
			}
		} while (choose <1 || choose >3);
		setCapBac(capBac);
		
		System.out.print("Nhập số tiết: ");
		int soTiet = sc.nextInt();
		setThoiGianLamViec(soTiet);
		
		setLuong(getHeSoLuong()*730 + getPhuCap() + getThoiGianLamViec()*45);
	}
	
	public void xuatGiangVien() {
		System.out.printf("%-14s %-14s %-13s %-13s %-13s %-13s\n", "Họ tên", "Hệ số lương", "Khoa", "Trình độ", "Số tiết", "Tổng lương");
		System.out.printf("%-14s %-14s %-13s %-13s %-13s %-13s\n\n", getHoTen(), getHeSoLuong(), getDonVi(), getCapBac(), getThoiGianLamViec(), getLuong());
	}
}
