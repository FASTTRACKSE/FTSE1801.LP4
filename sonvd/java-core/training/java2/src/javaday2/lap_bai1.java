package javaday2;

import java.util.Scanner;
import java.util.function.LongToIntFunction;

public class lap_bai1 {
	public static void main(String[] args) {
		double a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextDouble();
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm");
			}
		}else {
			double x= -b/a;
			System.out.println("Phương trình có nghiệm là x = "+x);
		}
	}
}