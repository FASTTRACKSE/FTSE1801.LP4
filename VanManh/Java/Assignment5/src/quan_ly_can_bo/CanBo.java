package quan_ly_can_bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class CanBo {
	private String ten;
	private double heSoLuong;
	private double phuCap;
	private int thoiGianTinhLuong;
	private double luong;
	private String nganh;
	private String donVi;
	private String trinhDo;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public int getThoiGianTinhLuong() {
		return thoiGianTinhLuong;
	}

	public void setThoiGianTinhLuong(int thoiGianTinhLuong) {
		this.thoiGianTinhLuong = thoiGianTinhLuong;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	ArrayList<CanBo> listCanBo;

	public CanBo() {
		listCanBo = new ArrayList<CanBo>();
	}

	/**
	 * Them giang vien vao danh sach can bo
	 * 
	 * @param input
	 */
	public void addGiangVienVaoListCanBo(Scanner input) {
		GiangVien giangVien = new GiangVien();
		giangVien.addGiangVien(input, giangVien);
		listCanBo.add(giangVien);
	}

	/**
	 * Them nhan vien vao danh sach can bo
	 * 
	 * @param input
	 */
	public void addNhanVienVaoListCanBo(Scanner input) {
		NhanVienHanhChinh nhanVienHanhChinh = new NhanVienHanhChinh();
		nhanVienHanhChinh.addNhanVienHanhChinh(input, nhanVienHanhChinh);
		listCanBo.add(nhanVienHanhChinh);
	}

	/**
	 * hien thi danh sach giang vien theo don vi
	 * 
	 * @param donVi
	 */
	public void showDonVi(String donVi) {
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
							listCanBo.get(i).getTen(), listCanBo.get(i).getNganh(), listCanBo.get(i).getDonVi(),
							listCanBo.get(i).getTrinhDo(), listCanBo.get(i).getPhuCap(),
							listCanBo.get(i).getThoiGianTinhLuong(), listCanBo.get(i).getHeSoLuong(),
							listCanBo.get(i).getLuong());
				}
			}
			System.out.println();
		}

	}

	/**
	 * hien thi tat ca giang vien
	 */
	public void showAll() {
		System.out.printf("%3s %20s %25s %20s %20s %10s %20s %10s %15s", "STT", "ten", "nganh", "khoa(phong ban)",
				"trinh do(chuc vu)", "phu cap", "so tiet(ngay cong)", "he so luong", "luong");
		for (int i = 0; i < listCanBo.size(); i++) {
			System.out.printf("%n %3s %20s %25s %20s %20s %10s %20s %10s %15s", i + 1, listCanBo.get(i).getTen(),
					listCanBo.get(i).getNganh(), listCanBo.get(i).getDonVi(), listCanBo.get(i).getTrinhDo(),
					listCanBo.get(i).getPhuCap(), listCanBo.get(i).getThoiGianTinhLuong(),
					listCanBo.get(i).getHeSoLuong(), listCanBo.get(i).getLuong());
		}
		System.out.println();
	}

	/**
	 * sap xep giang vien theo ten a to z, neu trung len thi sap xep theo luong
	 */
	public void sapXepAToZ() {
		Collections.sort(listCanBo, new SapXepAToZ());
		CanBo canBo = null;
		for (int i = 0; i < listCanBo.size(); i++) {
			for (int j = 1; j < listCanBo.size(); j++) {
				if (listCanBo.get(i).getTen().equals(listCanBo.get(j).getTen())) {
					if (listCanBo.get(i).getLuong() > listCanBo.get(j).getLuong()) {
						canBo = listCanBo.get(i);
						listCanBo.set(i, listCanBo.get(j));
						listCanBo.set(j, canBo);
					}
				}
			}
		}
	}

	/**
	 * tinh tong luong phai tra
	 */
	public void tongLuong() {
		double tongLuong = 0;
		for (int i = 0; i < listCanBo.size(); i++) {
			tongLuong = listCanBo.get(i).getLuong() + tongLuong;
		}
		System.out.println("Tong luong phai tra la: " + tongLuong);
		System.out.println();
	}

	public static void main(String[] args) {
		CanBo canBo = new CanBo() {
		};
		Scanner input = new Scanner(System.in);
		int luaChon, tiepTuc, choose;
		String donVi;
		while (true) {
			System.out.println("1. Them can bo.");
			System.out.println("2. Xuat danh sach can bo");
			System.out.println("3. Xuat danh sach giang vien khoa x hoac nhan vien phong ban y.");
			System.out.println("4. Tinh tong so luong truong phai tra.");
			System.out.println("5. Sap xep can bo theo ten neu trung ten thi sap xep theo luong.");
			System.out.println("6. Ket thuc.");

			System.out.println("Moi ban nhap lua chon : ");
			luaChon = input.nextInt();
			switch (luaChon) {
			case 1:
				do {
					System.out.println("Nhap (1: them giang vien | 2: them nhan vien)");
					choose = input.nextInt();
					switch (choose) {
					case 1:
						canBo.addGiangVienVaoListCanBo(input);
						break;
					case 2:
						canBo.addNhanVienVaoListCanBo(input);
						break;
					default:
						System.out.println("Ban da chon sai.");
						break;
					}
					System.out.println("Ban co muon tiep tuc khong : (0:khong | 1:co)");
					tiepTuc = input.nextInt();
				} while (tiepTuc == 1);
				break;

			case 2:
				canBo.showAll();
				break;

			case 3:

				System.out.println("Nhap ten khoa(phong ban) can hien thi");
				input.nextLine();
				donVi = input.nextLine();
				canBo.showDonVi(donVi);
				break;

			case 4:
				canBo.tongLuong();
				break;
			case 5:
				canBo.sapXepAToZ();
				canBo.showAll();
				break;
			case 6:
				System.out.println("Ket thuc chuong trinh");
				input.close();
				System.exit(0);
				break;
			default:
				System.out.println("nhap sai, moi ban chon lai.");
				break;
			}
		}
	}
}
