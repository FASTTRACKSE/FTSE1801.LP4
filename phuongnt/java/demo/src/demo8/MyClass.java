package demo8;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {
	public static void main(String[] args) throws IOException {
		// String a = " nguyen tuan phuong \t ho tan hieu ";
		// System.out.println(new String(a.toUpperCase()).toLowerCase());
		// System.out.println(a.length());
		// System.out.println(a.trim().length());
		// System.out.println(a.length());
		// System.out.println(a);
		// String b = "12345 67890";
		// System.out.println(b.substring(2));
		// System.out.println(b.substring(2, 7));
		// System.out.println(b.charAt(3));
		// System.out.println(b.replaceAll("5", "7"));
		// String c = "nguyen tuan phuong";
		// String[] a1 = c.split(" ");
		// String[] a2 = c.split("");
		// for(String x:a1) {
		// System.out.println(x);
		// }
		// System.out.println("----------");
		// for(String x:a2) {
		// System.out.println(x);
		// }
		// String d = "pham trung hai";
		// System.out.println(d);
		// StringBuffer stringbf = new StringBuffer();
		// Matcher m = Pattern.compile("([a-z])([a-z]*)",
		// Pattern.CASE_INSENSITIVE).matcher(d);
		// while (m.find()) {
		// m.appendReplacement(stringbf,
		// m.group(1).toUpperCase() + m.group(2).toLowerCase());
		// }
		// System.out.println(m.appendTail(stringbf).toString());
		//
		//
		// String ten = "doan van thanh van";
		// String[] ten1 = c.split(" ");
		// String ten2 = "";
		// for (String x : a1) {
		// ten2 += x.replace("" + x.charAt(0), ("" + x.charAt(0)).toUpperCase()) + " ";
		// }
		// System.out.println(ten2.trim());

		Scanner scanner = new Scanner(System.in);

		// while (true) {
		// System.out.println("Nhập số điện thoại: ");
		// String numberPhone = scanner.nextLine();
		// String pattern = "0[0-9]{9,10}";
		// if (numberPhone.matches(pattern)) {
		// System.out.println("Đúng số điện thoại");
		// } else {
		// System.out.println("Sai số điện thoại");
		// }
		// }

		// while (true) {
		// System.out.println("Nhập biển số xe: ");
		// String numberPhone = scanner.nextLine();
		// String pattern = "43-[A-Z]\\d-(\\d{4}|\\d{3}.\\d{2})";
		// if (numberPhone.matches(pattern)) {
		// System.out.println("Đúng biển số xe");
		// } else {
		// System.out.println("Sai biển số xe");
		// }
		// }

		// FileOutputStream fos = new FileOutputStream("file1.dat");
		// String text = "Hunter..FA..hTh";
		// byte[] textAsBytes = text.getBytes();
		// fos.write(textAsBytes);

		// FileOutputStream fileOutputStream = new FileOutputStream("abc.dat");
		// String a = "Hunter.FA..hTh";
		// byte[] c = a.getBytes();
		// fileOutputStream.write(c);
		// fileOutputStream.close();
		//
		// FileInputStream fileInputStream = new FileInputStream("abc.dat");
		// int d;
		// while ((d = fileInputStream.read()) != -1) {
		// System.out.print((char) d);
		// }
		// fileInputStream.close();

		FileOutputStream fileOutputStream = new FileOutputStream("file1.dat");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		int number = 5;
		dataOutputStream.writeInt(number);
		for (int i = 0; i < number; i++)
			dataOutputStream.writeInt(i);
		dataOutputStream.writeUTF("dep trai");
		dataOutputStream.writeDouble(123.34);
		dataOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("file1.dat");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);

		int rNumber = dataInputStream.readInt();
		System.out.println(rNumber);
		for (int i = 0; i < rNumber; i++)
			System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readUTF());
		System.out.println(dataInputStream.readDouble());
		dataInputStream.close();
		fileInputStream.close();
	}
}
