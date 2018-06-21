package demo_d2;

import java.util.Scanner;

public class ham_fibonacci {

	public static Integer[] ham_fibonacci(int n) {
		int t1,t2;
		t1=0;
		t2=1;
		Integer[] rs= new Integer[n];
		rs[0]=0;
		rs[1]=1;
		if(n>2) {
			for(int i = 2;i<n;i++) {
				int so = t1+t2;
				rs[i]= so;
				t1=t2;
				t2=so;
			}
		}
		return rs;
	}
	
	public static int so_Fibonaci(int n) {
		int t1,t2,so = 0;
		t1=0;
		t2=1;
		if(n<2) {
			return 0;
		}else {
			if(n==2) {
				return 1;
			}else {
				for(int i = 1;i<n-1;i++) {
					 so = t1+t2;
					t1=t2;
					t2=so;
				}
			}
		}
		return so;
	
	}
	
	
	public static void main(String args[]) {
		System.out.println("Xin mời nhập số n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//fibonaci(n);
		Integer[] day_so=ham_fibonacci(n);
		for(int x:day_so) {
			System.out.print(x+ " ");
		}
	}
}
