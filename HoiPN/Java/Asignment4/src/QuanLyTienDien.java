import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTienDien {
	
	private ArrayList<KhachHang> listKhachHang;
	public QuanLyTienDien() {
		listKhachHang = new ArrayList<KhachHang>();
	}
	
	public void addKhachHang(KhachHang khachHang) {
		listKhachHang.add(khachHang); 
	}
	public void show() {
		System.out.printf("%-20s %-10s %-20s %-15s %-15s %-15s", "Họ tên", "Số nhà", "Mã số Công tơ", "Chỉ số cũ", "Chỉ Số mới", "Tổng tiền");
		System.out.println();
		for (KhachHang khachHang: listKhachHang) {
			System.out.printf("%-20s %-10s %-20s %-15s %-15s %-15s", khachHang.getHoTen(),khachHang.getSoNha(),khachHang.getMaSoCt(),khachHang.getChiSoCu(),khachHang.getChiSoMoi(),khachHang.getTongTien());

		}
		System.out.println();
	}
	
	public void menu() {
		int tt, so;
		QuanLyTienDien quanLy = new QuanLyTienDien();
		while (true) {
			System.out.println("/****************************************/");
			System.out.println("1. Thêm khách hàng.");
			System.out.println("2. Hiển thị biên lai.");
			System.out.println("0.Kết thúc chương trình.");
			System.out.println("/****************************************/");
			System.out.println("Lựa chọn của bạn: ");
			Scanner sc = new Scanner(System.in);
			so = sc.nextInt();
			System.out.println();
			switch (so) {
			case 1:
				do {
					sc.nextLine();
					System.out.println("Nhập họ tên: ");
					String hoTen = sc.nextLine();
					
					System.out.println("Nhập số nhà: ");
					String soNha = sc.nextLine();

					System.out.println("Nhập mã số Công tơ: ");
					String maSoCt = sc.nextLine();
					
					System.out.println("Nhập chỉ số cũ: ");
					double chiSoCu = sc.nextDouble();
					
					System.out.println("Nhập chỉ số moi: ");
					double chiSoMoi = sc.nextDouble();
					
					KhachHang khachHang = new KhachHang();
					khachHang.setHoTen(hoTen);
					khachHang.setSoNha(soNha);
					khachHang.setMaSoCt(maSoCt);
					khachHang.setChiSoCu(chiSoCu);
					khachHang.setChiSoMoi(chiSoMoi);
					
					quanLy.addKhachHang(khachHang);
					
					System.out.println();
					System.out.println("Bạn muốn tiếp tục 0 - không | 1 - có");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				System.out.println("Biên lai: ");
				quanLy.show();
				break;

			}
		}
	}
	public static void main(String[] args) {
		QuanLyTienDien ql = new QuanLyTienDien();
		ql.menu();
	}

}
