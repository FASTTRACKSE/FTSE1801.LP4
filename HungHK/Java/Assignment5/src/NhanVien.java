import java.util.Scanner;

public class NhanVien extends CanBo {
	private String phongBan;
	private int soNgayCong;
	private String chucVu;

	public NhanVien() {
	}

	public NhanVien(String phongBan, int soNgayCong, String chucVu) {
		super();
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void nhapNhanVien(Scanner sc) {
		super.nhapCanBo(sc);
		sc.nextLine();

		System.out.print("Nhập phòng ban: ");
		String phongBan = sc.nextLine();
		setPhongBan(phongBan);

		int choose;
		do {
			System.out.println("Nhập chức vụ, chọn: \n1. Trưởng phòng \n2. Phó phòng \n3. Nhân viên");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				chucVu = "Trưởng phòng";
				this.setPhuCap(2000);
				break;
			case 2:
				chucVu = "Phó phòng";
				this.setPhuCap(1000);
				break;
			case 3:
				chucVu = "Nhân viên";
				this.setPhuCap(500);
				break;
			default:
				System.out.println("Chọn sai");
				break;
			}
		} while (choose < 1 || choose > 3);
		setChucVu(chucVu);

		System.out.print("Nhập số ngày công: ");
		int soNgayCong = sc.nextInt();
		setSoNgayCong(soNgayCong);
	}

	public double tinhLuong() {
		double luong = getHeSoLuong() * 730 + getPhuCap() + getSoNgayCong() * 30;
		return luong;
	}

	public void xuatNhanVien() {
		super.xuatCanBo();
		System.out.println("Phòng ban: " + getPhongBan());
		System.out.println("Chức vụ: " + getChucVu());
		System.out.println("Số ngày công: " + getSoNgayCong());
		System.out.println("Tổng lương: " + tinhLuong());
	}
}
