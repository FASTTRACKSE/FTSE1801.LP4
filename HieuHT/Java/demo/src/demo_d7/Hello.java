package demo_d7;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap b:");
			int b = sc.nextInt();
			int a = 1 / b;
			int[] c = new int[1];
			c[1] = a;
			System.out.println("Hello world");
			System.out.println("Hello world");
			System.out.println("Hello world");
			String aa = null;
			aa.toString();
		} catch (ArithmeticException e) {
			System.out.println("Khong the chia cho 0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Vuot qua kich thuoc cua mang");
		} finally {
			System.out.println("Chac chan qua day");
			sc.close();
		}
		System.out.println("Hello world");
	}

	public void calViDuThrow2() {
		// TODO Auto-generated method stub

	}

	public void callviDuThrow() {
		// TODO Auto-generated method stub

	}
}
