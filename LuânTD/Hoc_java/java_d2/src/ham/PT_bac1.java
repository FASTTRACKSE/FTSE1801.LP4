package ham;

import java.util.Scanner;

public class PT_bac1 {
	public static void PT_b1() {
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
		
		sc.close();
		
	}

}
