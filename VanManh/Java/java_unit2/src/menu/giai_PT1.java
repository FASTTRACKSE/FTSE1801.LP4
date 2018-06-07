package menu;

import java.util.Scanner;

public class giai_PT1 {
	public static void giai_PTbac1(String[] args){
		double a,b;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập giá trị a:");
		a = input.nextDouble();
		
		System.out.print("Nhập giá trị b:");
		b = input.nextDouble();
		
		if(a==0) {
			if(b==0) {
				System.out.println("Pt vô số nghiệm");
			}else {
				System.out.println("Pt vô nghiệm");
			}
		}else {
			double x = -b/a;
			System.out.println("Pt có nghiệm là:" + x);
		}
	}
	
}
