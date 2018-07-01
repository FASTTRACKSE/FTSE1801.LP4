package lap7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai2And3 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutStream = new FileOutputStream("NhanVien.txt");
		DataOutputStream dos = new DataOutputStream(fileOutStream);
		
		dos.writeUTF("Phạm Ngọc Hợi, phamngochoi010695@gmail.com, 01123456723, 987654321");
		dos.close();
		fileOutStream.close();
		
		FileInputStream fileInputStream = new FileInputStream("NhanVien.txt");
		DataInputStream dis = new DataInputStream(fileInputStream);
		
		System.out.print(dis.readUTF());
		dis.close();
		fileInputStream.close();
	}
}
