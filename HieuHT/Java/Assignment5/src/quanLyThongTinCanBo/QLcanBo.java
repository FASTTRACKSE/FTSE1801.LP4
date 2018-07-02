package quanLyThongTinCanBo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLcanBo {

	ArrayList<CanBo> listCanBo;

	public QLcanBo() {
		listCanBo = new ArrayList<CanBo>();
	}

	/**
	 * Thêm giảng viên và danh sách cán bộ
	 * 
	 * @param input
	 */
	public void addGiangVienVaoListCanBo(Scanner input) {
		GiangVien giangVien = new GiangVien();
		giangVien.addGiangVien(input, giangVien);
		listCanBo.add(giangVien);
	}

	/**
	 * Thêm giảng viên và danh sách cán bộ
	 * 
	 * @param input
	 */
	public void addNhanVienVaoListCanBo(Scanner input) {
		NVHanhChinh nhanVienHanhChinh = new NVHanhChinh();
		nhanVienHanhChinh.addNhanVienHanhChinh(input, nhanVienHanhChinh);
		listCanBo.add(nhanVienHanhChinh);
	}

	/**
	 * Hiển thị danh sách giảng viên theo đơn vị
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
			System.out.println("Nhập sai khoa (phòng ban)");
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
	 * Hiển thị tất cả giảng viên
	 */
	public void showAll() {
		System.out.printf("%3s %20s %25s %20s %20s %10s %20s %10s %15s", "STT", "Ten", "Nganh", "Khoa(phong ban)",
				"Trinh do(chuc vu)", "Phu cap", "So tiet(ngay cong)", "He so luong", "Luong");
		for (int i = 0; i < listCanBo.size(); i++) {
			System.out.printf("%n %3s %20s %25s %20s %20s %10s %20s %10s %15s", i + 1, listCanBo.get(i).getTen(),
					listCanBo.get(i).getNganh(), listCanBo.get(i).getDonVi(), listCanBo.get(i).getTrinhDo(),
					listCanBo.get(i).getPhuCap(), listCanBo.get(i).getThoiGianTinhLuong(),
					listCanBo.get(i).getHeSoLuong(), listCanBo.get(i).getLuong());
		}
		System.out.println();
	}

	/**
	 * Sặp xếp giảng viên theo tên a to z, nếu trùng tên sắp xếp theo lương
	 */
	public void sapXepAToZ() {
		Collections.sort(listCanBo, new sapXep());
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
	 * Tính tổng lương phải trả
	 */
	public void tongLuong() {
		double tongLuong = 0;
		for (int i = 0; i < listCanBo.size(); i++) {
			tongLuong = listCanBo.get(i).getLuong() + tongLuong;
		}
		System.out.println("Tổng lương phải trả: " + tongLuong);
		System.out.println();
	}

	public static void main(String[] args) {
		QLcanBo quanLy = new QLcanBo();
		Scanner input = new Scanner(System.in);
		int luaChon = 0, tiepTuc = 0, choose = 0;
		String donVi;
		while (true) {
			System.out.println("1. Thêm cán bộ.");
			System.out.println("2. Xuất danh sách cán bộ");
			System.out.println("3. Xuất danh sách giảng viên khoa x hoặc nhân viên phòng ban y.");
			System.out.println("4. Tính tổng số lương phải trả.");
			System.out.println("5. Sắp xếp cán bộ theo tên nếu trùng tên thì sắp xếp theo lương.");
			System.out.println("6. Kết thúc.");

			System.out.println("Mời bạn nhập lựa chọn : ");
			String luaChonStr = input.nextLine();
			try {
				luaChon = Integer.parseInt(luaChonStr);
			} catch (NumberFormatException e) {

			}

			switch (luaChon) {
			case 1:
				do {
					System.out.println("Nhập (1: thêm giảng viên | 2: thêm nhân viên)");
					String chooseStr = input.nextLine();
					try {
						choose = Integer.parseInt(chooseStr);
					} catch (NumberFormatException e) {
					}
					switch (choose) {
					case 1:
						quanLy.addGiangVienVaoListCanBo(input);
						break;
					case 2:
						quanLy.addNhanVienVaoListCanBo(input);
						break;
					default:
						System.out.println("Bạn đã chọn sai.");
						break;
					}
					System.out.println("Bạn có muốn tiếp tục không : (1:có | còn lại:không )");
					String tiepTucStr = input.nextLine();
					try {
						tiepTuc = Integer.parseInt(tiepTucStr);
					} catch (NumberFormatException e) {
						break;
					}
				} while (tiepTuc == 0);
				break;

			case 2:
				quanLy.showAll();
				break;

			case 3:
				System.out.println("Nhập tên khoa(phòng ban) cần hiển thị");
				input.nextLine();
				donVi = input.nextLine();
				quanLy.showDonVi(donVi);
				break;

			case 4:
				quanLy.tongLuong();
				break;

			case 5:
				quanLy.sapXepAToZ();
				quanLy.showAll();
				break;

			case 6:
				System.out.println("Kết thúc chương trình");
				input.close();
				System.exit(0);
				break;

			default:
				System.out.println("nhập sai, mời bạn chọn lại.");
				break;
			}
		}
	}
}