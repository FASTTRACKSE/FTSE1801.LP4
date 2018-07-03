package javaday2;

import java.util.Scanner;

public class VD4_TimUOC {
	public static void main(String[] args) {
		int a;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập số a: ");
		a = input.nextInt();
		int i;
		for(i=1;i<a;i++) {
			int uoc=a%i;
			if(uoc==0) {
				System.out.println("Ước của số a là: "+i);
			}
		}
	}
}
