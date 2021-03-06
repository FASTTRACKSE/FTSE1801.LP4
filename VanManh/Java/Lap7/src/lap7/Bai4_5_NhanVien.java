package lap7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai4_5_NhanVien implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private String address;

	public Bai4_5_NhanVien() {
	}

	public Bai4_5_NhanVien(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String toString() {
		return (name + " " + age + " " + address);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		String ten = null;
		String ageStr = null;
		int age = 0;
		String diaChi = null;
		boolean kiemTra;
		int tieptuc;
		ArrayList<Bai4_5_NhanVien> listNhanVien = new ArrayList<Bai4_5_NhanVien>();
		do {
			// Nhap ten
			do {
				String pantter = "([A-Z][a-z]* )*([A-Z][a-z]*)";
				System.out.println("Nhap ten : ");
				ten = input.nextLine();
				if (ten.matches(pantter)) {
					System.out.println("chuc mung ban da nhap dung.");
					kiemTra = false;
				} else {
					System.out.println("Nhap sai cmnr, nhap lai.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhap tuoi
			do {
				String pantter = "[1-6]\\d";
				System.out.println("Nhap tuoi : ");
				ageStr = input.nextLine();
				if (ageStr.matches(pantter)) {
					System.out.println("chuc mung ban da nhap dung.");
					kiemTra = false;
					age = Integer.parseInt(ageStr);
				} else {
					System.out.println("Nhap sai cmnr, nhap lai.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhap dia chi
			do {

				System.out.println("Nhap dia chi : ");
				diaChi = input.nextLine();
				if (!diaChi.isEmpty()) {
					System.out.println("chuc mung ban da nhap dung.");
					kiemTra = false;
				} else {
					System.out.println("Nhap sai cmnr, nhap lai.");
					kiemTra = true;
				}
			} while (kiemTra);

			Bai4_5_NhanVien nhanVien = new Bai4_5_NhanVien(ten, age, diaChi);
			listNhanVien.add(nhanVien);

			System.out.println("Ban co muon nhap tiep (1: co | 0: khong)");
			tieptuc = input.nextInt();
			input.nextLine();
		} while (tieptuc == 1);
		input.close();

		// Tao doi tuong va lien ket voi nguon du lieu
		FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.bin");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		// Ghi du lieu vao file
		objectOutputStream.writeObject(listNhanVien);

		// Dong luong du lieu
		objectOutputStream.close();
		fileOutputStream.close();

		// Tao doi tuong va lien ket voi nguon du lieu
		FileInputStream fileInputStream = new FileInputStream("nhanvien.bin");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		// Doc du lieu tu file
		ArrayList<Bai4_5_NhanVien> myList = (ArrayList) objectInputStream.readObject();
		for (Object s : myList) {
			System.out.println(s.toString());
		}

		// Dong luong du lieu
		objectInputStream.close();
		fileInputStream.close();
	}
}
