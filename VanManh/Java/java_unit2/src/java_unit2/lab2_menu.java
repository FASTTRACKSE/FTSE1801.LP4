package java_unit2;

import java.util.Scanner;

public class lab2_menu {
	public static void main(String[] args) {
		System.out.println("+-------------------------+");
		System.out.println("1. Giải phương trình bậc 1");
		System.out.println("2. Giải phương trình bậc 2");
		System.out.println("3. Tính tiền điện");
		System.out.println("4. Kết thúc");
		System.out.println("+-------------------------+");
		int n;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Chọn chức năng:");
			n = input.nextInt();
			System.out.println();
			switch(n) {
				case 1:
					System.out.println(PT_bac1());
					break;
				
				case 2:
					System.out.println(PT_bac2());
					break;
					
				case 3:
					System.out.println(tien_dien());
					break;
					
				case 4:
					System.out.println("Kết thúc chương trình");
					break;
					
				default:
					System.out.println("Chức năng bạn chọn không có, mời bạn nhập lại");
			}
		}while(n!=4);	
	}
	//Hàm giải Pt bậc 1
	public static String PT_bac1() {
		double a,b;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập giá trị a:");
		a = input.nextDouble();
		
		System.out.print("Nhập giá trị b:");
		b = input.nextDouble();
		
		if(a==0) {
			if(b==0) {
				System.out.println("Pt vô số nghiệm");
			}else {
				System.out.println("Pt vô nghiệm");
			}
		}else {
			double x = -b/a;
			System.out.println("Pt có nghiệm là:" + x);
		}
		return "";
	}
	
	//Hàm giải PT bậc 2
	public static String PT_bac2() {
		double a, b, c,delta, can_delta;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập a:");
		a = input.nextDouble();
		
		System.out.print("Nhập b:");
		b = input.nextDouble();
		
		System.out.print("Nhập c:");
		c = input.nextDouble();
		
		delta = Math.pow(b,2) - (4 * a * c);
		can_delta = Math.sqrt(delta);
		 if(a==0) {
			 if(b==0) {
				 if(c==0) {
					 System.out.println("Pt vô số nghiệm");
				 }else {
					 System.out.println("Pt vô nghiệm");
				 }
			 }else {
				 double x = -b/c;
				 System.out.println("Pt có 1 nghiệm là:"+x);
			 }
		 }else if(delta<0){
			 System.out.println("Pt vô nghiệm");
		 }else if(delta==0){
			 double x = -b/(2*a);
			 System.out.println("Phương trình có nghiệm kép là:"+x);
		 }else {
			 double x1= -(b+can_delta)/(2*a);
			 double x2= -(b-can_delta)/(2*a);
			 System.out.println("Pt có 2 nghiệm là:"+x1+"và"+x2);
		 }
		return "";
	}
	
	//Hàm tính tiền điện
	public static String tien_dien() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Nhập số điện = ");
		int soDien = input.nextInt();
		
		if(soDien<50) {
			System.out.println("Số tiền điện là:" + soDien*1000);
		}else {
			System.out.print("Số tiền điện là:" + (50*1000 + (soDien-50)*1200));
		}
		
		return "";
	}
}
