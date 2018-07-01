package demo.demo;



import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Nhap b:");
			int b = sc.nextInt();
			int a = 1 / b;
			int[] c = new int[1];
			c[0] = a;
			System.out.println("Hello COngMT1.");
			System.out.println("Hello COngMT2.");
			System.out.println("Hello COngMT3.");
			String aa=null;
			aa.toString();
			System.out.println("Hello COngMT4.");
		} catch (ArithmeticException e) {
			System.out.println("Khong the chia het cho 0.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Vuot qua kich thuoc cua mang.");
		}finally {
			System.out.println("thanh cong.");
			sc.close();
		}
		System.out.println("Hello COngMT.");
	}
	
}
