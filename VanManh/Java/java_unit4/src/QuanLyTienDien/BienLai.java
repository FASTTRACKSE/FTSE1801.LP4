package QuanLyTienDien;

import java.util.ArrayList;
import java.util.Scanner;

public class BienLai extends KhachHang {
	ArrayList<KhachHang> quanLy;

	public BienLai() {
		quanLy = new ArrayList<KhachHang>();
	}

	// Tính tiền điện
	public void tienDien() {
		for (int i = 0; i < quanLy.size(); i++) {
			quanLy.get(i).setTienDien((quanLy.get(i).getSoDienMoi() - quanLy.get(i).getSoDienCu()) * 750);
		}
	}

	// Thêm khách hàng
	public void addKhachHang(KhachHang khachHang) {
		quanLy.add(khachHang);
	}

	// Cập nhập số điện
	public void repairSoDien(Scanner input, String name) {
		for (int i = 0; i < quanLy.size(); i++) {
			if (quanLy.get(i).getName().equals(name)) {
				System.out.println("Nhập số điện mới : ");
				int soDien = input.nextInt();
				if (soDien > quanLy.get(i).getSoDienMoi()) {
					quanLy.get(i).setSoDienCu(quanLy.get(i).getSoDienMoi());
					quanLy.get(i).setSoDienMoi(soDien);
				} else {
					System.out.println("Bạn tính gian lận số điện à. Vui lòng nhập lại");
					continue;
				}
				break;
			}
		}
	}

	// sửa đổi thông tin khách hàng
	public void repairKhachHang(Scanner input, String name) {
		for (int i = 0; i < quanLy.size(); i++) {
			if (quanLy.get(i).getName().equals(name)) {
				System.out.print("Nhập tên khách hàng : ");
				String ten = input.nextLine();

				System.out.print("Nhập địa chỉ : ");
				String address = input.nextLine();

				System.out.print("Nhập mã công tơ : ");
				int maCongTo = input.nextInt();

				quanLy.get(i).setName(ten);
				quanLy.get(i).setAddress(address);
				quanLy.get(i).setMaCongTo(maCongTo);
				break;
			}
		}
	}

	// Xóa khách hàng
	public void deleteKhachHang(String name) {
		for (int i = 0; i < quanLy.size(); i++) {
			if (quanLy.get(i).getName().equals(name)) {
				quanLy.remove(i);
				break;
			}
		}
	}

	// Hiển thị khách hàng
	public void show() {
		System.out.printf("%-5s %-20s %-20s %-20s %-20s %-20s %-20s", "STT", "Tên", "Địa chỉ", "Mã công tơ",
				"Số điện cũ", "Số điện mới", "tiền điện");
		System.out.println();
		for (int i = 0; i < quanLy.size(); i++) {
			System.out.printf("\n %-5s %-20s %-20s %-20s %-20s %-20s %-20.1f", (i + 1), quanLy.get(i).getName(),
					quanLy.get(i).getAddress(), quanLy.get(i).getMaCongTo(), quanLy.get(i).getSoDienCu(),
					quanLy.get(i).getSoDienMoi(), quanLy.get(i).getTienDien());
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		int tt, luaChon, nhapTiep, tiepTuc;
		BienLai quanLy = new BienLai();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm khách hàng.");
			System.out.println("2. Cập nhật số điện.");
			System.out.println("3. Cập nhập thông tin khách hàng.");
			System.out.println("4. Xóa khách hàng  .");
			System.out.println("5. Hiển thị danh sách khách hàng .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();

			switch (luaChon) {
			case 1:
				do {

					input.nextLine();
					System.out.print("Nhập tên khách hàng : ");
					String name = input.nextLine();

					System.out.print("Nhập địa chỉ : ");
					String address = input.nextLine();

					System.out.print("Nhập mã công tơ : ");
					int maCongTo = input.nextInt();

					System.out.print("Nhập số  điện : ");
					int number = input.nextInt();

					KhachHang khachHang = new KhachHang(name, address, maCongTo, 0, number);
					quanLy.addKhachHang(khachHang);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				do {
					System.out.println();
					System.out.print("Nhập tên cần cập nhập số điện : ");
					input.nextLine();
					String name = input.nextLine();
					quanLy.repairSoDien(input, name);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					nhapTiep = input.nextInt();
					System.out.println();
				} while (nhapTiep == 1);
				quanLy.tienDien();
				quanLy.show();

				break;

			case 3:
				do {
					System.out.println();
					System.out.print("Nhập tên cần sửa đổi thông tin : ");
					input.nextLine();
					String name = input.nextLine();
					quanLy.repairKhachHang(input, name);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tiepTuc = input.nextInt();
					System.out.println();
				} while (tiepTuc == 1);
				quanLy.show();
				break;

			case 4:
				System.out.println();
				System.out.print("Nhập tên cần xóa : ");
				System.out.println();
				input.nextLine();
				String ten = input.nextLine();
				quanLy.deleteKhachHang(ten);
				quanLy.show();
				break;

			case 5:
				quanLy.tienDien();
				quanLy.show();
				break;	

			case 0:
				input.close();
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
