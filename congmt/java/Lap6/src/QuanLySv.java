
import java.util.Scanner;

/**
 * Class QuanLySv
 * 
 * @author CôngMT
 *
 */
public class QuanLySv {
	private Student[] listSinhVien;
	private int soluongSv;
	private int id = 0;

	public QuanLySv() {
		listSinhVien = new Student[100];
		soluongSv = 0;
	}

	/**
	 * Add Student
	 * 
	 * @param sv
	 */
	public void addSv(Student sv) {
		listSinhVien[soluongSv] = sv;
		soluongSv += 1;
	}

	/**
	 * Update Student
	 * 
	 * @param sc
	 * @param id
	 */

	public void updateSv(Scanner sc, int id) {
		boolean isExisted = false;

		int size = soluongSv;

		for (int i = 0; i < size; i++) {
			Student sv = listSinhVien[i];
			if (sv.getId().equals(id)) {
				isExisted = true;
				sc.nextLine();
				System.out.println("- Nhập tên sinh viên:");
				String name = sc.nextLine();
				sv.setName(name);
				System.out.println("- Nhập tuổi sinh viên:");
				byte age = sc.nextByte();
				sc.nextLine();
				sv.setAge(age);
				System.out.println("- Nhập địa chỉ sinh viên:");
				String address = sc.nextLine();
				sv.setAddress(address);
				System.out.println("- Nhập điểm trung bình:");
				float gpa = sc.nextFloat();
				sv.setGpa(gpa);

				break;
			}
		}
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		}
	}

	public void deletelSv(String id) {
		boolean isExisted = false;

		int size = soluongSv;
		for (int i = 0; i < listSinhVien.length - 1; i++) {
			Student sv = listSinhVien[i];
			isExisted = true;
			if (sv.getId().equals(id)) {
				for (int j = 0; j < listSinhVien.length - 1; j++) {
					listSinhVien[j] = listSinhVien[j + 1];
					break;
				}

			}
		}
		listSinhVien[listSinhVien.length - 1] = null;
		soluongSv -= 1;
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		}

	}

	/**
	 * Sắp xếp Student tăng dần
	 */

	public void sapXepTangDan() {
		Student sapxep = new Student();

		for (int i = 0; i < id - 1; i++) {
			for (int j = 1; j < id; j++) {
				if (listSinhVien[i].getAge() > listSinhVien[j].getAge()) {
					listSinhVien[i] = sapxep;
					listSinhVien[i] = listSinhVien[j];
					listSinhVien[j] = sapxep;
				}
			}
		}

	}

	public boolean isExistStudent(String id) {
		for (int i = 0; i < soluongSv; i++) {
			if (listSinhVien[i].getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Hiển thị DS Student
	 */

	public void displayAllSv() {
		System.out.printf("%-3s %-20s %-6s %-20s %-6s \n", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐiểmTB");
		System.out.println();

		for (int i = 0; i < soluongSv; i++) {
			System.out.printf(" %-3s %-20s %-6s %-20s %-6s \n", listSinhVien[i].getId(), listSinhVien[i].getName(),
					listSinhVien[i].getAge(), listSinhVien[i].getAddress(), listSinhVien[i].getGpa());
			;
			System.out.println();
			System.out.println();

		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		QuanLySv qlsv = new QuanLySv();
		Student sv1;
		int tt, luaChon;
		while (true) {

			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhập sinh viên  theo ID.");
			System.out.println("3. Xóa sinh viên theo ID  .");
			System.out.println("4. Sắp xếp sinh viên theo tuoi .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn lựa chọn : ");
			luaChon = sc.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					sv1 = new Student();
					boolean kiemTra;
					String id = null;
					/**
					 * Kiểm tra tuổi có được nhập đúng ký tự hay không
					 */
					do {
						kiemTra = false;

						try {
							System.out.println("-  Nhập MSSV:");
							id = sc.nextLine();

							if (id.isEmpty()) {
								throw new Exception("Không được để trống. Mời bạn nhập lại.!!");
							} else if (qlsv.isExistStudent(id)) {
								throw new Exception("ton tai sinh vien nay roi");
							} else {
								System.out.println("Co the dung ID này");
							}

						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}

					} while (kiemTra);
					sv1.setId(id);

					/**
					 * Kiểm tra tên có được nhập đúng ký tự hay không
					 */
					do {
						kiemTra = false;
						String name = null;
						try {
							System.out.println("-  Nhập tên sinh viên:");
							name = sc.nextLine();
							sv1.setName(name);
							if (name.isEmpty()) {
								throw new Exception("Tên đăng nhập không để rỗng!!");
							}
							for (int i = 0; i < name.length(); i++) {
								if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != ' ') {
									throw new Exception("Không được nhập số hoặc để trống!!");
								}
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}
					} while (kiemTra);
					/**
					 * Kiem tra tuoi nho hon 1 hay lon hon 100 hay khong
					 */
					do {
						kiemTra = false;
						int age;
						String ageStr = null;
						try {
							System.out.println("-  Nhập tuổi sinh viên:");
							ageStr = sc.nextLine();

							if (ageStr.isEmpty()) {
								throw new Exception("Không được để trống. Mời bạn nhập lại.!!");
							}
							age = Integer.parseInt(ageStr);
							sv1.setAge(age);
							if (age <= 0 || age > 100) {
								throw new Exception("Tuổi bạn nhập không được nhỏ hơn 1 và lớn hơn 100!!");
							}
						} catch (NumberFormatException er) {
							System.out.println("Bắt buộc phải nhập số nguyên.");
							kiemTra = true;
						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}
					} while (kiemTra);
					/**
					 * Kiểm tra địa chỉ có được nhập đúng ký tự hay không
					 */
					do {
						kiemTra = false;
						String address = null;
						try {
							System.out.println("-  Nhập địa chỉ sinh viên:");
							address = sc.nextLine();
							sv1.setAddress(address);
							if (address.isEmpty()) {
								throw new Exception("So ban nhap khong hop le!!");
							}
							for (int i = 0; i < address.length(); i++) {
								if (!Character.isLetter(address.charAt(i)) && address.charAt(i) != ' ') {

									throw new Exception("Không được nhập số hoặc để trống!!");
								}
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}
					} while (kiemTra);

					/**
					 * Kiem tra điểm trung binh nho hon 1 hay lon hon 10 hay khong
					 */
					do {
						kiemTra = false;
						float gpa;
						try {
							System.out.println("-  Nhập điểm trung bình:");
							gpa = sc.nextFloat();
							sv1.setGpa(gpa);
							;
							if (gpa <= 0 || gpa > 10) {
								throw new Exception("Điểm bạn nhập không được nhỏ hơn 0 và lớn hơn 10!!");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							kiemTra = true;
						}
					} while (kiemTra);
					
					qlsv.addSv(sv1);
					System.out.println();
					System.out.print("Bạn có muốn tiếp tục không: (0:không | 1:Có) ");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				System.out.println();
				System.out.print("Nhập Id cần sửa : ");
				int update1 = sc.nextInt();
				qlsv.updateSv(sc, update1);
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập Id cần xóa: ");
				System.out.println();
				String idDelete = sc.nextLine();
				qlsv.deletelSv(idDelete);
				break;
			case 4:
				qlsv.sapXepTangDan();
				break;
			case 5:
				qlsv.displayAllSv();
				break;

			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng. Mời chọn lại.");
				break;
			}
		}
	}

}
