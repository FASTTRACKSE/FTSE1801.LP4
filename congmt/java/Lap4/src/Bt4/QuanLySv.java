package Bt4;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quanlysinhvien.Student;

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

	public void sapxeptheodiem() {
		Collections.sort(listSinhVien, new Comparator<Student>() {
			public int compare(Student sv1, Student sv2) {
				return (int) (sv2.getGpa() - sv1.getGpa());
			}

		});
		Student sapxep = new Student();

		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSinhVien[i].getGpa() > listSinhVien[j].getGpa()) {
					listSinhVien[i] = sapxep;
					listSinhVien[i] = listSinhVien[j];
					listSinhVien[j] = sapxep;
				}
			}
		}
		
		

	}

	public void hienThiHocLuc() {
		
		for (int i = 0; i < id; i++) {
			if (listSinhVien[i].getGpa() >= 8) {

				this.displayAllSV();
			}
		}
	}

	public void displayAllSV() {
		System.out.printf("%-3s| %-20s| %-6s| %-20s| %-6s| %-20s \n", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐiểmTB",
				"Xếp loại");
		System.out.println();

		for (int i = 0; i < soluongSv; i++) {
			System.out.printf(" %-3s| %-20s| %-6s| %-20s| %-6s| %-20s \n", listSinhVien[i].getId(),
					listSinhVien[i].getName(), listSinhVien[i].getAge(), listSinhVien[i].getAddress(),
					listSinhVien[i].getGpa(), listSinhVien[i].getHocLuc());
			;
			System.out.println();
			System.out.println();

		}
	}

	public static void main(String[] args) {

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
			System.out.println("2. Xuất danh sách học sinh giỏi.");
			System.out.println("3. Sắp xếp sinh viên theo điểm trung bình .");
			System.out.println("4. Hiển thị danh sách sinh viên .");
			System.out.println("5. Kết thúc chương trình .");
			System.out.println("/***********************************/");
			System.out.print("Mời bạn lựa chọn : ");
			luaChon = sc.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					Student sv1 = new Student();

					System.out.print("-  Nhập Id:");
					int id = sc.nextInt();
					sv1.setId(id);
					sc.nextLine();
					System.out.print("-  Nhập tên sinh viên:");
					String name = sc.nextLine();
					sv1.setName(name);
					System.out.print("-  Nhập tuổi sinh viên:");
					byte age = sc.nextByte();
					sc.nextLine();
					sv1.setAge(age);
					System.out.print("-  Nhập địa chỉ sinh viên:");
					String address = sc.nextLine();
					sv1.setAddress(address);
					System.out.print("-  Nhập điểm trung bình:");
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
				qlsv.hienThiHocLuc();
				break;
			case 3:
				qlsv.sapxeptheodiem();
				break;
			case 4:
				qlsv.displayAllSV();
				break;

			case 5:
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
