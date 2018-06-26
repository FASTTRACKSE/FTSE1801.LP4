package Lap1;

import java.util.Scanner;

/**
 * Bai tap 4
 * 
 * @author SonVD
 *
 */
public class Bai4 {
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		double delta;
		double sqrtDelta;

		Scanner input = new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = input.nextInt();
		System.out.println("Nhập b: ");
		b = input.nextInt();
		System.out.println("Nhập c: ");
		c = input.nextInt();

		delta = Math.pow(b, 2) - 4 * a * c;
		sqrtDelta = Math.sqrt(delta);

		System.out.println("delta = " + delta);
		System.out.println("Căn delta = " + sqrtDelta);
	}
}
