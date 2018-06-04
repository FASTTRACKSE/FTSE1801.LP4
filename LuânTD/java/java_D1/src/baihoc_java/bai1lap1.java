package baihoc_java;

import java.util.Scanner;

public class bai1lap1 {
	public static void main(String[] args) {
		String hoten;
		float lp1,lp2,lp3;
		Scanner myInput=new Scanner(System.in);
		System.out.print("Nhập Họ và tên: ");
		hoten= myInput.nextLine();
		
		System.out.print("Nhập điểm LP1= ");
		lp1= myInput.nextInt();
		System.out.print("Nhập điểm LP2= ");
		lp2= myInput.nextInt();
		System.out.print("Nhập điểm LP3= ");
		lp3= myInput.nextInt();
		float diemtb=(lp1+lp2+lp3)/3;
		
		System.out.print("<<"+hoten+">>");
		System.out.print("<<"+lp1+","+lp2+","+lp3+">>");
		System.out.print(diemtb);
		
		
		
		
		
		
		
		
	}

}
