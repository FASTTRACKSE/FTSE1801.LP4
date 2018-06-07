package java_unit2;

import java.util.Scanner;

public class fibonacci {
	 public static void main(String[] args) {
		 	System.out.print("Nhập n: ");
		 	Scanner input = new Scanner(System.in);
		 	int n = input.nextInt();
	        System.out.println("dãy số fibonacci từ 0 đến " + n);
	        for (int i = 0; i < n; i++) {
	        	if(fibonacci(i)<n) {
	        		System.out.print(fibonacci(i) + " ");
	        	}
	        }
	    }

	    public static int fibonacci(int n) {
	        int f0 = 0;
	        int f1 = 1;
	        int fn = 1;
	 
	        if (n == 0 || n == 1) {
	            return n;
	        } else {
	            for (int i = 2; i < n; i++) {
	                f0 = f1;
	                f1 = fn;
	                fn = f0 + f1;
	            }
	        }
	        return fn;
	    }

}
