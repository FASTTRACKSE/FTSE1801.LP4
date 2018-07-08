  package lap7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Bai4And5 {
	public static void main(String[] args) throws Exception, ClassNotFoundException{
		FileOutputStream fos = new FileOutputStream("MangNhanVien.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Stock[] stock = {
				new Stock("Phạm Ngọc Hợi", "a@gmail.com", 1234567890, 987654321),
				new Stock("Phạm Ngọc", "b@gmail.com", 1234567890, 987654321),
				new Stock("Phạm", "c@gmail.com", 1234567890, 987654321),
		};
		oos.writeObject(stock);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("MangNhanVien.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Stock[] stock1 = (Stock[]) ois.readObject();
		for(Stock s:stock1) {
			System.out.println(s);
		}
		
		ois.close();
		fis.close();
	}
}
