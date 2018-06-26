package Lap1;

import java.util.Scanner;

/**
 * Bai tap 3
 * @author SonVD
 *
 */
public class Bai3 {
	public static void main(String[] args) {
		double canhLapPhuong;
		double theTich;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập cạnh lập phương: ");
		canhLapPhuong = input.nextDouble();
		
		theTich = Math.pow(canhLapPhuong, 3);
		
		System.out.println("Thể tích hình lập phương: "+theTich);
	}
}
