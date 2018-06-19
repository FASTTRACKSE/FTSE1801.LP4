import java.util.Scanner;

public class QlSinhVien {
	static int id;
	static String name;
	static int age;
	static String address;
	static double gpa;
	static QlSinhVien sv = new QlSinhVien();

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
	public static  void menu() {
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
			case 1:System.out.println("Thêm sinh viên");
					addSV();
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
			case 0:System.out.println("Chương trình kết thúc");break;
		}

	}
	public static void addSV() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập id: ");
		sv.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhập tên sinh viên: ");
		sv.setName(sc.nextLine());
		System.out.println("Nhập tuổi: ");
		sv.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhập địa chỉ: ");
		sv.setAddress(sc.nextLine());
		System.out.println("Nhập điểm trung bình: ");
		sv.setGpa(sc.nextDouble());
		sc.nextLine();
		System.out.println("Bạn muốn tiếp tục không 0 - Không|1 - Có");
		int chon = sc.nextInt();
		if(chon == 1) {
			addSV();
		}else {
			showSV();
			end();
		}
		
	}
	
	public static void updateSV() {
		
	}
	
	public static void deleteSV() {
		
	}
	
	public static void sapXepSV() {
		
	}
	public static void end() {
		System.out.println("Chương trình kết thúc!!!!");
		System.exit(0);
	}
	public static void xuat() {
		
	}
	public static void showSV() {
		System.out.printf("%3s| %20s| %10s| %20s| %10s| \n","Id","Name","Age","Address","Gpa");
		System.out.printf("%3s| %20s| %10s| %20s| %10s| \n",sv.getId(),sv.getName(),sv.getAge(),sv.getAddress(),sv.getGpa());
	}
	public static void main(String[] args) {
		menu();		
	}
}
