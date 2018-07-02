import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CanBo {
	private String hoTen;
	private int phuCap;
	private double heSoLuong;
	private String donVi;
	private String capBac;
	private int thoiGianLamViec;
	private double luong;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getCapBac() {
		return capBac;
	}
	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}
	public int getThoiGianLamViec() {
		return thoiGianLamViec;
	}
	public void setThoiGianLamViec(int thoiGianLamViec) {
		this.thoiGianLamViec = thoiGianLamViec;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	private ArrayList<CanBo> listCanBo;

	public CanBo() {
		listCanBo = new ArrayList<CanBo>();
	}

	public void menu() {
		int luaChon,tiepTuc;
		CanBo canBo = new CanBo();
		
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
						canBo.addGiangVienToListCanBo(sc);
						break;
					case 2:
						canBo.addNhanVienToListCanBo(sc);
						break;
					default:
						System.out.println("Chọn sai.");
						break;
					}
					System.out.println("Ban co muon tiep tuc khong : (0:khong | 1:co)");
					tiepTuc = sc.nextInt();
				}while(tiepTuc == 1);
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
		try {
			for (int i = 0; i < listCanBo.size(); i++) {
				if (listCanBo.get(i).getDonVi().equals(donVi)) {
					throw new Exception();
				}
			}
			System.out.println("Nhap sai khoa (phong ban)");
			System.out.println();
		} catch (Exception e) {
			System.out.printf("%3s %20s %25s %20s %20s %10s %20s %10s %15s", "STT", "Ten", "Nganh", "Khoa(phong ban)",
					"Trinh do(chuc vu)", "Phu cap", "So tiet(ngay cong)", "He so luong", "Luong");
			for (int i = 0; i < listCanBo.size(); i++) {
				if (listCanBo.get(i).getDonVi().equals(donVi)) {
					System.out.printf("%n %3s %20s %25s %20s %20s %10s %20s %10s %15s", i + 1,
							listCanBo.get(i).getHoTen(), listCanBo.get(i).getDonVi(),
							listCanBo.get(i).getCapBac(), listCanBo.get(i).getPhuCap(),
							listCanBo.get(i).getThoiGianLamViec(), listCanBo.get(i).getHeSoLuong(),
							listCanBo.get(i).getLuong());
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		CanBo canBo = new CanBo();
		canBo.menu();
	}
}
