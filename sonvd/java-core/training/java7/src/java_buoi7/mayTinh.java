package java_buoi7;
// Ví dụ về overloat

public class mayTinh {
	int  sum(int a, int b) {
		return a+b;
	};
	int sum(int a,int b,int c) {
		return a+b+c;
	}
	public static void main(String[] args) {
		mayTinh mt = new mayTinh();
		System.out.println("Tổng a+b = " + mt.sum(1, 2));
		System.out.println("Tổng a+b+c = " + mt.sum(1, 2,3));
	}
}
