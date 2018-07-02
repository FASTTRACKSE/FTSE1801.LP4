package lap7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 * 
 * @author Ngọc Thiên
 *
 */
public class FileWrite {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/**
		 * bài 1
		 */
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * bài 2 + bài 3
		 */
		FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.txt");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		dataOutputStream.writeUTF("1 Quốc Cường\n2 abc@gmail.com\n3 0905059064\n4 205723511\n");
		dataOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("nhanvien.txt");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		System.out.println(dataInputStream.readUTF());
		dataInputStream.close();
		fileInputStream.close();

		/**
		 * bài 4 + bài 5
		 */
		FileOutputStream File = new FileOutputStream("nhanvien.bin");
		ObjectOutputStream objec = new ObjectOutputStream(File);
		nhanvien[] nv = {new nhanvien("Võ Chí Công\n", "abc@gmail.com\n", "123456789\n", "098765432\n"),
				new nhanvien("Võ Chí Công\n", "abc@gmail.com\n", "123456789\n", "098765432\n")};
		objec.writeObject(nv);
		/**
		 * đóng luồng
		 */
		objec.close();
		File.close();
		
		FileInputStream file = null;
		ObjectInputStream oos = null;
		
			file = new FileInputStream("nhanvien.bin");
			oos = new ObjectInputStream(file);
			nhanvien[] nv1 = (nhanvien[]) oos.readObject();
			
			for (nhanvien s : nv1) {
				s.xuat();
			}
			
			oos.close();
			file.close();
		
	}
}
