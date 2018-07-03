import java.io.File;
import java.io.FileReader;

public class readFromFile {
	public static void main(String[] args) {
		File fileNhanVien = new File("nhanvien2.txt");
		try {
			FileReader input = new FileReader(fileNhanVien);
			System.out.println("Đọc từ file nhanvien2.txt và in ra màn hình:\n");
			int ch = input.read();
			while (ch != -1) {
				System.out.print((char) ch);
				ch = input.read();
			}
		} catch (Exception e) {
			
		}
	}
}
