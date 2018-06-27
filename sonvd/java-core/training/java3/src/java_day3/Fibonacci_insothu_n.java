package java_day3;

import java.util.Scanner;

public class Fibonacci_insothu_n {
    private static Scanner sc;
	public static Integer[] vidu_fibonacci(int n) {
    	int t1,t2;
    	t1 = 0;
    	t2 =1;
    	Integer[] rs = new Integer[n];
    	rs[0]=0;
    	rs[1]=1;
        if (n>2) {
        	for(int i = 2;i<n;i++) {
        		int so = t1+t2;
        		rs[i]=so;
        		t1=t2;
        		t2=so;
        	}	
        }
		return rs;
    }
	public static void main(String args[]) {
		System.out.println("Xin mời nhập số n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//fibonaci(n);
		Integer[] so=vidu_fibonacci(n);
		for(int x:so) {
			System.out.println(x);
		}
	}
}