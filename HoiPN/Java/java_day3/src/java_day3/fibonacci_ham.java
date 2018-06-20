package java_day3;

import java.util.Scanner;

public class fibonacci_ham {
    private static Scanner sc;
	public static void vidu_fibonacci(int n) {
    	int t1,t2;
    	t1 = 0;
    	t2 =1;  	
        if (n <= 2) {
        	System.out.print("0 1");
        	
        }else {
        	System.out.print("0-1");
        	for(int i = 2;i<n;i++) {
        		int so = t1+t2;
        		System.out.print("-"  + so);
        		t1=t2;
        		t2=so;
        	}
        	
        }

    }
    public static void main(String[] args) {
	    System.out.print("Xin mới nhập số n");
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		vidu_fibonacci(n);
    }
}