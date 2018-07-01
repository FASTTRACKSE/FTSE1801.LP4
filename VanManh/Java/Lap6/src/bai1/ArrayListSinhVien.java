package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListSinhVien {
	private ArrayList<SinhVienArray> listSinhVien;

	public ArrayListSinhVien() {
		listSinhVien = new ArrayList<SinhVienArray>();
	}

	/**
	 * Them sinh vien vao danh sach sinh vien
	 * 
	 * @param SV
	 */
	public void addSV(SinhVienArray SV) {
		listSinhVien.add(SV);
	}

	/**
	 * Xoa sinh vien khoi danh sach sinh vien
	 * 
	 * @param ten
	 */
	public void deleteSV(String ten) {
		SinhVienArray sinhVien = null;
		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getName().equals(ten)) {
				sinhVien = listSinhVien.get(i);
				break;
			}
		}

		if (sinhVien != null) {
			listSinhVien.remove(sinhVien);
		} else {
			System.out.println("Nhap sai ten.");
		}
	}

	/**
	 * Hien thi danh sach sinh vien
	 */
	public void show() {
		System.out.printf("%-5s %-20s %-20s %-6s %-20s %-6s", "ID", "Ma sinh vien", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < listSinhVien.size(); i++) {
			System.out.printf("\n %-4s %-20s %-20s %-6s %-20s %-6s", (i + 1), listSinhVien.get(i).getMaSinhVien(),
					listSinhVien.get(i).getName(), listSinhVien.get(i).getAge(), listSinhVien.get(i).getAddress(),
					listSinhVien.get(i).getGpa());
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * Dung Comparator sap xep theo tuoi tu thap den cao
	 */
	public void sapXepAge() {
		Collections.sort(listSinhVien, new SapXepArray() {
			public int compare(SinhVienArray sv1, SinhVienArray sv2) {
				return sv1.getAge() - (sv2.getAge());
			}
		});

	}

	/**
	 * Sap xep sinh vien theo ten tu a - z
	 */
	public void sapXepNameAToZ() {
		Collections.sort(listSinhVien, new SapXepArray());
	}

	/**
	 * Dung vong lap for sap xep theo tuoi tu thap den cao
	 */
	public void sapXepAgeCach2() {
		for (int i = 0; i < listSinhVien.size() - 1; i++) {
			for (int j = 1; j < listSinhVien.size(); j++) {
				if (listSinhVien.get(i).getAge() > listSinhVien.get(j).getAge()) {
					SinhVienArray temp = listSinhVien.get(i);
					listSinhVien.set(i, listSinhVien.get(j));
					listSinhVien.set(j, temp);
				}
			}
		}

	}

	/**
	 * Sua doi thong tin sinh vien dua vap ten
	 * 
	 * @param input
	 * @param ten
	 */
	public void repairSV(Scanner input, String ten) {

		for (int i = 0; i < listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getName().equals(ten)) {
				String name = null;
				String maSinhVien = null;
				String address = null;
				int age;
				double gpa;
				boolean kiemTra;

				// Kiem tra nhap ten co de trong hay co ki tu so khong, neu co bat nhap lai
				do {
					kiemTra = false;
					System.out.print("Nhập tên sinh vien : ");
					name = input.nextLine();

					if (name.isEmpty()) {
						kiemTra = true;
					} else {
						for (int j = 0; j < name.length(); j++) {
							if (!Character.isLetter(name.charAt(j)) && name.charAt(j) != ' ') {
								kiemTra = true;
								break;
							}
						}
					}
					if (kiemTra) {
						System.out.println("Ten khong the de trong hoac co ki tu so");
					}
				} while (kiemTra);

				// kiem tra ma sinh vien khong duoc trung nhau hoac de trong, neu sai bat nhap
				// lai
				do {
					kiemTra = false;
					System.out.print("Nhập ma sinh vien : ");
					maSinhVien = input.nextLine();
					if (maSinhVien.isEmpty()) {
						kiemTra = true;
					} else {
						for (int j = 0; j < listSinhVien.size(); j++) {
							if (maSinhVien.equals(listSinhVien.get(j).getMaSinhVien())) {
								kiemTra = true;
								break;
							}
						}
					}
					if (kiemTra) {
						System.out.println("ma sinh vien khong duoc de trong hoac da bi trung");
					}
				} while (kiemTra);

				// Kiem tra nhap tuoi co nho hon 0 hay lon hon 100 khong, neu co bat nhap lai
				do {
					kiemTra = false;
					System.out.print("Nhập tuổi : ");
					age = input.nextInt();
					if (age < 0 || age > 100) {
						kiemTra = true;
					}
					if (kiemTra) {
						System.out.println("Tuoi khong the nho hon 0 va lon hon 100");
					}
				} while (kiemTra);

				// Kiem tra dia chi co de trong ko, neu de trong thi bat buoc phai nhap
				input.nextLine();
				do {
					kiemTra = false;
					System.out.print("Nhập địa chỉ : ");
					address = input.nextLine();
					if (address.isEmpty()) {
						kiemTra = true;
						System.out.println("Bat buoc phai nhap dia chi");
					}
				} while (kiemTra);

				// Kiem tra nhap diem trung binh co nho hon 0 hay lon hon 10 khong, neu co bat
				// nhap lai
				do {
					kiemTra = false;
					System.out.print("Nhập điểm trung bình : ");
					gpa = input.nextDouble();
					if (gpa < 0 || gpa > 10) {
						kiemTra = true;
						System.out.println("Diem khong the nho hon 0 va lon hon 10");
					}

				} while (kiemTra);

				System.out.println();
				SinhVienArray sv = new SinhVienArray();
				sv.setName(name);
				sv.setMaSinhVien(maSinhVien);
				sv.setAge(age);
				sv.setAddress(address);
				sv.setGpa(gpa);
				listSinhVien.set(i, sv);
				break;
			}
		}
		System.out.println("Bạn đã nhập sai!!!!");

	}

	public static void main(String[] args) {
		int tiepTuc, luaChon;
		ArrayListSinhVien quanLy = new ArrayListSinhVien();
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

				boolean kiemTra;
				do {
					String name = null;
					String maSinhVien = null;
					String address = null;
					int age;
					double gpa;

					// Kiem tra nhap ten co de trong hay co ki tu so khong, neu co bat nhap lai
					input.nextLine();
					do {
						kiemTra = false;
						System.out.print("Nhập tên sinh vien : ");
						name = input.nextLine();

						if (name.isEmpty()) {
							kiemTra = true;
						} else {
							for (int i = 0; i < name.length(); i++) {
								if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != ' ') {
									kiemTra = true;
									break;
								}
							}
						}
						if (kiemTra) {
							System.out.println("Ten khong the de trong hoac co ki tu so");
						}
					} while (kiemTra);

					// kiem tra ma sinh vien khong duoc trung nhau hoac de trong, neu sai bat nhap
					// lai
					do {
						kiemTra = false;
						System.out.print("Nhập ma sinh vien : ");
						maSinhVien = input.nextLine();
						if (maSinhVien.isEmpty()) {
							kiemTra = true;
						} else {
							for (int i = 0; i < quanLy.listSinhVien.size(); i++) {
								if (maSinhVien.equals(quanLy.listSinhVien.get(i).getMaSinhVien())) {
									kiemTra = true;
									break;
								}
							}
						}
						if (kiemTra) {
							System.out.println("ma sinh vien khong duoc de trong hoac da bi trung");
						}
					} while (kiemTra);

					// Kiem tra nhap tuoi co nho hon 0 hay lon hon 100 khong, neu co bat nhap lai
					do {
						kiemTra = false;
						System.out.print("Nhập tuổi : ");
						age = input.nextInt();
						if (age < 0 || age > 100) {
							kiemTra = true;
						}
						if (kiemTra) {
							System.out.println("Tuoi khong the nho hon 0 va lon hon 100");
						}
					} while (kiemTra);

					// Kiem tra dia chi co de trong ko, neu de trong thi bat buoc phai nhap
					input.nextLine();
					do {
						kiemTra = false;
						System.out.print("Nhập địa chỉ : ");
						address = input.nextLine();
						if (address.isEmpty()) {
							kiemTra = true;
							System.out.println("Bat buoc phai nhap dia chi");
						}
					} while (kiemTra);

					// Kiem tra nhap diem trung binh co nho hon 0 hay lon hon 10 khong, neu co bat
					// nhap lai
					do {
						kiemTra = false;
						System.out.print("Nhập điểm trung bình : ");
						gpa = input.nextDouble();
						if (gpa < 0 || gpa > 10) {
							kiemTra = true;
							System.out.println("Diem khong the nho hon 0 va lon hon 10");
						}

					} while (kiemTra);

					SinhVienArray sinhVien = new SinhVienArray(name, maSinhVien, age, address, gpa);
					quanLy.addSV(sinhVien);

					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tiepTuc = input.nextInt();
					System.out.println();
				} while (tiepTuc == 1);

				break;
			case 2:
				System.out.println();
				System.out.print("Nhập tên cần sửa : ");
				input.nextLine();
				String name = input.nextLine();
				quanLy.repairSV(input, name);
				quanLy.show();
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập tên cần xóa : ");
				System.out.println();
				input.nextLine();
				String ten = input.nextLine();
				quanLy.deleteSV(ten);
				quanLy.show();
				break;
			case 4:
				quanLy.sapXepAge();
				quanLy.show();
				break;
			case 5:
				quanLy.show();
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
