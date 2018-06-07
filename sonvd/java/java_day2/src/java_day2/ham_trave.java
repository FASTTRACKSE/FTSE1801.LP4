package java_day2;

import java.util.Scanner;

public class ham_trave {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập thứ: ");
		int thu = input.nextInt();
		int thu1  = thungay(thu);
		System.out.println(thu1);
	}
	
	public static int thungay (int a) {
		switch (a) {
		case 2 :
			System.out.println("Thứ 2");
			break;
		case 3 :
			System.out.println("Thứ ba");
			break;
		case 4 :
			System.out.println("Thứ tư");
			break;
		case 5 :
			System.out.println("Thứ năm");
			break;
		case 6 :
			System.out.println("Thứ sáu");
			break;
		case 7 :
			System.out.println("Thứ bảy");
			break;
		case 8 :
			System.out.println("Chủ nhật");
			break;
		default :
			System.out.println("Hết các thứ trong tuần");
			break;
		}
		return (a);
	}
}
