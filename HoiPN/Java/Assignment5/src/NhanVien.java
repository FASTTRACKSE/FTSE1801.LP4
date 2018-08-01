import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * 
 * @author Phạm Ngọc Hợi
 *
 */
public class NhanVien extends CanBo {
	public void addNhanVien(Scanner sc, NhanVien nhanVien) {
		sc.nextLine();
		boolean check = false;
		do {
			check = false;
			try {
				System.out.println("Nhập họ tên: ");
				String ten = sc.nextLine();
				if (ten.isEmpty()) {
					throw new Exception("Tên không được để trống.");
				} else if (ten.length() > 40) {
					throw new Exception("Tên quá dài.");
				} else {
					for (int i = 0; i < ten.length(); i++) {
						if (!Character.isLetter(ten.charAt(i)) && !Character.isWhitespace(ten.charAt(i))) {
							throw new Exception("Tên chỉ được nhập chữ và khoảng trắng.");
						}

					}
				}
				nhanVien.setHoTen(ten);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				check = true;
			}
		} while (check);

		System.out.println("Nhập phòng ban: ");
		String ban = sc.nextLine();

		System.out.println("Lựa chọn chức vụ: 1-Trưởng phòng | 2-Phó phòng | 3-Nhân viên.");
		String trinhDoStr = sc.nextLine();
		int trinhDo = 0;
		try {
			trinhDo = Integer.parseInt(trinhDoStr);
		} catch (NumberFormatException e) {
			System.out.println("loi");
		}

		switch (trinhDo) {
		case 1:
			nhanVien.setCapBac("Trưởng phòng");
			nhanVien.setPhuCap(2000);
			break;
		case 2:
			nhanVien.setCapBac("Phó phòng");
			nhanVien.setPhuCap(1000);
			break;
		case 3:
			nhanVien.setCapBac("Nhân viên");
			nhanVien.setPhuCap(500);
			break;
		default:
			System.out.println("Chọn sai");
			break;
		}
		int soNgayCong = 0;
		String ngayCong = null;

		do {

			try {
				check = false;
				System.out.println("Số ngày công trong tháng: ");
				ngayCong = sc.nextLine();
				soNgayCong = Integer.parseInt(ngayCong);
				if (ngayCong.isEmpty()) {
					throw new Exception("Số ngày công không được để trống.");
				} else if (soNgayCong < 0) {
					throw new Exception("Số ngày công phải là số dương.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số.");
			} catch (Exception er) {
				System.out.println(er.getMessage());
				check = true;
			}
		} while (check);

		double heSoLuong = 0;
	
		do {
			check = false;
			try {
				System.out.println("Hệ số lương: ");
				String heSo = sc.nextLine();
				if (heSo.isEmpty())
					throw new Exception("Hệ số lương không được để trống.");

				heSoLuong = Double.parseDouble(heSo);
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số.");
			} catch (Exception er) {
				System.out.println(er.getMessage());
				check = true;
			}
		} while (check);

		nhanVien.setDonVi(ban);
		nhanVien.setThoiGianLamViec(soNgayCong);
		nhanVien.setHeSoLuong(heSoLuong);
		nhanVien.setLuong(heSoLuong * 730 + nhanVien.getPhuCap() + soNgayCong * 30);

	}
}
