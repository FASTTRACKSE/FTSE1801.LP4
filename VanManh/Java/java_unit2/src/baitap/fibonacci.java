package baitap;

import java.util.Scanner;

public class fibonacci {
	 public static void main(String[] args) {
		 	System.out.print("Nhập n: ");
		 	Scanner input = new Scanner(System.in);
		 	int n = input.nextInt();
		 	input.close();
		 	int[] rs = get_Fibonacci(n);
		 	for(int x:rs) {
		 		System.out.println(x);
		 	}
//	        System.out.println("dãy số fibonacci từ 0 đến " + n);
//	        for (int i = 0; i < n; i++) {
//	        	if(Fibonacci(i)<n) {
//	        		System.out.print(Fibonacci(i) + " ");
//	        	}
//	        }
	    }

	    public static int Fibonacci(int n) {
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

	    public static int[] get_Fibonacci(int n) {
	    	int t1, t2;
	    	t1=0;
	    	t2=1;
	    	int[] rs = new int[n];
    		rs[0]=0;
    		rs[1]=1;
	    	if(n>2) {
	    		int so;
	    		for(int i =2;i<n;i++) {
	    			so = t1+t2;
	    			rs[i]=so;
	    			t1=t2;
	    			t2=so;
	    		}
	    	}
	    	return rs;
	    }
}
