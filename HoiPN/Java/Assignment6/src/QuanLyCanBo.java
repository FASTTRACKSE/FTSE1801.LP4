import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyCanBo {
	private ArrayList<CanBo> listCanBo;

	public QuanLyCanBo() {
		listCanBo = new ArrayList<CanBo>();
	}

	public void menu() {
		int luaChon,tiepTuc;
		QuanLyCanBo qlcb =new QuanLyCanBo();
		while(true){
			System.out.println("//**********************************");
			System.out.println("1. Nhập thông tin cán bộ.");
			System.out.println("2. Hiển thị danh sách giảng viên theo khoa, cán bộ theo ban.");
			System.out.println("3. Tổng tiền lương phải trả.");
			System.out.println("4. Sắp xếp danh sách cán bộ theo lương.");
			System.out.println("5. Kết thúc chương trình.");
			System.out.println("*********************************//");
			
			Scanner sc = new Scanner(System.in);
			luaChon = sc.nextInt();
			
			switch(luaChon) {
			case 1:
				do {
					System.out.println("Nhập thông tin cán bộ.");
					System.out.println("1 - Thêm giản viên || 2 - Thêm nhân viên.");
					int chon = sc.nextInt();
					switch (chon) {
					case 1:
						addGiangVienToListCanBo(sc);
						break;
					case 2:
						addNhanVienToListCanBo(sc);
						break;
					default:
						System.out.println("Chọn sai.");
						break;
					}
					System.out.println("Ban co muon tiep tuc khong : (0:khong | 1:co)");
					tiepTuc = sc.nextInt();
				}while(tiepTuc == 1);
				break;
			case 2:
				showListCanBo();
				break;
			case 3:
				tongTienLuong();
				break;
			case 4:
				sortCanBo();
				break;
			case 5:
				System.out.println("Kết thúc chương trình!!!");
				sc.close();
				System.exit(0);
			}
		}
	}
	
	private void tongTienLuong() {
		double tongLuong = 0;
		for (int i = 0; i < listCanBo.size(); i++) {
			tongLuong = listCanBo.get(i).getLuong() + tongLuong;
		}
		System.out.println("Tong luong phai tra la: " + tongLuong);
		System.out.println();
		
	}
	
	private void sortCanBo() {
			Collections.sort(listCanBo, new SortAZ());
			CanBo canBo = null;
			for (int i = 0; i < listCanBo.size(); i++) {
				for (int j = 1; j < listCanBo.size(); j++) {
					if (listCanBo.get(i).getHoTen().equals(listCanBo.get(j).getHoTen())) {
						if (listCanBo.get(i).getLuong() > listCanBo.get(j).getLuong()) {
							canBo = listCanBo.get(i);
							listCanBo.set(i, listCanBo.get(j));
							listCanBo.set(j, canBo);
						}
					}
				}
			}
		
	}
	
	private void addGiangVienToListCanBo(Scanner sc) {
		GiangVien giangVien = new GiangVien();
		giangVien.addGiangVien(sc, giangVien);
		listCanBo.add(giangVien);
	}
	
	private void addNhanVienToListCanBo(Scanner sc) {
		NhanVien nhanVien = new NhanVien();
		nhanVien.addNhanVien(sc, nhanVien);
		listCanBo.add(nhanVien);
		
	}
	
	private void showListCanBo() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhập khoa, ban: ");
			String donVi = sc.nextLine();
			System.out.printf("%-20s %-25s %-25s %-10s %-30s %-20s %-10s \n","Ten", "Khoa(phong ban)",
					"Trinh do(chuc vu)", "Phu cap", "So tiet(ngay cong)", "He so luong", "Luong");
			for (int i = 0; i < listCanBo.size(); i++) {
				if (listCanBo.get(i).getDonVi().equals(donVi)) {
					System.out.printf("%-20s %-25s %-25s %-10s %-30s %-20s %-10s \n",
							listCanBo.get(i).getHoTen(), listCanBo.get(i).getDonVi(),
							listCanBo.get(i).getCapBac(), listCanBo.get(i).getPhuCap(),
							listCanBo.get(i).getThoiGianLamViec(), listCanBo.get(i).getHeSoLuong(),
							listCanBo.get(i).getLuong());
				}
			}
			System.out.println();
	}
	
	public static void main(String[] args ) throws NullPointerException{
		QuanLyCanBo qlcb = new QuanLyCanBo();
		qlcb.menu();
	}
}
