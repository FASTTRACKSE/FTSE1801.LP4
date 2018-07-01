package Lap5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Quan ly phong tro
 * 
 * @author SonVD
 *
 */
public class QLNhaTro {
	private ArrayList<PhongTro> listPhongTro;
	int n;

	/**
	 * 
	 */
	public QLNhaTro() {
		listPhongTro = new ArrayList<PhongTro>();
	}

	/**
	 * Cho thue phong tro
	 * 
	 * @param phongTro
	 *            phong tro
	 */
	public void choThuePhong(PhongTro phongTro) {
		listPhongTro.add(phongTro);
	}

	/**
	 * Tra phong
	 * 
	 * @param CMND
	 *            Chung minh nhan dan
	 */
	public void traPhong(String CMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (CMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}
		if (phongTro != null) {
			listPhongTro.remove(phongTro);
			System.out.println("Khách đã trả phòng.");
		} else {
			System.out.println("Nhập sai số CMND");
		}
	}

	/**
	 * Lay thong tin phong tro
	 * 
	 * @param CMND
	 *            Chung minh nhan dan
	 */
	public void layThongTinPHongTro(String CMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (CMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}
		if (phongTro != null) {
			phongTro.hienThiThongTin();
		} else {
			System.out.println("Nhập sai số CMND");
		}
	}

	/**
	 * Tinh tien phong tro
	 * 
	 * @param CMND
	 *            chung minh nhan dan
	 */
	public void tinhTienPhongTro(String CMND) {
		PhongTro phongTro = null;
		for (int i = 0; i < listPhongTro.size(); i++) {
			if (CMND.equals(listPhongTro.get(i).getKhach().getSoCMND())) {
				phongTro = listPhongTro.get(i);
				break;
			}
		}
		if (phongTro != null) {
			System.out.println("Số tiền khách phải trả: " + phongTro.thanhTien());
		} else {
			System.out.println("Nhập sai số CMND");
		}
	}

	/**
	 * Menu list phong tro
	 */
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng khách cần trọ: ");
		n = sc.nextInt();
		listPhongTro = new ArrayList<PhongTro>(n);

		PhongTro phongTro;
		for (int i = 0; i < n; i++) {
			phongTro = new PhongTro();
			phongTro.nhapThongTin(sc);
			choThuePhong(phongTro);
		}

		for (int i = 0; i < listPhongTro.size(); i++) {
			listPhongTro.get(i).hienThiThongTin();
		}

		String search;
		sc.nextLine();
		System.out.println("Nhập số chứng minh nhân dân của khách cần thanh toán: ");
		search = sc.nextLine();
		tinhTienPhongTro(search);
		
		traPhong(search);
	}

	public static void main(String[] args) {
		QLNhaTro qlPhongTro = new QLNhaTro();
		qlPhongTro.menu();
	}
}
