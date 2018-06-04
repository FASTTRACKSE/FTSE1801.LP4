package hello;

import java.util.Scanner;

public class bangdiem {
	public static void main(String [] args) {
		String name;
		double lp1,lp2,lp3, dtb;
		
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập họ và tên: ");
		name = input.nextLine();
		
		System.out.println("Nhập điểm lp1: ");
		lp1 = input.nextDouble();
		System.out.println("Nhập điểm lp2: ");
		lp2 = input.nextDouble();
		System.out.println("Nhập điểm lp3: ");
		lp3 = input.nextDouble();
		
		System.out.println("<<"+name+">>"+"<<"+lp1+","+lp2+","+lp3+">>"+((lp1+lp2+lp3)/3));
		
	}

}
