import java.util.Scanner;

public class QuanLySinhVien {
	public static int id = 0;
	private String name;
	private int age;
	private String address;
	private double gpa;

	public static QuanLySinhVien[] listSinhVien = new QuanLySinhVien[100];
	
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
	//Thêm sinh viên
	public void addSV(QuanLySinhVien sinhVien) {
		listSinhVien[id] = sinhVien;
		id++;
	}
	//Xóa sinh viên
	public void deleteSV(int idDelete) {
		for (int i = idDelete; i < id; i++) {
			listSinhVien[i-1] = listSinhVien[i];
		}
		id = id-1;
	}
	// Hiển thị danh sách sinh viên
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s","ID", "Tên", "Tuổi", "Địa chỉ" ,"ĐTB" );
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f",(i+1),listSinhVien[i].getName(),listSinhVien[i].getAge(),listSinhVien[i].getAddress(),listSinhVien[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}
	//Sửa đổi thông tin sinh viên
	public void repairSV(Scanner input, int id) {
		QuanLySinhVien repair = new QuanLySinhVien();
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
		listSinhVien[id-1] = repair;
	}
	
	//Sắp xếp danh sách sinh viên theo tuổi
	public void sapXep() {
		QuanLySinhVien sapXepSV = new QuanLySinhVien();
		for(int i = 0; i < id-1 ; i++) {
			for(int j = 1; j < id ; j++) {
				if(listSinhVien[i].getAge() > listSinhVien[j].getAge()) {
					sapXepSV = listSinhVien[i];
					listSinhVien[i]=listSinhVien[j];
					listSinhVien[j] = sapXepSV;
				}
			}
		}
		sapXepSV.show();
	}

	public static void menu() {
		int tt, luaChon;
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID.");
			System.out.println("3. Xóa sinh viên theo ID  .");
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
					QuanLySinhVien qlsv = new QuanLySinhVien();
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
	
					qlsv.setName(name);
					qlsv.setAge(age);
					qlsv.setAddress(address);
					qlsv.setGpa(gpa);
					qlsv.addSV(qlsv);
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
				QuanLySinhVien repair = new QuanLySinhVien();
				repair.repairSV(input, idRepair);
				break;
				
			case 3:
				System.out.println();
				System.out.print("Nhập ID cần xóa : ");
				System.out.println();
				int idDelete = input.nextInt();
				QuanLySinhVien delete = new QuanLySinhVien();
				delete.deleteSV(idDelete);
				break;
			case 4:
				QuanLySinhVien sapXep = new QuanLySinhVien();
				sapXep.sapXep();
				break;
			case 5:
				QuanLySinhVien in = new QuanLySinhVien();
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