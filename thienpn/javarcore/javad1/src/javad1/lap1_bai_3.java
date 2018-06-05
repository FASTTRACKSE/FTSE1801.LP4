package javad1;

import java.util.Scanner;

public class lap1_bai_3 {
   public static void main(String[]args) {
	   System.out.println("bài 3");
	   //khai báo biến
	   double a;
	   //nhập giá trị từ bàn phím
	   Scanner myInput = new Scanner(System.in);
	   System.out.print("nhập giá trị cạnh a : ");
	   a = myInput.nextDouble();
	   System.out.println("Thể tích hình lập phương canh a :"+ Math.pow(a,3));
   }
   
}
