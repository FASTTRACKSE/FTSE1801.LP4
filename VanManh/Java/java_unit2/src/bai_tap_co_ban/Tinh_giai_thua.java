package bai_tap_co_ban;

import java.util.Scanner;

public class Tinh_giai_thua{
	public static void main(String[] args) {
		int giai_thua=1;
		int n;
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập n : ");
		n = input.nextInt();
		input.close();
		for(int i=1; i<=n; i++) {
			giai_thua = giai_thua*i;
		}
		System.out.print("Giai thừa của "+n+ " là :"+giai_thua);
	}
}
