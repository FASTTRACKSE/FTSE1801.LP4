import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Bai3 {
	public static void main(String[] args) throws IOException {

		FileInputStream fileOutputStream1 = new FileInputStream("nhanvien.txt");
		int d;
		while ((d = fileOutputStream1.read()) != -1) {
			System.out.print((char) d);
		}
		fileOutputStream1.close();
	}
}
