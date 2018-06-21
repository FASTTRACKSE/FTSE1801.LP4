
package giaiphuongtrinh;

import java.util.Scanner;



public class menu {
  public static void main(String[]args) {
	  System.out.println( "1.Giải phương trình bậc 1");
	  System.out.println( "2.Giải phương trình bậc 2");
	  System.out.println( "3.Tính tiền điện");
	  System.out.println("4.kết thúc chương trình");
	 
	  Scanner sc = new Scanner(System.in);
	  int n;
	  
	  do {
		  System.out.println("nhập số thứ tự: ");
		  n = sc.nextInt();
	  if(n==1) {
		  Giaipt_bac1.pt_bac_1(args);
		  
	  }else if(n==2) {
		  Giaipt_bac2.pt_bac_2(args); 
		  
	  }else if(n==3) {
		  tiendien.tien_dien(args);
		  
	  }
	  else if(n==4) {
		  System.out.println("4.kết thúc chương trình");
	  }
	  }
	  while(n!=4);
  }
}
