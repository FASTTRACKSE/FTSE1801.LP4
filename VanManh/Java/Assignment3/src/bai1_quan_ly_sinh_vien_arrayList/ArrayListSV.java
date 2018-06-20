package bai1_quan_ly_sinh_vien_arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListSV {
	private ArrayList<SinhVienArray> listSV;

	public ArrayListSV() {
		listSV = new ArrayList<SinhVienArray>();
	}

	// Thêm sinh viên
	public void addSV(SinhVienArray SV) {
		listSV.add(SV);
	}

	// Xóa sinh viên
	public void deleteSV(String ten) {
		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getName().equals(ten)) {
				listSV.remove(i);
				break;
			}
		}
	}

	// Hiển thị sắp xếp sinh viên
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGpa());
		}
		System.out.println();
		System.out.println();
	}

	// Sắp xếp sinh viên theo tuổi cách 1
	public void sapXepAge() {
		Collections.sort(listSV, new SapXepArray() {
			public int compare(SinhVienArray sv1, SinhVienArray sv2) {
				return sv1.getAge() - (sv2.getAge());
			}
		});

	}

	// Sắp xếp sinh viên theo tên
	public void sapXepName() {
		Collections.sort(listSV, new SapXepArray());
	}

	// Sắp xếp sinh viên theo tuổi cách 2
	public void sapXepAgeCach2() {
		for (int i = 0; i < listSV.size() - 1; i++) {
			for (int j = 1; j < listSV.size(); j++) {
				if (listSV.get(i).getAge() > listSV.get(j).getAge()) {
					SinhVienArray temp = listSV.get(i);
					listSV.set(i, listSV.get(j));
					listSV.set(j, temp);
				}
			}
		}

	}

	// Sửa đổi thông tin sinh viên
	public void repairSV(Scanner input, String ten) {

		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getName().equals(ten)) {
				System.out.print("Nhập tên SV : ");
				String name = input.nextLine();

				System.out.print("Nhập tuổi : ");
				int age = input.nextInt();

				input.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = input.nextLine();

				System.out.print("Nhập điểm trung bình : ");
				double gpa = input.nextDouble();
				SinhVienArray sv = new SinhVienArray();
				sv.setName(name);
				sv.setAge(age);
				sv.setAddress(address);
				sv.setGpa(gpa);
				listSV.set(i, sv);
				break;
			}
		}
		System.out.println("Bạn đã nhập sai!!!!");

	}

	public static void main(String[] args) {
		int tt, luaChon;
		ArrayListSV quanLy = new ArrayListSV();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo tên.");
			System.out.println("3. Xóa sinh viên theo tên  .");
			System.out.println("4. Sắp sếp sinh viên theo tuổi .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
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

					SinhVienArray sv = new SinhVienArray(name, age, address, gpa);
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
				quanLy.sapXepAge();
				quanLy.show();
				break;
			case 5:
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
