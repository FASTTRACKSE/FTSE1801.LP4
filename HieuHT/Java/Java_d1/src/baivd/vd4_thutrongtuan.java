package baivd;

import java.util.Scanner;

public class vd4_thutrongtuan {
	public static void  main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Xin mời nhập số thứ");
		int so = sc.nextInt();
		String thu = tenthu(so);
		System.out.println(thu);
	}
	public static String  tenthu(int sothu) {
		switch(sothu) {
		case 2: return "Thứ hai";
		case 3: return "Thứ ba";
		case 4: return "Thứ tư";
		case 5: return "Thứ năm";
		case 6: return "Thứ sáu";
		case 7: return "Thứ bảy";
		case 8: return "Chủ nhật";
		default:return "Không biết";
		}
	}
}
