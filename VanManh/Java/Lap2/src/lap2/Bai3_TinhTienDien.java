package lap2;

import java.util.Scanner;

public class Bai3_TinhTienDien {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Nhập số điện từ bàn phím
		System.out.print("Nhập số điện = ");
		int soDien = input.nextInt();
		input.close();
		// Tính số tiền điện
		if (soDien < 50) {
			System.out.print("Số tiền điện là:" + soDien * 1000);
		} else {
			System.out.print("Số tiền điện là:" + (50 * 1000 + (soDien - 50) * 1200));
		}
	}
}
