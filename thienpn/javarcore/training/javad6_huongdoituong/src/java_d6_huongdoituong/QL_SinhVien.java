package java_d6_huongdoituong;


import java.util.Scanner;

public class QL_SinhVien {
	// thuộc tính;
	public int id = 0;
	private String name;
	private int age;
	private String address;
	private double gba;

	public QL_SinhVien[] listSV = new QL_SinhVien[100];

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

	public double getGba() {
		return gba;
	}

	public void setGba(double gba) {
		this.gba = gba;
	}

	public QL_SinhVien[] getListSV() {
		return listSV;
	}

	public void setListSV(QL_SinhVien[] listSV) {
		this.listSV = listSV;
	}

	//
	public void ThemSV(String Name, int Age, String Address, double Gba) {
		QL_SinhVien sv = new QL_SinhVien();

		sv.name = Name;
		sv.age = Age;
		sv.address = Address;
		sv.gba = Gba;
		listSV[id] = sv;
		id++;
	}

	public void inputDS() {
		QL_SinhVien sv = new QL_SinhVien();
		    System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n","ID","Name","Age","Address","Gba");
		for (int i = 0; i < id; i++) {
			
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n",i+1,listSV[i].getName(),listSV[i].getAge(),listSV[i].getAddress(),listSV[i].getGba());
			
		}

	}

	public void repair(int idsv) {
		Scanner sc = new Scanner(System.in);
		QL_SinhVien repair = new QL_SinhVien();
		System.out.print("Nhập tên SV : ");
		String Name = sc.nextLine();

		System.out.print("Nhập tuổi : ");
		int Age = sc.nextInt();

		sc.nextLine();
		System.out.print("Nhập địa chỉ : ");
		String Address = sc.nextLine();

		System.out.print("Nhập điểm trung bình : ");
		double Gpa = sc.nextDouble();

		repair.setName(Name);
		repair.setAge(Age);
		repair.setAddress(Address);
		repair.setGba(Gpa);
		listSV[idsv - 1] = repair;
	}

	public void delete(int iddelete) {
         for(int i = iddelete;i<id;i++) {
        	 listSV[i-1] = listSV[i];
        	 
         }
             id = id -1 ;
	}     
	public void sapxep() {

	}

	public void menu() {

		int chooseMenu;
		Scanner sc = new Scanner(System.in);

		String Name;
		int Age;
		String Address;
		double Gba;

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
				sc.nextLine();
				System.out.println("Nhập tên SV :");
				Name = sc.nextLine();
				
				System.out.println("Nhập tuổi SV :");
                Age = sc.nextInt();
                sc.nextLine();
				System.out.println("Nhập địa chỉ SV :");
				Address = sc.nextLine();
				
				System.out.println("Nhập điểm trung bình của SV :");
				Gba = sc.nextDouble();
				ThemSV(Name, Age, Address, Gba);
				break;

			case 2:
				inputDS();
				break;
			case 3:
				System.out.println("Nhập ID SV cần sửa :");
				int idsv = sc.nextInt();
				repair(idsv);
				break;
			case 4:
				System.out.println("Nhập ID SV cần xóa :");
				int iddelete = sc.nextInt();
				delete(iddelete);
				break;
			case 5:
				sapxep();
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
		QL_SinhVien show = new QL_SinhVien();
		show.menu();
	}
}
