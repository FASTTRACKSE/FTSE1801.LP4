package java_d3;

import java.util.Scanner;

public class vidu_chuyenso_sangthu {
	
	public static String tenthu(int n) {
		switch(n) {
		case 1: return "Chủ nhât";
		case 2: return "Thứ hai";
		case 3: return "Thứ Ba";
		case 4: return "Thứ tư";
		case 5: return "Thứ năm";
		case 6: return "Thứ sáu";
		case 7: return "Thứ bảy";
		default:return "không biết";
		}
	}
		
	public static void main(String[]args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập vào 1 số: ");
		
		n = sc.nextInt();
		String thu = tenthu(n);
		System.out.println(thu);
	}

}
