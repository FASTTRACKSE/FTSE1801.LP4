package java_d3;
import java_d3.thuvien;

import java.util.Scanner;

	public class vd2 {
		public static void main(String[] args) {
			thuvien lib= new thuvien();
			Scanner sc = new Scanner(System.in);
			System.out.println("Xin mời nhập số thứ");
			int so = sc.nextInt();
			String thu = lib.tenThu(so);
			System.out.println(thu);
			
	}
}
