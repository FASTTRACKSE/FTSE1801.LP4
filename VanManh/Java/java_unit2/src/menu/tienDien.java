package menu;

import java.util.Scanner;

public class tienDien {
	public static void tienDien(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Nhập số điện = ");
		int soDien = input.nextInt();
		
		if(soDien<50) {
			System.out.println("Số tiền điện là:" + soDien*1000);
		}else {
			System.out.println("Số tiền điện là:" + (50*1000 + (soDien-50)*1200));
		}
		
	}
}
