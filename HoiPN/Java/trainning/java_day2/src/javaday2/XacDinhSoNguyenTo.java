package javaday2;

import java.util.Scanner;

public class XacDinhSoNguyenTo {
	public static void main(String[] args) {
		int n;		
		Scanner input= new Scanner(System.in);
		System.out.println("Nhập n: ");
		n = input.nextInt();
		int i=n-1;
		if(i==1||i==2) {
			System.out.println( n +" là số nguyên tố");
		}else {
			System.out.println(n+" không phải số nguyên tố");
		}
	}
}
