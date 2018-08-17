package opp_nangcao;



public class thamtri_thamchieu {
   public static void m(int  x) {
	   x+=5;
	   System.out.println("X trong m = "+ x);
   }
   public static void m(int x[]) {
//	    x = new int[2];
	   x[0] +=5;
	   System.out.println("X trong m = "+ x[0]);
   }
   public static void m(String s) {
	   s = s + 1;
	   System.out.println("s trong m ="+s);
   }
   public static void m(StringBuilder s) {
	   s.append("1");
	   System.out.println("sB trong m = "+s);
   }
   public static void main(String[] args) {
	int x= 3;
	m(x);
	System.out.println("x ngoài m ="+ x);
	int[] X= new int[2];
	X[0]=3;
	m(X);
	System.out.println("X ngoai m = "+ X[0]);
	
	String s = new String("hello");
	m(s);
	System.out.println("s ngoai m "+ s);
	StringBuilder sB = new StringBuilder("hello");
	m(sB);
	System.out.println("sB trong m = "+ sB);

  }
}
