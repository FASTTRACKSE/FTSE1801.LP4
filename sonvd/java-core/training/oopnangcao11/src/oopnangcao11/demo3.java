package oopnangcao11;

public class demo3 {

	static int X;
	static String s = "Hello";

	static {
		X += 100;
	}

	public int sum(int... x) {
		int sum = 0;
		// for (int i : x)
		// sum += i;

		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

	public void printfX() {
		System.out.println(X);
	}

	public static void main(String[] args) {
		System.out.println(new demo3().sum(1, 2));
		System.out.println(new demo3().sum(1, 2, 3));
		System.out.println(new demo3().sum(1, 2, 3, 4, 5, 6));

		int x[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		System.out.println(new demo3().sum(x));

		demo3 Demo3 = new demo3();
		System.out.println(demo3.X);
		System.out.println(demo3.s);

		demo3 d1 = new demo3();
		demo3 d2 = new demo3();
		demo3 d3 = new demo3();

		d1.printfX();
		d2.printfX();
		d3.printfX();

		d1.X = 300;

		d1.printfX();
		d2.printfX();
		d3.printfX();

		MyClass o = new MyClass();
		o.X += 300;
		MyClass.X += 500;
		MyClass.method();
		System.out.println(MyClass.X);

	}
}
