import java.io.File;
import java.io.FileWriter;

public class writeToFile {
	public static void main(String[] args) {
		File fileNhanVien = new File("nhanvien2.txt");
		try {
			FileWriter out = new FileWriter(fileNhanVien);
			out.write("Huynh Khanh Hung \nhuynhkhanhhungdn@gmail.com \n0905817810 \n201568599");
			out.close();
		} catch (Exception e) {
		}
	}
}
