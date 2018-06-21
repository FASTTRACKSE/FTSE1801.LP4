
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLSinhVien {
	private ArrayList<SinhVien> listSinhVien;

	public QLSinhVien() {
		listSinhVien = new ArrayList<SinhVien>();
	}

	/**
	 * add student to studentList
	 * 
	 * @param student
	 */
	public void add(SinhVien sinhvien) {
		listSinhVien.add(sinhvien);

	}

	/**
	 * edit student by id
	 * 
	 * @param id
	 */
	public void update(Scanner sc, String id) {
		boolean isExisted = false;

		int size = listSinhVien.size();

		for (int i = 0; i < size; i++) {
			if (listSinhVien.get(i).getId() == id) {
				isExisted = true;
				sc.nextLine();
				System.out.println("- Nhập tên sinh viên:");
				String name = sc.nextLine();
				listSinhVien.get(i).setName(name);
				System.out.println("- Nhập tuổi sinh viên:");
				byte age = sc.nextByte();
				sc.nextLine();
				listSinhVien.get(i).setAge(age);
				System.out.println("- Nhập địa chỉ sinh viên:");
				String address = sc.nextLine();
				listSinhVien.get(i).setAddress(address);
				System.out.println("- Nhập điểm trung bình sinh viên:");
				double diemTb = sc.nextDouble();
				listSinhVien.get(i).setDiemTb(diemTb);
				break;
			}
		}
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		}

	}

	public void sapxeptheotuoi() {
		Collections.sort(listSinhVien, new Comparator<SinhVien>() {
			public int compare(SinhVien sv1, SinhVien sv2) {
				return sv2.getAge() - sv2.getAge();
			}

		});

	}

	public void sapxeptheodiem() {
		Collections.sort(listSinhVien, new SortStudentByGPA());

	}

	public void sapxepten() {
		Collections.sort(listSinhVien, new SortStudentByName());
	}

	/**
	 * delete student by id
	 * 
	 * @param id:
	 *            student id
	 */
	public void deletel(String id) {
		SinhVien sinhvien = null;
		int size = listSinhVien.size();
		for (int i = 0; i < size; i++) {
			if (listSinhVien.get(i).getId() == id) {
				sinhvien = listSinhVien.get(i);
				break;
			}
		}
		if (sinhvien != null) {
			listSinhVien.remove(sinhvien);
			// studentDao.write(listSinhVien);
		} else {
			System.out.printf("id = %d not existed.\n", id);
		}

	}

	/**
	 * show list student to screen
	 */
	public void displayAllSV(SinhVien sinhvien) {
		int size = listSinhVien.size();
		System.out.printf("%-3s %-20s %-6s %-20s %-6s \n", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.printf(" %-3s %-20s %-6s %-20s %-6s \n", listSinhVien.get(i).getId(),
					listSinhVien.get(i).getName(), listSinhVien.get(i).getAge(), listSinhVien.get(i).getAddress(),
					listSinhVien.get(i).getDiemTb());

			System.out.println();
		}

	}

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choose, tt;

		QLSinhVien qlsv = new QLSinhVien();

		// show menu
		showMenu();
		while (true) {
			choose = sc.nextInt();

			switch (choose) {
			case 1:
				do {
					SinhVien sv1 = new SinhVien();

					System.out.println("- Nhập Id sinh viên:");
					String id = sc.nextLine();
					sc.nextLine();
					sv1.setId(id);
					System.out.println("- Nhập tên sinh viên:");
					String name = sc.nextLine();
					sv1.setName(name);
					sc.nextLine();
					System.out.println("- Nhập tuổi sinh viên:");
					byte age = sc.nextByte();
					sc.nextLine();
					sv1.setAge(age);
					System.out.println("- Nhập địa chỉ sinh viên:");
					String address = sc.nextLine();
					sv1.setAddress(address);
					System.out.println("- Nhập điểm trung bình sinh viên:");
					double diemTb = sc.nextDouble();

					sv1.setDiemTb(diemTb);
					qlsv.add(sv1);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);

				break;
			case 2:
				System.out.println();
				System.out.print("Nhập ID cần sửa : ");
				String update1 = sc.nextLine();

				qlsv.update(sc, update1);

				break;

			case 3:
				System.out.println();
				System.out.print("Nhập ID cần xóa : ");
				System.out.println();
				String idDelete = sc.nextLine();
				qlsv.deletel(idDelete);
				break;
			case 4:
				qlsv.sapxeptheodiem();
				break;
			case 5:
				qlsv.sapxepten();
				break;
			case 6:
				qlsv.sapxeptheotuoi();
				break;
			case 7:

				qlsv.displayAllSV(null);
				break;

			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
			// show menu
			showMenu();
		}
	}

	/**
	 * create menu
	 */
	public static void showMenu() {
		System.out.println("-----------menu------------");
		System.out.println("1. Thêm sinh viên.");
		System.out.println("2. Cập nhập sinh viên theo Id.");
		System.out.println("3. Xóa sinh vien theo id.");
		System.out.println("4. Sort student by gpa.");
		System.out.println("5. Sort student by Name.");
		System.out.println("6. Sort student by Age.");
		System.out.println("7. Hiển thị danh sách sinh viên.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}
}
