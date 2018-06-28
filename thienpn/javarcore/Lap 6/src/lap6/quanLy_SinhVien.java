package lap6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author ngọc thiên 1801014
 *
 */
public class quanLy_SinhVien {

	private ArrayList<SinhVien> listSv;

	public quanLy_SinhVien() {

		listSv = new ArrayList<SinhVien>();
	}

	/**
	 * nhập Sinh Viên
	 * 
	 * @param sv1
	 */
	public void addSV(SinhVien sv1) {

		listSv.add(sv1);
	}

	/**
	 * Hiển thị danh sách sinh viên
	 */
	public void printSV() {

		System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", "ID", "Name", "Age", "Address", "Gba");
		for (int i = 0; i < listSv.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", listSv.get(i).getId(), listSv.get(i).getName(),
					listSv.get(i).getAge(), listSv.get(i).getAddress(), listSv.get(i).getGba());
		}
	}

	/**
	 * Sắp xếp sin viên theo tên a-z
	 */
	public void sort() {
		Collections.sort(listSv, new Comparator<SinhVien>() {

			public int compare(SinhVien o1, SinhVien o2) {

				return o1.getName().compareToIgnoreCase(o2.getName());
			}

		});
	}

	/**
	 * hàm dk trung lặp Id
	 * 
	 * @param id
	 */
	public boolean isExistStudent(int id) {
		for (int i = 0; i < listSv.size(); i++) {
			if (id == listSv.get(i).getId()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Sửa thông tin sinh viên theo id
	 * 
	 * @param id
	 */
	public void repair(int id) {
		for (int i = 0; i < listSv.size(); i++) {

			if (listSv.get(i).getId() == id) {

				Scanner sc = new Scanner(System.in);
				System.out.print("Nhập tên SV : ");
				String name = sc.nextLine();
				listSv.get(i).setName(name);
				System.out.print("Nhập tuổi : ");
				int age = sc.nextInt();
				listSv.get(i).setAge(age);
				sc.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = sc.nextLine();
				listSv.get(i).setAddress(address);
				System.out.print("Nhập điểm trung bình : ");
				double gba = sc.nextDouble();
				listSv.get(i).setGba(gba);
				break;
			} else {
				System.out.println("Vui lòng nhập đúng Id của sinh viên:");
			}
		}
	}

	/**
	 * Xóa thông tin sinh viên theo id
	 * 
	 * @param id
	 */
	public void delete(int id) {
		for (int i = 0; i < listSv.size(); i++) {

			if (listSv.get(i).getId() == id) {
				listSv.remove(i);
				break;
			} else {
				System.out.println("Vui lòng nhập đúng Id của sinh viên:");
			}
		}
	}

	/**
	 * menu
	 */
	public void menu() {
		int chooseMenu;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("*********** Manager student name list - Menu ***********");
			System.out.println("* 1 - Thêm thông tin Sinh Viên                                 *");
			System.out.println("* 2 - Hiển thị danh sách sinh viên                          *");
			System.out.println("* 3 - Sửa thông tin sinh viên                          *");
			System.out.println("* 4 - Xóa thông tin sinh viên                          *");
			System.out.println("* 5 - Sắp xếp Sinh viên theo tên                                     *");
			System.out.println("* 6 - Exit program                                     *");
			System.out.println("********************************************************");

			chooseMenu = sc.nextInt();

			switch (chooseMenu) {
			case 1:
				String name = null;
				boolean kiemTra;
				double gba = 0;
				int id = 0;
				int age = 0;

				String a = sc.nextLine();
				SinhVien sv = new SinhVien();
				/**
				 * kiểm tra id đã tồn tại và trống;
				 */

				do {
					kiemTra = false;
					try {

						System.out.println("Nhập id: ");
						a = sc.nextLine();
						if (a.isEmpty())

							throw new Exception("không được để rỗng");

						id = Integer.parseInt(a);

						if (isExistStudent(id)) {
							kiemTra = true;

							throw new Exception("Id này đã tồn tại");

						} else {
							kiemTra = false;
							System.out.println("co the them sinh vien nay");
						}
					} catch (NumberFormatException er) {
						kiemTra = true;
						System.out.println("Vui lòng nhập số không nhập chữ");

					} catch (Exception e) {
						kiemTra = true;
						System.out.println(e.getMessage());
					}

				} while (kiemTra);
				sv.setId(id);
				sc.nextLine();

				/**
				 * kiểm tra Name không được để rỗng và nhập số.
				 */
				do {
					kiemTra = false;
					try {
						System.out.print("Nhập tên SV : ");
						name = sc.nextLine();
						if (name.isEmpty()) {
							kiemTra = true;
							throw new Exception("Không được để rổng họ tên");
						}
						for (int i = 0; i < name.length(); i++) {
							if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != ' ') {
								kiemTra = true;
								throw new Exception("Không được nhập số và ký tự");
							}
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} while (kiemTra);
				sv.setName(name);

				// System.out.print("Nhập tên SV : ");
				// name = sc.nextLine();
				// if(name.isEmpty())
				// throw new Exception("Không được để rổng họ tên");
				//
				// for(int i = 0; i<name.length(); i++) {
				// if(Character.isAlphabetic(name.charAt(i)))
				// throw new Exception("không cho phếp nhập kí tự và số");

				/**
				 * kiểm tra lỗi nhập tuổi
				 */
				do {
					kiemTra = false;
					try {

						System.out.println("Nhập tuổi SV :");
						a = sc.nextLine();
						if (a.isEmpty())
							throw new Exception("không được để rỗng");

						age = Integer.parseInt(a);
						if (age < 0 || age > 100) {
							kiemTra = true;
							throw new Exception("tuổi nhập không nhỏ hơn 0 và lớn hơn 100");
						}
						System.out.println("Tuổi nhập hợp lệ");
					} catch (NumberFormatException er) {
						kiemTra = true;
						System.out.println("bắt buộc phải nhập số nguyên");
					} catch (Exception e) {
						kiemTra = true;
						System.out.println(e.getMessage());
					}
				} while (kiemTra);

				sv.setAge(age);

				sc.nextLine();
				System.out.println("Nhập địa chỉ SV :");
				String address = sc.nextLine();
				sv.setAddress(address);

				/**
				 * kiểm tra lỗi nhập điểm trung bình
				 */
				do {
					kiemTra = false;
					try {

						System.out.println("Nhập điểm SV :");
						a = sc.nextLine();
						if (a.isEmpty())
							throw new Exception("không được để rỗng");

						gba = Integer.parseInt(a);
						if (gba < 0 || gba > 10) {
							kiemTra = true;
							throw new Exception("Điểm nhập không nhỏ hơn 0 và lớn hơn 10");
						}
						System.out.println("điểm nhập hợp lệ");
					} catch (NumberFormatException er) {
						kiemTra = true;
						System.out.println("bắt buộc phải nhập đúng định dạng ");
					} catch (Exception e) {
						kiemTra = true;
						System.out.println(e.getMessage());
					}
				} while (kiemTra);
				sv.setGba(gba);
				addSV(sv);
				break;

			case 2:
				printSV();
				break;
			case 3:
				System.out.println("Nhập ID SV cần sửa :");
				int Id = sc.nextInt();
				repair(Id);
				break;
			case 4:
				System.out.println("Nhập ID SV cần xóa :");
				int iddelete = sc.nextInt();
				delete(iddelete);
				break;
			case 5:
				sort();
				break;
			case 6:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;

			default:
				System.out.println("\n\n\n\n********Menu not exist feature********");
				break;
			}

			System.out.println("\n\n\n\n\n");
		}
	}

	public static void main(String[] args) {
		quanLy_SinhVien qlsv = new quanLy_SinhVien();
		qlsv.menu();

	}
}
