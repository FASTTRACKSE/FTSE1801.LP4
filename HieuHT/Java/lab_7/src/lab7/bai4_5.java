package lab7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class bai4_5 implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String address;

	public bai4_5() {
	}

	public bai4_5(String name, int age, String address) {
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
		ArrayList<bai4_5> listNhanVien = new ArrayList<bai4_5>();
		do {
			// Nhập tên
			do {
				String pantter = "([A-Z][a-z]* )*([A-Z][a-z]*)";
				System.out.println("Nhap ten : ");
				ten = input.nextLine();
				if (ten.matches(pantter)) {
					System.out.println("Bạn đã chọn đúng.");
					kiemTra = false;
				} else {
					System.out.println("Nhập sai, mời nhập lại.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhập tuổi
			do {
				String pantter = "[1-6]\\d";
				System.out.println("Nhập tuổi : ");
				ageStr = input.nextLine();
				if (ageStr.matches(pantter)) {
					System.out.println("Bạn đã nhập đúng.");
					kiemTra = false;
					age = Integer.parseInt(ageStr);
				} else {
					System.out.println("Nhập sai, mời nhập lại.");
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhap dia chi
			do {

				System.out.println("Nhập địa chỉ : ");
				diaChi = input.nextLine();
				if (!diaChi.isEmpty()) {
					System.out.println("Bạn đã nhập đúng.");
					kiemTra = false;
				} else {
					System.out.println("Nhập sai, mời nhập lại.");
					kiemTra = true;
				}
			} while (kiemTra);

			bai4_5 nhanVien = new bai4_5(ten, age, diaChi);
			listNhanVien.add(nhanVien);

			System.out.println("Bạn có muốn nhập tiếp (1: có | 0: không)");
			tieptuc = input.nextInt();
			input.nextLine();
		} while (tieptuc == 1);
		input.close();

		// Tạo đối tượng và liên kết với nguồn dữ liệu
		FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.bin");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		// Ghi dữ liệu vào file
		objectOutputStream.writeObject(listNhanVien);

		// Dong luong du lieu
		objectOutputStream.close();
		fileOutputStream.close();

		// Tạo đối tượng và liên kết với nguồn dữ liệu
		FileInputStream fileInputStream = new FileInputStream("nhanvien.bin");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		// Doc do lieu to file
		ArrayList<bai4_5> myList = (ArrayList<bai4_5>) objectInputStream.readObject();
		for (Object s : myList) {
			System.out.println(s.toString());
		}

		// Dong luong du lieu
		objectInputStream.close();
		fileInputStream.close();
	}
}