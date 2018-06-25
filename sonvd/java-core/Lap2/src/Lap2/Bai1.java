package Lap2;

import java.util.Scanner;

/**
 * Bai tap 1
 * 
 * @author SonVD
 *
 */
public class Bai1 {
	public static void main(String[] args) {
		float a;
		float b;

		Scanner input = new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = input.nextFloat();
		System.out.println("Nhập b: ");
		b = input.nextFloat();

		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình vô số nghiệm.");
			} else if (b != 0) {
				System.out.println("Phương trình vô nghiệm.");
			}
		} else {
			System.out.println("Phương trình có nghiệm:" + (-b / a));
		}
	}
}
