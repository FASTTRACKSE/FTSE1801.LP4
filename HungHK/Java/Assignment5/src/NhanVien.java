import java.util.Scanner;

public class NhanVien extends CanBo {

	public void nhapNhanVien(Scanner sc) {
		System.out.print("Nhập họ tên: ");
		String hoTen = sc.next();
		setHoTen(hoTen);
		
		System.out.print("Nhập hệ số lương: ");
		float heSoLuong = sc.nextFloat();
		setHeSoLuong(heSoLuong);
		
		System.out.print("Nhập phòng ban: ");
		String phongBan = sc.next();
		setDonVi(phongBan);
		
		int choose;
		do {
			System.out.println("Nhập chức vụ, chọn: \n1. Trưởng phòng \n2. Phó phòng \n3. Nhân viên");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				capBac = "Trưởng phòng";
				this.setPhuCap(2000);
				break;
			case 2:
				capBac = "Phó phòng";
				this.setPhuCap(1000);
				break;
			case 3:
				capBac = "Nhân viên";
				this.setPhuCap(500);
				break;
			default:
				System.out.println("Chọn sai");
				break;
			}
		} while (choose < 1 || choose > 3);
		setCapBac(capBac);
		
		System.out.print("Nhập số ngày công: ");
		int soNgayCong = sc.nextInt();
		setThoiGianLamViec(soNgayCong);
		
		setLuong(getHeSoLuong()*730 + getPhuCap() + getThoiGianLamViec()*30);
	}

	public void xuatNhanVien() {
		System.out.printf("%-14s %-14s %-14s %-14s %-14s %-14s\n", "Họ tên", "Hệ số lương", "Phòng ban", "Chức vụ", "Số ngày công", "Tổng lương");
		System.out.printf("%-14s %-14s %-14s %-14s %-14s %-14s\n\n", getHoTen(), getHeSoLuong(), getDonVi(), getCapBac(), getThoiGianLamViec(), getLuong());
	}
}
