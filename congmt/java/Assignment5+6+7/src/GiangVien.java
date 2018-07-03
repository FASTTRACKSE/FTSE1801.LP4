import java.io.Serializable;
import java.util.Scanner;

/**
 * GiangVien Class
 * 
 * @author CongMT
 *
 */
public class GiangVien extends CanBo implements Serializable {
	private String khoa;
	private String trinhDo;
	private int soTietDay;

	public GiangVien() {
		super();

	}

	public GiangVien(String hoTen, double heSoLuong, int phuCap) {
		super(hoTen, heSoLuong, phuCap);

	}

	public GiangVien(String khoa, String trinhDo, int soTietDay, String hoTen, double heSoLuong, int phuCap) {
		super(hoTen, heSoLuong, phuCap);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	/**
	 * Tinh luong theo so tiet day cua giang vien
	 */
	public long tinhLuong() {
		return (long) (this.getHeSoLuong() * 730000 + this.getPhuCap() + this.getSoTietDay() * 45);
	}
	/**
	 * Nhap thong tin giang vien
	 * @param sc
	 */
	public void NhapThongTinGiangVien(Scanner sc) {
		boolean kiemTra;
		int N = 0;
		System.out.println("Nhập thông tin Giảng Viên");
		System.out.println("+------------------------------+");
		// Nhap so luong giang vien
		do {
			try {
				kiemTra = false;
				System.out.print("Nhập Số Lượng Giảng viên: ");
				N = sc.nextInt();
				if (N < 0) {
					throw new Exception("Không được nhập số âm.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		// Nhập Họ Tên
		String hoTen = null;
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập Thông Tin Giảng viên thứ " + (i + 1) + "\n");
			sc.nextLine();

			do {
				try {
					kiemTra = true;
					System.out.print("Nhập Tên Giảng viên: ");
					hoTen = sc.nextLine();

					if (hoTen.isEmpty()) {
						throw new Exception("Tên đăng nhập không để rỗng!!");
					}
					if (hoTen.length() < 1 || hoTen.length() > 40) {
						throw new Exception("Tên đăng nhập không quá 40 ký tự.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = false;
				}
			} while (!kiemTra);
			// Nhập hệ số lương và chỉ được nhập số dương
			double heSoLuong = 0;
			do {
				try {
					kiemTra = true;
					System.out.print("Nhập hệ số lương: ");
					heSoLuong = sc.nextDouble();

					if (heSoLuong < 0) {
						throw new Exception("Chỉ được phép nhập số dương");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = false;
				}
			} while (!kiemTra);
			sc.nextLine();

			// Nhập KHOA
			String khoa = null;
			do {
				try {
					kiemTra = true;
					System.out.print("Nhập Khoa: ");
					khoa = sc.nextLine();

					if (khoa.length() == 0) {
						throw new Exception("Bạn nhập sai.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = false;
				}
			} while (!kiemTra);

			// Nhập trình độ và phụ cấp
			int phuCap = 0;
			String trinhDo = null;
			int choose;
			do {
				System.out.print("Nhập trình độ: 1.Cử nhân  2.Thạc sĩ  3.Tiến sĩ ");
				choose = sc.nextInt();
				switch (choose) {
				case 1:
					trinhDo = "Trình độ: Cử nhân";
					System.out.print("Phụ cấp: 300.000 VNĐ \n");
					phuCap = 300000;
					break;
				case 2:
					trinhDo = "Trình độ: Thạc sĩ";
					System.out.print("Phụ cấp: 500.000 VNĐ \n");
					phuCap = 500000;
					break;
				case 3:
					trinhDo = "Trình độ: Tiến sĩ";
					System.out.print("Phụ cấp: 1.000.000 VNĐ \n");
					phuCap = 1000000;
					break;
				}
			} while (choose < 1 || choose > 3);

			// Nhập số tiết dạy và chỉ được nhập số dương
			int soTietDay = 0;
			do {
				try {
					kiemTra = true;
					System.out.print("Nhập Số tiết dạy: ");
					soTietDay = sc.nextInt();

					if (soTietDay < 0) {
						throw new Exception("Chỉ được phép nhập số dương.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = false;
				}
			} while (!kiemTra);
			System.out.println("------------------------------------------------------------------");
			// gan gia tri
			setHoTen(hoTen);
			setHeSoLuong(heSoLuong);
			setKhoa(khoa);
			setPhuCap(phuCap);
			setSoTietDay(soTietDay);
			setTrinhDo(trinhDo);
			setNganh("GiangVien");
		}
	}
	/**
	 * Xuat thong tin giang vien
	 */
	public void XuatThongTinGiangVien() {

		System.out.println(
				"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
		System.out.println(
				"|   Tên GV     |     Trình độ      |Hệ số lương|   Phụ cấp   | Khoa |  Số tiết  |   Tiền lương   |");

		System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", getHoTen(), trinhDo,getHeSoLuong(),phuCap,khoa,soTietDay,tinhLuong());

	}
}