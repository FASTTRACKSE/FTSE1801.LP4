package Assignment5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Quan ly thong tin can bo
 * 
 * @author SonVD
 *
 */
public class QLThongTinCanBo {
	private ArrayList<CanBo> listQLCanBo;

	public QLThongTinCanBo() {
		listQLCanBo = new ArrayList<CanBo>();
	}

	/**
	 * Display menu
	 */
	public void menu() {
		CanBo canBo;
		int chooseMenu;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("/****************************************/");
			System.out.println("1. Nhập thông tin cán bộ");
			System.out.println("2. Hiển thị thông tin cán bộ");
			System.out.println("0. Kết thúc chương trình.");
			System.out.println("/****************************************/");

			chooseMenu = sc.nextInt();
			switch (chooseMenu) {
			case 1:
				int soCanbo;
				System.out.println("Nhập số lượng cán bộ");
				soCanbo = sc.nextInt();
				for (int i = 0; i < soCanbo; i++) {
					System.out.println("Nhập thông tin cán bộ " + (i + 1) + ": ");

					int canbo;
					System.out.println("Chọn loại cán bộ: 1.Giảng viên || 2.Nhân viên");
					canbo = sc.nextInt();
					if (canbo == 1) {
						canBo = new giangVien();
						((giangVien) canBo).inputGiangVien();
						listQLCanBo.add(canBo);
					} else if (canbo == 2) {
						canBo = new nhanVien();
						((nhanVien) canBo).inputNhanVien();
						listQLCanBo.add(canBo);
					}
				}
				break;
			case 2:
				CanBo canbo;
				for (int i = 0; i < listQLCanBo.size(); i++) {
					canbo = listQLCanBo.get(i);
					if (canbo instanceof giangVien) {
						((giangVien) canbo).outputGiangVien();
					} else {
						((nhanVien) canbo).outputNhanVien();
					}
				}
				break;
			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình.");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		QLThongTinCanBo quanLithongTinCanBo = new QLThongTinCanBo();
		quanLithongTinCanBo.menu();
	}
}
