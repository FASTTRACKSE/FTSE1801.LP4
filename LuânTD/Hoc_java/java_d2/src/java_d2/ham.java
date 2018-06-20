package java_d2;

import java.util.Scanner;

public class ham {
	public static void PT_bac1(String[] args) {
		double a,b;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Nhập a= ");
		a=sc.nextDouble();
		System.out.print("Nhâp b= ");
		b=sc.nextDouble();
		if(a==0) {
			if(b==0) {
				System.out.println("PT có vô số nghiệm");
			}else {
				System.out.println("PT vô nghiệm");
			}
		}else {
			double x=-b/a;
			System.out.println("PT có nghiệm là x= "+x);
		}
	}
	public static void PT_bac2(String[] args) {
		double a,b,c;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Nhập a= ");
		a=sc.nextDouble();
		System.out.print("Nhập b= ");
		b=sc.nextDouble();
		System.out.print("Nhập c= ");
		c=sc.nextDouble();
		double delta= Math.pow(b,2)-4*a*c;
		
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("PT vô số nghiệm");
				}else {
					System.out.println("PT vô nghiệm");
				}
			}else {
				double x=-c/b;
				System.out.println("PT có 1 nghiêm x= "+x);
			}
		}else {
			if(delta<0) {
				System.out.println("PT vô nghiệm");
			}else if(delta==0) {
				double xx=-b/2*a;
				System.out.println("PT có nghiệm kép x1=x2="+xx);
			}else {
				double x1=(-b+Math.sqrt(delta))/2*a;
				double x2=(-b-Math.sqrt(delta))/2*a;
				System.out.println("PT có 2 nghiệm x1= "+x1+", x2= "+x2);
			}
		}

	}
	public static void tiendien(String[] args) {
		
		int sodien,tien;
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Nhập số điện sử dụng: ");
		sodien=sc.nextInt();
		if(sodien<50) {
			tien=sodien*1000;
			System.out.println("Số tiền phải trả là: "+tien);
		}else {
			tien=50*1000+(sodien-50)*1200;
			System.out.println("Số tiền phải trả là: "+tien);
		}

	}
	public static void xeploai(String[] args) {
		int diem;
		Scanner sc=new Scanner(System.in);
		
		
		
	}

}
