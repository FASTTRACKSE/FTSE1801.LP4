package quanlysinhvien;

import java.util.Scanner;

public class QuanLySv {
	private Student[] listSinhVien;
	private int soluongSv;
	private int id = 0;

	public QuanLySv() {
		listSinhVien = new Student[100];
		soluongSv = 0;
	}

	public void addSv(Student sv) {
		listSinhVien[soluongSv] = sv;
		soluongSv += 1;
	}

	public void updateSv(Scanner sc, int id) {
		boolean isExisted = false;

		int size = soluongSv;

		for (int i = 0; i < size; i++) {
			if (listSinhVien[i].getId() == id) {
				isExisted = true;
				sc.nextLine();
				System.out.println("- Nhập tên sinh viên:");
				String name = sc.nextLine();
				listSinhVien[i].setName(name);
				System.out.println("- Nhập tuổi sinh viên:");
				byte age = sc.nextByte();
				sc.nextLine();
				listSinhVien[i].setAge(age);
				System.out.println("- Nhập địa chỉ sinh viên:");
				String address = sc.nextLine();
				listSinhVien[i].setAddress(address);
				System.out.println("- Nhập điểm trung bình:");
				float gpa = sc.nextFloat();
				listSinhVien[i].setGpa(gpa);

				// qlsv.displayAllSV();
				break;
			}
		}
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		}
	}

	public void deletelSV(int id) {
		for (int i = 0; i < listSinhVien.length - 1; i++) {

			if (listSinhVien[i].getId() == id) {
				for (int j = 0; j < listSinhVien.length - 1; j++) {
					listSinhVien[j] = listSinhVien[j + 1];
				}
			}
		}
		listSinhVien[listSinhVien.length - 1] = null;
		soluongSv -= 1;

	}

	public void sapxep() {
		Student sapxep = new Student();

		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSinhVien[i].getAge() > listSinhVien[j].getAge()) {
					listSinhVien[i] = sapxep;
					listSinhVien[i] = listSinhVien[j];
					listSinhVien[j] = sapxep;
				}
			}
		}

	}

	public void displayAllSV() {
		System.out.printf("%-3s %-20s %-6s %-20s %-6s \n", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐiểmTB");
		System.out.println();

		for (int i = 0; i < soluongSv; i++) {
			System.out.printf(" %-3s %-20s %-6s %-20s %-6s \n", listSinhVien[i].getId(), listSinhVien[i].getName(),
					listSinhVien[i].getAge(), listSinhVien[i].getAddress(), listSinhVien[i].getGpa());
			;
			System.out.println();
			System.out.println();

		}
	}

	public static void main(String[] args) {
		// Scanner sc=new Scanner(System.in);
		// QuanLySv qlsv=new QuanLySv();
		// Student sv1=new Student();
		//
		// System.out.println("- Nháº­p ID sinh viÃªn:");
		// int id=sc.nextInt();
		// sv1.setId(id);
		// sc.nextLine();
		// System.out.println("- Nháº­p tÃªn sinh viÃªn:");
		// String name=sc.nextLine();
		// sv1.setName(name);
		// System.out.println("- Nháº­p tuá»•i sinh viÃªn:");
		// byte age= sc.nextByte();
		// sc.nextLine();
		// sv1.setAge(age);
		// System.out.println("- Nháº­p Ä‘á»‹a chá»‰ sinh viÃªn:");
		// String address=sc.nextLine();
		// sv1.setAddress(address);
		// System.out.println("- Nháº­p Ä‘iá»ƒm TB sinh viÃªn:");
		// float gpa=sc.nextFloat();
		// sv1.setGpa(gpa);
		//
		// qlsv.addSv(sv1);
		// qlsv.displayAllSV();
		menu();
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		QuanLySv qlsv = new QuanLySv();
		int tt, luaChon;
		while (true) {
			// Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhập sinh viên  theo ID.");
			System.out.println("3. Xóa sinh viên theo ID  .");
			System.out.println("4. Sắp xếp sinh viên theo tuoi .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn lựa chọn : ");
			luaChon = sc.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					Student sv1 = new Student();

					System.out.println("-  Nhập Id:");
					int id = sc.nextInt();
					sv1.setId(id);
					sc.nextLine();
					System.out.println("-  Nhập tên sinh viên:");
					String name = sc.nextLine();
					sv1.setName(name);
					System.out.println("-  Nhập tuổi sinh viên:");
					byte age = sc.nextByte();
					sc.nextLine();
					sv1.setAge(age);
					System.out.println("-  Nhập địa chỉ sinh viên:");
					String address = sc.nextLine();
					sv1.setAddress(address);
					System.out.println("-  Nhập điểm trung bình:");
					float gpa = sc.nextFloat();
					sv1.setGpa(gpa);
					qlsv.addSv(sv1);
					System.out.println();
					System.out.print("Bạn có muốn tiếp tục không: (0:không | 1:Có) ");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);

				break;
			case 2:
				System.out.println();
				System.out.print("Nhập Id cần sửa : ");
				int update1 = sc.nextInt();
				qlsv.updateSv(sc, update1);
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập Id cần xóa: ");
				System.out.println();
				int idDelete = sc.nextInt();
				qlsv.deletelSV(idDelete);
				break;
			case 4:
				qlsv.sapxep();
				break;
			case 5:
				qlsv.displayAllSV();
				break;

			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng. Mời chọn lại.");
				break;
			}
		}
	}

}
