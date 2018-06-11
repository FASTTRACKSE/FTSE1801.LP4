package java_d2;

import java.util.Scanner;

public class fibonacci {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.print("Nhập N= ");
        int n=sc.nextInt();
        sc.close();
        System.out.println(n+" số đầu của dãy số fibonacci là: ");
        int[] rs=fbn(n);
        for (int i:rs) {
        	System.out.println(i);
        }
    }
	
     //hàm tính fibonacci
    
    public static int[] fbn(int n) {
    	
    	
    	int t1,t2;
    	t1=0;
    	t2=1;
    	int[] a= new int[n];
    		a[0]=0;
    		a[1]=1;
    	if(n>2) {
    		for(int i=2; i<a.length;i++) {
    			int so=t1+t2;
    			t1=t2;
    			t2=so;
    			a[i]=so;	
    		}
    	}
    	
    	return a;
    }
    
    
}	
	
	
	
	
	