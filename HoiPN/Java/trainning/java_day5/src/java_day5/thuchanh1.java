package java_day5;

import java.util.Scanner;

public class thuchanh1 {
	public static void giaiphuongtrinh(double a, double b) {	
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm");
			}
		}else {
			double x= -b/a;
			System.out.println("Phương trình có nghiệm là x = " + x);
		}		
	}
	public static void main(String[] args) {
		double a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextDouble();
		giaiphuongtrinh(a,b);

	}

}
