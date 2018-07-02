package lap7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bai1_2_3 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		boolean kiemTra = true;
		String sdt = null;
		String email = null;
		String name = null;
		String cmnd = null;

		// nhap ten
		do {
			String pantter = "([A-Z][a-z]* )+([A-Z][a-z]*)";
			System.out.println("Nhap ten : ");
			name = input.nextLine();
			if (name.matches(pantter)) {
				System.out.println("chuc mung ban da nhap dung :");
				kiemTra = false;
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);

		// Nhap email
		do {
			String pantter = "\\w+@\\w+(\\.\\w+){1,2}";
			System.out.print("Nhap email : ");
			email = input.nextLine();
			if (email.matches(pantter)) {
				System.out.println("chuc mung ban da nhap dung :");
				kiemTra = false;
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);

		// Nhap so dien thoai
		do {
			String pantter = "0\\d{9,10}";
			System.out.print("Nhap sdt : ");
			sdt = input.nextLine();
			if (sdt.matches(pantter)) {
				System.out.println("chuc mung ban da nhap dung :");
				kiemTra = false;
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);

		// Nhap so cmnd
		do {
			String pantter = "\\d{3} \\d{3} \\d{3}";
			System.out.print("Nhap so cmnd : ");
			cmnd = input.nextLine();
			if (cmnd.matches(pantter)) {
				System.out.println("chuc mung ban da nhap dung :");
				kiemTra = false;
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);
		System.out.println();
		input.close();

		// Luu du lieu vao file
		FileWriter fileWriter = new FileWriter("nhavien.txt");
		fileWriter.write(name + "\n");
		fileWriter.write(email + "\n");
		fileWriter.write(sdt + "\n");
		fileWriter.write(cmnd + "\n");
		fileWriter.close();

		// Doc du lieu tu file
		FileReader fileReader = new FileReader("nhavien.txt");
		System.out.println("Doc du lieu tu file nhanvien.txt");
		System.out.println();
		int choose = fileReader.read();
		while (choose != -1) {
			System.out.print((char) choose);
			choose = fileReader.read();
		}
		fileReader.close();

	}
}
