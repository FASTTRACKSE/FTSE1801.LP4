import java.util.Scanner;

/**
 * 
 * @author Phạm Ngọc Hợi
 *
 */
public class GiangVien extends CanBo {
	public void addGiangVien(Scanner sc, GiangVien giangVien) {
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
				giangVien.setHoTen(ten);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				check = true;
			}
		} while (check);

		System.out.println("Nhập khoa: ");
		String khoa = sc.nextLine();

		System.out.println("Lựa chọn trình độ: 1-Cử nhân | 2-Thạc sĩ | 3-Tiến sĩ.");
		int trinhDo = sc.nextInt();
		switch (trinhDo) {
		case 1:
			giangVien.setCapBac("Cử nhân");
			giangVien.setPhuCap(300);
			break;
		case 2:
			giangVien.setCapBac("Thạc sĩ");
			giangVien.setPhuCap(500);
			break;
		case 3:
			giangVien.setCapBac("Tiến sĩ");
			giangVien.setPhuCap(1000);
			break;
		}
		
		sc.nextLine();
		int soTiet = 0;

		do {
			check = false;

			try {
				System.out.println("Số ngày công trong tháng: ");
				String tiet = sc.nextLine();
				soTiet = Integer.parseInt(tiet);
				if (tiet.isEmpty()) {
					throw new Exception("Số ngày công không được để trống.");
				} else if (soTiet < 0) {
					throw new Exception("Số ngày công phỉa là số dương.");
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

		giangVien.setDonVi(khoa);
		giangVien.setThoiGianLamViec(soTiet);
		giangVien.setHeSoLuong(heSoLuong);
		giangVien.setLuong(heSoLuong * 730 + giangVien.getPhuCap() + soTiet * 45);
	}
}
