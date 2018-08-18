package java_d2;

import java.util.Scanner;

public class Xuat_mennu {
  public static void main(String[]args) {
	 
	  System.out.println( "1.Giải phương trình bậc 1");
	  System.out.println( "2.Giải phương trình bậc 2");
	  System.out.println( "3.Tính tiền điện");
	  System.out.println("4.Chương trình kết thúc");
	  //System.out.println("nhập số thứ tự: ");
	  Scanner sc = new Scanner(System.in);
	  int n;
	  //n = sc.nextInt();
	  do {
		  System.out.println("nhập số thứ tự: ");
		  n = sc.nextInt();
	  if(n==1) {
		  pt_bac_1();
		  
	  }else if(n==2) {
		  pt_bac_2(); 
		  
	  }else if(n==3) {
		  tien_dien();
		  
	  }
	  else if(n==4) {
		  System.out.println("4.Chương trình kết thúc");  
	  }
	  }
	  while(n!=4);
  }

  
public static void pt_bac_1(){
	
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
public static void pt_bac_2() {
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
public static void tien_dien(){
	  //khai báo biến.
	   int sodien, tien;
	   //gắn giá trị
	  
	   Scanner sc = new Scanner(System.in);
	   System.out.print("Nhập số tiền điện: ");
	   sodien = sc.nextInt();
	   
	   if(sodien<50) {
		   
		   System.out.println("Số tiền điện là: "+(sodien*1000));
	   }
	   else {
		   tien = 50*1000 + (sodien-50)*1200;
		   System.out.println("Số tiền điện là: "+tien);
	   }
}
}