package demo;

import java.util.Random;

public class Demo3 {
	static int x;
	static String s = "Hello";
	static {
		x += 100;
		System.out.println(new String("12345"));
	}

	/**
	 * 
	 * @param x
	 * @return 
	 */
	public static int sum(int... x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

	final public void printX() {
		System.out.println(x);
	}

	/**
	 * 
	 */
	public void printS() {
		System.out.println(s);
	}

	public static void main(String[] args) {
		System.out.println(Demo3.sum(1, 2));
		System.out.println(Demo3.sum(1, 2, 3));
		System.out.println(Demo3.sum(1, 2, 3, 4, 5, 6));
		int x[] = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(Demo3.sum(x));

		// Demo3 demo3 = new Demo3();
		System.out.println(Demo3.x);
		System.out.println(Demo3.s);
		System.out.println(Demo3.sum(1, 2, 3));

		Demo3 d1 = new Demo3();
		Demo3 d2 = new Demo3();
		Demo3 d3 = new Demo3();

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

		d2.s = "vkl";

		d1.printS();
		d2.printS();
		d3.printS();

		MyClass o = new MyClass();
		o.X += 300;
		MyClass.X += 500;
		MyClass.method();
		System.out.println(MyClass.X);
		
		Random rand = new Random();
		System.out.println(rand.nextInt(9));

	}

}
