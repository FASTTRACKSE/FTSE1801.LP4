package java_d1;

import java.util.Scanner;
import java.util.function.LongToIntFunction;

public class vd1 {
	public static void main(String[] args) {
	   double a,b;
	   
	   Scanner sc= new Scanner(System.in);
	   
	   System.out.println("Nhap gia tri a: ");
	   a=sc.nextDouble();
	   System.out.println("Nhap gia tri b: ");
	   b= sc.nextDouble();
	   if(a==0) {
		   if(b==0) {
			   System.out.println("Pt co vo so nghiem");
		   }else {
			   System.out.println("Pt vo nghiem");
		   }
	   }else {
		   double x = -b/a;
		   System.out.print("Pt co nghiem la x="+ x);
	   }
	}
}
