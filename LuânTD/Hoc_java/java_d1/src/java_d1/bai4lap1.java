package java_d1;

import java.util.Scanner;

public class bai4lap1 {
	public static void main(String[] args) {
		double a,b,c;
		Scanner myInput=new Scanner(System.in);
		System.out.print("Nhập a= ");
		a=myInput.nextDouble();
		System.out.print("Nhập b= ");
		b=myInput.nextDouble();
		System.out.print("Nhập c= ");
		c=myInput.nextDouble();
		double delta=Math.pow(b,2)-4*a*c;
		double x=Math.sqrt(delta);
		System.out.printf("%f",x);
		
	}

}
