package Lap2;

import java.util.Scanner;

/**
 * Tạo menu
 * 
 * @author SonVD
 *
 */
public class Bai4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int chooseMenu;

		while (true) {
			System.out.println("+---------------------------------------------------+");
			System.out.println("1.Giải phương trình bậc nhất");
			System.out.println("2.Giải phương trình bậc 2");
			System.out.println("3.Tính tiền điện");
			System.out.println("4.Kết thúc");
			System.out.println("+---------------------------------------------------+");

			chooseMenu = input.nextInt();

			switch (chooseMenu) {
			case 1:
				Bai1.main(args);
				break;
			case 2:
				Bai2.main(args);
				break;
			case 3:
				Bai3.main(args);
				break;
			case 4:
				input.close();
				System.out.println("Chương trình kết thúc!");
				System.exit(0);
			default:
				System.out.println("Chọn chức năng không đúng. Vui lòng nhập lại");
				break;
			}
		}
	}
}
