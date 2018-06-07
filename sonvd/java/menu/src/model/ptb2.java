package model;

import java.util.Scanner;

public class ptb2 {
	public static void main(String[] args) {
		double a, b, c, delta, x1, x2;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập hệ số a = ");
		a = input.nextDouble();
		System.out.println("Nhập hệ số b = ");
		b = input.nextDouble();
		System.out.println("Nhập hệ số c = ");
		c = input.nextDouble();
		
		delta = Math.pow(b, 2) - 4*a*c;
		x1 = (-b+Math.sqrt(delta)/(2*a));
		x2 = (-b-Math.sqrt(delta)/(2*a));
		
		if (a == 0){
			if ((b==0)&&(c==0)){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình vô số nghiệm");
			} else if ((b==0)&&(c!=0)){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình vô nghiệm");
			}else {
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình có nghiệm x = "+(-c/b));
			}
		}else {
			if (delta<0){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình vô nghiệm");
			}else if (delta == 0){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình có nghiệm kép x=" +(-b/2*a));
			}else{
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình có 2 nghiệm phân biệt:"+x1 + " và "+x2);
			}
		}

	}

}
