package java_day2;

import java.util.*;

public class dangnhap {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("----Login----");
		String a;
		 int b, n =12345;
		
		System.out.printf("username: ");
		a = input.nextLine();
		System.out.printf("Password: ");
		b = input.nextInt();
		
		do {
			System.out.printf("Password: ");
			b = input.nextInt();
			if (b==n) {
				System.out.println("Đăng nhập thành công");
				break;
			}
		} while (true);
		
	}
}
