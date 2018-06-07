package main;

import java.util.Scanner;
import model.*;

public class menu {
	public static void main(String[] args) {
		while (true) {
				System.out.println("+---------------------------------------------------+");
				System.out.println("1. Giải phương trình bậc 1");
				System.out.println("2. Giải phương trình bậc 2");
				System.out.println("3. Tính tiền điện");
				System.out.println("4. Kết thúc");
				System.out.println("+---------------------------------------------------+");
				
				int n;
				Scanner input = new Scanner(System.in);
				System.out.println("Nhập và chọn số thứ tự: ");
				n = input.nextInt();
				if (n == 1) {
					ptb1.main(args);
					break;
				} else if (n == 2) {
					ptb2.main(args);
					break;
				} else  if (n == 3) {
					tiendien.main(args);
					break;
				} else if (n == 4) {
					System.out.println("Chương trình kết thúc!!!!");
					break;
				}
		}
	}
}
