package java_d1;

import java.util.Scanner;

public class ptbac2 {
	public static void main(String[] args) {
		double a,b,c;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Nhập a= ");
		a=sc.nextDouble();
		System.out.print("Nhập b= ");
		b=sc.nextDouble();
		System.out.print("Nhập c= ");
		c=sc.nextDouble();
		double delta= Math.pow(b,2)-4*a*c;
		
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("PT vô số nghiệm");
				}else {
					System.out.println("PT vô nghiệm");
				}
			}else {
				double x=-c/b;
				System.out.println("PT có 1 nghiêm x= "+x);
			}
		}else {
			if(delta<0) {
				System.out.println("PT vô nghiệm");
			}else if(delta==0) {
				double xx=-b/2*a;
				System.out.println("PT có nghiệm kép x1=x2="+xx);
			}else {
				double x1=(-b+Math.sqrt(delta))/2*a;
				double x2=(-b-Math.sqrt(delta))/2*a;
				System.out.println("PT có 2 nghiệm x1= "+x1+", x2= "+x2);
			}
		}
		
		
		
		
		
	}

}
