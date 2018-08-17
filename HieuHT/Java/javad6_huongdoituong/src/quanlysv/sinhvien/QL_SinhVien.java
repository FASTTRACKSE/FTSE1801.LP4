package quanlysv.sinhvien;

import java.util.Scanner;


import quanlysv.quanly.SinhVien;

public class QL_SinhVien {
    private SinhVien[] listSinhVien;
    private int soluongSv;
    
   public QL_SinhVien() {
	   listSinhVien = new SinhVien[100];
	   soluongSv = 0;
   }
    
    
  
	


	//add Sinh viên
    public void addSv(SinhVien sv) {
    	
    	listSinhVien[soluongSv] = sv;
    	soluongSv +=1;
    	
    }
    public void display() {
    	System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n","ID","Name","Age","Address","Gba");
    	for(int i = 0; i < soluongSv; i++) {
    		System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n",listSinhVien[i].getId(),listSinhVien[i].getName(),listSinhVien[i].getAge(),listSinhVien[i].getAddress(),listSinhVien[i].getGba());
			
    	}
    }
    public void repair(int id) {
    	
    	for(int i = 0; i<soluongSv;i++) {
    		if(listSinhVien[i].getId() == id) {
    			Scanner sc = new Scanner(System.in);
    			System.out.print("Nhập tên SV : ");
    			String name = sc.nextLine();
    			listSinhVien[i].setName(name);
    			System.out.print("Nhập tuổi : ");
    			int age = sc.nextInt();
    			listSinhVien[i].setAge(age);
    			sc.nextLine();
    			System.out.print("Nhập địa chỉ : ");
    			String address = sc.nextLine();
    			listSinhVien[i].setAddress(address);
    			System.out.print("Nhập điểm trung bình : ");
    			double gba = sc.nextDouble();
				listSinhVien[i].setGba(gba);
    			break;
    		}
    		else {
    			System.out.println("Vui lòng nhập đúng id cần thay đổi");
    			break;
    		}
    	}
    	
		
    }
    public void delete(int id) {
        for(int i = 0;i<soluongSv;i++) {
       
        	listSinhVien[i] = listSinhVien[i+1];
        	 soluongSv -= 1;
        }
       
	}  
public void sapxep() {
		
	}
    
    public void menu() {

		int chooseMenu;
		Scanner sc = new Scanner(System.in);
		QL_SinhVien qlsv = new QL_SinhVien();
    	
		

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
				
				SinhVien sv1 = new SinhVien();
				
				
		    	System.out.println("Nhập id SV :");
		    	int id = sc.nextInt();
		    	sv1.setId(id); 
		    	sc.nextLine();
				System.out.println("Nhập tên SV :");
				String name = sc.nextLine();
				sv1.setName(name);
				
				System.out.println("Nhập tuổi SV :");
		        int age = sc.nextInt();
		        sv1.setAge(age);
		        sc.nextLine();
				System.out.println("Nhập địa chỉ SV :");
				String address = sc.nextLine();
				sv1.setAddress(address);
				System.out.println("Nhập điểm trung bình của SV :");
				double gba = sc.nextDouble();
				sv1.setGba(gba);
		    	qlsv.addSv(sv1);
				break;

			case 2:
				qlsv.display();
				break;
			case 3:
				System.out.println("Nhập ID SV cần sửa :");
				int Id = sc.nextInt();
				qlsv.repair(Id);
				break;
			case 4:
				System.out.println("Nhập ID SV cần xóa :");
				int iddelete = sc.nextInt();
				qlsv.delete(iddelete);
				break;
			case 5:
				sapxep();
				break;
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

    
    
    
    
    
    
    public static void main(String[]args) {
    	QL_SinhVien qlsv = new QL_SinhVien();
    	qlsv.menu();
    	
    	
    }
}    