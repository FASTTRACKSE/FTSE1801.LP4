import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public static void readFile(String fileName, Callback callback) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(new File("TheTu.dat"));
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				callback.doSomeThing(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Doc bi loi");
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("Dong bi file");
			}
		}
	}

	public static void writeFile(String fileName, String content) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.write(content);
		} catch (FileNotFoundException e) {
			System.out.println(" Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Ghi file bi loi");
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Dong bi loi");
			}
		}
	}

	static public interface Callback {
		void doSomeThing(String line);
	}
}
