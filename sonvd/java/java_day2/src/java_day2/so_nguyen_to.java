package java_day2;

import java.util.Scanner;

public class so_nguyen_to {
	public static void main(String[] args) {
		int a,i;
		
		Scanner input = new Scanner (System.in);
		System.out.println("Nhập số:");
		a = input.nextInt();
		
		for (i=2;i<=Math.sqrt(a); i++) {
			if (a%i==0) {
				System.out.println("Đây không phải là số nguyên tố");
				break;
			}
			else if(a%i!=0) {
				System.out.println("Đây là số nguyên tố");
				break;
			}
		}
	}
}
