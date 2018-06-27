package javaday2;

import java.util.Scanner;

public class lap_bai6 {
	public static void main(String[] args) {
		String ten;
		double dtb;
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập họ và tên: ");
		ten = input.next();
		Scanner input1 = new Scanner(System.in);
		System.out.print("Nhập điểm: ");
		dtb = input1.nextDouble();
		
		if(dtb>=9) {
			System.out.print("Học lực: Xuất sắc.");
		}else if(dtb>7.5) {
			System.out.print("Học lực: Giỏi.");
		}else if(dtb>6.5) {
			System.out.print("Học lực: Khá.");
		}else if(dtb>5) {
			System.out.print("Học lực: TB.");
		}else {
			System.out.print("Học lực: Yếu.");
		}
	}
}
