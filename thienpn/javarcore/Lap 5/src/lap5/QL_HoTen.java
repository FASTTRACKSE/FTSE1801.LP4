package lap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;





public class QL_HoTen {
   
  private ArrayList<ql_tenNV> ql;
   
   
   
   public QL_HoTen() {
	   ql = new ArrayList<ql_tenNV>();
   }
   
   
  




   public void nhap(ql_tenNV ten) {
	   ql.add(ten);
	   
   }
   public void xuat() {
	   System.out.printf("%30s|%30s%n","Họ và Tên", "địa chỉ");
	   for(int i = 0; i <ql.size(); i++) {
		   System.out.printf("%30s|%30s%n", ql.get(i).getHoTen(),ql.get(i).getDiachi());
	   }
   }
   public void ngaunhien() {
	   Collections.shuffle(ql);
	 
	   
   }
   public void sapxep() {
	   Collections.sort(ql, new Comparator<ql_tenNV>() {
		   public int compare(ql_tenNV o1, ql_tenNV o2) {
				
				return o2.getHoTen().compareToIgnoreCase(o1.getHoTen());
			}
	});
   }
   public void xoa(String hoTen) {
	   Object name = null;
	   for(int i=0; i<ql.size(); i++) {
		   if(ql.get(i).getHoTen().equals(hoTen)) {
			  name = ql.get(i);
			   break;
		   }
	   }
	   
	   if(name != null) {
		   ql.remove(name);
	   }else {
		   System.out.println("Bạn đã nhập sai.");
	   }
   }
   public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);
		QL_HoTen in = new QL_HoTen();
		
		
	
		while (true) {
			System.out.println("*********** Manager student name list - Menu ***********");
			System.out.println("* 1 - Thêm thông                                 *");
			System.out.println("* 2 - Hiển thị                           *");
			System.out.println("* 3 - ngẫu nhiên                       *");
			System.out.println("* 4 - sắp xếp                          *");
			System.out.println("* 5 - xóa                                     *");
			System.out.println("* 6 - Exit program                                     *");
			System.out.println("********************************************************");
			
			chooseMenu = sc.nextInt();
	
			switch (chooseMenu) {
			case 1:
				
				ql_tenNV sv = new ql_tenNV();
				sc.nextLine();
				   System.out.print("Vui lòng nhạp Họ Tên: ");
				   String hoTen = sc.nextLine();
				   
				   sv.setHoTen(hoTen);
				   
				   System.out.print("Vui lòng nhạp địa chỉ: ");
				   String diachi = sc.nextLine();
				   sv.setDiachi(diachi);
				   
				in.nhap(sv);
				
				break;
	
			case 2:
				in.xuat();
				break;
			case 3:
				in.ngaunhien();
				in.xuat();
				break;
			case 4:
			    in.sapxep();
				break;
			case 5:
				System.out.println("Nhập đúng họ tên cần xóa :");
				sc.nextLine();
				String hoten = sc.nextLine();
			    in.xoa(hoten);
			    in.xuat();
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

   public static void main(String[] args) {
	   QL_HoTen person = new QL_HoTen();
	   person.menu();
}
}
