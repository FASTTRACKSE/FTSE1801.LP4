package QuanLyCanBo;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLy {
	ArrayList<CanBo> listQuanLy;

	public QuanLy() {
		listQuanLy = new ArrayList<CanBo>();

	}

	public void meNu() {
    	int chooseMenu;
    	int soCanBo;
    	CanBo canBo;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("1 : nhập thông tin cán bộ\n");
			System.out.print("2 : xem thông tin\n");
			System.out.print("3 : Kết thúc chương trình\n");
			System.out.print("*************************\n ");
			System.out.print("\n chọn chức năng bạn muốn : ");
			chooseMenu = sc.nextInt();
			switch(chooseMenu) {
			  
			
			
			case 1:
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = sc.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.print("Nhập thông tin cán bộ " + (i + 1) + " \n");

					System.out.print("Nhập 1 chọn giảng viên, 2 chọn nhân viên");
					int cb;
					cb = sc.nextInt();
					sc.nextLine();
					if (cb == 1) {
						canBo = new GiangVien();
						((GiangVien)canBo).nhapGiangVien(sc);
						listQuanLy.add(canBo);
					} else if (cb == 2) {
						canBo = new NhanVien();
						((NhanVien)canBo).nhapNhanVien(sc);
						listQuanLy.add(canBo);
					}

				}
			case 2:
				System.out.println("Hiển thị danh sách cán bộ trong trường: ");
				CanBo cb;
				for (int i = 0; i<listQuanLy.size() ; i++) {
		        	cb = listQuanLy.get(i);
		            if (cb instanceof NhanVien) {
		            	((NhanVien)cb).xuatNhanVien();
		            } else {
		            	((GiangVien)cb).xuatGiangVien();
		            } 
		            
		        }
                
                
			case 3:
				sc.close();
				System.out.println("Tạm biệt");
				System.exit(0);
				break;
				
			default:
				System.out.println("\n-Menu không tồn tại tính năng-");
				break;	
			}
			
		}while(true);
    }

	public static void main(String[] args) {
		QuanLy ql = new QuanLy();
		ql.meNu();
	}
}