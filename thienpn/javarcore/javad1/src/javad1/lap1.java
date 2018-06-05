package javad1;

import java.util.Scanner;

public class lap1 {

	  
	     public static void main(String[]args) {
			System.out.println("Bài tập 1");
		    String hoten;
		    double lp1, lp2, lp3, dtb;
		    //nhập giá trị từ bàn phím
		    Scanner myInput = new Scanner(System.in);
		    System.out.print("nhập họ tên : ");
		    hoten = myInput.nextLine();
		    
		    System.out.println("nhập điểm : ");
		    lp1 = myInput.nextDouble();
		    lp2 = myInput.nextDouble();
		    lp3 = myInput.nextDouble();
		    
		    System.out.println("họ và tên :"+ "<<" + hoten + ">>");
		    System.out.println("điểm "+"lp1 "+ lp1 + " lp2 "+lp2 + " lp3 "+ lp3);
		    System.out.println("điểm trung bình :"+"<<" + (lp1+lp2+lp3)/3 + ">>");
		 }
  
}
