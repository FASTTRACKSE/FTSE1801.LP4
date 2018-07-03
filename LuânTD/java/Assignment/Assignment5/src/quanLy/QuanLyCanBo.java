package quanLy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import canBo.CanBo;
import canBo.GiangVien;
import canBo.NhanVien;
/**
 * Class quan ly can bo
 * @author Luan
 *
 */
public class QuanLyCanBo {
	private ArrayList<CanBo> listCanBo;
	/**
	 * Mang can bo
	 */
	public QuanLyCanBo() {
		listCanBo = new ArrayList<CanBo>();
	}
	/**
	 * Them giang vien
	 * @param sc scanner
	 */
	public void addGiangVien(Scanner sc) {
		GiangVien giangVien = new GiangVien();
		giangVien.nhapGiangVien(sc, giangVien);
		listCanBo.add(giangVien);
	}
	/**
	 * Them Nhan Vien
	 * @param sc scanner
	 */
	public void addNhanVien(Scanner sc) {
		NhanVien nhanVien = new NhanVien();
		nhanVien.nhapNhanVien(sc, nhanVien);
		listCanBo.add(nhanVien);
	}
	/**
	 * Hien thi danh sach can bo
	 */
	public void showCanBo() {
		System.out.printf("%3s %20s %25s %20s %10s %20s %10s %15s", "STT", "Ho Ten", "Don Vi", "Trinh Do", "Phu Cap",
				"So Gio Lam", "He So Luong", "Luong");
		System.out.println();
		for (int i = 0; i < listCanBo.size(); i++) {
			System.out.printf("%n %3s %20s %25s %20s %10s %20s %10s %15s", i + 1, listCanBo.get(i).getHoTen(),
					listCanBo.get(i).getDonVi(), listCanBo.get(i).getTrinhDo(), listCanBo.get(i).getPhuCap(),
					listCanBo.get(i).getSoGioLam(), listCanBo.get(i).getHeSoLuong(), listCanBo.get(i).getLuong());
		}
		System.out.println();
	}
	/**
	 * Tim can bo them don vi(Khoa hoac phong ban)
	 * @param donVi don vi
	 */
	public void findCanBo(String donVi) {
		System.out.printf("%3s %20s %25s %20s %10s %20s %10s %15s", "STT", "Ho Ten", "Don Vi", "Trinh Do", "Phu Cap",
				"So Gio Lam", "He So Luong", "Luong");
		System.out.println();
		for (int i = 0; i < listCanBo.size(); i++) {
			if (listCanBo.get(i).getDonVi().equals(donVi))
				System.out.printf("%n %3s %20s %25s %20s %10s %20s %10s %15s", i + 1, listCanBo.get(i).getHoTen(),
						listCanBo.get(i).getDonVi(), listCanBo.get(i).getTrinhDo(), listCanBo.get(i).getPhuCap(),
						listCanBo.get(i).getSoGioLam(), listCanBo.get(i).getHeSoLuong(), listCanBo.get(i).getLuong());
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * Tinh tong tien truong phai tra cho Can bo;
	 */
	public void sumLasary() {
		double tongLuong = 0;
		for (int i = 0; i < listCanBo.size(); i++) {
			tongLuong = listCanBo.get(i).getLuong() + tongLuong;
		}
		System.out.println("Tong luong truong phai tra cho can bo la:  " + tongLuong);
	}
	/**
	 * Sap xep can bo theo luong tu thap den cao;
	 */
	public void sortCanBo() {
		Collections.sort(listCanBo, new Comparator<CanBo>() {
			public int compare(CanBo o1, CanBo o2) {
				return (int) (o1.getLuong() - o2.getLuong());
			}

		});

	}

	public static void main(String[] args) {
		int tiepTuc, luaChon;
		String donVi;
		QuanLyCanBo quanLy = new QuanLyCanBo();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("/***********************************/");
			System.out.println("1. Thêm giảng viên.");
			System.out.println("2. Thêm nhân viên");
			System.out.println("3. Hiển thị danh sách cán bộ thêm khoa(Phòng ban) .");
			System.out.println("4. Tổng số lương trường trả cho cán bộ .");
			System.out.println("5. Hiển thị danh sách cán bộ sắp xếp theo lương .");
			System.out.println("0. Kết thúc chương trình .");
			System.out.println("/***********************************/");

			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = sc.nextInt();
			System.out.println();

			switch (luaChon) {
			case 1:
				do {
					quanLy.addGiangVien(sc);
					System.out.println("Ban co muon tiep tuc khong : (0:khong | 1:co)");
					tiepTuc = sc.nextInt();
				} while (tiepTuc == 1);
				break;
			case 2:
				do {
					quanLy.addNhanVien(sc);
					System.out.println("Ban co muon tiep tuc khong : (0:khong | 1:co)");
					tiepTuc = sc.nextInt();
				} while (tiepTuc == 1);
				break;
			case 3:
				System.out.println("Nhap ten khoa(phong ban) can hien thi");
				sc.nextLine();
				donVi = sc.nextLine();
				quanLy.findCanBo(donVi);
				break;
			case 4:
				quanLy.sumLasary();
				break;
			case 5:
				quanLy.sortCanBo();
				quanLy.showCanBo();
				break;
			case 0:
				System.out.println("Ket thuc chuong trinh");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("nhap sai, moi ban chon lai.");
				break;
				
				
			}
		}
	}

}
