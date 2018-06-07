package baivd;

import java.util.Scanner;

public class vd_tinhdaythua {
	public static void main(String[] args) {
		for(int n = 0; n<=10; n++) {
			System.out.printf("%d! = %d\n", n,
			         factorial(n));
		}
	}
			   public static long factorial(long number) {
			      if (number <= 1)
			         return 1;
			      else
			         return number * factorial(number - 1);
			   }
}