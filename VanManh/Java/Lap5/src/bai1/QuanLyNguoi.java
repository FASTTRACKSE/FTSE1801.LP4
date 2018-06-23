package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyNguoi {
	ArrayList<People> listPeople;

	public QuanLyNguoi() {
		listPeople = new ArrayList<People>();
	}

	// Them nguoi
	public void addNguoi(People person) {
		listPeople.add(person);
	}

	// Hien thi danh sach people
	public void show() {
		System.out.printf("%-5s %-20s %-5s %-20s", "STT", "Name", "Age", "Address");
		System.out.println();
		for (int i = 0; i < listPeople.size(); i++) {
			System.out.printf("%-5s %-20s %-5s %-20s", i + 1, listPeople.get(i).getName(), listPeople.get(i).getAge(),
					listPeople.get(i).getAddress());
			System.out.println();
		}
		System.out.println();
	}

	// Hien thi danh sach people ngau nhien
	public void showRandom() {
		Collections.shuffle(listPeople);
		System.out.printf("%-5s %-20s %-5s %-20s", "STT", "Name", "Age", "Address");
		System.out.println();
		for (int i = 0; i < listPeople.size(); i++) {
			System.out.printf("%-5s %-20s %-5s %-20s", i + 1, listPeople.get(i).getName(), listPeople.get(i).getAge(),
					listPeople.get(i).getAddress());
			System.out.println();
		}
		System.out.println();
	}

	// Sap xep theo ten tu z den a
	public void sortZtoA() {
		Collections.sort(listPeople, new Sort());
	}

	// Tim va xoa prenson theo ten
	public void delete(String name) {
		Object person = null;
		for (int i = 0; i < listPeople.size(); i++) {
			if (listPeople.get(i).getName().equals(name)) {
				person = listPeople.get(i);
				break;
			}
		}

		if (person != null) {
			listPeople.remove(person);
		} else {
			System.out.println("Bạn đã nhập sai tên vui lòng chọn lại chức năng của chương trình. ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int tt, luaChon;
		QuanLyNguoi quanLy = new QuanLyNguoi();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm person.");
			System.out.println("2. Hiển thị danh sách person.");
			System.out.println("3. Xuất danh sách sinh person ngẫu nhiên .");
			System.out.println("4. Sắp xếp danh sách person theo tên từ z đến a .");
			System.out.println("5. Xóa person theo tên .");
			System.out.println("6. Kết thúc");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();

			switch (luaChon) {
			case 1:
				do {
					input.nextLine();
					System.out.print("Nhập tên : ");
					String name = input.nextLine();

					System.out.print("Nhập tuổi : ");
					int age = input.nextInt();

					input.nextLine();
					System.out.print("Nhập địa chỉ : ");
					String address = input.nextLine();

					People person = new People();
					person.setName(name);
					person.setAge(age);
					person.setAddress(address);
					quanLy.addNguoi(person);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				quanLy.show();
				break;

			case 3:
				quanLy.showRandom();
				break;
			case 4:

				quanLy.sortZtoA();
				quanLy.show();
				break;
			case 5:
				System.out.println("Nhập tên cần xóa : ");
				input.nextLine();
				String name = input.nextLine();
				quanLy.delete(name);
				quanLy.show();
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
