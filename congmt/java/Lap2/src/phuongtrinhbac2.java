

import java.util.Scanner;

public class phuongtrinhbac2 {
	public static void main (String[] args) {
		double a,b,c, delta;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a= sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b= sc.nextDouble();
		System.out.println("Nhập giá trị c: ");
		c= sc.nextDouble();
		
		if(a==0) {
			if(b==0) {
				if(c==0) {
				System.out.println("- Phương trình có vô số nghiệm.");
				}
				else {
				System.out.println("- Phương trình vô nghiệm.");
				}
			}else {
			double x1= -b/a;
			System.out.println("- Phương trình có nghiệm là x: " + x1);
			}
		}else {
			delta = Math.pow(b,2)-4*a*c;
			if(delta<0) {
				System.out.println("- Phương trình vô nghiệm.");
			}
			else if(delta==0) {
				double x2=-b/(2*a);
				System.out.println("- Phương trình có nghiệm kép x= " + x2);
			}
			else {
			double	x3= (-b + Math.sqrt(delta))/(2*a);
			double	x4= (-b - Math.sqrt(delta))/(2*a);
			System.out.println("Phương trình có 2 nghiệm phân biệt x1 ="  + x3 + " và x2 = " + x4);
			}
			
		}
	}
}