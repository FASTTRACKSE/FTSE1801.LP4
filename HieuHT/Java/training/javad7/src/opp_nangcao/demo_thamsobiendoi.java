package opp_nangcao;

public class demo_thamsobiendoi {
	static int x;
	static {
		x +=100;
	}
	
	
	
	
    public int sum(int ... x) {
    	int sum = 0;
//    	for(int i : x)
//    		sum += i;
    	
    	for(int i = 0 ; i<x.length; i++) {
    		sum +=x[i];
    		
    	}
    	return sum;
    }
    public void print() {
    	System.out.println(x);
    }
    
    public static void main(String[] args) {
		System.out.println(new demo_thamsobiendoi().sum(1, 2));
		System.out.println(new demo_thamsobiendoi().sum(1, 2, 3));
		System.out.println(new demo_thamsobiendoi().sum(1, 2, 3, 4, 5, 6));
		 int x[]= new int[] {1, 2, 3, 4, 5, 6};
		 System.out.println(new demo_thamsobiendoi().sum(x));
		 


		 System.out.println(new demo_thamsobiendoi().x);
		 demo_thamsobiendoi d1 = new demo_thamsobiendoi();
		 demo_thamsobiendoi d2 = new demo_thamsobiendoi();
		 demo_thamsobiendoi d3 = new demo_thamsobiendoi();
		 
		 d1.print();
		 d2.print();
		 d3.print();
		 d1.x=500;
		 d1.print();
		 d2.print();
		 d3.print();
		 
	}
   
}
