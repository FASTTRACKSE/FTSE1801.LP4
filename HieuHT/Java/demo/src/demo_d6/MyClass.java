package demo_d6;

public class MyClass {
	static public int X = 100;
	static {
		X += 100;
	}
	static public void method() {
		X += 200;
	}
}