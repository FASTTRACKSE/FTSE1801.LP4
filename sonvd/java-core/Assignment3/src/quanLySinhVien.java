
//import java.util.Scanner;

public class quanLySinhVien {
	public int id;
	private String name;
	private int age;
	private String address;
	private double gpa;
	/**
	 * Quan ly sinh vien
	 * 
	 * @author VDSon
	 *
	 */
	public quanLySinhVien[] listSv = new quanLySinhVien[100];

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public quanLySinhVien[] getListSv() {
		return listSv;
	}

	public void setListSv(quanLySinhVien[] listSv) {
		this.listSv = listSv;
	}

//	public void menu() {
//		int chooseMenu;
//		Scanner input = new Scanner(System.in);
//
//		String Name;
//		int Age;
//		String Address;
//		double Gpa;
//
//		while (true) {
//			System.out.println("/****************************************/");
//			System.out.println("1. Thêm sinh viên");
//			System.out.println("2. Cập nhật thông tin sinh viên theo ID");
//			System.out.println("3. Xóa sinh viên theo ID");
//			System.out.println("4. Sắp sếp sinh viên theo tên");
//			System.out.println("5. Hiển thị danh sách sinh viên");
//			System.out.println("0. Kết thúc chương trình.");
//			System.out.println("/****************************************/");
//
//			chooseMenu = input.nextInt();
//
//			switch (chooseMenu) {
//			case 1:
//				input.nextLine();
//				System.out.println("Nhập tên sinh viên: ");
//				Name = input.nextLine();
//				System.out.println("Nhập tuổi sinh viên: ");
//				Age = input.nextInt();
//				input.nextLine();
//				System.out.println("Nhập địa chỉ sinh viên: ");
//				Address = input.nextLine();
//				System.out.println("Nhập điểm trung bình: ");
//				Gpa = input.nextDouble();
//
//				addSV(Name, Age, Address, Gpa);
//				break;
//			case 2:
//				System.out.println("Nhập Id cần sửa: ");
//				int update = input.nextInt();
//				updateSV(update);
//				break;
//			case 3:
//				System.out.println("Nhập Id cần xóa: ");
//				int del = input.nextInt();
//				deleteSV(del);
//				break;
//			case 4:
//				sortSV();
//				break;
//			case 5:
//				display();
//				break;
//			case 0:
//				input.close();
//				System.out.println("Kết thúc chương trình!!!");
//				System.exit(0);
//			default:
//				System.out.println("Menu không tồn tại!!!");
//				break;
//			}
//		}
//	}
//
//	public void addSV(String Name, int Age, String Address, double Gpa) {
//		quanLySinhVien sv = new quanLySinhVien();
//
//		sv.name = Name;
//		sv.age = Age;
//		sv.address = Address;
//		sv.gpa = Gpa;
//		listSv[id] = sv;
//		id++;
//		System.out.println("Được thêm thành công!");
//	}
//
//	public void updateSV(int idsinhvien) {
//		Scanner input = new Scanner(System.in);
//		quanLySinhVien update = new quanLySinhVien();
//		System.out.println("Nhập tên sinh viên: ");
//		String Name = input.nextLine();
//		System.out.println("Nhập tuổi sinh viên: ");
//		int Age = input.nextInt();
//		input.nextLine();
//		System.out.println("Nhập địa chỉ sinh viên:");
//		String Address = input.nextLine();
//		System.out.println("Nhập điểm trung bình: ");
//		double Gpa = input.nextDouble();
//
//		update.setName(Name);
//		update.setAge(Age);
//		update.setAddress(Address);
//		update.setGpa(Gpa);
//		listSv[idsinhvien - 1] = update;
//		System.out.println("Được cập nhập thành công!");
//	}
//
//	public void deleteSV(int del) {
//		for (int i = del; i < id; i++) {
//			listSv[i - 1] = listSv[i];
//		}
//		id = id - 1;
//		System.out.println("Được xóa thành công !");
//	}
//
//	public void sortSV() {
//		quanLySinhVien temp = new quanLySinhVien();
//		for (int i = 0; i < id - 1; i++) {
//			for (int j = i + 1; j < id; j++) {
//				if (listSv[i].getGpa() < listSv[j].getGpa()) {
//					temp = listSv[i];
//					listSv[i] = listSv[j];
//					listSv[j] = temp;
//				}
//			}
//		}
//		System.out.println("Được sắp xếp thành công!");
//	}
//
//	public void display() {
//		System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", "Id", "Tên sinh viên", "Tuổi", "Địa chỉ", "Trung bình");
//		if (id != 0) {
//			for (int i = 0; i < id; i++) {
//				System.out.format("%3s|%-30s|%9s|%-30s|%9s%n", i + 1, listSv[i].getName(), listSv[i].getAge(),
//						listSv[i].getAddress(), listSv[i].getGpa());
//			}
//		} else {
//			System.out.println("Không có tên sinh viên trong danh sách!!!");
//		}
//		System.out.println("\n\n");
//	}
//
//	public static void main(String[] args) {
//		quanLySinhVien qlsv = new quanLySinhVien();
//		qlsv.menu();
//	}
}
