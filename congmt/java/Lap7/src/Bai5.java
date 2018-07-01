import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Bai5 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = null;
		ObjectInputStream object = null;
		
		fileInputStream = new FileInputStream("nhanvien.bin");
		object = new ObjectInputStream(fileInputStream);
		Nhanvien[] nhanvien = (Nhanvien[]) object.readObject();
		System.out.println(" Doc tu file");
		for (Nhanvien s : nhanvien) {
			System.out.println(s);
		}
		// Dong luong du lieu
		object.close();
		fileInputStream.close();
	}
}
