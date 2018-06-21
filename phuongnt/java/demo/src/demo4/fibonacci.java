package demo4;

import java.util.Scanner;

public class fibonacci {
	
//	public static int fibonacci(int n) {
//		int t1, t2;
//		t1 = 0;
//		t2 = 1;
//		if(n <= 2) {
//			System.out.println("0 1");
//		} else {
//			System.out.print("0-1");
//			for(int i = 2; i <= n; i++) {
//				int so = t1 + t2;
//				System.out.print( "-"+so);
//
//				t1 = t2;
//				t2 = so;
//			}
//		}
//		return n;
//	}
	
	public static int[] day_Fibonaci(int n) {
		int t1,t2;
		t1=0;
		t2=1;
		int[] rs= new int[n];
		rs[0]=0;
		rs[1]=1;
		int so;
		if(n>2) {
			for(int i = 2;i<n;i++) {
				so = t1+t2;
				rs[i]= so;
				t1=t2;
				t2=so;
			}
		}
		return rs;
	}
	
	public static void main(String[] args) {
		System.out.println("xin mời nhập số n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int t1, t2;
//		t1 = 0;
//		t2 = 1;
//		if(n <= 2) {
//			System.out.println("0 1");
//		} else {
//			System.out.print("0-1");
//			for(int i = 2; i<= n; i++) {
//				int so = t1 + t2;
//				System.out.print( "-"+so);
//
//				t1 = t2;
//				t2 = so;
//			}
//		}
//		fibonacci(n);
		int[] day_so=day_Fibonaci(n);
		for(int x:day_so) {
			System.out.println(x);
		}
		
		
	}
}
