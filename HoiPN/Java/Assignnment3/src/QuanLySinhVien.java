import java.util.Scanner;

public class QuanLySinhVien {
	private int id=0;
	private String name;
	private int age;
	private String address;
	private double gpa;
	
	public static QuanLySinhVien[] listSv =new QuanLySinhVien[100];
	
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
	
	public static QuanLySinhVien[] getListSv() {
		return listSv;
	}

	public static void setListSv(QuanLySinhVien[] listSv) {
		QuanLySinhVien.listSv = listSv;
	}
	public void addSV(String ten, int tuoi,String diaChi, double diem) {
		QuanLySinhVien sv= new QuanLySinhVien();
		
		Scanner sc= new Scanner(System.in);
		
			
		sv.name = ten;
		sv.age = tuoi;
		sv.address = diaChi;
		sv.gpa = diem;
		listSv[id] = sv;
		id++;
	}
	public void nhap() {
		
	}
	public void menu() {
		System.out.println("/****************************************/");
		System.out.println("1.Thêm sinh viên.");
		System.out.println("2.Cập nhật thông tin sinh viên theo ID.");
		System.out.println("3.Xóa sinh viên theo ID.");
		System.out.println("4.Sắp xếp sinh viên theo tên.");
		System.out.println("5.Hiển thị danh sách sinh viên");
		System.out.println("0.Kết thúc chương trình.");
		System.out.println("/****************************************/");
		Scanner sc  = new Scanner(System.in);
		int so = sc.nextInt();
		switch(so) {
			case 1:
			System.out.println("Thêm sinh viên");
			System.out.println("Nhập tên sinh viên: ");
			String ten = sc.nextLine();
			sc.nextLine();
			System.out.println("Nhập tuổi: ");
			int tuoi = (sc.nextInt());
			sc.nextLine();
			System.out.println("Nhập địa chỉ: ");
			String diaChi = (sc.nextLine());
			System.out.println("Nhập điểm trung bình: ");
			double diem = (sc.nextDouble());
			sc.nextLine();
			System.out.println("Bạn muốn tiếp tục không 0 - Không|1 - Có");
			int chon = sc.nextInt();
			sc.nextLine();
			if(chon == 1) {
				addSV(ten,tuoi,diaChi,diem);
			}
			menu();
			break;
			case 2:System.out.println("Cập nhật thông tin sinh viên theo ID");
				    updateSV();
			break;
			case 3: System.out.println("Sắp xếp sinh viên theo tên");
					deleteSV();
			break;
			case 4:System.out.println("Sắp xếp sinh viên theo tên");
			 		sapXepSV();
			break;
			case 5:System.out.println("Hiển thị danh sách sinh viên");
					showSV();
			break;
			case 0:System.out.println("Chương trình kết thúc");
					end();
			break;
		}

	}


	public void updateSV() {
		
	}
	
	public void deleteSV() {
		
	}
	
	public void sapXepSV() {
		
	}
	public void end() {
		System.exit(0);
	}

	public void showSV() {
		System.out.printf("%3s| %20s| %10s| %20s| %10s| \n","Id","Name","Age","Address","Gpa");
		for(int i=0;i<id;i++) {		
			System.out.printf("%3s| %20s| %10s| %20s| %10s| \n",(i+1),listSv[i].getName(),listSv[i].getAge(),listSv[i].getAddress(),listSv[i].getGpa());
		}
	}
	public static void main(String[] args) {
		QuanLySinhVien qlsv =new QuanLySinhVien();
		qlsv.menu();
	}
}
