package lap1;

import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		double canh;
		Scanner myInput= new Scanner(System.in);
		System.out.print("Nhập cạnh hình lập phương= ");
		canh= myInput.nextInt();
		myInput.close();
		double x= Math.pow(canh,3);
		System.out.println("thể tích hình lập phương là: "+x);
		
		
		
	}
}
