package java_day9_OOPNangCao;

public class MyClass {
	static int x =100;
	static {
		x+=100;
	}
	static  void method(){
		x += 200;
	}
	public static void main(String[] args) {
		MyClass o = new MyClass();
		o.x += 300;
		MyClass.x += 500;
		MyClass.method();
		System.out.println(MyClass.x);
		
	}


}
