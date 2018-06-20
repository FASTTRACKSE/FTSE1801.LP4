package java_d2;

import java.util.Scanner;

public class vidu1 {
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhập số: ");
		n=sc.nextInt();
		ngay(n);
		
	}
	public static void ngay(int n) {
		switch(n) {
		case 1:
			System.out.println("Chủ Nhật");
			break;
		case 2:
			System.out.println("Thứ Hai");
			break;
		case 3:
			System.out.println("Thứ Ba");
			break;
		case 4:
			System.out.println("Thứ Tư");
			break;
		case 5:
			System.out.println("Thứ Năm");
			break;
		case 6:
			System.out.println("Thứ Sáu");
			break;
		case 7:
			System.out.println("Thứ Bảy");
			break;
		default:
			System.out.println("Nhập sai");
		}
	}
	

}
