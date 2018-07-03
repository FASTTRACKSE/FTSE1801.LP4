import java.util.ArrayList;
import java.util.Scanner;

/**
 * Quản lý cán bộ
 * @author Khanh Hung
 *
 */
public class QuanLyCanBo {
	ArrayList<CanBo> listCanBo;
	
	public QuanLyCanBo() {
		listCanBo = new ArrayList<CanBo>();
	}
	
	public void menu() {
		int chooseMenu;
		int soCanBo;
		CanBo canBo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn chọn menu!");
		
		while (true) {
			System.out.println("1. Nhập thông tin cán bộ");
			System.out.println("2. Hiển thị thông tin cán bộ");
			System.out.println("3. Chương trình kết thúc");
			
			chooseMenu = sc.nextInt();
			switch (chooseMenu) {
			case 1:
				System.out.print("Nhập số lượng cán bộ: ");
				soCanBo = sc.nextInt();
				for (int i=0; i<soCanBo; i++) {
					System.out.println("Nhập thông tin cán bộ thứ " + (i+1) + ", chọn:");
					System.out.println("1. Giảng viên \n2. Nhân viên");
					int cb;
					cb = sc.nextInt();
					sc.nextLine();
					if (cb==1) {
						canBo = new GiangVien();
						((GiangVien)canBo).nhapGiangVien(sc);
						listCanBo.add(canBo);
					} else if (cb==2) {
						canBo = new NhanVien();
						((NhanVien)canBo).nhapNhanVien(sc);
						listCanBo.add(canBo);
					}
				}
				break;
				
			case 2:
				System.out.println("Hiển thị danh sách cán bộ: ");
				CanBo cb;
				for (int i=0; i<listCanBo.size(); i++) {
					cb = listCanBo.get(i);
					if (cb instanceof NhanVien) {
						((NhanVien)cb).xuatNhanVien();
					} else {
						((GiangVien)cb).xuatGiangVien();
					}
				}
				break;
				
			case 3:
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
		QuanLyCanBo quanLyCanBo = new QuanLyCanBo();
		quanLyCanBo.menu();
	}
}
