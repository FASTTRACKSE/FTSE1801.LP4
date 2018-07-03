package bai1_2_3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaoFile {

	public static void main(String[] args) throws IOException {
		boolean kiemtra;
		String name=null;
		String email=null;
		String numberPhone=null;
		String numberId=null;
		
		Scanner sc = new Scanner(System.in);
		// ho ten
		do {
			System.out.println("Nhap ten");
			name = sc.nextLine();
			String patter = "([A-Z][a-z]* )+[A-Z][a-z]*";
			// String patter="([A-Za-z]* )*";
			if (name.matches(patter)) {
				System.out.println("dung ten roi");
				kiemtra = false;
			} else {
				System.out.println("sai cmnr");
				kiemtra = true;
			}
		} while (kiemtra);

		// email
		do {
			System.out.print("Nhap email: ");
			email = sc.nextLine();

			String patter1 = "\\w+@\\w+(\\.\\w+){1,2}";

			if (email.matches(patter1)) {
				System.out.println("dung email roi");
				kiemtra = false;
			} else {
				System.out.println("sai cmnr");
				kiemtra = true;
			}
		} while (kiemtra);

		// so dien thoai
		do {
			System.out.print("Nhap sdt: ");
			numberPhone = sc.nextLine();

			String patter2 = "0\\d{9,10}";

			if (numberPhone.matches(patter2)) {
				System.out.println("dung so dien thoai");
				kiemtra = false;
			} else {
				System.out.println("sai cmnr");
				kiemtra = true;
			}
		} while (kiemtra);

		// so CMND
		do {
			System.out.print("Nhap CMND: ");
			numberId = sc.nextLine();

			String patter3 = "\\d{9}";

			if (numberId.matches(patter3)) {
				System.out.println("dung so CMND roi");
				kiemtra = false;
			} else {
				System.out.println("sai cmnr");
				kiemtra = true;
			}
		} while (kiemtra);
		
		// luu du lieu vao file nhanvien.txt
		FileWriter fw = new FileWriter("nhanvien.txt");
		fw.write("Name: "+name+"\n");
		fw.write("Email: "+email+"\n");
		fw.write("Phone: "+numberPhone+"\n");
		fw.write("Id Number: "+numberId+"\n");
		System.out.println();
		fw.close();
		
		// doc file nhanvien.txt
		FileReader fr = new FileReader("nhanvien.txt");
		System.out.println("du lieu trong file nhanvien.txt");
		int d;
		while((d = fr.read()) != -1) {
			System.out.print((char) d);
		}
		fr.close();
		
		
		
	}
}
