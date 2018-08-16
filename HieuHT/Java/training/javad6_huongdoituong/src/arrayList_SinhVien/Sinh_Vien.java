package arrayList_SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quanlysv.quanly.SinhVien;

public class Sinh_Vien {
	ArrayList<SinhVien> listSV;

	public Sinh_Vien() {
		listSV = new ArrayList<SinhVien>();
	}

	// thêm sinh viên
	public void addSV(SinhVien sv) {
		listSV.add(sv);

	}

	// hiển thị sv
	public void show() {
		System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", "ID", "Name", "Age", "Address", "Gba");
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", listSV.get(i).getId(), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGba());
		}

	}

	public void repair() {
		listSV.set(0, new SinhVien(1, "Duốc", 25, "Quảng nam", 10));
		System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", "ID", "Name", "Age", "Address", "Gba");
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", listSV.get(i).getId(), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGba());
		}

	}

	public void delete() {
		listSV.remove(1);
		System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", "ID", "Name", "Age", "Address", "Gba");
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", listSV.get(i).getId(), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGba());
		}

	}

	public void sort() {
		Collections.sort(listSV, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {

				return o2.getName().compareToIgnoreCase(o1.getName());

			}

		});
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", listSV.get(i).getId(), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGba());
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sinh_Vien ql = new Sinh_Vien();
		SinhVien sv = new SinhVien();
		// System.out.println("Nhập id SV :");
		// int id = sc.nextInt();
		// sv.setId(id);
		// sc.nextLine();
		// System.out.println("Nhập tên SV :");
		// String name = sc.nextLine();
		// sv.setName(name);
		//
		// System.out.println("Nhập tuổi SV :");
		// int age = sc.nextInt();
		// sv.setAge(age);
		// sc.nextLine();
		// System.out.println("Nhập địa chỉ SV :");
		// String address = sc.nextLine();
		// sv.setAddress(address);
		// System.out.println("Nhập điểm trung bình của SV :");
		// double gba = sc.nextDouble();
		// sv.setGba(gba);
		// ql.addSV(sv);
		// ql.addSV(sv);
		sv = new SinhVien(2, "aợi", 22, "Nghệ An", 8);
		ql.addSV(sv);
		sv = new SinhVien(3, "bhương", 21, "Đà nẵng", 6);
		ql.addSV(sv);
		sv = new SinhVien(4, "cưng", 27, "Đà nẵng", 9);
		ql.addSV(sv);
		// add sinh viên
		ql.show();
		ql.repair();
		ql.delete();
		ql.sort();
	}
}
