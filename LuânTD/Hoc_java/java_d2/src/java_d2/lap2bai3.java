package java_d2;

import java.util.Scanner;

public class lap2bai3 {
	
	public static void main(String[] args) {
		
		int sodien,tien;
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Nhập số điện sử dụng: ");
		sodien=sc.nextInt();
		if(sodien<50) {
			tien=sodien*1000;
			System.out.println("Số tiền phải trả là: "+tien);
		}else {
			tien=50*1000+(sodien-50)*1200;
			System.out.println("Số tiền phải trả là: "+tien);
		}
		
		
	}

}
