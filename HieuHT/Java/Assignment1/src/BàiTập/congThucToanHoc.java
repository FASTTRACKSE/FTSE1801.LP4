package BàiTập;

import java.util.Scanner;

public class congThucToanHoc {
		public static void main(String[] args) {
			int a, b, c, x, y;
			Scanner myInput = new Scanner(System.in);
			System.out.print("Nhap so a: ");
			a = myInput.nextInt();
			System.out.print("Nhap so b: ");
			b = myInput.nextInt();
			System.out.print("Nhap so c: ");
			c = myInput.nextInt();
			x = Math.min(a,  Math.min(c, b));
			y = Math.max(a,  Math.max(c, b));
			System.out.println("So nho nhat la: " + x);
			System.out.println("So lon nhat la: " + y);
		}
	}
