package java_day2;

import java.util.Scanner;

public class timuoc1so {
	public static void main(String args[]){
		int n;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.print("- Ước chung của số n= ");
		n=sc.nextInt();
		
		
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				System.out.print( i+ ",");
			}
			
		}
	
	}
}
