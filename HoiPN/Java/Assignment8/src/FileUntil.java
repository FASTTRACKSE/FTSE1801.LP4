import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUntil {
	public static void readFile(String fileName,Callback callback) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!=null) {
				callback.doSomething1(line);
			}
		}catch(FileNotFoundException e) {
			System.out.println("Không tìm thấy file");
		}catch(IOException e) {
			System.out.println("Đọc bị lỗi");
		}finally {
			try {
				br.close();
			}catch(IOException e) {
				System.out.println("Đóng file bị lỗi");
			}
		}
	}
	
	
	public static void writeFile(String fileName, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(fileName));
			fw.write(content);
		}catch(FileNotFoundException e) {
			System.out.println("không tìm thấy file");
		}catch(IOException e) {
			System.out.println("Ghi bị lỗi");
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				System.out.println("Đóng bị lỗi");
			}
		}
	}

	static public interface Callback {
		void doSomething1(String line);
	}
	
	
	public static void main(String[] args) {
		String id = "12345678900000";
		
		readFile(id+".dat", new Callback(){
			public void doSomething1(String line) {
				System.out.println(line);
			}

		});
		
		readFile("TheTu.dat",new Callback() {
			String newPin =  "345612";
			String content ="";
			@Override
			public void doSomething1(String line) {
				
				String arg[] = line.split(",");
				if(arg[0].equals(id)) {
					line = arg[0]+newPin +"\n";
				}
				content += line +"\n";
			}
			
			public void doSomething(String line) {
				writeFile("TheTu.dat", content);
			}	
		});
	}
}