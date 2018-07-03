package quanLyDien;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Bien Lai thanh toan tien dien
 * @author Luan
 *
 */
public class BienLai {

	ArrayList<KhachHang> listKH;
	/**
	 * Mang bien lai
	 */
	public BienLai() {
		listKH = new ArrayList<KhachHang>();
	}
	/**
	 * them khach hang
	 * @param kh Khach hang
	 */
	public void addKH(KhachHang kh) {
		listKH.add(kh);
	}
	/**
	 * Tinh tien dien
	 */
	public void dien() {
		for (int i = 0; i < listKH.size(); i++) {
			listKH.get(i).setTienDien((listKH.get(i).getNewNumber() - listKH.get(i).getOldNumber()) * 750);
		}
	}
	/**
	 * hien thi danh sach khach hang
	 */
	public void show() {
		System.out.printf("%-5s %-20s %-20s %10s %10s %10s %10s", "STT", "Tên", "Địa chỉ", "Mã Công tơ", "Số điện cũ",
				"Số điện mới", "Số tiền");
		System.out.println();
		for (int i = 0; i < listKH.size(); i++) {
			System.out.printf("\n %-4s %-20s %-20s %10s %10s %10s %10s", (i + 1), listKH.get(i).getHoTen(),
					listKH.get(i).getSoNha(), listKH.get(i).getMaSoCongTo(), listKH.get(i).getOldNumber(),
					listKH.get(i).getNewNumber(), listKH.get(i).getTienDien());
		}
		System.out.println();
		System.out.println();
	}
	/**
	 * Menu
	 * @param args
	 */
	public static void main(String[] args) {
		int luaChon, tt;

		BienLai quanLy = new BienLai();

		while (true) {
			Scanner sc = new Scanner(System.in);
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Thêm khách hàng.");
			System.out.println("2. Hiển thị biên lai.");
			System.out.println("3. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();

			switch (luaChon) {
			case 1:
				do {
					sc.nextLine();
					System.out.print("Nhập tên khách hàng : ");
					String name = sc.nextLine();
					System.out.print("Nhập địa chỉ khách hàng: ");
					String address = sc.nextLine();
					System.out.print("Nhập mã số công tơ: ");
					String code = sc.nextLine();
					System.out.print("Nhập số điện cũ: ");
					int oldN = sc.nextInt();
					System.out.print("Nhập số điện mới: ");
					int newN = sc.nextInt();
					KhachHang kh = new KhachHang(name, address, code, oldN, newN);
					quanLy.addKH(kh);
					sc.nextLine();
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = sc.nextInt();
					
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				quanLy.dien();
				quanLy.show();
				break;
			case 3:
				input.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
			sc.close();
		}

	}

}
