package java_unit2;

import java.util.Scanner;

public class tim_uoc {
	public static void main(String[] args) {
		Scanner input = new  Scanner(System.in);
		
		System.out.print("Nhập n = ");
		int n = input.nextInt();
		System.out.println("Các ước của "+n +" là:");
		for(int i=1; i<=n; i++) {
			if(n%i==0) {
				System.out.print(i+"    ");
			}
		}
	}
}
