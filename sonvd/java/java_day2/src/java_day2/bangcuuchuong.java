package java_day2;

import java.util.Scanner;

public class bangcuuchuong {
	public static void main(String[] args) {
		int i,j;
		
		for (i =1 ;i<=10; i++) {
			for(j = 2; j<=9; j++) {
				System.out.printf(j+" x " +i+" = "+i*j+ "	");
			}
			System.out.println();
		}
	}
}
