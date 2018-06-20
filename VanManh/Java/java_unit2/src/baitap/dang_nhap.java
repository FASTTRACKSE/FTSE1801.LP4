package baitap;

import java.util.Scanner;

public class dang_nhap {
	public static void main(String[] args) {
		Scanner input = new  Scanner(System.in);
		
		System.out.println("----Login----");
		String password, username;
		System.out.print("Username: ");
		username = input.nextLine();
		do {
			System.out.print("Password: ");
			password = input.nextLine();
		}while(!"vanmanh12345".equals(password));
		System.out.println("Đăng nhập thành công");
	}
	
}
