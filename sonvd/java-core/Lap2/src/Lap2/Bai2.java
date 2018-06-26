package Lap2;

import java.util.Scanner;

/**
 * Bai tap 2
 * 
 * @author SonVD
 *
 */
public class Bai2 {
	public static void main(String[] args) {
		float a, b, c;
		double delta;
		double x1, x2;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextFloat();
		System.out.println("Nhập b: ");
		b = sc.nextFloat();
		System.out.println("Nhập c: ");
		c = sc.nextFloat();
		
		if (a==0) {
			if (b==0 && c==0) {
				System.out.println("Phương trình vô số nghiệm.");
			} else if (b==0 && c!=0) {
				System.out.println("Phương trình vô nghiệm.");
			} else {
				System.out.println("Phương trình có nghiệm: "+(-b/a));
			}
		} else {
			delta = Math.pow(b, 2)-4*a*c;
			x1 = (-b + Math.sqrt(delta))/(2*a);
			x2 = (-b - Math.sqrt(delta))/(2*a);
			if (delta<0) {
				System.out.println("Phương trình vô nghiệm.");
			} else if(delta == 0) {
				System.out.println("Phương trình có nghiệm kép: "+(-b/2*a));
			} else {
				System.out.println("Phương trình có 2 nghiệm phân biệt:\nx1 = "+x1+"\nx2 = "+x2);
			}
		}
	}
}
