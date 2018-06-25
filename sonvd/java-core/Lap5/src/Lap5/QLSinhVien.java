package Lap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLSinhVien {
	private ArrayList<SinhVien> listSinhVien;

	public QLSinhVien() {
		listSinhVien = new ArrayList<SinhVien>();
	}
	
	//Menu list sinh vien
	public void menu() {
		int chooseMenu;
		Scanner input = new Scanner(System.in);

		QLSinhVien ql = new QLSinhVien();

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

				ql.addSV(sv);
				System.out.println("Thêm sinh viên có Id " +Id+ " thành công!");
				break;
			case 2:
				ql.displaySV();
				break;
			case 3:
				sortSVByName();
				break;
			case 4:
				ql.hoanDoiNgauNhien();
				break;
			case 5:
				System.out.println("Nhập tên sinh viên cần xóa: ");
				input.nextLine();
				String name1 = input.nextLine();
				ql.deleteSVByName(name1);
				System.out.println("Xóa sinh viên thành công theo tên " +name1+ " !");
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
	
	//add sinh vien in list
	public void addSV(SinhVien Sv) {
		listSinhVien.add(Sv);
	}
	
	//display list sinh vien
	public void displaySV() {
		System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", "Id", "Tên sinh viên", "Tuổi", "Địa chỉ", "Trung bình");
		for (int i = 0; i < listSinhVien.size(); i++) {
			System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", listSinhVien.get(i).getId(), listSinhVien.get(i).getName(),
					listSinhVien.get(i).getAge(), listSinhVien.get(i).getAddress(), listSinhVien.get(i).getGpa());
		}
	}
	
	//Sort sinh vien by name
	public void sortSVByName() {
		Collections.sort(listSinhVien, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		System.out.println("Sắp xếp danh sách sinh viên theo tên thành công!");
	}
	
	//hoán đổi ngẫu nhiên
	public void hoanDoiNgauNhien() {
		Collections.shuffle(listSinhVien);
		System.out.println("Hóa đổi ngẫu nhiên thành công!");
	}
	
	// delete sinhvien by Id
	public void deleteSVByName(String name) {
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getName().equals(name)) {
				listSinhVien.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		QLSinhVien qlsv = new QLSinhVien();

		qlsv.menu();
	}

}
