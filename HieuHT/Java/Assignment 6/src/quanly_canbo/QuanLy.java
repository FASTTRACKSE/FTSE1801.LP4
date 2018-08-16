package quanly_canbo;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author Ngọc Thiên
 *
 */
public class QuanLy {
	ArrayList<CanBo> listQuanLy;

	public QuanLy() {
		listQuanLy = new ArrayList<CanBo>();

	}

	/**
	 * Sắp xếp nhân viên theo lương từ cao đến thấp hoặc sắp xếp theo tên nếu lương
	 * bằng nhau
	 */

	public void sort() {
		Collections.sort(listQuanLy, new Comparator<CanBo>() {

			public int compare(CanBo cb1, CanBo cb2) {
				if (Double.compare(cb2.getLuong(), cb1.getLuong()) == 0) {
					return cb1.getHoTen().compareToIgnoreCase(cb2.getHoTen());
				} else {
					return Double.compare(cb2.getLuong(), cb1.getLuong());
				}
			}

		});
	}

	public void meNu() {
		int chooseMenu;
		int soCanBo;
		CanBo canBo;

		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("\n*************************************************\n");
			System.out.print("* số 1 : nhập thông tin cán bộ               *\n");
			System.out.print("* số 2 : xem thông tin                 *\n");
			System.out.print("* số 3 : sắp xếp theo lương của cán bộ               *\n");
			System.out.print("* số 4 : Kết thúc chương trình*\n");
			System.out.print("*************************************************\n ");
			System.out.print("\n chọn chức năng bạn muốn : ");
			chooseMenu = sc.nextInt();
			switch (chooseMenu) {

			case 1:
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = sc.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.print("Nhập thong tin can bo thu " + (i + 1) + " \n");

					System.out.print("Nhập 1 chon giang vien, 2 chon nhan vien");
					int cb;
					cb = sc.nextInt();
					sc.nextLine();
					if (cb == 1) {
						canBo = new GiangVien();
						((GiangVien) canBo).nhapGiangVien(sc);
						listQuanLy.add(canBo);
					} else if (cb == 2) {
						canBo = new NhanVien();
						((NhanVien) canBo).nhapNhanVien(sc);
						listQuanLy.add(canBo);
					}

				}
				break;
			case 2:
				System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
				CanBo cb;
				for (int i = 0; i < listQuanLy.size(); i++) {
					cb = listQuanLy.get(i);
					if (cb instanceof NhanVien) {
						((NhanVien) cb).xuatNhanVien();
					} else {
						((GiangVien) cb).xuatGiangVien();
					}

				}
				break;
			case 3:
				sort();

				break;
			case 4:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;

			default:
				System.out.println("\n\n\n\n********Menu not exist feature********");
				break;
			}

		} while (true);
	}

	public static void main(String[] args) {
		QuanLy ql = new QuanLy();
		ql.meNu();
	}
}
