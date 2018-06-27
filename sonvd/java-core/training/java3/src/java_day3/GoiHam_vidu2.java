package java_day3;

import java.util.Scanner;

public class GoiHam_vidu2 {
	public static void main(String[] args) {
		hienthi(null);
	}
	public static void hienthi(String ten) {
		Scanner input = new Scanner(System.in);
		int so = input.nextInt();
		if(so == 2) {
			System.out.print("Thứ hai");
		}else if(so ==3) {
			System.out.print("Thứ ba");
		}else if(so ==4) {
			System.out.print("Thứ tư");
		}else if(so ==5) {
			System.out.print("Thứ năm");
		}else if(so ==6) {
			System.out.print("Thứ sáu");
		}else if(so ==7) {
			System.out.print("Thứ bảy");
		}else if(so ==1) {
			System.out.print("Chủ nhật");
		}		
	}
}
