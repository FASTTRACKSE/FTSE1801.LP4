package demo_d7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class vidu_throw {
	public void viDuThrow() throws IOException {
		FileWriter fileWriter = new FileWriter("data.txt");
		fileWriter.write("Xin chao");
		fileWriter.close();
	}

	public void calViDuThrow() {
		try {
			viDuThrow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void calViDuThrow2() throws IOException {
		viDuThrow();
	}

	public void calViDuThrow3() {
		try {
			viDuThrow();
			throw new NullPointerException();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		vidu_throw hello = new vidu_throw();
		hello.calViDuThrow();
		try {
			hello.viDuThrow();
		} catch (IOException e) {
			e.printStackTrace();
		}
		hello.calViDuThrow2();

		try {
			hello.calViDuThrow3();
		} catch (NullPointerException e) {
			System.out.println("loi null pointer");
		}

		System.out.println("Fuck You");
	}
}