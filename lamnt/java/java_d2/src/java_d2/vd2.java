package java_d2;

import java.util.Scanner;

public class vd2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Login----");
		System.out.print("Username: ");
		String username= sc.nextLine();
		String password;
		do {
			System.out.print("Password: ");
			password= sc.nextLine();
		}while(!password.equals("12345"));
		System.out.println("Dang nhap thanh cong");
	}
}
