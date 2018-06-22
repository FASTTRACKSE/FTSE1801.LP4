package java_day9_OOPNangCao;

public class demo {
	/*
	Nguyên thủy: tham trị:copy giá trị vào(không thay đổi);
	Đối  tượng là tham chiếu
	*/
	public static void m(int x) {
		x +=5;
		System.out.println("x trong m = " +x);
	}
	
	public static void m(int x[]) {
		// x = new int[2];
		x[0] += 5;
		System.out.println("x trong m = " + x[0]);
	}
	
	public static void m(String s) {
		s  = s + "1";
		System.out.println("x trong m = "+ s);
	}
	
	public static void m(StringBuilder s) {
		//s = new StringBuilder("Hello");
		s.append("1");
		System.out.println("sB trong m "+s);
	}
	
	public static void main(String[] args) {
		int x = 3;
		m(x);
		System.out.println("x ngoai m = " + x);
		
		int[] X= new int[2];
		X[0] = 3;
		m(X);
		System.out.println("x ngoai m = " +X[0]);
		
		String s = new String("Hello");
		m(s);
		System.out.println("x ngoai m = " +s);
		
		StringBuilder sB = new StringBuilder("Hello");
		m(sB);
		System.out.println("sB ngoai m = " +sB);
	}
}
