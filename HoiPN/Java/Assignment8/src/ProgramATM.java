import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProgramATM {
	public ProgramATM() {
		
	}
	
	public void login(String id,String maPin) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("TheTu.dat");
			br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!=null) {
				if(id.equals(line.split(",")[0]) && maPin.equals(line.split(",")[1])) {
					File file  = new File(line.split(",")[0]+".dat");
					if(file.exists()) {
						System.out.println("Đăng nhập thành công.");
					}else {
						System.out.println("Sai mã Pin.");
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Không tìm thấy file.");
		} catch(Exception e) {
			System.out.println("Không đọc được.");
		}finally {
			fr.close();
			br.close();
		}
		
	}
	
	public void wthdrawal(String id,double moneyWthdrawal) {
		
	}
	
	public void display(String id) {
		
	}
	
	public void log() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
