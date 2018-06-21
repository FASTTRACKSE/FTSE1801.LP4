package giaiphuongtrinh;

import java.util.Scanner;

public class tiendien {
	public static void tien_dien(String[]args){
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
