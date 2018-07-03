package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class quanLySinhVien {

	private ArrayList<sinhVien> ql;

	public quanLySinhVien() {
		ql = new ArrayList<sinhVien>();
	}

	public void nhap(sinhVien ten) {
		ql.add(ten);

	}

	public void xuat() {
		System.out.printf("%30s|%30s%n", "Họ và Tên", "Địa chỉ");
		for (int i = 0; i < ql.size(); i++) {
			System.out.printf("%30s|%30s%n", ql.get(i).getHoTen(), ql.get(i).getDiachi());
		}
	}

	public void ngauNhien() {
		Collections.shuffle(ql);

	}

	public void sapXep() {
		Collections.sort(ql, new Comparator<sinhVien>() {
			public int compare(sinhVien o1, sinhVien o2) {

				return o2.getHoTen().compareToIgnoreCase(o1.getHoTen());
			}
		});
	}

	public void xoaSV(String hoTen) {
		sinhVien name = null;
		for (int i = 0; i < ql.size(); i++) {
			if (ql.get(i).getHoTen().equals(hoTen)) {
				name = ql.get(i);
				break;
			}
		}

		if (name != null) {
			ql.remove(name);
		} else {
			System.out.println("Bạn đã nhập sai.");
		}
	}

	public void menu() {
		int chooseMenu, nt;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("***********Menu ***********");
			System.out.println("* 1 - Thêm thông tin sinh viên*");
			System.out.println("* 2 - Hiển thị danh sách sinh viên*");
			System.out.println("* 3 - Hiển thị danh sách ngẫu nhiên*");
			System.out.println("* 4 - Sắp xếp sinh viên theo tên *");
			System.out.println("* 5 - Xóa thông tin sinh viên*");
			System.out.println("* 6 - Exit program *");
			System.out.println("********************************************************");
			
			System.out.println("Hãy chọn 1 trong 6 mục trên: ");
			chooseMenu = sc.nextInt();

			switch (chooseMenu) {
			case 1:
				do {

					sinhVien sv = new sinhVien();
					sc.nextLine();
					System.out.print("Nhập họ tên: ");
					String hoTen = sc.nextLine();

					sv.setHoTen(hoTen);

					System.out.print("Nhập địa chỉ: ");
					String diachi = sc.nextLine();
					sv.setDiachi(diachi);

					nhap(sv);
					System.out.println("Bạn muốn thêm sinh viên: (1. có | 0. Không)");
					nt = sc.nextInt();
				} while (nt == 1);

				break;

			case 2:
				xuat();
				break;
			case 3:
				ngauNhien();
				xuat();
				break;
			case 4:
				sapXep();
				break;
			case 5:
				System.out.println("Nhập đúng họ tên cần xóa :");
				sc.nextLine();
				String hoten = sc.nextLine();
				xoaSV(hoten);
				xuat();
				break;
			case 6:
				sc.close();
				System.out.println("------The end-------");
				System.exit(0);
				break;

			default:
				System.out.println("\n Mời bạn nhập lại");
				break;
			}

			System.out.println("\n\n\n");
		}
	}

	public static void main(String[] args) {
		quanLySinhVien person = new quanLySinhVien();
		person.menu();
	}
}