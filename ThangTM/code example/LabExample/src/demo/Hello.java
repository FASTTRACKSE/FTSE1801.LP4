package demo;
import java.io.FileWriter;
import java.io.IOException;

public class Hello {

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
			throw new NullPointerException();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		Hello hello = new Hello();

		try {
			hello.viDuThrow();
		} catch (IOException e) {
			e.printStackTrace();
		}

		hello.callViDuThrow();

		hello.callViDuThrow2();

		try {
			hello.callViDuThrow3();
		} catch (NullPointerException e) {
			System.err.println("loi null pointer");
		}

		System.out.println("hahahahaha");
	}
}
