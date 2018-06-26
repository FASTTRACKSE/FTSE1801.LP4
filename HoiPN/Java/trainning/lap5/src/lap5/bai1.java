package lap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class bai1 {
	private ArrayList<DanhSachTen> listTen;
	
	public bai1() {
		listTen = new ArrayList<DanhSachTen>();
	}
	
	public void menu() {
		int tt, so;
		bai1 quanLy = new bai1();
		while (true) {
			System.out.println("/****************************************/");
			System.out.println("1. Thêm họ tên.");
			System.out.println("2. Xóa theo tên.");
			System.out.println("3. Sắp xếp danh sách theo tên ");
			System.out.println("4. Sắp xếp danh sách ngẫu nhiên.");
			System.out.println("5. Hiển thị danh sách.");
			System.out.println("0. Kết thúc chương trình.");
			System.out.println("/****************************************/");
			System.out.println("Lựa chọn của bạn: ");
			Scanner sc = new Scanner(System.in);
			so = sc.nextInt();
			System.out.println();
			switch (so) {
			case 1:
				do {
					System.out.println("Nhập id: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Nhập họ tên: ");
					String name = sc.nextLine();
					
					DanhSachTen danhSachTen = new DanhSachTen();
					danhSachTen.setId(id);
					danhSachTen.setName(name);
					
					quanLy.addDS(danhSachTen);
					
					System.out.println();
					System.out.println("Bạn muốn tiếp tục 0 - không | 1 - có");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				System.out.println("Nhập họ tên cần xóa:  ");
				sc.nextLine();
				String nameDelete = sc.nextLine();		
				quanLy.deleteDS(nameDelete);
				quanLy.showDS();
				break;
			case 3:
				quanLy.sortDS();
				quanLy.showDS();
				break;
			case 4:
				quanLy.ngauNhien();
				quanLy.showDS();
				break;
			case 5:			
				quanLy.showDS();
				break;
			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình!!!");
				System.exit(0);
				break;
			}
		}
	}
	
	public void addDS(DanhSachTen danhsach)	{
		listTen.add(danhsach);
	}

	public void deleteDS(String nameDelete) {
//		Object name = null;
//		for(int i = 0;i < listTen.size();i++) {
//			if(listTen.get(i).getName().equals(nameDelete)) {
//				name = listTen.get(i);
//				break;
//			}
//			
//			if(name != null) {
//				listTen.remove(name);
//			}else {
//				System.out.println("Bạn nhập sai tên.");
//			}
//		}
		
		for(int i = 0;i < listTen.size();i++) {
			if(listTen.get(i).getName().equals(nameDelete)) {
				listTen.remove(i);
				break;
			}
		}
	}
	
	public void sortDS() {
		Collections.sort(listTen, new Comparator<DanhSachTen>() {
			public int compare(DanhSachTen arg0, DanhSachTen arg1) {
				return arg0.getName().compareToIgnoreCase(arg1.getName());
			};
		
		});
	}
	
	public void ngauNhien() {
		Collections.shuffle(listTen);
	}
	
	public void showDS() {
		System.out.printf("%3s %20s \n", "ID", "Name");
		System.out.println();
		for (DanhSachTen danhSachTen: listTen) {
			System.out.printf("%3s %20s \n", danhSachTen.getId(),danhSachTen.getName());
		}
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		bai1 bai = new bai1();
		bai.menu();
	}
}
