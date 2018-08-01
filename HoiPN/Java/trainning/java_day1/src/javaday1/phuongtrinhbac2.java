package javaday1;

import java.util.Scanner;

public class phuongtrinhbac2 {
	public static void main(String[] args) {
		double a,b,c;
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextDouble();
		System.out.println("Nhập b: ");
		b = sc.nextDouble();
		System.out.println("Nhập c: ");
		c = sc.nextDouble();
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("Phương trình có vô số "
							+ "nghiệm");
				}else {
					System.out.println("Phương trình vô nghiệm");
				}
			}else {
				double x = -c/b;
				System.out.println("Phương trình có nghiệm là x = " + x);
			}
		}else {
			double dt=b*b-4*a*c;
			double y1 =(-b + Math.sqrt(dt))/(2*a);
			double y2 =(-b - Math.sqrt(dt))/(2*a);

			if (dt < 0) {
				System.out.println("Phương trình vô nghiệm");
			}else if (dt == 0) {
				System.out.println("Phương trình có nghiệm kép: x = " + -b/(2*a));
			}else if(dt > 0){
				System.out.println("Phương trình có 2 nghiệm phân biệt là x1 = " +y1+" và x2 = "+y2);

			}
		}
	}
}
