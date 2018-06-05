package java_day2;

import java.util.Scanner;

public class tiendien {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		double sodien;
		System.out.print("Số điện= ");
		sodien= sc.nextDouble();
		if(sodien>=50) {
			System.out.println("Số tiền= "+ ((50*1000 +(sodien-50)*1200)));
		}else {
			System.out.println("Số tiền= "+(sodien*1000));
		}
	}
}