package demo;

import java.io.FileWriter;
import java.io.IOException;

public class ExampleException {

	public void viDuThrow() throws IOException {
		FileWriter fileWriter = new FileWriter("data.txt");
		fileWriter.write("xin chao the gioi");
		fileWriter.close();
	}

	public void callViDuThrow() {
		try {
			viDuThrow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void callViDuThrow2() throws IOException {
		viDuThrow();
	}

	public void callViDuThrow3() {
		try {
			viDuThrow();
			throw new IOException();
		} catch (IOException e) {
			System.out.println("da bat lai ngoai le cua chinh no tao ra");
			throw new NullPointerException();
		}
	}

	public static void main(String[] args) throws IOException {

		ExampleException hello = new ExampleException();

		try {
			hello.viDuThrow();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		hello.callViDuThrow();

		try {
			hello.callViDuThrow2();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			hello.callViDuThrow3();
		} catch (NullPointerException e) {
			System.out.println("loi null");
		}

		System.out.println("hahahahaha");
	}
}
