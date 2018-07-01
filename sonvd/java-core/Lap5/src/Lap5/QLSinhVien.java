package Lap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Quan ly sinh vien
 * 
 * @author SonVD
 *
 */
public class QLSinhVien {
	private ArrayList<SinhVien> listSinhVien;

	public QLSinhVien() {
		listSinhVien = new ArrayList<SinhVien>();
	}

	/**
	 * Menu list sinh vien
	 */
	public void menu() {
		int chooseMenu;
		Scanner input = new Scanner(System.in);

		

		while (true) {
			System.out.println("/****************************************/");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Hiển thị danh sách sinh viên");
			System.out.println("3. Sắp sếp sinh viên theo tên");
			System.out.println("4. Hoán đổi ngẫu nhiên");
			System.out.println("5. Xóa sinh viên");
			System.out.println("0. Kết thúc chương trình.");
			System.out.println("/****************************************/");

			chooseMenu = input.nextInt();

			switch (chooseMenu) {
			case 1:
				SinhVien sv = new SinhVien();

				System.out.println("Nhập Id:");
				int Id = input.nextInt();
				sv.setId(Id);
				input.nextLine();
				System.out.println("Nhập tên sinh viên:");
				String Name = input.nextLine();
				sv.setName(Name);
				System.out.println("Nhập tuổi sinh viên: ");
				int Age = input.nextInt();
				sv.setAge(Age);
				input.nextLine();
				System.out.println("Nhập địa chỉ sinh viên: ");
				String Address = input.nextLine();
				sv.setAddress(Address);
				System.out.println("Nhập điểm trung bình");
				double Gpa = input.nextDouble();
				sv.setGpa(Gpa);

				addSV(sv);
				System.out.println("Thêm sinh viên có Id " + Id + " thành công!");
				break;
			case 2:
				displaySV();
				break;
			case 3:
				sortSVByName();
				break;
			case 4:
				hoanDoiNgauNhien();
				break;
			case 5:
				System.out.println("Nhập tên sinh viên cần xóa: ");
				input.nextLine();
				String name1 = input.nextLine();
				
				deleteSVByName(name1);
				System.out.println("Xóa sinh viên thành công theo tên " + name1 + " !");
				break;
			case 0:
				input.close();
				System.out.println("Chương trình kết thúc!!!!");
				System.exit(0);
			default:
				System.out.println("Menu không tồn tại.");
				break;
			}
		}

	}

	/**
	 * add sinh vien in list
	 * @param Sv Sinh viên
	 */
	public void addSV(SinhVien Sv) {
		listSinhVien.add(Sv);
	}

	/**
	 * display list sinh vien
	 */
	public void displaySV() {
		System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", "Id", "Tên sinh viên", "Tuổi", "Địa chỉ", "Trung bình");
		for (int i = 0; i < listSinhVien.size(); i++) {
			System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", listSinhVien.get(i).getId(), listSinhVien.get(i).getName(),
					listSinhVien.get(i).getAge(), listSinhVien.get(i).getAddress(), listSinhVien.get(i).getGpa());
		}
	}

	/**
	 * sort sinh vien by name
	 */
	public void sortSVByName() {
		Collections.sort(listSinhVien, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		System.out.println("Sắp xếp danh sách sinh viên theo tên thành công!");
	}

	/**
	 * hoan doi ngau nhien
	 */
	public void hoanDoiNgauNhien() {
		Collections.shuffle(listSinhVien);
		System.out.println("Hóa đổi ngẫu nhiên thành công!");
	}

	/**
	 * delete sinh vien by name
	 * @param name tên 
	 */
	public void deleteSVByName(String name) {
		SinhVien Name = null;
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getName().equals(name)) {
				Name = listSinhVien.get(i);
				break;
			}
		}
		if (Name != null) {
			listSinhVien.remove(Name);
		} else {
			System.out.println("Tên sinh viên không có trong danh sách.");
		}
	}


	public static void main(String[] args) {
		QLSinhVien qlsv = new QLSinhVien();

		qlsv.menu();
	}

}
