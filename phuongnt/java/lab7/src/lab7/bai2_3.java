package lab7;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class bai2_3 {
	//Bai 2 + bai 3:
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.txt");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		dataOutputStream.writeUTF("Nguyen Tuan Phuong, 1801@gmai.com, 0120120222, 201709224");
		dataOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("nhanvien.txt");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		System.out.println(dataInputStream.readUTF());
		dataInputStream.close();
		fileInputStream.close();
	
	//Bài 4 + 5:
		FileOutputStream File = new FileOutputStream("nhanvien.bin");
		ObjectOutputStream objec = new ObjectOutputStream(File);
		nhanvien[] nv = {new nhanvien("Nguyễn Quốc Cường Song Sy\n", "abc@gmail.com\n", "123456789\n", "098765432\n")};
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
