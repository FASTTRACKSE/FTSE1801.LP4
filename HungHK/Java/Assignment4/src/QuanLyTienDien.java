

import java.util.Scanner;

public class QuanLyTienDien {
	private BienLai[] listKh;
	private int soLuongKh;
	
	public QuanLyTienDien() {
		listKh = new BienLai[100];
		soLuongKh = 0;
	}
	public void addKh(BienLai bienlai) {
		listKh[soLuongKh] = bienlai;
		soLuongKh += 1;
	}
	public void hienThiBienLai() {
		System.out.printf("%-20s|%-10s|%-8s|%-12s|%-12s|%-10s|%n", "Họ tên", "Địa chỉ", "Mã số", "Chỉ số cũ", "Chỉ số mới", "Số tiền");
		for (int i=0; i<soLuongKh; i++) {
			System.out.printf("%-20s|%-10s|%-8s|%-12s|%-12s|%-10s|%n", listKh[i].getHoTen(), listKh[i].getDiaChi(), listKh[i].getMaSoCongTo(), listKh[i].getChiSoCu(), listKh[i].getChiSoMoi(), (listKh[i].getChiSoMoi() - listKh[i].getChiSoCu())*750);
		}
	}
	
	public static void main(String[] args) {
		int mn;
		Scanner sc = new Scanner(System.in);
		QuanLyTienDien qltd = new QuanLyTienDien();
		
		while (true) {
			System.out.println("1. Thêm khách hàng:");
			System.out.println("2. Hiển thị khách hàng:");
			System.out.println("3. Exit!");

			mn = sc.nextInt();
			switch (mn) {
			case 1: 
				BienLai bl1 = new BienLai();
				
				System.out.print("Nhập tên khách hàng: ");
				String hoTen  = sc.nextLine();
				bl1.setHoTen(hoTen);
				sc.nextLine();
				
				System.out.print("Nhập địa chỉ khách hàng: ");
				String diaChi = sc.nextLine();
				bl1.setDiaChi(diaChi);
				
				System.out.print("Nhập mã số công tơ: ");
				String maSoCongTo = sc.nextLine();
				bl1.setMaSoCongTo(maSoCongTo);
				
				System.out.print("Nhập chỉ số cũ: ");
				double chiSoCu = sc.nextDouble();
				bl1.setChiSoCu(chiSoCu);
				
				System.out.print("Nhập chỉ số mới: ");
				double chiSoMoi = sc.nextDouble();
				bl1.setChiSoMoi(chiSoMoi);
				
				qltd.addKh(bl1);
				break;
				
			case 2:
				qltd.hienThiBienLai();
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
		}
	}
}
