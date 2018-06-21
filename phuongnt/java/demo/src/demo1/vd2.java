package demo1;

import java.util.Scanner;

public class vd2 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("username: ");
		String a=sc.nextLine();
		int i=1;
		String n;
		do {
			System.out.println("password: ");
			n=sc.nextLine();
			i++;
		}while (!"12345".equals(n));
		System.out.println("Đăng nhập thành công");
	}
}

