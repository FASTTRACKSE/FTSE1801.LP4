package lap5;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyPhongTro {
	private ArrayList<PhongTro> listPhongTro;

	public QuanLyPhongTro() {
		listPhongTro = new ArrayList<PhongTro>();
	}

	public void choThuePhong(PhongTro phongTro) {
		listPhongTro.add(phongTro);
	}

	public void traPhong(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			listPhongTro.remove(phongTro);
			System.out.println("Đã trả phòng");
		} else {
			System.out.println("Nhập sai CMND!");
		}
	}

	public void layThongTinPhongTro(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			phongTro.hienThongTin();
		} else {
			System.out.println("Nhập sai CMND!");
		}
	}

	public void tinhTienTraPhong(String soCMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (soCMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}

		if (phongTro != null) {
			System.out.println(
					"Số tiền khách " + phongTro.getKhach().getHoTen() + " phải trả là : " + phongTro.thanhTien());
		} else {
			System.out.println("Nhập sai CMND!");
		}
	}

	public void menu() {
		int chooseMenu;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Cho thuê phòng trọ");
			System.out.println("2. Hiển thị thông tin phòng trọ");
			System.out.println("3. Trả phòng");
			System.out.println("4. Chương trình kết thúc");

			chooseMenu = scanner.nextInt();
			switch (chooseMenu) {
			case 1:
				System.out.print("Nhập số phòng cần trọ :");
				int soPhongChoThue = scanner.nextInt();
				scanner.nextLine();

				// cho thue
				PhongTro phongTro;
				for (int i = 0; i < soPhongChoThue; i++) {
					phongTro = new PhongTro();
					phongTro.nhapThongTin(scanner);
					choThuePhong(phongTro);
				}
				
				// hien thi thong tin
//				for (int i = 0; i < listPhongTro.size(); i++) {
//					listPhongTro.get(i).hienThongTin();
//				}
				break;
				
			case 2:
				System.out.print("Nhập số CMND muốn hiển thị phòng trọ: ");
				scanner.nextLine();
				String cmnd = scanner.nextLine();
				layThongTinPhongTro(cmnd);
				break;
				
			case 3:
				System.out.print("Nhập số CMND muốn trả phòng: ");
				scanner.nextLine();
				String cmnd2 = scanner.nextLine();
				tinhTienTraPhong(cmnd2);
				traPhong(cmnd2);
				break;
				
			case 4:
				scanner.close();
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
		QuanLyPhongTro quanLyPhongTro = new QuanLyPhongTro();
		quanLyPhongTro.menu();
	}
}
