package quanly_canbo;

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
			System.out.print("\n*************************************************\n");
			System.out.print("* số 1 : nhập thông tin cán bộ               *\n");
			System.out.print("* số 2 : xem thông tin                 *\n");
			System.out.print("* số 3 : tổng tiền lương phải trả               *\n");
			
			System.out.print("* số 4 : Kết thúc chương trình*\n");
			System.out.print("*************************************************\n ");
			System.out.print("\n chọn chức năng bạn muốn : ");
			chooseMenu = sc.nextInt();
			switch(chooseMenu) {
			  
			
			
			case 1:
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = sc.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.print("Nhập thong tin can bo thu " + (i + 1) + " \n");

					System.out.print("Nhập 1 chon giang vien, 2 chon nhan vien");
					int cb;
					cb = sc.nextInt();
					
					
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
				System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
		        for (CanBo cb : listQuanLy) {
		            ((NhanVien)cb).xuatNhanVien();
		            
		        }
                
                
			case 3:
				canBo = new GiangVien();
				canBo = new NhanVien();
				((GiangVien)canBo).tinhLuong();
				((NhanVien)canBo).tinhLuong();
			}
			
		}while(true);
    }

	public static void main(String[] args) {
		QuanLy ql = new QuanLy();
		ql.meNu();
	}
}
