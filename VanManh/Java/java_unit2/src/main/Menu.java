package main;

import java.util.Scanner;
import menu.*;
public class Menu {
	public static void main(String[] args) {
		System.out.println("+-------------------------+");
		System.out.println("1. Giải phương trình bậc 1");
		System.out.println("2. Giải phương trình bậc 2");
		System.out.println("3. Tính tiền điện");
		System.out.println("4. Kết thúc.");
		System.out.println("+-------------------------+");
		int n;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Chọn chức năng:");
			n = input.nextInt();
			System.out.println();
			switch(n) {
				case 1:
					System.out.print("Nhập giá trị a:");
					double a = input.nextDouble();
					System.out.print("Nhập giá trị b:");
					double b = input.nextDouble();
					System.out.println(giai_PT1.giai_PTbac1(a, b));
					break;
				
				case 2:
					giai_PT2.giai_PTbac2(args);;
					break;
					
				case 3:
					tienDien.tiendien(args);
					break;
					
				case 4:
					System.out.println("Kết thúc chương trình");
					break;
					
				default:
					System.out.println("Chức năng bạn chọn không có, mời bạn nhập lại.");
			}
		}while(n!=4);
		input.close();
	}
}
