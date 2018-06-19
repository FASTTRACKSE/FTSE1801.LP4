package baitap;

import java.util.Scanner;

public class vidu1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int i =1;
		do {
			System.out.println("STT-"+ i+": xin chào");
			System.out.println("Bạn có muốn tiếp tục in ko (1:Yes|0:No)");
			n = input.nextInt();
			i++;
		}while(n==1);
	}
}
