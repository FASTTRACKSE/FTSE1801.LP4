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
	
	/**
	 * Hien thi danh sach can bo theo tung don vi
	 * @param donVi
	 */
	public void xuatTheoDonVi(String donVi) {
		try {
			for (int i=0; i<listCanBo.size(); i++) {
				if (listCanBo.get(i).getDonVi().equals(donVi)) {
					throw new Exception();
				}
			}
			System.out.println("Nhập sai");
		} catch (Exception e) {
			System.out.printf("%-14s %-14s %-17s %-20s %-22s %-13s\n", "Họ tên", "Hệ số lương", "Khoa/Phòng ban", "Trình độ/Chức vụ", "Số tiết/Số ngày công", "Tổng lương");
			for (int i=0; i<listCanBo.size(); i++) {
				if (listCanBo.get(i).getDonVi().equals(donVi)) {
					System.out.printf("%-14s %-14s %-17s %-20s %-22s %-13s\n", listCanBo.get(i).getHoTen(), listCanBo.get(i).getHeSoLuong(), listCanBo.get(i).getDonVi(), listCanBo.get(i).getCapBac(), listCanBo.get(i).getThoiGianLamViec(), listCanBo.get(i).getLuong());
				}
			}
		}
		
	}
	
	/**
	 * Tinh tong luong truong phai tra cho can bo
	 */
	public void tongLuong() {
		double tongLuong = 0;
		for (int i=0; i<listCanBo.size(); i++) {
			tongLuong = listCanBo.get(i).getLuong() + tongLuong;
		}
		System.out.println("Tổng lương trường phải trả: " + tongLuong);
	}
	
	/**
	 * Menu chuc nang chuong trinh
	 */
	public void menu() {
		int chooseMenu;
		int soCanBo;
		CanBo canBo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn chọn menu!");
		
		while (true) {
			System.out.println("1. Nhập thông tin cán bộ");
			System.out.println("2. Hiển thị thông tin cán bộ");
			System.out.println("3. Hiển thị danh sách cán bộ theo đơn vị");
			System.out.println("4. Hiển thị tổng lương trường phải trả cho cán bộ");
			System.out.println("6. Chương trình kết thúc");
			
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
					} else if (cb!=1 || cb!=2) {
						System.out.println("Chọn sai");
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
				System.out.print("Nhập đơn vị muốn hiển thị: ");
				sc.nextLine();
				String donVi = sc.nextLine();
				xuatTheoDonVi(donVi);
				break;
				
			case 4:
				tongLuong();
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
		QuanLyCanBo quanLyCanBo = new QuanLyCanBo();
		quanLyCanBo.menu();
	}
}
