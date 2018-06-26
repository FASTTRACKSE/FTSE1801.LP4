package javaday2;

import java.util.Scanner;

public class lap_bai4 {
	public static void main(String[] args) {
		showMyMenu();
	}
	public static void showMyMenu() {
		while(true) {
			try {
				System.out.println("Menu quản lí");
				System.out.println("+---------------------------+");
				System.out.println("1. Giải phương trình bậc nhất");
				System.out.println("2. Giải phương trình bậc hai");
				System.out.println("3. Tính tiền điện");
				System.out.println("4. Kết thúc");
				System.out.println("+---------------------------+");
				int myoption;		
				Scanner input = new Scanner(System.in);
				System.out.println("Lựa chọn của ban: ");
				myoption = input.nextInt();
				if(myoption ==1) {
					main1();
					break;
				}else if(myoption == 2) {
					main2();
					break;
				}else if(myoption ==3) {
					main3();
					break;
				}else if(myoption ==4) {
					main4();
					break;
				}
			}catch(ArithmeticException e){
				System.out.println("Nhập sai");
				break;
			}
			System.out.println("Nhập sai");
			break;}
	}
	public static void main1() {
		double a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextDouble();
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm");
			}
		}else {
			double x= -b/a;
			System.out.println("Phương trình có nghiệm là x = "+x);
		}
	}
	public static void main2() {
		double a,b,c;
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextDouble();
		System.out.println("Nhập b: ");
		b = sc.nextDouble();
		System.out.println("Nhập c: ");
		c = sc.nextDouble();
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("Phương trình có vô số nghiệm");
				}else {
					System.out.println("Phương trình vô nghiệm");
				}
			}else {
				double x = -c/b;
				System.out.println("Phương trình có nghiệm là x = " + x);
			}
		}else {
			double dt=b*b-4*a*c;
			double y1 =(-b + Math.sqrt(dt))/(2*a);
			double y2 =(-b - Math.sqrt(dt))/(2*a);

			if (dt < 0) {
				System.out.println("Phương trình vô nghiệm");
			}else if (dt == 0) {
				System.out.println("Phương trình có nghiệm kép: x = " + -b/(2*a));
			}else if(dt > 0){
				System.out.println("Phương trình có 2 nghiệm phân biệt là x1 = " +y1+" và x2 = "+y2);

			}
		}
	}
	public static void  main3() {
		int sd;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập số tiền:  ");
		sd = input.nextInt();
		int st;
		if(sd<=50) {
			st = sd*1000;
			System.out.println("Số tiền điện là: " + st);
		}else {
			st=50*1000 + (sd-50)*1200;
			System.out.println("Số tiền điện là: " + st);
		}
	}
	public static void main4() {
		System.out.println("Chương trình kết thúc.");
	}
}
