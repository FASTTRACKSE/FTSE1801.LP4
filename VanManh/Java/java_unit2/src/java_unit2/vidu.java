package java_unit2;

import java.util.Scanner;

public class vidu {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		System.out.print("nhập ngày");
		int so = input.nextInt();
		String ngay = thu_ngay(so);
		System.out.print(ngay);
	}
	public static String thu_ngay(int ngay) {
		switch(ngay) {
		case 2: return "Thứ hai";
		case 3: return "Thứ ba";
		case 4: return "Thứ tư";
		case 5: return "Thứ năm";
		case 6: return "Thứ sáu";
		case 7: return "Thứ bảy";
		case 8: return "Chủ nhật";
		default: return "Bạn đã nhập sai";
		}
	
	}
	
	
}
