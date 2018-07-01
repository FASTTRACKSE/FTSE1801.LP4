package lap7;

import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Nhập tên:");
			String ten =sc.nextLine();
			String quyTacTen = "[A-Z][a-z]*(\\s[A-Z][a-z])*";
			if(ten.matches(quyTacTen)) {
				System.out.println("Đúng");
			}else {
				System.out.println("Sai");
			}
			
			System.out.println("Nhập số điện thoại: ");
			String numberPhone = sc.nextLine();
			String pattern = "0[0-9]{9,10}";
			if(numberPhone.matches(pattern)) {
				System.out.println("Đúng");
			}else {
				System.out.println("Sai");
			}
			
			System.out.println("Nhập biển số xe: ");
			String bsx = sc.nextLine();
			String a = "5\\d-[A-Z]\\d-((\\d{4})|(\\d{3}\\.\\d{2}))";
			if(bsx.matches(a)) {
				System.out.println("Đúng");
			}else {
				System.out.println("Sai");
			}
		}
	}

}
