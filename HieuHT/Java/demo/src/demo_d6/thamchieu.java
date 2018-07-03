package demo_d6;

public class thamchieu {
	public static void m(int x) {
		x += 5;
		System.out.println("x trong m = " + x);
	}
	
	public static void m(int x[]) {
		x[0] += 5;
		System.out.println("x trong m = " + x[0]);
	}
	
	public static void m(String s) {
		s = s + "1";
		System.out.println("s trong m = " + s);
	}
	public static void m(StringBuilder s) {
		s.append("1");
		System.out.println("sB trong m = " + s);
	}
	public static void main(String[] args) {
		int x = 3;
		m(x);
		System.out.println("x ngoai m = " + x);
		
		int[] X = new int [2];
		X[0] = 3;
		m(x);
		System.out.println("X ngoai m = "+ X[0]);
		String s = new String("Hello");
		m(s);
		System.out.println("s trong m = "+ s);
		
		StringBuilder sB = new StringBuilder("Hello");
		m(sB);
		System.out.println("sB trong m = " + sB);
		
		A a = new A();
		a.s = "Hello";
		m(a);
		System.out.println(a.s);
		
	}
	public static void m(A a) {
		a.s = a.s + "1";
	}
	static class A {
		String s;
	}
}
