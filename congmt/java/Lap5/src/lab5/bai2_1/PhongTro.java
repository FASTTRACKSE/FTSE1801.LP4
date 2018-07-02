package lab5.bai2_1;

import java.util.Scanner;

/**
 * Class for contain info Home stay
 * 
 * @author CongMT
 *
 */
public class PhongTro {
	private int soNgaytro;
	private int loaiP;
	Nguoi nguoi;

	public PhongTro() {

	}

	public PhongTro(int soNgaytro, int loaiP, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiP = loaiP;

		this.nguoi = nguoi;
	}

	public int getSoNgaytro() {
		return soNgaytro;
	}

	public void setSoNgaytro(int soNgaytro) {
		this.soNgaytro = soNgaytro;
	}

	public int getLoaiP() {
		return loaiP;
	}

	public void setLoaiP(int loaiP) {
		this.loaiP = loaiP;
	}

	public Nguoi getNguoi() {
		return nguoi;
	}

	public void setNguoi(Nguoi nguoi) {
		this.nguoi = nguoi;
	}

	/**
	 * Set thong tin nguoi thue va so ngay tro
	 * 
	 * @param sc dung cho viec doc data tu ban phim
	 *            
	 */
	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin(sc);

		System.out.print("Nhập số ngày trọ: ");
		this.soNgaytro = sc.nextInt();

		sc.nextLine();
		System.out.print("Nhập loại phòng trọ: ");
		this.loaiP = sc.nextInt();

	}

	public double getGiaP() {
		if (getLoaiP() == 1) {
			return 100000;
		} else if (getLoaiP() == 2) {
			return 80000;
		} else if (getLoaiP() == 3) {
			return 60000;
		} else {
			System.out.println("Không có loại phòng này.!");
		}
		return getGiaP();

	}

	/**
	 * Tinh so tien da o tro
	 * 
	 * @return tong tien o tro
	 */
	public double getThanhTien() {
		return getSoNgaytro() * getGiaP();
	}

	/**
	 * Get thong tin khach hang dang o phong tro hien tai
	 * 
	 * @return nguoi o tro
	 */
	public Nguoi getKhach() {
		return this.nguoi;
	}

}
