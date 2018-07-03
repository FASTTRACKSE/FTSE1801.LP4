package assignment5;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLy extends CanBo {
	ArrayList<CanBo> listQuanLy;

	public QuanLy() {
		listQuanLy = new ArrayList<CanBo>();

	}

	public void meNu() {
		int chooseMenu;
		int soCanBo;
		CanBo canBo;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n*************MENU***********\n");
			System.out.println("1. Nhập thông tin cán bộ");
			System.out.println("2. Hiển thị thông tin");
			System.out.println("3. Kết thúc chương trình\n");
			System.out.println("*******************************");
			System.out.println("Chọn chức năng bạn muốn : ");
			chooseMenu = sc.nextInt();
			switch (chooseMenu) {

			case 1:
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = sc.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + " \n");

					System.out.println("Nhập 1: Chọn giảng viên; Nhập 2: Chọn nhân viên");
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

			case 3:
				sc.close();
				System.out.println("**Bye bye**");
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
