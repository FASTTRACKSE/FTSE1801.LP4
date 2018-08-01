import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * NhanVien Class
 * 
 * @author CongMT
 *
 */
public class NhanVien extends CanBo implements Serializable {

	private String phongBan;
	private int soNgayCong;
	private String chucVu;

	public NhanVien() {
		super();
	}

	public NhanVien(String hoTen, double heSoLuong, int phuCap) {
		super(hoTen, phuCap, phuCap);

	}

	public NhanVien(String hoTen, double heSoLuong, int phuCap, String phongBan, int soNgayCong, String chucVu) {
		super(chucVu, soNgayCong, soNgayCong);
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
	/**
	 *  Tinh luong theo so ngay cong cua nhan vien
	 */
	public long tinhLuong() {
		return (long) (this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoNgayCong() * 45);
	}
	/**
	 * Nhap thong tin nhan vien
	 * @param sc
	 */
	public void NhapThongTinNhanVien(Scanner sc) {
		boolean inputOK;
		int N = 0;
		System.out.println("Nhập thông tin cán bộ");
		System.out.println("+------------------------------+");
		do {
			try {
				inputOK = true;
				System.out.print("Nhập Số Lượng Cán bộ: ");
				N = sc.nextInt();
				if (N < 0) {
					throw new Exception("Chỉ được nhập số dương.");
				}
			} catch (Exception e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);

		// Nhập tên cán bộ
		String hoTen = "";
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập Thông Tin Cán bộ thứ " + (i + 1) + "\n");
			sc.nextLine();
			do {
				try {
					inputOK = true;
					System.out.print("Nhập Tên Cán bộ: ");
					hoTen = sc.nextLine();
					if (hoTen.length() < 1 || hoTen.length() > 40) {
						throw new Exception("Chỉ được nhập số dương.");
					}

				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				} finally {
				}
			} while (!inputOK);

			// Nhập hệ số lương
			double heSoLuong = 0;
			do {
				try {
					inputOK = true;
					System.out.print("Nhập hệ số lương: ");
					heSoLuong = sc.nextDouble();
					if (heSoLuong < 0) {
						throw new Exception("Chỉ được nhập số dương.");
					}
				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);
			sc.nextLine();

			// Nhập phòng ban
			String phongBan = "";
			do {
				try {
					inputOK = true;
					System.out.print("Nhập Phòng ban: ");
					phongBan = sc.nextLine();
					if (phongBan.length() == 0) {
						throw new Exception("Bạn nhập sai phòng ban");
					}
				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			// nhap phu cap
			int phuCap = 0;
			String chucVu = null;
			int choose;
			do {
				System.out.print("Nhập chức vụ: 1.Trưởng phòng  2.Phó phòng  3.Nhân viên ");
				choose = sc.nextInt();
				switch (choose) {
				case 1:
					chucVu = "Chức vụ: Trưởng phòng";
					System.out.println("phụ cấp: 2.000.000 VNĐ \n");
					phuCap = 2000000;
					break;
				case 2:
					chucVu = "Chức vụ: Phó Phòng";

					System.out.println(" phụ cấp: 1.000.000 VNĐ \n");
					phuCap = 1000000;
					break;
				case 3:
					chucVu = "Chức vụ: Nhân viên";

					System.out.println(" phụ cấp: 500.000 VNĐ \n");
					phuCap = 500000;
					break;
				}
			} while (choose < 1 || choose > 3);

			// Nhập số ngày công
			int soNgayCong = 0;
			do {
				try {
					inputOK = true;
					System.out.print("Nhập Số ngày công: ");
					soNgayCong = sc.nextInt();
					if (soNgayCong < 0) {
						throw new Exception("Chỉ được nhập số dương.");
					}
				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);
			System.out.println("------------------------------------------------------------------");
			// gan gia tri
			setChucVu(chucVu);
			setHeSoLuong(heSoLuong);
			setHoTen(hoTen);
			setPhongBan(phongBan);
			setPhuCap(phuCap);
			setSoNgayCong(soNgayCong);
			setNganh("NhanVien");
		}
	}
	/**
	 * Xuat thong tin nhan vien
	 */
	public void XuatThongTinNhanVien() {
		System.out.println(
				"+---------------------------------DANH SÁCH CÁN BỘ HÀNH CHÍNH--------------------------------------+");
		System.out.println(
				"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |  Tiền lương   |");

		System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s %-16s\n", getHoTen(), phongBan, getHeSoLuong(),
				phuCap, chucVu, soNgayCong, tinhLuong());

	}

}