package Lap2;

import java.util.Scanner;

/**
 * Bai tap 3
 * 
 * @author SonVD
 *
 */
public class Bai3 {
	public static void main(String[] args) {
		int soDien;
		float thanhTien;

		Scanner input = new Scanner(System.in);
		System.out.println("Nhập số điện tiêu thụ: ");
		soDien = input.nextInt();

		if (soDien < 50) {
			thanhTien = soDien * 1000;
			System.out.println("Số tiền phải trả khi dưới 50 là: " + thanhTien);
		} else {
			thanhTien = 50 * 1000 + (soDien - 50) * 1200;
			System.out.println("Số tiền phải trả khi quá 50 là: " + thanhTien);
		}
	}
}
