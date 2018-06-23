package java_day9_OOPNangCao;

public class demo2 {
	static int x;
	static String s = "Hello";
	
	static {
		x += 100;
	}
	
	public int sum(int...x) {
		int sum = 0;
		for(int i : x)
			sum +=i;
		return sum;
		
//		for(int i = 0;i<x.length;i++) {
//			sum += x[i];
//			return sum;
//		}
	}
	
	public static int sum2(int...x) {
		int sum = 0;
		for(int i : x)
			sum +=i;
		return sum;
	}
	
	public void printx() {
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		System.out.println(new demo2().sum(1,2,3));
		System.out.println(new demo2().sum(1,2,3,7,3));
		System.out.println(new demo2().sum(1,2,3,4,5,7,8));
		
//		int x[] = new int[] {1,2,3,4,5,7,8};
//		System.out.println(new demo2().sum(x));
		
		System.out.println(demo2.x);
		System.out.println(demo2.s);
		System.out.println(demo2.sum2(1,2,3));
		
		demo2 d1 = new demo2();
		demo2 d2 = new demo2();
		demo2 d3 = new demo2();
		
		d1.printx();
		d2.printx();
		d3.printx();
		
		d1.x = 200;
		
		d1.printx();
		d2.printx();
		d3.printx();
		
	}
}
