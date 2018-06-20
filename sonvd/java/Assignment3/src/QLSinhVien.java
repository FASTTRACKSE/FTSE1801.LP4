import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLSinhVien {
	private ArrayList<quanLySinhVien> listSinhVien;

	public QLSinhVien() {
		listSinhVien = new ArrayList<quanLySinhVien>();
	}

	public void menu() {
		int chooseMenu;
		Scanner input = new Scanner(System.in);

		QLSinhVien ql = new QLSinhVien();

		while (true) {
			System.out.println("/****************************************/");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID");
			System.out.println("3. Xóa sinh viên theo ID");
			System.out.println("4. Sắp sếp sinh viên theo tên");
			System.out.println("5. Hiển thị danh sách sinh viên");
			System.out.println("0. Kết thúc chương trình.");
			System.out.println("/****************************************/");

			chooseMenu = input.nextInt();

			switch (chooseMenu) {
			case 1:
				quanLySinhVien sv = new quanLySinhVien();
				
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
				break;
			case 2:
				System.out.println("Nhập id sinh viên cần sửa: ");
				int idUp = input.nextInt();
				ql.updateSVById(idUp);
				break;
			case 3:
				System.out.println("Nhập id sinh viên cần xóa: ");
				int idDel = input.nextInt();
				ql.deleteSVById(idDel);
				break;
			case 4:
				sortSVByName();
				break;
			case 5:
				ql.displaySV();
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

	public void addSV(quanLySinhVien Sv) {
		listSinhVien.add(Sv);
		System.out.println("Thêm sinh viên thành công!");
	}

	public void updateSVById(int id) {
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getId() == id) {
				Scanner input = new Scanner(System.in);
				System.out.println("Nhập tên sinh viên:");
				String Name = input.nextLine();
				listSinhVien.get(i).setName(Name);
				System.out.println("Nhập tuổi sinh viên: ");
				int Age = input.nextInt();
				listSinhVien.get(i).setAge(Age);
				input.nextLine();
				System.out.println("Nhập địa chỉ sinh viên: ");
				String Address = input.nextLine();
				listSinhVien.get(i).setAddress(Address);
				System.out.println("Nhập điểm trung bình");
				double Gpa = input.nextDouble();
				listSinhVien.get(i).setGpa(Gpa);
				input.close();
			} else {
				System.out.println("Vui lòng nhập đúng Id của sinh viên.");
			}
		}
	}

	public void deleteSVById(int id) {
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getId() == id) {
				listSinhVien.remove(i);
			}
		}
	}

	public void sortSVByName() {
		Collections.sort(listSinhVien, new Comparator<quanLySinhVien>() {

			@Override
			public int compare(quanLySinhVien o1, quanLySinhVien o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}

		});
	}

	public void displaySV() {
		System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", "Id", "Tên sinh viên", "Tuổi", "Địa chỉ", "Trung bình");
		for (int i = 0; i < listSinhVien.size(); i++) {
			System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", listSinhVien.get(i).getId(), listSinhVien.get(i).getName(),
					listSinhVien.get(i).getAge(), listSinhVien.get(i).getAddress(), listSinhVien.get(i).getGpa());
		}
	}

	public static void main(String[] args) {
		QLSinhVien qlsv = new QLSinhVien();

		qlsv.menu();
	}

}
