package java_day3;

import java.util.Scanner;

public class GoiHam_vidu3 {
	public static String tenthu(int sothu) {
		switch(sothu) {
		case 2: return "Thứ hai";
		case 3: return "Thứ ba";
		case 4: return "Thứ tư";
		case 5: return "Thứ năm";
		case 6: return "Thứ sáu";
		case 7: return "Thứ bảy";
		case 8: return "Chủ nhật";
		default: return "Không biết";
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập thứ: ");
		int so = input.nextInt();
		String thu  = tenthu(so);
		System.out.println(thu);
	}
}
