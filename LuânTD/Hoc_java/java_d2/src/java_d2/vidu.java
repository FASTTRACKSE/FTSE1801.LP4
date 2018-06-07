package java_d2;

import java.util.Scanner;

public class vidu {
	public static void main(String[] args) {
		System.out.println("-----Login-----");
		Scanner sc=new Scanner(System.in);
		/*
		int n;
		int i=1;
		do {
			System.out.println("STT "+i+": Xin Chào");
			System.out.print("Bạn có muốn tiếp tục không (1|0)");
			n=sc.nextInt();
			i++;
			
		}while(n==1);
		*/
		String name,pass;
		System.out.print("Username: ");
		name=sc.nextLine();
		do {
			System.out.print("Passwork: ");
			pass=sc.nextLine();
		}while(!"12345".equals(pass));
		System.out.println("Đăng nhập thàng công");
	}

}
