package java_tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class BienLai {

	private ArrayList<KhachHang> listBienLai;

	public BienLai() {
		listBienLai = new ArrayList<KhachHang>();
	}

	public void add(KhachHang bienlai) {
		listBienLai.add(bienlai);

	}

	public void soTienPhaiTra() {
		int size = listBienLai.size();
		for (int i = 0; i < size; i++) {
			listBienLai.get(i).setSoTienPhaiTra(((listBienLai.get(i).getChiSoMoi() - listBienLai.get(i).getChiSoCu()) * 750));
		}
	}

	public void update(Scanner sc, String hoTen) {
		boolean isExisted = false;

		int size = listBienLai.size();

		for (int i = 0; i < size; i++) {
			if (listBienLai.get(i).getHoTen() == hoTen) {
				isExisted = true;
				sc.nextLine();
				System.out.println("- Nhập tên khách hàng:");
				String hoTen1 = sc.nextLine();
				listBienLai.get(i).setHoTen(hoTen1);
				System.out.println("- Nhập số nhà khách hàng:");
				int soNha = sc.nextInt();
				sc.nextLine();
				listBienLai.get(i).setSoNha(soNha);
				System.out.println("- Nhập mã số công tơ:");
				int maSoCongTo = sc.nextInt();
				listBienLai.get(i).setMaSoCongTo(maSoCongTo);
				;
				System.out.println("- Nhập chữ số cũ:");
				int chiSoCu = sc.nextInt();
				listBienLai.get(i).setChiSoCu(chiSoCu);
				System.out.println("- Nhập chữ số mới:");
				int chiSoMoi = sc.nextInt();
				listBienLai.get(i).setChiSoMoi(chiSoMoi);
				break;
			}
		}
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", hoTen);
		}

	}

	public void deletel(String hoTen) {
		KhachHang bienlai = null;
		int size = listBienLai.size();
		for (int i = 0; i < size; i++) {
			if (listBienLai.get(i).getHoTen() == hoTen) {
				bienlai = listBienLai.get(i);
				break;
			}
		}
		if (bienlai != null) {
			listBienLai.remove(bienlai);
			// studentDao.write(listSinhVien);
		} else {
			System.out.printf("id = %d not existed.\n", hoTen);
		}

	}

	public void show(KhachHang bienlai) {

		System.out.printf("%-3s| %-20s| %-6s| %-10s| %-10s| %-10s| %-10s| \n", "STT", "Họ và tên", "Số nhà",
				"MS Công tơ", "Chỉ số cũ", "Chỉ số mới", "Số tiền");
		System.out.println();

		int i =1;
		for (KhachHang bienlai1 : listBienLai) {
			System.out.printf(" %-3s| %-20s| %-6s| %-10s| %-10s| %-10s| %-10s| \n",i, bienlai1.getHoTen(),
					bienlai1.getSoNha(), bienlai1.getMaSoCongTo(), bienlai1.getChiSoCu(), bienlai1.getChiSoMoi(),bienlai1.getSoTienPhaiTra());

			System.out.println();
			i += 1;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BienLai quanly = new BienLai();
		while (true) {
			// show menu
			showMenu();
			int choose = sc.nextInt();

			switch (choose) {
			case 1:
				int tt;
				do {
					KhachHang bienlai1 = new KhachHang();
					sc.nextLine();
					System.out.println("- Nhập tên khách hàng:");
					String hoTen = sc.nextLine();
					bienlai1.setHoTen(hoTen);
					sc.nextLine();

					System.out.println("- Nhập số nhà khách hàng:");
					int soNha = sc.nextInt();
					sc.nextLine();
					bienlai1.setSoNha(soNha);
					System.out.println("- Nhập mã số công tơ:");
					int maSoCongTo = sc.nextInt();
					bienlai1.setMaSoCongTo(maSoCongTo);
					System.out.println("- Nhập chỉ số cũ:");
					int chiSoCu = sc.nextInt();
					bienlai1.setChiSoCu(chiSoCu);
					System.out.println("- Nhập chỉ số mới:");
					int chiSoMoi = sc.nextInt();
					bienlai1.setChiSoMoi(chiSoMoi);

					quanly.add(bienlai1);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);

				break;
			case 2:
				System.out.println();
				System.out.print("Nhập họ tên cần sửa : ");
				String update1 = sc.nextLine();
				quanly.update(sc, update1);
				;
				break;
			case 3:
				System.out.println();
				System.out.print("Nhập họ tên cần xóa : ");
				System.out.println();
				String idDelete = sc.nextLine();
				quanly.deletel(idDelete);
				;
				break;
			case 4:
				quanly.soTienPhaiTra();
				quanly.show(null);
				break;

			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
			
		}

	}

	public static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("-----------menu------------");
		System.out.println("1. Thêm tên khách hàng.");
		System.out.println("2. Cập nhập thông tin khách hàng.");
		System.out.println("3. Xóa thông tin khách hàng.");
		System.out.println("4. Hiện thông tin khách hàng.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}

}
