package lap;

import java.util.Scanner;

public class MangSinhVien {

	public static int id = 0;
	private String name;
	private int age;
	private String address;
	private double gpa;

	public static MangSinhVien[] listSinhVien = new MangSinhVien[100];

	public int getId() {
		return id;
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

	//sắp xếp sinh viên theo tuổi
	public void SortSV() {
		MangSinhVien SortSv=new MangSinhVien();
		for(int i=0; i<id-1;i++) {
			for(int j=1; j<id; j++) {
				if(listSinhVien[i].getGpa()>listSinhVien[j].getGpa()) {
					SortSv=listSinhVien[i];
					listSinhVien[i]=listSinhVien[j];
					listSinhVien[j]=SortSv;
				}
			}
		}
		SortSv.show();
		
	}

	//mang sinh vien
	public void addSV(MangSinhVien sinhVien) {
		listSinhVien[id] = sinhVien;
		id++;
	}

	//xóa sinh vien theo id
	public void deleteSV(int idDelete) {
		for (int i = idDelete; i < id; i++) {
			listSinhVien[i - 1] = listSinhVien[i];
		}
		id = id - 1;
	}

	//hiển thị sinh vien 
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSinhVien[i].getName(),
					listSinhVien[i].getAge(), listSinhVien[i].getAddress(), listSinhVien[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}

	//cập nhật sinh viên
	public void repairSV(Scanner input, int id) {
		MangSinhVien repair = new MangSinhVien();
		input.nextLine();
		System.out.print("Nhập tên SV : ");
		String name = input.nextLine();

		System.out.print("Nhập tuổi : ");
		int age = input.nextInt();

		input.nextLine();
		System.out.print("Nhập địa chỉ : ");
		String address = input.nextLine();

		System.out.print("Nhập điểm trung bình : ");
		double gpa = input.nextDouble();

		repair.setName(name);
		repair.setAge(age);
		repair.setAddress(address);
		repair.setGpa(gpa);
		listSinhVien[id] = repair;
	}

	// menu
	public static void menu() {
		int tt, luaChon;
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID.");
			System.out.println("3. Xóa sinh viên theo ID  .");
			System.out.println("4. Sắp sếp sinh viên theo điểm .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					MangSinhVien msv = new MangSinhVien();

					input.nextLine();
					System.out.print("Nhập tên SV : ");
					String name = input.nextLine();

					System.out.print("Nhập tuổi : ");
					int age = input.nextInt();

					input.nextLine();
					System.out.print("Nhập địa chỉ : ");
					String address = input.nextLine();

					System.out.print("Nhập điểm trung bình : ");
					double gpa = input.nextDouble();

					msv.setName(name);
					msv.setAge(age);
					msv.setAddress(address);
					msv.setGpa(gpa);
					msv.addSV(msv);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);

				break;
			case 2:
				System.out.println();
				System.out.print("Nhập ID cần sửa : ");
				int idRepair = input.nextInt();
				System.out.println();
				MangSinhVien repair = new MangSinhVien();
				repair.repairSV(input, idRepair);
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập ID cần xóa : ");
				System.out.println();
				int idDelete = input.nextInt();
				MangSinhVien delete = new MangSinhVien();
				delete.deleteSV(idDelete);
				break;

			case 4:
				MangSinhVien sapXep= new MangSinhVien();
				sapXep.SortSV();
				break;
				
			case 5:
				MangSinhVien in = new MangSinhVien();
				in.show();
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

	public static void main(String[] args) {
		menu();
	}

}
