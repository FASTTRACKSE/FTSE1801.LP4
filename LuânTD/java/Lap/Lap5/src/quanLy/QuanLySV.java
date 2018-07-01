package quanLy;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

import sinhVien.SinhVien;
import sinhVien.SortSinhVienByNameFromZToA;

/**
 * 
 * @author luan
 *
 */
public class QuanLySV {

	private ArrayList<SinhVien> listSinhVien;

	public QuanLySV() {
		listSinhVien = new ArrayList<SinhVien>();
	}

	/**
	 * them sinh vien vao danh sach
	 * 
	 * @param SV	Sinh vien
	 *            
	 */
	public void addSinhVien(SinhVien SV) {
		listSinhVien.add(SV);
	}

	/**
	 * hien thi danh sach ngau nhien
	 */
	public void random() {
		Collections.shuffle(listSinhVien);
	}

	/**
	 * xoa sinh vien
	 * 
	 * @param name 	ten Sinh Vien
	 *            
	 */
	public void delSinhVienByName(String name) {
		SinhVien person = null;
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getLastName().equals(name)) {
				person = listSinhVien.get(i);
				break;
			}
		}
		if (person != null) {
			listSinhVien.remove(person);
		} else {
			System.out.println("Nhap sai chuc nang");
		}

	}

	/**
	 * Hien thị danh sach sinh vien
	 */
	public void show() {
		System.out.printf("%-5s %-20s %-20s %-6s", "ID", "Họ", "Tên", "Tuổi");
		System.out.println();
		for (int i = 0; i < listSinhVien.size(); i++) {
			System.out.printf("\n %-5s %-20s %-20s %-6s", (i + 1), listSinhVien.get(i).getFistName(),
					listSinhVien.get(i).getLastName(), listSinhVien.get(i).getAge());
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * sap xep danh sach sinh vien tu Z-A
	 */

	public void sort() {
		Collections.sort(listSinhVien, new SortSinhVienByNameFromZToA());

	}

	public static void main(String[] args) {
		int tiepTuc, luaChon;
		QuanLySV quanly = new QuanLySV();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Nhập danh sách sinh viên.");
			System.out.println("2. Hiển thị danh sách sinh viên .");
			System.out.println("3. Xuất danh sách sinh viên ngẫu nhiên  .");
			System.out.println("4. Sắp sếp sinh viên theo tên từ Z-A .");
			System.out.println("5. Tìm và xóa họ tên sinh viên nhập từ bàn phím .");
			System.out.println("6. Kết thúc chương trình  .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {

					input.nextLine();
					System.out.print("Nhập họ SV : ");
					String fistname = input.nextLine();

					System.out.print("Nhập tên SV : ");
					String lastname = input.nextLine();

					System.out.print("Nhập tuổi SV : ");
					int age = input.nextInt();

					SinhVien sv = new SinhVien(fistname, lastname, age);
					quanly.addSinhVien(sv);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tiepTuc = input.nextInt();
					System.out.println();
				} while (tiepTuc == 1);
				break;

			case 2:
				quanly.show();
				break;

			case 3:
				quanly.random();
				quanly.show();
				break;

			case 4:
				quanly.sort();
				quanly.show();
				break;

			case 5:
				System.out.print("Nhập tên cần xóa : ");
				input.nextLine();
				String ten = input.nextLine();
				quanly.delSinhVienByName(ten);
				quanly.show();
				break;

			case 6:
				input.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
		}

	}

}
