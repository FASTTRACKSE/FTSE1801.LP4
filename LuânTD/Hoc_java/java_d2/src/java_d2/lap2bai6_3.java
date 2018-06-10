package java_d2;

import java.util.Scanner;

public class lap2bai6_3 {
	public static void main(String[] args) {
		double a,b;
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhập a= ");
		a=sc.nextInt();
		System.out.print("Nhập b= ");
		b=sc.nextInt();
		sc.close();
		ptbac1(a,b);
		System.out.println("Nghiem cua pt la: "+ptbac1(a,b));
			
	}
	
	public static double ptbac1(double a, double b) {
		double x=-b/a;
		return x;
	}

}
