package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bai3 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("NhanVien1.txt");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		dataOutputStream.writeUTF("Hồ Tấn Hiệu\ntanhieu@gmail.com\n01672185517\n1234567890");
		dataOutputStream.close();
		fileOutputStream.close();
		
		FileInputStream fileInputStream = new FileInputStream("NhanVien1.txt");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		System.out.println(dataInputStream.readUTF());
		dataInputStream.close();
		fileInputStream.close();
	}
}
