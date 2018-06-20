/**
 * Assignment 1
 * @author Phạm Ngọc Hợi
 *
 */
public class bai2 {
	public static void main(String[] args) {
		//Cho 2 số a, b
		int x = -9;
		int y = 15;
		double z = Math.random();
		//Tìm min, max
		System.out.println("Math.max(" + x + "," + y + ")=" + Math.max(x, y));
		System.out.println("Math.min(" + x + "," + y + ")=" + Math.min(x, y));
		System.out.println("Math.sqrt(" + x + ")=" + Math.sqrt(x));
		System.out.println("Math.abs(" + x + ")=" + Math.abs(x));
		System.out.println("Math.tanh(" + x + ")=" + Math.tanh(x));
		System.out.println("Math.tan(" + x + ")=" + Math.tan(x));
		System.out.println("sinh(" + x + ")=" + Math.sinh(x));
		System.out.println("Math.sin(" + x + ")=" + Math.sin(x));
		System.out.println("Math.round(" + x + ")=" + Math.round(x));
		System.out.println("Math.rint(" + x + ")=" + Math.rint(x));
		System.out.println("Random number 1:" + z);
		System.out.println("Math.pow(" + x + "," + y + ")=" + Math.pow(x, y));
	}

}
