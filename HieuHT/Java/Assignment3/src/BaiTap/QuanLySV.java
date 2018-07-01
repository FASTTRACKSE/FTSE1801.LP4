package BaiTap;

import java.util.Scanner;

public class QuanLySV {
	private SinhVien[] listSV;
	private int id;

	public QuanLySV() {
		listSV = new SinhVien[100];
		id = 0;
	}

	// Thêm sinh viên
	public void addSV(SinhVien SV) {
		listSV[id] = SV;
		id += 1;
	}

	// Xóa sinh viên cách 1
	public void deleteSV(String ten) {

		for (int i = 0; i < id; i++) {
			if (listSV[i].getName().equals(ten)) {
				for (int j = i; j < id; j++) {
					listSV[j] = listSV[j + 1];
				}
				id = id - 1;
				break;
			}
			System.out.println("Kết thúc");
		}
	}

	// Xóa sinh viên cách 2
	public void deleteSV2(String ten) {

		boolean flagExist = false;
		for (int i = 0; i < id; i++) {
			if (flagExist == false) {
				if (listSV[i].getName().equals(ten)) {
					flagExist = true;
					listSV[i] = listSV[i + 1];
				}
			} else {
				listSV[i] = listSV[i + 1];
			}
		}
		listSV[listSV.length] = null;
		id = id - 1;

	}

	// Hiển thị sinh viên
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSV[i].getName(), listSV[i].getAge(),
					listSV[i].getAddress(), listSV[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}

	// Sắp xếp theo tuổi từ thấp đến cao
	public void sapXep() {

		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSV[i].getAge() > listSV[j].getAge()) {
					SinhVien sapXep = listSV[i];
					listSV[i] = listSV[j];
					listSV[j] = sapXep;
				}
			}
		}

	}

	// Sắp xếp theo tên từ a - z
	public void sapXepAtoZ() {
		// Sắp xếp theo tên từ a - z

		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSV[i].getName().compareTo(listSV[j].getName()) > 0) {
					SinhVien sapXep = listSV[i];
					listSV[i] = listSV[j];
					listSV[j] = sapXep;
				}
			}
		}

	}

	// Sửa đổi thông tin sinh viên
	public void repairSV(Scanner input, String ten) {

		for (int i = 0; i < id; i++) {
			if (listSV[i].getName().equals(ten)) {
				System.out.print("Nhập tên SV : ");
				
				String name = input.nextLine();

				System.out.print("Nhập tuổi : ");
				int age = input.nextInt();

				input.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = input.nextLine();

				System.out.print("Nhập điểm trung bình : ");
				double gpa = input.nextDouble();

				listSV[i].setName(name);
				listSV[i].setAge(age);
				listSV[i].setAddress(address);
				listSV[i].setGpa(gpa);
				break;
			}
		}
		System.out.println("Bạn đã nhập sai!!!!");

	}

	public static void main(String[] args) {
		int tt, luaChon;
		QuanLySV quanLy = new QuanLySV();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Cập nhật thông tin sinh viên theo tên");
			System.out.println("3. Xóa sinh viên theo ID");
			System.out.println("4. Sắp sếp sinh viên theo tuổi");
			System.out.println("5. Hiển thị danh sách sinh viên");
			System.out.println("0. Kết thúc chương trình");
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
				break;
			case 2:
				System.out.println();
				System.out.print("Nhập tên cần sửa : ");
				input.nextLine();
				String name = input.nextLine();
				quanLy.repairSV(input, name);
				quanLy.show();
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập tên cần xóa : ");
				System.out.println();
				input.nextLine();
				String ten = input.nextLine();
				quanLy.deleteSV(ten);
				quanLy.show();
				break;
			case 4:
				quanLy.sapXep();
				quanLy.show();
				break;
			case 5:
				quanLy.show();
				break;

			case 0:
				input.close();
				System.out.println("Kết thúc chương trình! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
		}
	}
}