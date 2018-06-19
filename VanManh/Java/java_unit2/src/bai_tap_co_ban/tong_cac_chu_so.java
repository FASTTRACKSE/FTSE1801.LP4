package bai_tap_co_ban;

import java.util.Scanner;

public class tong_cac_chu_so {
	public static void main(String[] args) {
		int n, soDu;
		int tong = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào số nguyên dương bất kỳ: ");
		n = input.nextInt();
		input.close();
		while (n > 0) {
			soDu = n % 10;
			n = (n-soDu) / 10;
			tong =tong + soDu;
		}
		System.out.println("Tổng các chữ số = " + tong);
	}
}
