package bai1_quan_ly_sinh_vien_arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListSV {
	private ArrayList<SinhVienArray> listSV;

	public ArrayListSV() {
		listSV = new ArrayList<SinhVienArray>();
	}

	/**
	 * Thêm sinh viên
	 * @param SV
	 */
	public void addSV(SinhVienArray SV) {
		listSV.add(SV);
	}

	/**
	 * Xóa sinh viên theo ten
	 * @param ten
	 */
	public void deleteSV(String ten) {
		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getName().equals(ten)) {
				listSV.remove(i);
				break;
			}
		}
	}

	/**
	 * Hiển thị All sinh viên
	 */
	public void showAll() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < listSV.size(); i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSV.get(i).getName(),
					listSV.get(i).getAge(), listSV.get(i).getAddress(), listSV.get(i).getGpa());
		}
		System.out.println();
		System.out.println();
	}

	/**
	 *  Sắp xếp sinh viên theo tuổi tu thap den cao cách 1
	 */
	public void sapXepAgeTuThapDenCao() {
		Collections.sort(listSV, new SapXepArray() {
			public int compare(SinhVienArray sv1, SinhVienArray sv2) {
				return sv1.getAge() - (sv2.getAge());
			}
		});

	}

	/**
	 * Sắp xếp sinh viên theo tên A-Z
	 */
	public void sapXepNameAtoZ() {
		Collections.sort(listSV, new SapXepArray());
	}

	/**
	 *  Sắp xếp sinh viên theo tuổi tu thap den cao cách 2
	 */
	public void sapXepAgeTuThapDenCaoCach2() {
		for (int i = 0; i < listSV.size() - 1; i++) {
			for (int j = 1; j < listSV.size(); j++) {
				if (listSV.get(i).getAge() > listSV.get(j).getAge()) {
					SinhVienArray temp = listSV.get(i);
					listSV.set(i, listSV.get(j));
					listSV.set(j, temp);
				}
			}
		}

	}

	/**
	 * Sửa đổi thông tin sinh viên theo ten
	 * @param input
	 * @param ten
	 */
	public void repairSV(Scanner input, String ten) {

		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getName().equals(ten)) {
				System.out.print("Nhập tên SV : ");
				String name = input.nextLine();

				System.out.print("Nhập tuổi : ");
				int age = input.nextInt();

				input.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = input.nextLine();

				System.out.print("Nhập điểm trung bình : ");
				double gpa = input.nextDouble();
				SinhVienArray sv = new SinhVienArray();
				sv.setName(name);
				sv.setAge(age);
				sv.setAddress(address);
				sv.setGpa(gpa);
				listSV.set(i, sv);
				break;
			}
		}
		System.out.println("Bạn đã nhập sai!!!!");

	}

	public static void main(String[] args) {
		int tt, luaChon;
		ArrayListSV quanLy = new ArrayListSV();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo tên.");
			System.out.println("3. Xóa sinh viên theo tên  .");
			System.out.println("4. Sắp sếp sinh viên theo tuổi .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();

			switch (luaChon) {
			case 1:
				do {
					String name = null;
					int age = 0;
					double gpa = 0.0;
					boolean kiemTra;
					String ageStr = null;
					
					/**
					 * Kiem tra nhap ten co de trong hay co ki tu so khong, neu co bat nhap lai
					 */
					input.nextLine();
					
					do {
						try {
							kiemTra = false;
							System.out.print("Nhập tên SV : ");
							name = input.nextLine();
							if (name.isEmpty()) {
								throw new Exception("Nhap sai, ten khong duoc de trong");
							} else {
								for (int i = 0; i < name.length(); i++) {
									if (!Character.isLetter(name.charAt(i))
											&& !Character.isWhitespace(name.charAt(i))) {
										throw new Exception("Nhap sai, ten khong co ki tu so");
									}
								}
							}

						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}
					} while (kiemTra);

					/**
					 * Kiem tra nhap tuoi co nho hon 0 hay lon hon 100 khong, neu co bat nhap lai
					 */
					do {
						try {

							kiemTra = false;
							System.out.print("Nhập tuổi : ");
							ageStr = input.nextLine();
							if(ageStr.isEmpty()) {
								throw new Exception("Tuoi khong duoc de trong");
							}
							age = Integer.parseInt(ageStr);						
							if ((age <= 0 || age > 100)) {
								throw new Exception("Tuoi khong duoc nho hon 0 va lon on 100");
							}
						}catch (NumberFormatException e) {
							System.out.println("Tuoi phai la so nguyen");
							kiemTra = true;
						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}

					} while (kiemTra);

					System.out.print("Nhập địa chỉ : ");
					String address = input.nextLine();

					/**
					 * Kiem tra nhap diem trung binh co nho hon 0 hay lon hon 10 khong, neu co bat
					 * nhap lai
					 */
					do {
						try {
							kiemTra = false;
							System.out.print("Nhập điểm trung bình : ");
							gpa = input.nextDouble();
							if (0 < gpa || gpa > 10) {
								throw new Exception("Diem khong duoc nho hon 0 va lon hon 10");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}

					} while (kiemTra);

					SinhVienArray sv = new SinhVienArray(name, age, address, gpa);
					quanLy.addSV(sv);
					
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				System.out.println();
				System.out.print("Nhập tên cần sửa : ");
				input.nextLine();
				String name = input.nextLine();
				quanLy.repairSV(input, name);
				quanLy.showAll();
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập tên cần xóa : ");
				System.out.println();
				input.nextLine();
				String ten = input.nextLine();
				quanLy.deleteSV(ten);
				quanLy.showAll();
				break;
			case 4:
				quanLy.sapXepAgeTuThapDenCao();
				quanLy.showAll();
				break;
			case 5:
				quanLy.showAll();
				break;

			case 0:
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
