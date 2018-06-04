package hello;

import java.util.Scanner;

public class thetichlphuong {
	public static void main(String[] args) {
		double canh, thetich;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập cạnh khối chữ nhật: ");
		canh = input.nextDouble();
		
		thetich = Math.pow(canh,3);
		
		System.out.println("Thể tích khối chữ nhật: "+canh+" * "+canh+" * "+canh+ " = " +thetich);
	}

}
