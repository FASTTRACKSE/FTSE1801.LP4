import java.util.Scanner;

public class QuanLySV {
	public  int id = 0;
	private String name;
	private int age;
	private String address;
	private double gpa;
	public  QuanLySV[] listSv = new QuanLySV[100];
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
		
	public QuanLySV[] getListSv() {
		return listSv;
	}
	public void setListSv(QuanLySV[] listSv) {
		this.listSv = listSv;
	}
	public  void addSV(QuanLySV sv) {
		listSv[id] = sv;
		id++;
	}
	
	public  void updateSV(Scanner sc,int id) {
		QuanLySV update = new  QuanLySV();
		sc.nextLine();
		System.out.println("Nhập họ tên: ");
		String ten = sc.nextLine();
		System.out.println("Nhập tuổi: ");
		int tuoi = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập địa chỉ: ");
		String diachi = sc.nextLine();
		System.out.println("Nhập điểm: ");
		double diem = sc.nextDouble();
		
		update.setName(ten);
		update.setAge(tuoi);
		update.setAddress(diachi);
		update.setGpa(diem);
		listSv[id-1]=update;
	}
	
	public  void deleteSV(int idDelete) {
		for (int i = idDelete; i < id; i++) {
			listSv[i-1] = listSv[i];
		}
		id = id-1;
	}
	
	public void sortSV() {
		QuanLySV sort = new QuanLySV();
		for(int i =0;i<id-1;i++) {
			for(int j=1;j<id+1;j++) {
				if(listSv[i].getAge()>listSv[j].getAge()) {
					sort = listSv[i];
					listSv[i] = listSv[j];
					listSv[j] = sort;
				}
			}
		}
	}
	
	public  void showSV(){
		System.out.printf("%-5s %-20s %-6s %-20s %-6s","ID", "Tên", "Tuổi", "Địa chỉ" ,"ĐTB" );
		System.out.println();
		for (int i = 0; i < id; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f",(i+1),listSv[i].getName(),listSv[i].getAge(),listSv[i].getAddress(),listSv[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}
	
	public  void menu() {
		int luachon,tt;
		while(true) {
			Scanner sc  = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID.");
			System.out.println("3. Xóa sinh viên theo ID  .");
			System.out.println("4. Sắp sếp sinh viên theo tuổi .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");
			System.out.print("Mời bạn nhập lựa chọn : ");
			luachon = sc.nextInt();
			System.out.println();
			
			switch(luachon) {
			case 1:
				do{
					QuanLySV qlsv = new QuanLySV();
					sc.nextLine();
					System.out.println("Nhập họ tên: ");
					String ten = sc.nextLine();
					System.out.println("Nhập tuổi: ");
					int tuoi=sc.nextInt();
					sc.nextLine();
					System.out.println("Nhập địa chỉ: ");
					String diachi = sc.nextLine();
					System.out.println("Nhập điểm: ");
					double diem = sc.nextDouble();
					
					qlsv.setName(ten);
					qlsv.setAge(tuoi);
					qlsv.setAddress(diachi);
					qlsv.setGpa(diem);
					System.out.println("Bạn muốn tiếp tục 0 - không|1 - có");
					tt = sc.nextInt();
				}while(tt == 1);
				break;
			case 2:
				System.out.println("Nhập id cần sửa: ");
				int idUpdate = sc.nextInt();
				QuanLySV update = new QuanLySV();
				update.updateSV(sc, idUpdate);			
				break;
			case 3:
				System.out.println("Nhập id cần xóa");
				int idDelete =  sc.nextInt();
				QuanLySinhVien delete = new QuanLySinhVien();
				delete.deleteSV(idDelete);
				break;
			case 4:
				QuanLySinhVien sapXep = new QuanLySinhVien();
				sapXep.sapXep();
				break;
			}
				
		}
	}
	public static void main(String[] args) {
		QuanLySV qlsv = new QuanLySV();	
		qlsv.menu();
	}
}	
