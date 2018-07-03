package quanly;

import java.util.Scanner;

public class viduveham {
private static Scanner sc;
//	public static double dientichHCN(double cd, double cr) {
//		return cd*cr;
//	}
	public static boolean kiemtraSN(int n) {
		int dem=0;
		
		for(int i=1; i<n;i++) {
			if(n%i==0) {
				dem++;
			}
		}
		if(dem==1) {
			return true;
		
		}else {
			return false;
		}
	}
	public static void hienthi(String ten) {
	
		System.out.println("Xin chào:" +ten);
		
	}
	public static String thungay(int n) {
		switch(n) {
		case 1: System.out.print("Chủ nhật");break;
		case 2: System.out.print("Thứ hai");break;
		case 3: System.out.print("Thứ ba");break;
		case 4: System.out.print("Thứ tư");break;
		case 5: System.out.print("Thứ năm");break;
		case 6: System.out.print("Thứ sáu");break;
		case 7: System.out.print("Thứ bảy");break;
		default:System.out.print("Bạn nhập sai!!");break;
		}
//		return null;
	
	
		
		
	}
	public static void main(String[] args) {
		hienthi("Nam");
//		String ngay=thungay(3);
//		System.out.print(ngay);
		int n ;
		sc = new Scanner(System.in);
		System.out.print("- Hôm nay là :");
		n=sc.nextInt();
		thungay(n);
//		boolean kq=kiemtraSN(2);
//		if(kq==true) {
//			System.out.print("- n là số nguyên tố.");
//		}
//		else {
//			System.out.print("-n không phải là số nguyên tố.");
//
//		}
//		
		
	}
}
