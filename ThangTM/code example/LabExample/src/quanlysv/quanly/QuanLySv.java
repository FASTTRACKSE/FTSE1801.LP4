package quanlysv.quanly;

import java.util.ArrayList;

import quanlysv.entity.SinhVien;

/**
 * Manage list student
 * @author GaLonTon
 *
 */
public class QuanLySv {

	/** List sinh vien */
	private ArrayList<SinhVien> listSinhVien;

	public QuanLySv() {
		listSinhVien = new ArrayList<SinhVien>();
	}

	/**
	 * Add new sinh vien to list sinh vien
	 * @param sinhVien sinh vien need add new
	 */
	public void addSinhVien(SinhVien sinhVien) {
		listSinhVien.add(sinhVien);
	}

	/**
	 * Display info of some sinh vien in list sinh vien
	 * @param sinhVien some sinh vien
	 */
	public void displaySinhVien(SinhVien sinhVien) {
		System.out.format("%10s | %-30s | %3d | %2.1f%n",
														sinhVien.getId(),
														sinhVien.getName(),
														sinhVien.getOld(),
														sinhVien.getDtb());
	}

	/**
	 * Display all sinh vien
	 */
	public void displayAllSinhVien() {
		for (SinhVien sinhVien : listSinhVien) {
			displaySinhVien(sinhVien);
		}
	}

	/**
	 * get total sinh vien in list
	 * @return total sinh vien
	 */
	public int getTotalSinhVien() {
		return listSinhVien.size();
	}

	public static void main(String[] args) {
		QuanLySv quanLySv = new QuanLySv();
		SinhVien sinhVien = new SinhVien("ffse1801", "Vui", 15, 6);
		quanLySv.addSinhVien(sinhVien);

		sinhVien = new SinhVien("ffse1802", "Vui Hon", 16, 7);
		quanLySv.addSinhVien(sinhVien);

		quanLySv.displayAllSinhVien();
		System.out.println("so luong sinh vien la : " + quanLySv.getTotalSinhVien());

	}
}
