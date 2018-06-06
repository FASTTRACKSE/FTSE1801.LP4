package java_unit2;

import java.util.Scanner;

public class bang_diem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String hoc_luc;
		System.out.print("Nhập tên:");
		String hoTen =  input.nextLine();
		
		System.out.print("Nhập điểm lp1:");
		double lp1 = input.nextDouble();
		
		System.out.print("Nhập điểm lp2:");
		double lp2 = input.nextDouble();
		
		System.out.print("Nhập điểm lp3:");
		double lp3 = input.nextDouble();
		
		double dtb = (lp1+lp2+lp3)/3 ;
		
		if(dtb<5) {
			hoc_luc = "Yếu";
		}else if(dtb<6.5) {
			hoc_luc = "Trung bình";
		}else if(dtb<7.5) {
			hoc_luc = "Khá";
		}else if(dtb<9) {
			hoc_luc = "Giỏi";
		}else {
			hoc_luc = "Xuất sắc";
		}
	
		System.out.println("Họ và tên:" + hoTen);
		System.out.println("Điểm lp1 :" + lp1);
		System.out.println("Điểm lp2 :" + lp2);
		System.out.println("Điểm lp3 :" + lp3);
		System.out.println("Điểm tb  :" + dtb);
		System.out.println("Xếp loại :" + hoc_luc);
	}
}
