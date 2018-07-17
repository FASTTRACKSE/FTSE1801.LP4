package common.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUntil {
	/**
	 * Doc file
	 * 
	 * @param fileName
	 * @param callBack
	 */
	public static void readFile(String fileName, CallBack callBack) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				callBack.doReadLine(line);
			}
			callBack.doDoneReadFile();
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		} catch (Exception e) {
		} finally {
			try {
				bufferedReader.close();
			} catch (Exception e) {
				System.out.println("loi roi");
			}
		}
	}

	/**
	 * Ghi file
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void writeFile(String fileName, String content) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File(fileName));
			fileWriter.write(content);
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		} catch (Exception e) {
			System.out.println("Ghi bi loi");
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Dong bi loi");
			}
		}
	}

	static public interface CallBack {
		void doReadLine(String line);
		void doDoneReadFile();
	}
}
