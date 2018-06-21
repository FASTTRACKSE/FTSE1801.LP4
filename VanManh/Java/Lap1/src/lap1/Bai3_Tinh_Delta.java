package lap1;

import java.util.Scanner;

public class Bai3_Tinh_Delta {
	public static void main(String[] args) {
		double a, b, c,delta;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập a:");
		a = input.nextDouble();
		
		System.out.print("Nhập b:");
		b = input.nextDouble();
		
		System.out.print("Nhập c:");
		c = input.nextDouble();
		input.close();
		delta = Math.pow(b,2) - (4 * a * c);
		
		//In ra màn hình căn delta
		System.out.printf("Căn bậc 2 delta là:"+"%.2f",Math.sqrt(delta));
	}
}
