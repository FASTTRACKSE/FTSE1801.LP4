package java_day11;

import java.util.Scanner;

public class chuongtrinhlapphuong {
	public static void main (String[] args) {
		int canh;
		double thetich;
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập giá trị cạnh: ");
		canh= sc.nextInt();
		
		
		
		System.out.println("- Thể tích khối lập phương là: " + (thetich= Math.pow(canh,3)));
	}
}
