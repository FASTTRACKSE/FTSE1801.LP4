import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyCanBo {

	private ArrayList<CanBo> dsNhanVien;
	long tongLuong = 0;
	long luong;

	public QuanLyCanBo() {
		dsNhanVien = new ArrayList<CanBo>();
	}

	public static void menu() {
		System.out.println("+---------------------------------------------------+");
		System.out.println("+------------------------MENU-----------------------+");
		System.out.println("|1.Nhập Thông Tin Cán Bộ                            |");
		System.out.println("|2.Xuất thông tin Giảng Viên hoặc Nhân Viên         |");
		System.out.println("|3.Tổng số lương phải trả cho cán bộ                |");
		System.out.println("|4.Sắp xếp Cán bộ                                   |");
		System.out.println("|5.Ghi file cán bộ                                  |");
		System.out.println("|6.Đọc file cán bộ                                  |");
		System.out.println("|5.Thoát chương trình                               |");
		System.out.println("+---------------------------------------------------+");
		System.out.println("Mời Bạn Chọn Chức Năng");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		QuanLyCanBo quanlycanbo = new QuanLyCanBo();
		int choose;
		menu();
		while (true) {
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				quanlycanbo.NhapThongTinNv(sc);
				break;

			case 2:
				quanlycanbo.XuatThongTin(sc);
				break;
			case 3:
				quanlycanbo.TongSoLuong();
				break;
			case 4:
				quanlycanbo.SapXepNV();
				break;
			case 5:
				quanlycanbo.GhiFile();
				break;
			case 6:
				quanlycanbo.DocFile();
				break;
			case 7:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}

		}
	}

	public void NhapThongTinNv(Scanner sc) {
		GiangVien giangvien;
		System.out.println("    Nhập thông tin");
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");

		int n = sc.nextInt();
		if (n == 1) {
			giangvien = new GiangVien();
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
			String hoTen = "";
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Giảng viên thứ " + (i + 1) + "\n");
				sc.nextLine();

				do {
					try {
						kiemTra = true;
						System.out.print("Nhập Tên Giảng viên: ");
						hoTen = sc.nextLine();
						giangvien.setHoTen(hoTen);
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
						giangvien.setHeSoLuong(heSoLuong);
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
				String khoa = "";
				do {
					try {
						kiemTra = true;
						System.out.print("Nhập Khoa: ");
						khoa = sc.nextLine();
						giangvien.setKhoa(khoa);
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
				giangvien.setTrinhDo(trinhDo);

				// Nhập số tiết dạy và chỉ được nhập số dương
				int soTietDay = 0;
				do {
					try {
						kiemTra = true;
						System.out.print("Nhập Số tiết dạy: ");
						soTietDay = sc.nextInt();
						giangvien.setSoTietDay(soTietDay);
						if (soTietDay < 0) {
							throw new Exception("Chỉ được phép nhập số dương.");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						kiemTra = false;
					}
				} while (!kiemTra);
				System.out.println("------------------------------------------------------------------");
				
				// dsNhanVien.add(new GiangVien(hoTen, heSoLuong, khoa, trinhDo, soTietDay));
			}

			// Nhập Nhân viên
		} else if (n == 2) {
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

				dsNhanVien.add(new NhanVien(hoTen, heSoLuong, phuCap, chucVu, soNgayCong, phongBan));
			}
		}
	}
	public  void DocFile() {
		dsNhanVien.clear();
		dsNhanVien = LuuDocFile.docFile("danhsachcanbo.txt");
	}
	
	public void GhiFile() {
		LuuDocFile.luuFile(dsNhanVien, "danhsachcanbo.txt");
	}

	public void XuatThongTin(Scanner sc) {
		System.out.println("    Xuất Thông Tin");
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");
		int n = sc.nextInt();
		sc.nextLine();
		if (n == 1) {
			System.out.println("Mời bạn nhập khoa của giảng viên: ");
			String khoa = sc.nextLine();
			sc.nextLine();
			for (CanBo x : dsNhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
				System.out.println(
						"|   Tên GV     |     Trình độ      |Hệ số lương|   Phụ cấp   | Khoa |  Số tiết  |   Tiền lương   |");
				if (((GiangVien) x).getKhoa().equals(khoa)) {
					System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", x.getHoTen(),
							((GiangVien) x).getTrinhDo(), x.getHeSoLuong(), x.getPhuCap(), ((GiangVien) x).getKhoa(),
							((GiangVien) x).getSoTietDay(), ((GiangVien) x).tinhLuong());
				}
			}
		} else if (n == 2) {
			System.out.print("Mời bạn nhập phòng ban của cán bộ: ");
			String phongBan = sc.nextLine();
			for (CanBo x : dsNhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ HÀNH CHÍNH--------------------------------------+");
				System.out.println(
						"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |");
				if (((NhanVien) x).getPhongBan().equals(phongBan)) {
					System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoTen(), ((NhanVien) x).getPhongBan(),
							x.getHeSoLuong(), x.getPhuCap(), ((NhanVien) x).getChucVu(),
							((NhanVien) x).getSoNgayCong());
				}
			}

		}

	}

	public void TongSoLuong() {
		for (CanBo x : dsNhanVien) {
			luong = x.tinhLuong();
			tongLuong = luong;
		}
		System.out.println("Tổng lương phải trả cho cán bộ = " + tongLuong);
	}

	public void SapXepNV() {
		Collections.sort(dsNhanVien, NvComparator.CanBoLuongASComparator);
		for (CanBo x : dsNhanVien) {
			if (x instanceof GiangVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
				System.out.println(
						"|   Tên GV     |     Trình độ      |Hệ số lương|   Phụ cấp   | Khoa |  Số tiết  |   Tiền lương   |");
				System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", x.getHoTen(),
						((GiangVien) x).getTrinhDo(), x.getHeSoLuong(), x.getPhuCap(), ((GiangVien) x).getKhoa(),
						((GiangVien) x).getSoTietDay(), ((GiangVien) x).tinhLuong());
			} else if (x instanceof NhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ HÀNH CHÍNH--------------------------------------+");
				System.out.println(
						"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |");
				System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoTen(), ((NhanVien) x).getPhongBan(),
						x.getHeSoLuong(), x.getPhuCap(), ((NhanVien) x).getChucVu(), ((NhanVien) x).getSoNgayCong());
			}
		}
	}

	public static void KetThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
		System.exit(0);
	}
}