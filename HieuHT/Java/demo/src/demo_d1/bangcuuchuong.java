package demo_d1;

import java.util.Scanner;

public class bangcuuchuong {
	public static void  main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		int j;
		System.out.print("Bảng cửu chương:");
		System.out.println();
		for(i=1; i<=10;i++) {
			for(j=2;j<=8;j++) {
			System.out.print(j + " " + "*" + " "+ i + " " + "=" + j*i + "\t   ");
			}
		System.out.println(j + " " + "*" + " "+ i + " " + "=" + j*i + "\t   ");
		}
	}
}
