package bai1_quan_ly_sinh_vien_array;

import java.util.Scanner;

public class QuanLySinhVien {
	private SinhVien[] listSV;
	private int id;

	public QuanLySinhVien() {
		listSV = new SinhVien[100];
		id = 0;
	}

	/**
	 * Them sinh vien
	 * 
	 * @param SV
	 */
	public void addSV(SinhVien SV) {
		listSV[id] = SV;
		id += 1;
	}

	/**
	 * Xoa sing vien theo ten cach
	 * 
	 * @param ten
	 */
	public void deleteSV(String ten) {

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

	/**
	 * Hien thi all sinh vien
	 */
	public void showAll() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSV[i].getName(), listSV[i].getAge(),
					listSV[i].getAddress(), listSV[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * Sắp xếp theo tuổi từ thấp đến cao
	 */
	public void sapXepAgeThapDenCao() {

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

	/**
	 * Sắp xếp theo tên từ a - z
	 */
	public void sapXepAtoZ() {

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

	/**
	 * Sửa đổi thông tin sinh viên theo ten
	 * 
	 * @param input
	 * @param ten
	 */
	public void repairSV(Scanner input, String ten) {

		for (int i = 0; i < id; i++) {
			if (listSV[i].getName().equals(ten)) {
				System.out.print("Nhập tên SV : ");
				String name = input.nextLine();

				SinhVien sv = listSV[i];

				System.out.print("Nhập tuổi : ");
				int age = input.nextInt();

				input.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = input.nextLine();

				System.out.print("Nhập điểm trung bình : ");
				double gpa = input.nextDouble();

				sv.setName(name);
				sv.setAge(age);
				sv.setAddress(address);
				sv.setGpa(gpa);
				break;
			}
		}
		System.out.println("Bạn đã nhập sai!!!!");
	}

	public static void main(String[] args) {
		int tiepTuc, luaChon;
		QuanLySinhVien quanLy = new QuanLySinhVien();
		SinhVien sv;
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo tên.");
			System.out.println("3. Xóa sinh viên theo ID  .");
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

					sv = new SinhVien(name, age, address, gpa);
					quanLy.addSV(sv);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tiepTuc = input.nextInt();
					System.out.println();
				} while (tiepTuc == 1);
				break;
			case 2:
				System.out.println();
				System.out.print("Nhập tên cần sửa : ");
				input.nextLine();
				String name = input.nextLine();
				quanLy.repairSV(input, name);
				quanLy.showAll();
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập tên cần xóa : ");
				System.out.println();
				input.nextLine();
				String ten = input.nextLine();
				quanLy.deleteSV(ten);
				quanLy.showAll();
				break;
			case 4:
				quanLy.sapXepAgeThapDenCao();
				quanLy.showAll();
				break;
			case 5:
				quanLy.showAll();
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
