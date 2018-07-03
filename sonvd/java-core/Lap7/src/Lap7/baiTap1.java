package Lap7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class baiTap1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.txt");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		dataOutputStream.writeUTF("Phương pêlê , abc@gmail.com , 0123456789 , 201678507");
		dataOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("nhanvien.txt");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);

		System.out.println(dataInputStream.readUTF());
		dataInputStream.close();
		fileInputStream.close();

		FileOutputStream fos = new FileOutputStream("nhanvien.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		nhanvien[] nhanvien = { new nhanvien("abc", "abc@gmail.com", "0123456789", "123456789"),
				new nhanvien("bca", "bca@gmail.com", "0112456789", "145456789"),
				new nhanvien("cba", "cba@gmail.com", "0653456789", "1687456789") };

		oos.writeObject(nhanvien);

		oos.close();
		fos.close();

		FileInputStream fileInputStream2 = new FileInputStream("nhanvien.bin");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream2);

		nhanvien[] nhanviens = (nhanvien[]) objectInputStream.readObject();
		System.out.println();
		for (nhanvien nv : nhanviens) {
			nv.output();
		}

		objectInputStream.close();
		fileInputStream.close();
	}
}
