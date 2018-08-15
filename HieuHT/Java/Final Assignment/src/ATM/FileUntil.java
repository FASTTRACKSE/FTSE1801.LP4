package ATM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUntil {
	
	public static void readFile(String fileName, Callback callback) throws IOException {
		FileReader fd = null;
		BufferedReader bf= null;
		try {
			fd = new FileReader(new File(fileName));
			bf = new BufferedReader(fd);
			String line;
			while ((line = bf.readLine())!= null) {
				callback.doSomething(line);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Không tìm thấy file");
		} catch(IOException e) {
			System.out.println("Đọc bị lỗi");
		} finally {
			try {
				bf.close();
			} catch(IOException e) {
				System.out.println("Dong bi file");
			}
		}
	}
	
	public static void writeFile(String fileName, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(fileName));
			fw.write(content);
		} catch (FileNotFoundException e) {
			System.out.println("Không tìm thấy file");
		} catch (IOException e) {
			System.out.println("Ghi bị lỗi");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("Đóng bị lỗi");
			}
		}
	}
	static public interface Callback{
		void doSomething(String line);
	}
}
