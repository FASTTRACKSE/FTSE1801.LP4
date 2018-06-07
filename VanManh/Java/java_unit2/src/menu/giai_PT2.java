package menu;

import java.util.Scanner;

public class giai_PT2 {
	public static void giai_PTbac2(String[] args){
		double a, b, c,delta, can_delta;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập a:");
		a = input.nextDouble();
		
		System.out.print("Nhập b:");
		b = input.nextDouble();
		
		System.out.print("Nhập c:");
		c = input.nextDouble();
		
		delta = Math.pow(b,2) - (4 * a * c);
		can_delta = Math.sqrt(delta);
		 if(a==0) {
			 if(b==0) {
				 if(c==0) {
					 System.out.println("Pt vô số nghiệm");
				 }else {
					 System.out.println("Pt vô nghiệm");
				 }
			 }else {
				 double x = -b/c;
				 System.out.println("Pt có 1 nghiệm là:"+x);
			 }
		 }else if(delta<0){
			 System.out.println("Pt vô nghiệm");
		 }else if(delta==0){
			 double x = -b/(2*a);
			 System.out.println("Phương trình có nghiệm kép là:"+x);
		 }else {
			 double x1= -(b+can_delta)/(2*a);
			 double x2= -(b-can_delta)/(2*a);
			 System.out.println("Pt có 2 nghiệm là:"+x1+"và"+x2);
		 }
	}
}
