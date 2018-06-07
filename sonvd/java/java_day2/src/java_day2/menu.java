package java_day2;

import java.util.*;

public class menu {
	public static void main(String[] args) {
		while (true) {
				System.out.println("+---------------------------------------------------+");
				System.out.println("1. Giải phương trình bậc 1");
				System.out.println("2. Giải phương trình bậc 2");
				System.out.println("3. Tính tiền điện");
				System.out.println("4. Kết thúc");
				System.out.println("+---------------------------------------------------+");
				
				int n;
				Scanner input = new Scanner(System.in);
				System.out.println("Nhập và chọn số thứ tự: ");
				n = input.nextInt();
				if (n == 1) {
					giaiptb1();
					break;
				} else if (n == 2) {
					giaiptb2();
					break;
				} else  if (n == 3) {
					tiendien();
					break;
				} else if (n == 4) {
					ketthuc();
					break;
				}
		}
	}
	public static void giaiptb1() {
		int a,b;
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập giá trị a = ");
		a = input.nextInt();
		System.out.println("Nhập giá trị b = ");
		b = input.nextInt();
		
		
		
		if ((a==0)&&(b==0)){
			System.out.println("Phương trình vô số nghiệm");
		} else if ((a==0)&&(b!=0)) {
			System.out.println("Phương trình vô nghiệm");
		} else {
			System.out.println("Phương trình có nghiệm x = " +(-b/a));
		}
	}
	public static void giaiptb2() {
		double a, b, c, delta, x1, x2;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập hệ số a = ");
		a = input.nextDouble();
		System.out.println("Nhập hệ số b = ");
		b = input.nextDouble();
		System.out.println("Nhập hệ số c = ");
		c = input.nextDouble();
		
		delta = Math.pow(b, 2) - 4*a*c;
		x1 = (-b+Math.sqrt(delta)/(2*a));
		x2 = (-b-Math.sqrt(delta)/(2*a));
		
		if (a == 0){
			if ((b==0)&&(c==0)){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình vô số nghiệm");
			} else if ((b==0)&&(c!=0)){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình vô nghiệm");
			}else {
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình có nghiệm x = "+(-c/b));
			}
		}else {
			if (delta<0){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình vô nghiệm");
			}else if (delta == 0){
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình có nghiệm kép x=" +(-b/2*a));
			}else{
				System.out.println("a = "+a+" , "+"b = "+b+" , "+"c = "+c+"  "+"Phương trình có 2 nghiệm phân biệt:"+x1 + " và "+x2);
			}
		}

	}
	public static void tiendien() {
		int sodien;
		
		Scanner input = new Scanner  (System.in);
		
		System.out.println("Nhập số điện tiêu thụ: ");
		sodien = input.nextInt();
		
		if (sodien<50) {
			System.out.println("Số tiền điện tiêu thụ là: " +(sodien*1000));
		} else {
			System.out.println("Số tiền điện tiêu thụ là: " +(50*1000+(sodien-50)*1200));
		}
	}
	public static void ketthuc() {
		System.out.println("Chương trình kết thúc!!!!");
	}

}
