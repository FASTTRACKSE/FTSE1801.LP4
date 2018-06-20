package quanlysinhvien;
import java.util.Scanner;

public class QuanLySinhVien {
	private int id=0;
	
    public QuanLySinhVien() {
    			
    }
    public QuanLySinhVien(int id, double gpa) {
		super();
		this.id = id;
		this.gpa = gpa;
	}
    // Add sinh viên
    // Deletel sinh viên
    // Update sinh viên
    // Hiển thi sinh viên theo tên
    //Hiển thị tất cả sinh viên
    
	public static Student[]listSV=new Student[100];
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
 
    public double getGpa() {
        return gpa;
    }
 
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void addSV(Student sinhvien) {
    	listSV[id]= sinhvien;
    	setId(id +1);
    }
    public void deletelSV(int xoaID) {
    	for(int i=xoaID;i<id;i++) {
    		listSV[i-1]=listSV[i];
    	}
    	id=id-1;
    }

	public void show() {
		System.out.printf("%-3s %-20s %-6s %-20s %-6s \n","ID", "Tên", "Tuổi", "Địa chỉ" ,"ĐTB" );
		System.out.println();
		for (int i = 0; i < this.getId(); i++) {
			System.out.printf(" %-3s %-20s %-6s %-20s %-6s \n",(i+1),listSV[i].getName(),listSV[i].getAge(),listSV[i].getAddress(),listSV[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}

	public void repairSV(Scanner input, int id) {
		input.nextLine();
		System.out.print("Nhập tên SV : ");
		String name = input.nextLine();

		System.out.print("Nhập tuổi : ");
		Byte age = input.nextByte();

		input.nextLine();
		System.out.print("Nhập địa chỉ : ");
		String address = input.nextLine();

		System.out.print("Nhập điểm trung bình : ");
		float gpa = input.nextFloat();
		
		listSV[id-1].setName(name);
		listSV[id-1].setAge(age);
		listSV[id-1].setAddress(address);
		listSV[id-1].setGpa(gpa);
	}
	public void sapxep() {
		Student sapxep = new Student();
		for (int i = 0;i<id-1;i++) {
			for(int j = 0;j<id;j++) {
				if(listSV[i].getAge()>listSV[j].getAge()) {
					listSV[i]=sapxep;
					listSV[i]=listSV[j];
					listSV[j]=sapxep;
				}
			}
		}
		this.show();
	}
	public static void menu() {
		int tt, luaChon;
		QuanLySinhVien qlsv = new QuanLySinhVien();
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID.");
			System.out.println("3. Xóa sinh viên theo ID  .");
			System.out.println("4. Sắp sếp sinh viên theo tuoi .");
			System.out.println("5. Hiển thị danh sách sinh viên .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					
//					
					input.nextLine();
					System.out.print("Nhập tên SV : ");
					String name = input.nextLine();
	
					System.out.print("Nhập tuổi : ");
					Byte age = input.nextByte();
	
					input.nextLine();
					System.out.print("Nhập địa chỉ : ");
					String address = input.nextLine();
					int id = qlsv.getId()+1;
					System.out.print("Nhập điểm trung bình : ");
					float gpa = input.nextFloat();
					Student sv = new Student(id,name,age,address,gpa);
					qlsv.addSV(sv);
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
				qlsv.repairSV(input, idRepair);
				break;
				
			case 3:
				System.out.println();
				System.out.print("Nhập ID cần xóa : ");
				System.out.println();
				int idDelete = input.nextInt();
				qlsv.deletelSV(idDelete);
				break;
			case 4:
				qlsv.sapxep();
				break;
			case 5:
				qlsv.show();
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
	

