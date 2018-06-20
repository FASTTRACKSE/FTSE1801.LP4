package java_d3;

import java.util.Scanner;

public class thuvien {
	public static void hienthi() {
		System.out.println("Xin chao");
		System.out.println("Toi ten la Nam");
		System.out.println("Cam on cac ban");
	}
	public static void xinchao(String ten) {
		System.out.print("Xin chao:" + ten);
	}
	
	public static double dienTichHCN(double cd,double cr) {
		return cd*cr;
	}
	public static boolean kiemTraSNT(int n) {
		int dem=0;
		for(int i =1;i<n;i++) {
			if(n%i==0) {
				dem=dem+1;//dem++,dem+=1
			}
		}
		if(dem==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String tenThu(int soThu) {
		switch(soThu) {
			case 2: return "Thứ hai";
			case 3: return "Thứ ba";
			case 4: return "Thứ tư";
			case 5: return "Thứ năm";
			case 6: return "Thứ sáu";
			case 7: return "Thứ bảy";
			case 8: return "Chủ nhật";
			default:return " Không biết";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Xin mời nhập số thứ");
		int so = sc.nextInt();
		String thu = tenThu(so);
		System.out.println(thu);
		
		
	}
}
