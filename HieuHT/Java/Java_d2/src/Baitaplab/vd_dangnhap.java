package Baitaplab;

import java.util.Scanner;

public class vd_dangnhap {
	public static void main(String[] asge){
		System.out.println("-----Login-----");
		String a;
		int pass = 12345;
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		a = sc.next();
		int i = 1;
		int j;
		do {
			System.out.print("Password: ");
			j = sc.nextInt();
			if(j==pass) {
				System.out.print("�?ăng nhập thành công");
				break;
			}
			
		}while(true);
	}
}
