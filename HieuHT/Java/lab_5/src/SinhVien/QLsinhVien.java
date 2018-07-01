package SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author HieuHT
 *
 */

public class QLsinhVien {

	private ArrayList<danhSachSV> sv;

	public QLsinhVien() {
		sv = new ArrayList<danhSachSV>();
	}

	/**
	 * 
	 * @param ten
	 */

	public void nhap(danhSachSV ten) {
		sv.add(ten);

	}

	public void xuat() {
		System.out.printf("%-30s|%-30s%n", "Họ và Tên", "địa chỉ");
		for (int i = 0; i < sv.size(); i++) {
			System.out.printf("%-30s|%-30s%n", sv.get(i).getHoTen(), sv.get(i).getDiachi());
		}
	}

	public void ngaunhien() {
		Collections.shuffle(sv);

	}

	public void sapxep() {
		Collections.sort(sv, new Comparator<danhSachSV>() {
			public int compare(danhSachSV o1, danhSachSV o2) {

				return o2.getHoTen().compareToIgnoreCase(o1.getHoTen());
			}
		});
	}

	/**
	 * 
	 * @param hoTen
	 */

	public void xoaSV(String hoTen) {
		Object name = null;
		for (int i = 0; i < sv.size(); i++) {
			if (sv.get(i).getHoTen().equals(hoTen)) {
				name = sv.get(i);
				break;
			}
		}

		if (name != null) {
			sv.remove(name);
		} else {
			System.out.println("Bạn nhập sai.");
		}
	}

	/**
	 * @author menu
	 */

	public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("****** - Menu - ******");
			System.out.println(" 1 - Thêm thông tin   ");
			System.out.println(" 2 - Hiển thị         ");
			System.out.println(" 3 - ngẫu nhiên       ");
			System.out.println(" 4 - sắp xếp          ");
			System.out.println(" 5 - xóa tên          ");
			System.out.println(" 6 - Kết thúc     ");
			System.out.println("**********************");

			chooseMenu = sc.nextInt();

			switch (chooseMenu) {
			case 1:

				danhSachSV sv = new danhSachSV();
				sc.nextLine();
				System.out.print("Nhập Họ Tên: ");
				String hoTen = sc.nextLine();

				sv.setHoTen(hoTen);

				System.out.print("Nhập địa chỉ: ");
				String diachi = sc.nextLine();
				sv.setDiachi(diachi);

				nhap(sv);

				break;

			case 2:
				xuat();
				break;
			case 3:
				ngaunhien();
				xuat();
				break;
			case 4:
				sapxep();
				break;
			case 5:
				System.out.println("Nhập họ tên cần xóa :");
				sc.nextLine();
				String hoten = sc.nextLine();
				xoaSV(hoten);
				xuat();
				break;
			case 6:
				sc.close();
				System.out.println("Tạm biệt");
				System.exit(0);
				break;

			default:
				System.out.println("Không tồn tại menu");
				break;
			}

			System.out.println("\n\n\n\n\n");
		}
	}

	public static void main(String[] args) {
		QLsinhVien person = new QLsinhVien();
		person.menu();
	}
}