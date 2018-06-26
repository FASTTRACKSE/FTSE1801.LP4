package quanLy;

import java.util.Scanner;

import mangSinhVien.mangSinhVien;

public class QuanLySV {

	// danh sach sinh vien
	private mangSinhVien[] listSinhVien;
	public static int id;

	public QuanLySV() {
		listSinhVien = new mangSinhVien[100];
		id = 0;
	}

	// sắp xếp sinh viên theo điểm
	public void SortSV() {
		mangSinhVien SortSv = new mangSinhVien();
		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSinhVien[i].getGpa() > listSinhVien[j].getGpa()) {
					SortSv = listSinhVien[i];
					listSinhVien[i] = listSinhVien[j];
					listSinhVien[j] = SortSv;
				}
			}
		}

	}

	// mang sinh vien
	public void addSV(mangSinhVien sinhVien) {
		listSinhVien[id] = sinhVien;
		id++;
	}

	// xep loai
	public void xepLoai() {
		for (int i = 0; i < id; i++) {

			if (listSinhVien[i].getGpa() < 5) {
				listSinhVien[i].setType("Yếu");
			} else if (listSinhVien[i].getGpa() < 7.5) {
				listSinhVien[i].setType("Trung bình");
			} else if (listSinhVien[i].getGpa() < 8.5) {
				listSinhVien[i].setType("Khá");
			} else {
				listSinhVien[i].setType("Giỏi");
			}

		}
	}

	// Sinh vien co hoc luc gioi
	public void gioi() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s %10s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB", "Xếp loại");
		System.out.println();
		for (int i = 0; i < id; i++) {
			if (listSinhVien[i].getType().equals("Giỏi")) {
				System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f %10s", (i + 1), listSinhVien[i].getName(),
						listSinhVien[i].getAge(), listSinhVien[i].getAdd(), listSinhVien[i].getGpa(),
						listSinhVien[i].getType());
				System.out.println();
			}
		}
	}

	// hiển thị sinh vien
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s %10s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB", "Xếp loại");
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f %10s", (i + 1), listSinhVien[i].getName(),
					listSinhVien[i].getAge(), listSinhVien[i].getAdd(), listSinhVien[i].getGpa(),
					listSinhVien[i].getType());
		}
		System.out.println();
		System.out.println();
	}

	// menu
	public static void main(String[] args) {

		int tt, luaChon;
		QuanLySV quanly = new QuanLySV();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Nhập danh sách sinh viên.");
			System.out.println("2. Hiển thị danh sách sinh viên .");
			System.out.println("3. Xuất danh sách sinh viên có học lực giỏi  .");
			System.out.println("4. Sắp sếp sinh viên theo điểm .");
			System.out.println("5. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					mangSinhVien msv = new mangSinhVien();

					input.nextLine();
					System.out.print("Nhập tên SV : ");
					String name = input.nextLine();

					System.out.print("Nhập tuổi : ");
					int age = input.nextInt();

					input.nextLine();
					System.out.print("Nhập địa chỉ : ");
					String address = input.nextLine();

					System.out.print("Nhập điểm trung bình : ");
					double gpa = input.nextDouble();

					msv.setName(name);
					msv.setAge(age);
					msv.setAdd(address);
					msv.setGpa(gpa);
					quanly.addSV(msv);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);
				quanly.xepLoai();
				break;

			case 2:
				quanly.show();
				break;

			case 3:
				quanly.gioi();
				break;

			case 4:

				quanly.SortSV();
				quanly.show();
				break;

			case 5:
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
