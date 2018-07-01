package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author HieuHT
 *
 */
public class danhSachSV {

	private ArrayList<sinhVien> listSV;

	public danhSachSV() {

		listSV = new ArrayList<sinhVien>();
	}

	/**
	 * nhập Sinh Viên
	 * 
	 * @param sv1
	 */
	public void addSV(sinhVien sv1) {

		listSV.add(sv1);
	}

	/**
	 * Hiển thị danh sách sinh viên
	 */
	public void printSV() {

		System.out.printf("%5s|%-20s|%5s|%-20s|%6s %n", "ID", "Họ và tên", "Tuổi", "Địa chỉ", "ĐiểmTB");
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%6s %n", listSV.get(i).getId(), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGba());
		}
	}

	/**
	 * Sắp xếp sinh viên theo tên a-z
	 */
	public void sort() {
		Collections.sort(listSV, new Comparator<sinhVien>() {

			public int compare(sinhVien o1, sinhVien o2) {

				return o1.getName().compareToIgnoreCase(o2.getName());
			}

		});
	}

	/**
	 * Hàm điều kiện trung lặp id
	 * 
	 * @param id
	 */
	public boolean isExistStudent(int id) {
		for (int i = 0; i < listSV.size(); i++) {
			if (id == listSV.get(i).getId()) {
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
		for (int i = 0; i < listSV.size(); i++) {

			if (listSV.get(i).getId() == id) {

				Scanner sc = new Scanner(System.in);
				System.out.print("Nhập tên SV : ");
				String name = sc.nextLine();
				listSV.get(i).setName(name);
				System.out.print("Nhập tuổi : ");
				int age = sc.nextInt();
				listSV.get(i).setAge(age);
				sc.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = sc.nextLine();
				listSV.get(i).setAddress(address);
				System.out.print("Nhập điểm trung bình : ");
				double gba = sc.nextDouble();
				listSV.get(i).setGba(gba);
				break;
			} else {
				System.out.println("Vui lòng nhập đúng id của sinh viên:");
			}
		}
	}

	/**
	 * Xóa thông tin sinh viên theo id
	 * 
	 * @param id
	 */
	public void delete(int id) {
		for (int i = 0; i < listSV.size(); i++) {

			if (listSV.get(i).getId() == id) {
				listSV.remove(i);
				break;
			} else {
				System.out.println("Vui lòng nhập đúng id của sinh viên:");
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
			System.out.println("Danh sách sinh viên - Menu");
			System.out.println("1 - Thêm thông tin Sinh Viên");
			System.out.println("2 - Hiển thị danh sách sinh viên");
			System.out.println("3 - Sửa thông tin sinh viên");
			System.out.println("4 - Xóa thông tin sinh viên");
			System.out.println("5 - Sắp xếp Sinh viên theo tên");
			System.out.println("6 - Exit program");
			System.out.println("****************");

			chooseMenu = sc.nextInt();

			switch (chooseMenu) {
			case 1:
				String name = null;
				boolean kiemTra;
				double gba = 0;
				int id = 0;
				int age = 0;
				String a = sc.nextLine();
				sinhVien sv = new sinhVien();
				/**
				 * kiểm tra id đã tồn tại và trống;
				 */

				do {
					kiemTra = false;
					try {
						kiemTra = true;
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
							System.out.println("Có thể thêm sinh viên này");
						}
					} catch (NumberFormatException er) {

						System.out.println("Vui lòng nhập số không nhập chữ");

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} while (kiemTra);
				sv.setId(id);
				sc.nextLine();

				/**
				 * kiểm tra tên không được để rỗng và nhập số.
				 */
				do {
					kiemTra = false;
					try {
						System.out.print("Nhập tên SV : ");
						name = sc.nextLine();
						if (name.isEmpty()) {
							kiemTra = true;
							throw new Exception("Không được để rỗng họ tên");
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
				// throw new Exception("Không được để rỗng họ tên");
				//
				// for(int i = 0; i<name.length(); i++) {
				// if(Character.isAlphabetic(name.charAt(i)))
				// throw new Exception("không cho phép nhập kí tự và số");

				/**
				 * kiểm tra lỗi nhập tuổi
				 */
				do {
					kiemTra = false;
					try {

						System.out.println("Nhập tuổi SV :");
						a = sc.nextLine();
						if (a.isEmpty())
							throw new Exception("Vui lòng nhập!!!");

						age = Integer.parseInt(a);
						if (age < 0 || age > 100) {
							kiemTra = true;
							throw new Exception("Nhập tuổi phải từ 1 -> 100");
						}
						System.out.println("Tuổi nhập hợp lệ!!!");
					} catch (NumberFormatException er) {
						kiemTra = true;
						System.out.println("Vui lòng nhập số nguyên!!!");
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
						System.out.println("Nhập điểm trung bình của SV :");
						gba = sc.nextDouble();
						if (gba < 0 || gba > 10) {
							kiemTra = true;
							throw new Exception("Điểm không nhỏ hơn 0 và lớn hơn 10");
						}
							kiemTra = false;
							System.out.println("Điểm nhập hợp lệ");
						
					} catch (Exception e) {
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
				System.out.println("Nhập id SV cần sửa :");
				int Id = sc.nextInt();
				repair(Id);
				break;
			case 4:
				System.out.println("Nhập id SV cần xóa :");
				int iddelete = sc.nextInt();
				delete(iddelete);
				break;
			case 5:
				sort();
				break;
			case 6:
				sc.close();
				System.out.println("Tạm biệt");
				System.exit(0);
				break;

			default:
				System.out.println("Menu không tồn tại");
				break;
			}

			System.out.println("\n\n\n\n\n");
		}
	}

	public static void main(String[] args) {
		danhSachSV qlsv = new danhSachSV();
		qlsv.menu();

	}
}