import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class demo {
	
	public void viDuThrow() throws IOException {
		FileWriter fileWriter = new FileWriter("data.txt");
		fileWriter.write("Xin chào thế giới");
		fileWriter.close();
	}
	
	public void callViDuThrow() {
		try {
			viDuThrow();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void callViDuThrow2() throws IOException {
		viDuThrow();
	}
	
	public void callViDuThrow3() {
		try {
			viDuThrow();
			throw new NullPointerException();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		demo demo = new demo();
		
		try {
			demo.viDuThrow();
		}catch(IOException e) {
			e.printStackTrace();
		}
		

		demo.callViDuThrow();

		try {
			demo.callViDuThrow2();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			demo.callViDuThrow3();
		} catch (NullPointerException e) {
			System.err.println("loi null pointer");
		}

		System.out.println("hahahahaha");
		/*
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Nhập a: ");
			int a = sc.nextInt();
			System.out.println("Nhập b: ");
			int b = sc.nextInt();
			int c= a/b;
			System.out.println(c);
		}catch(InputMismatchException e) {
			System.out.println("Giá trị nhập vào phải là số nguyên");
		}catch(ArithmeticException er) {
			System.out.println("Giá trị b phải khác 0");
		}finally {
			System.out.println("close");
			sc.close();
		}
		*/
		
	}
}
