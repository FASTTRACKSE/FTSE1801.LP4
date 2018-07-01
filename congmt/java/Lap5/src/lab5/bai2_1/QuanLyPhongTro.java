package lab5.bai2_1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class QuanLyPhongTro {
	private ArrayList<PhongTro> listPhongTro;

	public QuanLyPhongTro() {
		listPhongTro = new ArrayList<PhongTro>();
	}

	/**
	 * Cho thuê phòng trọ
	 * 
	 * @param phongTro nhập số phòng cho thuê
	 *            
	 */
	public void choThuePhong(PhongTro phongTro) {
		listPhongTro.add(phongTro);
	}

	/**
	 * Trả phòng trọ
	 * 
	 * @param soCMND dùng để lấy Số CMND để trả phòng
	 *            
	 */
	public void traPhong(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			listPhongTro.remove(phongTro);
			System.out.println("da tra phong");
		} else {
			System.out.println("sai CMND cmnr");
		}
	}

	/**
	 * Lấy thông tin khách trọ
	 * 
	 * @param soCMND dùng để tìm thông tin khách trọ
	 *           
	 */
	public void layThongTinPhongTro(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			hienThiKhachTro();
		} else {
			System.out.println("sai CMND cmnr");
		}
	}

	/**
	 * Tính tiền
	 * 
	 * @param soCMND dùng để tìm và tính tiền của vị khách trọ
	 *           
	 */
	public void tinhTienTraPhong(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			System.out.println(
					"Số tiền khách " + phongTro.getKhach().getHoTen() + " phải trả là : " + phongTro.getThanhTien());
		} else {
			System.out.println("sai CMND cmnr");
		}
	}

	/**
	 * Delete person by name
	 * 
	 * @param name:
	 * 
	 */
	public void deletelPerson(String hoTen) {

		PhongTro phongTro = null;
		int size = listPhongTro.size();
		for (int i = 0; i < size; i++) {
			if (listPhongTro.get(i).getKhach().getHoTen().equals(hoTen)) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}
		if (phongTro != null) {
			listPhongTro.remove(phongTro);

		} else {
			System.out.printf("name = %d not existed.\n", hoTen);
		}
	}

	public void hienThiKhachTro() {

		System.out.printf("%-3s|%-20s|%-30s|%-20s|%-20s|%-20s|%-20s|%-20s \n", "STT", "Họ và tên", "Ngày sinh",
				"số CMND", "Số ngày trọ", "Loại phòng", "Giá phòng", "Tính tiền");
		int size = listPhongTro.size();
		for (int i = 0; i < size; i++) {
			System.out.printf("%-3s|%-20s|%-30s|%-20s|%-20s|%-20s|%-20s|%-20s \n", (i + 1),
					listPhongTro.get(i).getKhach().getHoTen(), listPhongTro.get(i).getKhach().getNgaySinh(),
					listPhongTro.get(i).getKhach().getSoCMND(), listPhongTro.get(i).getSoNgaytro(),
					listPhongTro.get(i).getLoaiP(), listPhongTro.get(i).getGiaP(), listPhongTro.get(i).getThanhTien());

		}
	}

	/**
	 * create showMenu
	 */
	public static void showMenu() {
		System.out.println("-----------MENU------------");
		System.out.println("1. Nhập họ và tên.");
		System.out.println("2. Xóa danh sách theo tên.");
		System.out.println("3. Tính tiền.");
		System.out.println("4. Hiển thị thông tin khách trọ.");
		System.out.println("0. Exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QuanLyPhongTro quanLyPhongTro = new QuanLyPhongTro();
		PhongTro phongTro;
		int choose, tiepTuc, n;
		showMenu();
		while (true) {
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập số phòng cần trọ :");
				int soPhongChoThue = scanner.nextInt();
				scanner.nextLine();

				// Cho thuê

				for (int i = 0; i < soPhongChoThue; i++) {
					phongTro = new PhongTro();
					phongTro.nhapThongTin(scanner);
					quanLyPhongTro.choThuePhong(phongTro);
				}
				System.out.println();
				System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
				tiepTuc = scanner.nextInt();
				System.out.println();

				break;

			case 2:
				System.out.println();
				System.out.print("Nhập ten can xoa : ");
				System.out.println();
				scanner.nextLine();
				String idDelete = scanner.nextLine();
				quanLyPhongTro.deletelPerson(idDelete);
				break;
			case 3:
				System.out.println();
				System.out.print("Nhập so CMND của khách hàng : ");
				System.out.println();
				scanner.nextLine();
				String tinhtien = scanner.nextLine();
				quanLyPhongTro.tinhTienTraPhong(tinhtien);

				break;
			case 4:
				System.out.println("Danh sach khach tro: ");
				System.out.println();
				quanLyPhongTro.hienThiKhachTro();
				break;

			case 0:
				scanner.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}

		}
	}
}
