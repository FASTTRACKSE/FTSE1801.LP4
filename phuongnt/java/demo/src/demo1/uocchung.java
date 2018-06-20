package demo1;

import java.util.Scanner;

public class uocchung {
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhập N= ");
		n=sc.nextInt();
		
		System.out.print("Ước của "+n+" là: ");
		for(int i=1; i<=n; i++) {
			if(n%i==0) {
				System.out.print(i+", ");
			}
		}
		
		
		
		
		
	}
}

