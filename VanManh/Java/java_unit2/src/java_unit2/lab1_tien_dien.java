package java_unit2;

import java.util.Scanner;

public class lab1_tien_dien {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập số điện = ");
		int soDien = input.nextInt();
		
		if(soDien<50) {
			System.out.print("Số tiền điện là:" + soDien*1000);
		}else {
			System.out.print("Số tiền điện là:" + (50*1000 + (soDien-50)*1200));
		}
	}
}
