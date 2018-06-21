package giaiphuongtrinh;

import java.util.Scanner;

public class Giaipt_bac1 {
	public static void pt_bac_1(String[]args){
		
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
