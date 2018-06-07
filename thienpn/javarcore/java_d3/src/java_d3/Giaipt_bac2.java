package java_d3;

import java.util.Scanner;

public class Giaipt_bac2 {
	public static void pt_bac_2(String[]args) {
		double a, b, c, x, delta;
		   //nhập giá trị từ bàn phím
		   Scanner myInput = new Scanner(System.in);
		   System.out.print("nhập giá tri a: ");
		   a = myInput.nextDouble();
		   System.out.print("nhập giá trị b: ");
		   b = myInput.nextDouble();
		   System.out.print("nhập giá trị c :");
		   c = myInput.nextDouble();
		   delta = Math.pow(b,2)-4*a*c;
		   //in ra màn hình
	    
		   System.out.println("Giá trị delta : "+ delta);
		   System.out.println("Căn bậc 2 delta: "+ Math.sqrt(delta));
		   if(a==0) {
			   System.out.println("phương trình bậc nhất");
			   if(b==0) {
			      if(c==0) {
			    	  System.out.println("phương trình vô số nghiệm");
			      }
			      else {
			    	  System.out.println("phương trình vô nghiệm");
			      }
				  
			   }
			   else {
				   x = -c/b;
				   System.out.println("phương trình có nghiệm : "+x);
			   }
			   
		   }
		   else {
			   System.out.println("phương trình bậc 2 ax^2 + bx +c=0");
			   if(delta<0){
				   System.out.println("phương trình vô nghiệm");
			   }
			   else if(delta==0) {
				   x=-b/(2*a);
				System.out.println("phương trình có nghiệm kép : "+x);		   
			   }
			   else {
				   double x1 = (-b + Math.sqrt(delta))/2;
				   double x2 = (-b - Math.sqrt(delta))/2;
				   System.out.println("phương trình có 2 nghiệm phân biệt : "+x1+ " và "+x2);
			   }
		   }
	}
}
