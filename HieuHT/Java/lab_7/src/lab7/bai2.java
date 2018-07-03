package lab7;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class bai2 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("NhanVien.txt");
		String a = "Hồ Tấn Hiệu\ntanhieu@gmail.com\n01672185517\n1234567890";
		byte[] c = a.getBytes();
		fileOutputStream.write(c);
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("NhanVien.txt");
		int d;
		while ((d = fileInputStream.read()) != -1) {
			System.out.print((char) d);
		}
		fileInputStream.close();
	}
}
