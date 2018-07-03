package demo6;

public class demo {
	static int x;
	static String s = "hello";
	static {
		x += 100;

	}

	public static int sum(int... x) {
		int sum = 0;
		// for(int i:x)
		// sum += i;
		// return sum;

		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}
	
	public void printX() {
		System.out.println(x);
	}
	
	public void printS(){
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		System.out.println(demo.sum(1, 2));
		System.out.println(demo.sum(1, 2, 3));
		System.out.println(demo.sum(1, 2, 3, 4, 5, 6));
		int[] x = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(demo.sum(x));
		demo demo = new demo();
		
		System.out.println(demo.x);
		System.out.println(demo.s);
		System.out.print(demo.sum(1, 2, 3));
		
		demo d1 = new demo();
		demo d2 = new demo();
		demo d3 = new demo();
		
		d1.x = 200;
		
		d1.printX();
		d2.printX();
		d3.printX();
		
		d1.printS();
		d2.printS();
		d3.printS();
		
		d2.s = "phuong";
		
		d1.printS();
		d2.printS();
		d3.printS();
		
		
		MyClass o = new MyClass(); o.X += 300;
		MyClass.X += 500;
		MyClass.method();
		System.out.println(MyClass.X);

	}

}
