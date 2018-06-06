package java_day2;

import java.util.*;

public class ptb1 {
	public static void main(String[] args) {
		int a,b;
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập giá trị a = ");
		a = input.nextInt();
		System.out.println("Nhập giá trị b = ");
		b = input.nextInt();
		
		
		
		if ((a==0)&&(b==0)){
			System.out.println("Phương trình vô số nghiệm");
		} else if ((a==0)&&(b!=0)) {
			System.out.println("Phương trình vô nghiệm");
		} else {
			System.out.println("Phương trình có nghiệm x = " +(-b/a));
		}
	}
}
