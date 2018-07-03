package ql_sinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import quanlysv.quanly.SinhVien;

public class hienthiDS_SinhVien {
	private ArrayList<SinhVien> listSv;

	public hienthiDS_SinhVien() {
		listSv = new ArrayList<SinhVien>();
	}

	// thêm sinh viên:
	public void addSV(SinhVien sv) {
		listSv.add(sv);
	}

	// In danh sách;
	public void printSV() {

		System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", "ID", "Name", "Age", "Address", "Gba");
		for (int i = 0; i < listSv.size(); i++) {
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", listSv.get(i).getId(), listSv.get(i).getName(),
					listSv.get(i).getAge(), listSv.get(i).getAddress(), listSv.get(i).getGpa());
		}
	}

	// Sắp xếp theo tên:
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

	// Sửa:
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
				double gpa = sc.nextDouble();
				listSv.get(i).setGpa(gpa);
				break;
			} else {
				System.out.println("Vui lòng nhập đúng Id của sinh viên:");
			}
		}
	}

	// Xóa:
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

	public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);
		hienthiDS_SinhVien ql = new hienthiDS_SinhVien();

		while (true) {
			System.out.println("*********** Menu ***********");
			System.out.println("* 1 - Thêm thông tin Sinh Viên*");
			System.out.println("* 2 - Hiển thị danh sách sinh viên*");
			System.out.println("* 3 - Sửa thông tin sinh viên*");
			System.out.println("* 4 - Xóa thông tin sinh viên*");
			System.out.println("* 5 - Sắp xếp Sinh viên theo tên*");
			System.out.println("* 6 - Exit program*");
			System.out.println("*****************************");

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
						kiemTra = true;
						System.out.println("Nhập id: ");
						a = sc.nextLine();
						if (a.isEmpty())

							throw new Exception("Không được để rỗng, vui lòng nhập lại");

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
							throw new Exception("Điểm nhập từ 0 -> 10, vui lòng nhập lại!!!");
						} else {
							kiemTra = false;
							System.out.println("Điểm nhập hợp lệ!!!");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} while (kiemTra);
				sv.setGpa(gba);
				addSV(sv);
				break;

			case 2:
				ql.printSV();
				break;
			case 3:
				System.out.println("Nhập ID SV cần sửa :");
				int Id = sc.nextInt();
				ql.repair(Id);
				break;
			case 4:
				System.out.println("Nhập ID SV cần xóa :");
				int iddelete = sc.nextInt();
				ql.delete(iddelete);
				break;
			case 5:
				ql.sort();
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
		hienthiDS_SinhVien qlsv = new hienthiDS_SinhVien();
		qlsv.menu();

	}
}