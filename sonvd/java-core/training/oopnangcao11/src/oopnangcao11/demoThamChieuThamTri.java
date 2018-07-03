package oopnangcao11;

public class demoThamChieuThamTri {
	public static void m(int x) {
		x+=5;
		System.out.println("x trong m = " +x);
	}
	
	public static void m(int x[]) {
		//x = new int[2];
		x[0] +=5;
		System.out.println("x trong m = " +x[0]);
	}
	
	public static void m(String s) {
		s = s+"1";
		System.out.println("s trong m = " +s);
	}
	
	public static void m(StringBuilder s) {
//		s = new StringBuilder("Hello");
		s.append("1");
		System.out.println("sB trong m = "+s);
	}
	
	public static void main(String[] args) {
		int x = 3;
		m(x);
		System.out.println("x ngo�i m = " +x);
		
		int[] X = new int[2];
		X[0] = 3;
		m(X);
		System.out.println("X  ngo�i m = " +X[0]);
		
		String s = new String ("Hello");
		m(s);
		System.out.println("s ngo�i m = " +s);
		
		StringBuilder sB = new StringBuilder("Hello");
		m(sB);
		System.out.println("sB trong m = " +sB);
		A a = new A();
		a.s = "Hello";
		m(a);
		System.out.println(a.s);
	}
	
	public static void m(A a) {
		a.s = a.s +"1";
	}
	
	static class A {
		String s;
	}
}
