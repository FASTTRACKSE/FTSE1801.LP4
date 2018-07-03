import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Quản lý sinh viên
 * @author Khanh Hung
 *
 */
public class QuanLySinhVien {
	private ArrayList<SinhVien> listSinhVien;
	
	public QuanLySinhVien() {
		listSinhVien = new ArrayList<SinhVien>();
	}
	
	public void nhapSv(SinhVien sinhVien) {
		listSinhVien.add(sinhVien);
	}
	
	public void xuatDanhSachSv() {
		System.out.printf("%-8s %-15s %-7s %-15s %-7s\n", "Id", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		for (SinhVien sinhVien: listSinhVien) {
			System.out.printf("%-8s %-15s %-7s %-15s %-7s\n", sinhVien.getId(), sinhVien.getName(), sinhVien.getAge(), sinhVien.getAddress(), sinhVien.getGpa());
		}
	}
	
	public void sapXepDanhSachSv() {
		Collections.sort(listSinhVien, new Comparator<SinhVien>() {
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}
	
	public void xoaSvTheoId(String id) {
		SinhVien Id = null;
		for (int i=0; i<listSinhVien.size(); i++) {
			if (listSinhVien.get(i).getId().equals(id)) {
				Id = listSinhVien.get(i);
				break;
			}
		}
		if (Id != null) {
			listSinhVien.remove(Id);
		}else {
			System.out.println("Bạn đã nhập sai!");
		}
	}
	
	public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn chon menu!");
		
		while (true) {
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Hiển thị danh sách sinh viên");
			System.out.println("3. Sắp xếp danh sách sinh viên");
			System.out.println("4. Xóa sinh viên theo Id");
			System.out.println("5. Chương trình kết thúc");
			
			chooseMenu = sc.nextInt();
			switch (chooseMenu) {
			case 1:
				SinhVien sinhVien = new SinhVien();
				sc.nextLine();
				
				System.out.print("Nhập Id sinh viên: ");
				String id = sc.nextLine();
				sinhVien.setId(id);
				
				System.out.print("Nhập tên sinh viên: ");
				String name = sc.nextLine();
				sinhVien.setName(name);
				
				System.out.print("Nhập tuổi sinh viên: ");
				int age = sc.nextInt();
				sinhVien.setAge(age);
				
				System.out.print("Nhập địa chỉ sinh viên: ");
				String address = sc.next();
				sinhVien.setAddress(address);
				
				System.out.print("Nhập điểm trung bình: ");
				double gpa = sc.nextDouble();
				sinhVien.setGpa(gpa);
				
				nhapSv(sinhVien);
				break;
				
			case 2:
				xuatDanhSachSv();
				break;
				
			case 3:
				sapXepDanhSachSv();
				xuatDanhSachSv();
				break;
				
			case 4:
				System.out.print("Nhập Id sinh viên cần xóa: ");
				sc.nextLine();
				String Id = sc.nextLine();
				xoaSvTheoId(Id);
				xuatDanhSachSv();
				break;
				
			case 5:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;
				
			default:
				System.out.println("\n\n********Menu not exist feature********");
				break;
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		QuanLySinhVien quanLy = new QuanLySinhVien();
		quanLy.menu();
	}
}
