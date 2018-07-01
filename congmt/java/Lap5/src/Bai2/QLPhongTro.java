package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class QLPhongTro {
	private ArrayList<PhongTro> listPhongTro;

	public QLPhongTro() {
		listPhongTro = new ArrayList<PhongTro>();
	}

	/**
	 * add person to PersonList
	 * 
	 * @param person
	 */
	public void nhapKhachTro(PhongTro phongtro) {
		listPhongTro.add(phongtro);

	}

	/**
	 * Show DS Khach tro
	 */
	public void hienThiKhachTro() {
		
		System.out.printf("%-3s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s \n", "STT", "Họ và tên", "Ngày sinh",
				"số CMND", "Số ngày trọ", "Loại phòng", "Giá phòng", "Tính tiền");
		int size = listPhongTro.size();
		for (int i = 0; i < size; i++) {
			System.out.printf("%-3s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s \n", (i + 1),
					listPhongTro.get(i).nguoi.getHoTen(), listPhongTro.get(i).nguoi.getNgaySinh(), listPhongTro.get(i).nguoi.getSoCMND(),
					listPhongTro.get(i).getSoNgaytro(), listPhongTro.get(i).getLoaiP(), listPhongTro.get(i).getGiaP(),
					listPhongTro.get(i).getThanhTien());

		}
	}

	/**
	 * Tinh tien dua tren so CMND
	 * 
	 * @param soCMND
	 */
	public void traTienPhong(int  soCMND) {
		PhongTro phongtro = null;
		
		int size = listPhongTro.size();
		for (int i = 0; i < size; i++) {
			if (listPhongTro.get(i).getKhach().getSoCMND() == soCMND) {
				phongtro = listPhongTro.get(i);
				
				break;
			}
		}
		if (phongtro != null) {
			
			System.out.println("Tien phai thanh toan: " + phongtro.getThanhTien());

		} else {
			System.out.printf("SoCMND bạn sai rồi. \n", soCMND);
		}
	}

	/**
	 * Delete person by name
	 * 
	 * @param name:
	 * 
	 */
	public void deletelPerson(String hoTen) {

		PhongTro phongtro = null;
		int size = listPhongTro.size();
		for (int i = 0; i < size; i++) {
			if (listPhongTro.get(i).getKhach().getHoTen().equals(hoTen)) {
				phongtro = listPhongTro.get(i);
				break;
			}
		}
		if (phongtro != null) {
			listPhongTro.remove(phongtro);

		} else {
			System.out.printf("name = %d not existed.\n", hoTen);
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

		Scanner sc = new Scanner(System.in);
		QLPhongTro quanly = new QLPhongTro();
		PhongTro phongtro1;
		
		int choose, tiepTuc, n;
		showMenu();
		while (true) {
			choose = sc.nextInt();
			System.out.print("Nhap so luong khach tro: ");
			n = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1:
				do {
					phongtro1 = new PhongTro();
					System.out.println("- Nhập tên:");
					String hoTen = sc.nextLine();
					phongtro1.getKhach().setHoTen(hoTen);
					System.out.println("- Nhập ngày sinh :");
					String str = sc.nextLine();
					phongtro1.getKhach().setNgaySinh(phongtro1.getKhach().chuyenStringDate(str));
					System.out.println("- Nhập số CMND:");
					int soCMND = sc.nextInt();
					phongtro1.getKhach().setSoCMND(soCMND);
					System.out.println("- Nhập số ngày trọ:");
					int soNgaytro = sc.nextInt();
					phongtro1.setSoNgaytro(soNgaytro);

					System.out.println("- Nhập loại phòng trọ:");
					int loaiP = sc.nextInt();
					phongtro1.setLoaiP(loaiP);

					quanly.nhapKhachTro(phongtro1);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tiepTuc = sc.nextInt();
					System.out.println();
				} while (tiepTuc == 1);

				break;

			case 2:
				System.out.println();
				System.out.print("Nhập ten can xoa : ");
				System.out.println();
				sc.nextLine();
				String idDelete = sc.nextLine();
				quanly.deletelPerson(idDelete);
				quanly.showMenu();
				break;
			case 3:
				System.out.println();
				System.out.print("Nhập so CMND của khách hàng : ");
				System.out.println();
				sc.nextLine();
				int tinhtien = sc.nextInt();
				quanly.traTienPhong(tinhtien);

				break;
			case 4:
				System.out.println("Danh sach khach tro: ");
				System.out.println();
				quanly.hienThiKhachTro();
				break;

			case 0:
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

}
