package java_day4;

import java.util.Scanner;

public class fibonacci {
 

    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);
    	System.out.println("Hãy nhập số n: ");
    	int n=sc.nextInt();
    	System.out.print(n+" số đầu tiên trong dãy fibonacci là: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
     
//Tính số fibonacci thứ n

    public static int fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int fn = 1;
 
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
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
