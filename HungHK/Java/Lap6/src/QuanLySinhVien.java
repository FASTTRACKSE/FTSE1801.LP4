
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySinhVien {
	private ArrayList<SinhVien> listSinhVien;

	public QuanLySinhVien() {
		listSinhVien = new ArrayList<SinhVien>();
	}

	public void nhapSv(SinhVien sinhVien) {
		listSinhVien.add(sinhVien);
	}

	public void xuatDanhSachSv() {
		System.out.printf("%-8s %-15s %-7s %-15s %-7s\n", "Id", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		for (SinhVien sinhVien : listSinhVien) {
			System.out.printf("%-8s %-15s %-7s %-15s %-7s\n", sinhVien.getId(), sinhVien.getName(), sinhVien.getAge(),
					sinhVien.getAddress(), sinhVien.getGpa());
		}
	}

	public void sapXepDanhSachSv() {
		Collections.sort(listSinhVien, new Comparator<SinhVien>() {
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	public void xoaSvTheoId(String id) {
		SinhVien Id = null;
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getId().equals(id)) {
				Id = listSinhVien.get(i);
				break;
			}
		}
		if (Id != null) {
			listSinhVien.remove(Id);
		} else {
			System.out.println("Bạn đã nhập sai!");
		}
	}

	public boolean isExistStudent(String id) {
		for (SinhVien sinhVien : listSinhVien) {
			if (id.equals(sinhVien.getId())) {
				return true;
			}
		}
		return false;
	}

	public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn chọn menu!");

		while (true) {
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Hiển thị danh sách sinh viên");
			System.out.println("3. Sắp xếp danh sách sinh viên");
			System.out.println("4. Xóa sinh viên theo Id");
			System.out.println("5. Chương trình kết thúc");

			chooseMenu = sc.nextInt();
			switch (chooseMenu) {
			case 1:
				SinhVien sinhVien = new SinhVien();
				boolean kiemtra;
				String id = null;
				String name = null;
				int age;
				double gpa = 0;
				sc.nextLine();

				do {
					kiemtra = false;
					try {
						kiemtra = true;
						System.out.print("Nhập Id sinh viên: ");
						id = sc.nextLine();
						if (id.isEmpty())
							throw new Exception("Id không được rỗng");
						if (isExistStudent(id)) {
							kiemtra = true;
							throw new Exception("Id đã tồn tại");
						} else {
							kiemtra = false;
							System.out.println("Có thể thêm Id này");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} while (kiemtra);
				sinhVien.setId(id);

				do {
					kiemtra = false;
					System.out.print("Nhập tên sinh viên: ");
					name = sc.nextLine();
					if (name.trim().equals("")) {
						kiemtra = true;
					} else {
						for (int j = 0; j < name.length(); j++) {
							if (!Character.isLetter(name.charAt(j)) && name.charAt(j) != ' ') {
								kiemtra = true;
								break;
							}
						}
					}
					if (kiemtra) {
						System.out.println("Tên chỉ được nhập chữ và không được để rỗng");
					}
				} while (kiemtra);
				sinhVien.setName(name);

				do {
					kiemtra = false;
					System.out.print("Nhập tuổi : ");
					age = sc.nextInt();
					if (age <= 0 || age > 100) {
						kiemtra = true;
					}
					if (kiemtra) {
						System.out.println("Tuổi không thể nhỏ hơn 0 và lớn hơn 100");
					}
				} while (kiemtra);
				sinhVien.setAge(age);

				System.out.print("Nhập địa chỉ sinh viên: ");
				String address = sc.next();
				sinhVien.setAddress(address);

				do {
					kiemtra = false;
					try {
						System.out.println("Nhập điểm trung bình: ");
						gpa = sc.nextDouble();
						if (gpa < 0 || gpa > 10) {
							kiemtra = true;
							throw new Exception("Ðiểm chỉ được từ 0 - 10");
						} else {
							kiemtra = false;
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} while (kiemtra);
				sinhVien.setGpa(gpa);

				nhapSv(sinhVien);
				break;

			case 2:
				xuatDanhSachSv();
				break;

			case 3:
				sapXepDanhSachSv();
				xuatDanhSachSv();
				break;

			case 4:
				System.out.print("Nhập Id sinh viên cần xóa: ");
				sc.nextLine();
				String Id = sc.nextLine();
				xoaSvTheoId(Id);
				xuatDanhSachSv();
				break;

			case 5:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;

			default:
				System.out.println("\n\n********Menu not exist feature********");
				break;
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		QuanLySinhVien quanLy = new QuanLySinhVien();
		quanLy.menu();
	}
}
