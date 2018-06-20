package demo1;

import java.util.Scanner;

public class bangcuuchuong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i= 1; i <= 10; i++) {

			for (int j = 1; j <= 9; j++) {
				System.out.print( j + " * "  + i + " = "  + (i*j) + "	");
				
			}
			System.out.println();
		}
	}
}

