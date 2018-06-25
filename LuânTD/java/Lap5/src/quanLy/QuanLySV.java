package quanLy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sinhVien.SinhVien;
import sinhVien.Sort;

public class QuanLySV {

	private ArrayList<SinhVien> listSV;

	public QuanLySV() {
		listSV = new ArrayList<SinhVien>();
	}

	// them sinh vien
	public void addSV(SinhVien SV) {
		listSV.add(SV);
	}

	// hien thi danh sach ngau nhien
	public void random() {
		Collections.shuffle(listSV);
		System.out.printf("%-5s %-20s %-20s %-6s", "ID", "Họ", "Tên", "Tuổi");
		System.out.println();
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("\n %-5s %-20s %-20s %-6s", (i + 1), listSV.get(i).getFistName(),
					listSV.get(i).getLastName(), listSV.get(i).getAge());
		}
		System.out.println();
		System.out.println();
	}

	// xoa sinh vien
	public void delSV(String name) {
		Object person = null;
		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getLastName().equals(name)) {
				person = listSV.get(i);
				break;
			}
		}
		if (person != null) {
			listSV.remove(person);
		} else {
			System.out.println("Nhap sai chuc nang");
		}

	}

	// Hiển thị sinh viên
	public void show() {
		System.out.printf("%-5s %-20s %-20s %-6s", "ID", "Họ", "Tên", "Tuổi");
		System.out.println();
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("\n %-5s %-20s %-20s %-6s", (i + 1), listSV.get(i).getFistName(),
					listSV.get(i).getLastName(), listSV.get(i).getAge());
		}
		System.out.println();
		System.out.println();
	}
	// Sắp xếp sinh viên theo tên từ a-z

	public void sort() {
		Collections.sort(listSV, new Sort());

	}

	public static void main(String[] args) {
		int tt, luaChon;
		QuanLySV quanly = new QuanLySV();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Nhập danh sách sinh viên.");
			System.out.println("2. Hiển thị danh sách sinh viên .");
			System.out.println("3. Xuất danh sách sinh viên ngẫu nhiên  .");
			System.out.println("4. Sắp sếp sinh viên theo giảm dần .");
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
					quanly.addSV(sv);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);
				break;

			case 2:
				quanly.show();
				break;

			case 3:
				quanly.random();
				break;

			case 4:
				quanly.sort();
				quanly.show();
				break;

			case 5:
				System.out.print("Nhập tên cần xóa : ");
				input.nextLine();
				String ten = input.nextLine();
				quanly.delSV(ten);
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
