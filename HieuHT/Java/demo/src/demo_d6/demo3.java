package demo_d6;

public class demo3 {
	static int x;
	static String s = "Hello";
	
	static {
		x += 100;
	}

	public static int sum(int ...x) {
		int sum = 0;
		for(int i = 0; i<x.length; i++) {
			sum += x[i];
		}
		return sum;
	}
	public void printX() {
		System.out.println(x);
	}
	public void printS() {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		System.out.println(demo3.sum(1,2));
		System.out.println(demo3.sum(1,2,3));
		System.out.println(demo3.sum(1,2,3,4,5,6));
		int x[] = new int[] {1,2,3,4,5,6};
		System.out.println(new demo3().sum(x));

		demo3 demo3 = new demo3();
		System.out.println(demo3.x);
		System.out.println(demo3.s);
		System.out.println(demo3.sum(1,2,3));
		
		demo3 d1 = new demo3();
		demo3 d2 = new demo3();
		demo3 d3 = new demo3();
		
		d1.printX();
		d2.printX();
		d3.printX();
		
		d1.x = 200;
		
		d1.printX();
		d2.printX();
		d3.printX();
		
		d1.printS();
		d2.printS();
		d3.printS();
		
		d2.s = "Hi";
		
		d1.printS();
		d2.printS();
		d3.printS();
		
		MyClass o = new MyClass();
		o.X += 300;
		MyClass.X += 500; MyClass.method();
		System.out.println(MyClass.X);
	}
}
