package lap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Quản lý nhân viên
 * @author Ngọc Thiên
 *
 */

public class QL_HoTen {

	private ArrayList<NhanVien> listQuanLy;

	public QL_HoTen() {
		listQuanLy = new ArrayList<NhanVien>();
	}

	/**
	 * Nhập họ tên và địa chỉ nhân viên
	 * @param import employee
	 */
	public void importNv(NhanVien ten) {
		listQuanLy.add(ten);

	}

	/**
	 * export 
	 */
	public void export() {
		System.out.printf("%-30s|%-30s%n", "Họ và Tên", "địa chỉ");
		for (int i = 0; i < listQuanLy.size(); i++) {
			System.out.printf("%-30s|%-30s%n", listQuanLy.get(i).getHoTen(), listQuanLy.get(i).getDiachi());
		}
	}

	/**
	 * export ngẫu nhiên nhân viên
	 */
	public void ranDom() {
		Collections.shuffle(listQuanLy);

	}

	/**
	 * Sắp xếp nhân viên theo tên từ z-a
	 */
	public void sortByName() {
		Collections.sort(listQuanLy, new Comparator<NhanVien>() {
			public int compare(NhanVien o1, NhanVien o2) {

				return o2.getHoTen().compareToIgnoreCase(o1.getHoTen());
			}
		});
	}

	/**
	 * 
	 * @param delete 
	 */
	public void deleteByName(String hoTen) {
		NhanVien name = null;
		for (int i = 0; i < listQuanLy.size(); i++) {
			if (listQuanLy.get(i).getHoTen().equals(hoTen)) {
				name = listQuanLy.get(i);
				break;
			}
		}

		if (name != null) {
			listQuanLy.remove(name);
		} else {
			System.out.println("Bạn đã nhập sai.");
		}
	}

	public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("*********** Manager student name list - Menu ***********");
			System.out.println("* 1 - Thêm thông                                 *");
			System.out.println("* 2 - Hiển thị                           *");
			System.out.println("* 3 - ngẫu nhiên                       *");
			System.out.println("* 4 - sắp xếp                          *");
			System.out.println("* 5 - xóa                                     *");
			System.out.println("* 6 - Exit program                                     *");
			System.out.println("********************************************************");

			chooseMenu = sc.nextInt();

			switch (chooseMenu) {
			case 1:

				NhanVien sv = new NhanVien();
				sc.nextLine();
				System.out.print("Vui lòng nhạp Họ Tên: ");
				String hoTen = sc.nextLine();

				sv.setHoTen(hoTen);

				System.out.print("Vui lòng nhạp địa chỉ: ");
				String diachi = sc.nextLine();
				sv.setDiachi(diachi);

				importNv(sv);

				break;

			case 2:
				export();
				break;
			case 3:
				ranDom();
				export();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				System.out.println("Nhập đúng họ tên cần xóa :");
				sc.nextLine();
				String hoten = sc.nextLine();
				deleteByName(hoten);
				export();
				break;
			case 6:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;

			default:
				System.out.println("\n\n\n\n********Menu not exist feature********");
				break;
			}

			System.out.println("\n\n\n\n\n");
		}
	}

	public static void main(String[] args) {
		QL_HoTen person = new QL_HoTen();
		person.menu();
	}
}
