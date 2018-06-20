package bai_tap_co_ban;

import java.util.Scanner;

public class phan_tich_thanh_thua_so {
	public static void main(String[] args) {
		int i = 2;
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập n : ");
		int n = input.nextInt();
		input.close();
		while(i <= n) {
			if(n%i==0) {
				System.out.print(i+"  ");
				n=n/i;
			}else {
				i++;
			}
		}
		
	}
}
