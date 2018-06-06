package java_day2;

import java.util.Scanner;

public class vd2 {
	public static void main(String args[]){
		String user;
		
		int password=12345;
		System.out.println("----Login----");
		Scanner sc=new Scanner(System.in);
		int n ;
		int i=1;
//	do {
//		System.out.println("STT-" +i+ ": Xin chào");
//		System.out.println("- Bạn có mún tiếp tục không (1|0)");
//		n= sc.nextInt();
//		i++;
//	}while(n==1);
		System.out.print("- Username:");
		user= sc.nextLine();
		System.out.print("- Password:");
		n=sc.nextInt();
		do {
			System.out.print("- Password:");
			n=sc.nextInt();
			i++;
			if(n==password) {
				
				System.out.println("- Đăng nhập thành công");
				break;
		
			}
			
		}while(true);
//		do {
//			System.out.print("- Password:");
//			n=sc.nextInt();
//		}while(!password.equal("12345"));
//		System.out.println("- Đăng nhập thành công");
	}
}
