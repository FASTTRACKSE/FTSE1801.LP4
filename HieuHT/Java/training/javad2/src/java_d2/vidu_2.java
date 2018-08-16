package java_d2;

import java.util.Scanner;

public class vidu_2 {
	
	public static void main(String[]args) {
		  //khai báo biến
		  int n, i;
		  Scanner sc = new Scanner(System.in);
		  System.out.println("nhập giá trin N : ");
		  n = sc.nextInt();
		      if((n/2)==2){
		    	  System.out.println(n+"là nguyên tố");
		      }
		      else{
		    	  for (i=3;i<=(n/2);i+=2){
					  if(n%i==0){
						 System.out.println(n+"không phải nguyên tố"); 
					  }
					  else {
						  System.out.println(n+ "là số nguyên tố");
					  }
					  break;
				  }
		    	  
		      }
					  
		  
	  }
}
