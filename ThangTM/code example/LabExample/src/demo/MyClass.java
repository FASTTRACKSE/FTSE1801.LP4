package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyClass {
	static public int X = 100;
	static {
		X += 100;
	}

	static public void method() {
		X += 200;
	}

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		String dateInput = scanner.nextLine();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			// convert String to Date
			date = dateFormat.parse(dateInput);
			System.out.println("Date : " + date);
		} catch (ParseException e) {
			System.out.println("Khong phai dinh dang ngay thang nam");
		}

		// convert Date to String
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("String b: " + dateFormat2.format(date));

		scanner.close();*/
		
		String c = "doan van thanh van";
		String[] a1 = c.split(" ");
		String c2 = "";
		for (String x : a1) {
			c2 += x.replace("" + x.charAt(0), ("" + x.charAt(0)).toUpperCase()) + " ";
		}
		System.out.println(c2.trim());
	}
}
