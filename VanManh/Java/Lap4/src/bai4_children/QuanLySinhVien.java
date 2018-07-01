package bai4_children;

import java.util.Scanner;

import bai4_parent.SinhVien;

public class QuanLySinhVien {
	private SinhVien[] listSV;
	private int id;

	public QuanLySinhVien() {
		listSV = new SinhVien[100];
		id = 0;
	}

	// Thêm sinh viên
	public void addSV(SinhVien SV) {
		listSV[id] = SV;
		id += 1;
	}

	// Xét học lực cho sinh viên
	public void hocLuc() {
		for (int i = 0; i < id; i++) {
			if (listSV[i].getGpa() < 5) {
				listSV[i].setXepLoai("yếu");
			} else if (listSV[i].getGpa() < 6.5) {
				listSV[i].setXepLoai("Trung bình");
			} else if (listSV[i].getGpa() < 7.5) {
				listSV[i].setXepLoai("Khá");
			} else if (listSV[i].getGpa() < 9) {
				listSV[i].setXepLoai("Giỏi");
			} else {
				listSV[i].setXepLoai("Xuất sắc");
			}
		}
	}

	// hiển thị sinh viên có học lực giỏi
	public void showSvGioi() {
		for (int i = 0; i < id; i++) {
			if (listSV[i].getXepLoai().equals("Giỏi")) {
				System.out.printf("%-5s %-20s %-6s %-20s %-6s %-20s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB",
						"Xếp loại");
				System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f %-20s", (i + 1), listSV[i].getName(),
						listSV[i].getAge(), listSV[i].getAddress(), listSV[i].getGpa(), listSV[i].getXepLoai());
			}
		}
		System.out.println("Không có sinh viên nào có học lực giỏi.");
		System.out.println();
	}

	// Hiển thị sinh viên
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s %-20s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB", "Xếp loại");
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f %-20s", (i + 1), listSV[i].getName(), listSV[i].getAge(),
					listSV[i].getAddress(), listSV[i].getGpa(), listSV[i].getXepLoai());
		}
		System.out.println();
		System.out.println();
	}

	// Sắp xếp theo điểm từ thấp đến cao
	public void sapXep() {

		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSV[i].getGpa() > listSV[j].getGpa()) {
					SinhVien sapXep = listSV[i];
					listSV[i] = listSV[j];
					listSV[j] = sapXep;
				}
			}
		}

	}

	public static void main(String[] args) {
		int tt, luaChon;
		QuanLySinhVien quanLy = new QuanLySinhVien();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Hiển thị danh sách sinh viên.");
			System.out.println("3. Xuất danh sách sinh viên có học lực giỏi .");
			System.out.println("4. Sắp xếp danh sách sinh viên theo điểm .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();

			switch (luaChon) {
			case 1:
				do {
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

					SinhVien sv = new SinhVien(name, age, address, gpa);
					quanLy.addSV(sv);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);
				quanLy.hocLuc();
				break;
			case 2:

				quanLy.show();
				break;

			case 3:

				quanLy.showSvGioi();
				break;
			case 4:

				quanLy.sapXep();
				quanLy.show();
				break;

			case 0:
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
