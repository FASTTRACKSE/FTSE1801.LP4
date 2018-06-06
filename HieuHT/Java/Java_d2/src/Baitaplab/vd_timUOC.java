package Baitaplab;

import java.util.Scanner;

public class vd_timUOC {
	public static void main(String[] asge){
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số a: ");
		a = sc.nextInt();
		int i;
		for(i=1;i<a;i++) {
			int uoc=a%i;
			if(uoc==0) {
				System.out.println("Uoc so cua a la: " + i);
			}
		}
	}
}