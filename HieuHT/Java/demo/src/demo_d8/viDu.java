package demo_d8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class viDu {

	private static Scanner scanner;

	public static void main(String[] args) throws IOException {
 		// String a = " hotanhieu hunter \\t forever ";
		// System.out.println(new String(a.toUpperCase()).toLowerCase());
		// System.out.println(a.length());
		// System.out.println(a.trim().length());
		// System.out.println(a.length());
		// System.out.println(a);
		// String b = "1234 56780";
		// System.out.println(b.substring(2));
		// System.out.println(b.substring(2, 7));
		// System.out.println(b.charAt(3));
		// System.out.println(b.replaceAll("6", "7"));
		// String c = "Nguyen Van Nguyen Van";
		// String[] a1 = c.split(" ");
		// String[] a2 = c.split("Van");
		// for (String x : a1) {
		// System.out.println(x);
		// }
		// System.out.println("-------");
		// for (String x : a2) {
		// System.out.println("x");
		// }
		// String d = "ho tan hieu";
		// System.out.println(d);
		// StringBuffer stringbf = new StringBuffer();
		// Matcher m = Pattern.compile("([a-z])([a-z]*)",
		// Pattern.CASE_INSENSITIVE).matcher(d);
		// while (m.find()) {
		// m.appendReplacement(stringbf, m.group(1).toUpperCase() +
		// m.group(2).toLowerCase());
		// }
		// System.out.println(m.appendTail(stringbf).toString());
		// đổi chữ cái đầu thành in hoa
		// String ten = "doan van thanh van";
		// String[] ten1 = c.split(" ");
		// String ten2 = "";
		// for (String x : a1) {
		// ten2 += x.replace("" + x.charAt(0), ("" + x.charAt(0)).toUpperCase()) + " ";
		// }
		// System.out.println(ten2.trim());
		// // Nhập số điện thoại
		// scanner = new Scanner(System.in);
		// while (true) {
		// System.out.println("Nhập số điện thoại:");
		// String numberPhone = scanner.nextLine();
		// String pattern = "0[0-9]{9,10}";
		//
		// if (numberPhone.matches(pattern)) {
		// System.out.println("Đúng số");
		// } else {
		// System.out.println("sai số");
		// }
		// }
		// while (true) {
		// System.out.println("Nhập biển số xe:");
		// String numberPhone = scanner.nextLine();
		// String pattern = "92-[A-Z]\\d-(\\d{4}|\\d{3}.\\d{2})";
		//
		// if (numberPhone.matches(pattern)) {
		// System.out.println("Đúng số");
		// } else {
		// System.out.println("sai số");
		// }
		// }
		// Ví dụ về luồng
		// FileOutputStream fileOutputStream = new FileOutputStream("file1.dat");
		// String text = "Hunter..FA..hTh";
		// byte[] textAsBytes = text.getBytes();
		// fileOutputStream.write(textAsBytes);

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
		// tạo đối tượng luồng và liên kết với nguồn dữ liệu
		FileOutputStream fileOutputStream = new FileOutputStream("abc.dat");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

		// Thao tác dữ liệu (đọc hoặc ghi hoặc cả đọc và ghi)
		int number = 5;
		dataOutputStream.writeInt(number);
		for (int i = 0; i < number; i++)
			dataOutputStream.writeInt(i);
		dataOutputStream.writeUTF("Hunter..FA");
		dataOutputStream.writeDouble(123.34);
		// Đóng luồng
		dataOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("abc.dat");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);

		int rNumber = dataInputStream.readInt();
		for (int i = 0; i < rNumber; i++)
			System.out.print(dataInputStream.readInt());
		System.out.println(dataInputStream.readUTF());
		System.out.println(dataInputStream.readDouble());
		dataInputStream.close();
		fileInputStream.close();
	}
}
