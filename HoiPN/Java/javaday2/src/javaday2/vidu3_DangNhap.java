package javaday2;

import java.util.Scanner;

public class vidu3_DangNhap {
	public static void main(String[] args) {
		System.out.println("----Login----");
		String id;
		int pass = 12345;
		Scanner input= new Scanner(System.in);
		System.out.print("Username: ");
		id = input.next();
		int i =1;
		int n;
		do{
			System.out.print("Password: ");
			n= input.nextInt();			
			if(n==pass) {
				System.out.println("Đăng nhập thành công.");
				break;
			}
		}while(true);
	}
}
