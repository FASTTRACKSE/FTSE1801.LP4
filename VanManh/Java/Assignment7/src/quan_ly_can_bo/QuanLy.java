package quan_ly_can_bo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLy {

	ArrayList<CanBo> listCanBo;

	public QuanLy() {
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
	 * sap xep giang vien theo ten a to z, neu trung ten thi sap xep theo luong
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

	/**
	 * Them can bo vao file
	 * 
	 * @throws IOException
	 */
	public void themCanBoVaoFile() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("CanBo.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(listCanBo);
		objectOutputStream.close();
		fileOutputStream.close();
	}

	/**
	 * hien thi can bo tu file
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void showCanBoTuFile() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("CanBo.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		ArrayList<CanBo> myList = (ArrayList) objectInputStream.readObject();

		System.out.printf("%3s %20s %25s %20s %20s %10s %20s %10s %15s", "STT", "Ten", "Nganh", "Khoa(phong ban)",
				"Trinh do(chuc vu)", "Phu cap", "So tiet(ngay cong)", "He so luong", "Luong");

		for (int i = 0; i < myList.size(); i++) {
			System.out.printf("%n %3s %20s %25s %20s %20s %10s %20s %10s %15s", i + 1, myList.get(i).getTen(),
					myList.get(i).getNganh(), myList.get(i).getDonVi(), myList.get(i).getTrinhDo(),
					myList.get(i).getPhuCap(), myList.get(i).getThoiGianTinhLuong(), myList.get(i).getHeSoLuong(),
					myList.get(i).getLuong());
		}
		System.out.println();
		System.out.println();

		objectInputStream.close();
		fileInputStream.close();
	}

	public static void main(String[] args) {
		QuanLy quanLy = new QuanLy();
		Scanner input = new Scanner(System.in);
		int luaChon = 0, tiepTuc = 0, choose = 0;
		String donVi;
		while (true) {
			System.out.println("1. Them can bo.");
			System.out.println("2. Xuat danh sach can bo");
			System.out.println("3. Xuat danh sach giang vien khoa x hoac nhan vien phong ban y.");
			System.out.println("4. Tinh tong so luong truong phai tra.");
			System.out.println("5. Sap xep can bo theo ten neu trung ten thi sap xep theo luong.");
			System.out.println("6. Them can bo vao file.");
			System.out.println("7. Hien thi can bo tu file.");
			System.out.println("0. Ket thuc.");

			System.out.println("Moi ban nhap lua chon : ");
			String luaChonStr = input.nextLine();
			try {
				luaChon = Integer.parseInt(luaChonStr);
			} catch (NumberFormatException e) {

			}

			switch (luaChon) {
			case 1:
				do {
					System.out.println("Nhap (1: them giang vien | 2: them nhan vien)");
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
						System.out.println("Ban da chon sai.");
						break;
					}
					System.out.println("Ban co muon tiep tuc khong : (1:co | con lai:khong )");
					String tiepTucStr = input.nextLine();
					try {
						tiepTuc = Integer.parseInt(tiepTucStr);
					} catch (NumberFormatException e) {
						break;
					}
				} while (tiepTuc == 1);
				break;

			case 2:
				quanLy.showAll();
				break;

			case 3:
				System.out.println("Nhap ten khoa(phong ban) can hien thi");
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
				try {
					quanLy.themCanBoVaoFile();
				} catch (IOException e) {
					System.out.println("Co loi");
				}
				break;

			case 7:

				try {
					quanLy.showCanBoTuFile();
				} catch (ClassNotFoundException e) {
					System.out.println("Co loi");
				} catch (IOException e) {
					System.out.println("Co loi");
				}
				break;
			case 0:
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
