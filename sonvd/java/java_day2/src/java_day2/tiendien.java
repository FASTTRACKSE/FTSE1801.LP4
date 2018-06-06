package java_day2;

import java.util.Scanner;

public class tiendien {
	public static void main(String[] args) {
		int sodien;
		
		Scanner input = new Scanner  (System.in);
		
		System.out.println("Nhập số điện tiêu thụ: ");
		sodien = input.nextInt();
		
		if (sodien<50) {
			System.out.println("Số tiền điện tiêu thụ là: " +(sodien*1000));
		} else {
			System.out.println("Số tiền điện tiêu thụ là: " +(50*1000+(sodien-50)*1200));
		}
	}
}
