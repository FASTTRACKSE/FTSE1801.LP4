package java_day2;

import java.util.*;

public class ucln_ucnn {
	public static void main(String[] args) {
		int a,b;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập a = ");
		a = input.nextInt();
		System.out.println("Nhập b = ");
		b = input.nextInt();
		
		while (a!=b) {
			if (a>=b) {
				a = a-b;
			} else {
				b = b-a;
			}
		}
		System.out.println("Ước chung lớn nhất là: "+a);
	}
}
