package java_day2;

import java.util.Scanner;

public class tinhtiendien {
	public static void main(String args[]){
		int chu, tien;
		Scanner sc=new Scanner(System.in);
		System.out.print("- Số chữ điện dùng trong tháng là:");
		chu=sc.nextInt();
		if(chu<50) {
			 tien=chu*1000;
		}
		else {
			 tien=50*1000 + (chu - 50)*1200;
		}
		System.out.print("- Số tiền phải trả trong tháng là: " + tien);
	}
}
