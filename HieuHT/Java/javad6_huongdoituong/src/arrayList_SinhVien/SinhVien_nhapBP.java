package arrayList_SinhVien;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quanlysv.quanly.SinhVien;
import quanlysv.sinhvien.QL_SinhVien;

public class SinhVien_nhapBP {
   private ArrayList<SinhVien> listSv;

		public SinhVien_nhapBP() {
			listSv = new ArrayList<SinhVien>();
		}
		// thêm sinh viên:
		public void addSV(SinhVien sv) {
			listSv.add(sv);
		}
		// In danh sách;
		public void printSV() {
			
			System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n", "ID", "Name", "Age", "Address", "Gba");
			for(int i = 0; i< listSv.size();i++) {
				System.out.printf("%5s|%-20s|%5s|%-20s|%5s%n",listSv.get(i).getId(),
						listSv.get(i).getName(), listSv.get(i).getAge(),
						listSv.get(i).getAddress(), listSv.get(i).getGba());
			}
		}
		//Sắp xếp theo tên:
		public void sort() {
			Collections.sort(listSv, new Comparator<SinhVien>() {
		
				
				public int compare(SinhVien o1, SinhVien o2) {
					
					return o1.getName().compareToIgnoreCase(o2.getName());
				}
				
			});
		}
		// Sửa:
		public void repair(int id) {
			for(int i = 0; i< listSv.size(); i++) {
			
				if(listSv.get(i).getId()== id) {
					
					Scanner sc = new Scanner(System.in);
					System.out.print("Nhập tên SV : ");
					String name = sc.nextLine();
					listSv.get(i).setName(name);
					System.out.print("Nhập tuổi : ");
					int age = sc.nextInt();
				    listSv.get(i).setAge(age);
					sc.nextLine();
					System.out.print("Nhập địa chỉ : ");
					String address = sc.nextLine();
					listSv.get(i).setAddress(address);
					System.out.print("Nhập điểm trung bình : ");
					double gba = sc.nextDouble();
					listSv.get(i).setGba(gba);
					break;
				}
				else {
					System.out.println("Vui lòng nhập đúng Id của sinh viên:");
				}
			}
		}
		// Xóa:
		public void delete(int id) {
			for(int i = 0; i<listSv.size(); i++) {
				
				if(listSv.get(i).getId()==id) {
				listSv.remove(i);
				break;
				}
				else {
					System.out.println("Vui lòng nhập đúng Id của sinh viên:");
				}
			}
		} 
		public void menu() {
			int chooseMenu;
			Scanner sc = new Scanner(System.in);
			SinhVien_nhapBP ql = new SinhVien_nhapBP();
			
			
		
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
					
					SinhVien sv = new SinhVien();
					System.out.println("Nhập id SV :");
			    	int id = sc.nextInt();
			    	sv.setId(id); 
			    	sc.nextLine();
					System.out.println("Nhập tên SV :");
					String name = sc.nextLine();
					sv.setName(name);
					
					System.out.println("Nhập tuổi SV :");
			        int age = sc.nextInt();
			        sv.setAge(age);
			        sc.nextLine();
					System.out.println("Nhập địa chỉ SV :");
					String address = sc.nextLine();
					sv.setAddress(address);
					System.out.println("Nhập điểm trung bình của SV :");
					double gba = sc.nextDouble();
					sv.setGba(gba);
					ql.addSV(sv);
					break;
		
				case 2:
					ql.printSV();
					break;
				case 3:
					System.out.println("Nhập ID SV cần sửa :");
					int Id = sc.nextInt();
					ql.repair(Id);
					break;
				case 4:
					System.out.println("Nhập ID SV cần xóa :");
					int iddelete = sc.nextInt();
				    ql.delete(iddelete);
					break;
				case 5:
					ql.sort();
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
	SinhVien_nhapBP qlsv = new SinhVien_nhapBP();
	qlsv.menu();
	
	
}
}
