package demo_d1;

import java.util.Scanner;

public class Quanly {
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}
	public static void menu() {
		while(true) {
			
				System.out.println(">>  MENU QUẢN L�? SINH VIÊN <<");
				System.out.println("+-------------------------------+");
				System.out.println("|1. Giải phương trình bậc nhất");
				System.out.println("|2. Giải phương trình bậc 2");
				System.out.println("|3. Tính ti�?n điện");
				System.out.println("|4. Kết thúc");
				System.out.println("+-------------------------------+");
				Scanner input = new Scanner(System.in);
				System.out.println("Lấy CT của bạn: ");
				int mytion = input.nextInt();
				if (mytion ==1) {
					PTbac1();
					break;
				}else if (mytion==2) {
					PTbac2();
					break;
				}else if (mytion==3) {
					tinhtiendien();
					break;
				}else if (mytion==4) {
					System.out.println("Chương trình kết thúc.");
					break;
				}
			
		}
	}

	private static void tinhtiendien() {
		int sd;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập ti�?n điện:  ");
		sd = input.nextInt();
		int st;
		if(sd<=50) {
			st = sd*1000;
			System.out.println("Số ti�?n điện là : " + st);
		}else {
			st=50*1000 + (sd-50)*1200;
			System.out.println("Số ti�?n điện là : " + st);
		}

	}

	private static void PTbac2() {
		double a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextDouble();
		System.out.println("Nhập giá trị c: ");
		c = sc.nextDouble();
		if(a==0) {
			if((b==0)&&(c==0)) {
				System.out.println("phương trình có vô số nghiệm");
			}else if((b==0)&&(c!=0)) {
				System.out.println("Phương trình vô nghiệm");
			}else {
				double z = -c/b;
				System.out.println("Phương trình có nghiệm = " + z);
			}
		}else {
			double dt=b*b-4*a*c;
			double x =(-b + Math.sqrt(dt))/(2*a);
			double y =(-b - Math.sqrt(dt))/(2*a);
			if (dt < 0) {
				System.out.println("Phương trình vô nghiệm");
			}else if (dt == 0) {
				System.out.println("Phương trình có nghiệm kép= " + -b/(2*a));
			}else if(dt > 0){
				System.out.println("Có hai nghiệm phân biệt" + x+" " + y);
			}
		}

	}

	private static void PTbac1() {
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
				System.out.println("Phương trình có nghiệm x = " + x);
			}
	}

}
