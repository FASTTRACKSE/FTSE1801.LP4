package nhaTro;

import java.util.Scanner;

/**
 * 
 * @author HieuHT
 *
 */
public class PhongTro {
	private int soNgaytro;
	private String loaiP;
	private double giaP;
	Nguoi nguoi;

	public PhongTro() {

	}

	public PhongTro(int soNgaytro, String loaiP, double giaP, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiP = loaiP;
		this.giaP = giaP;
		this.nguoi = nguoi;
	}

	/**
	 * Set thông tin người thuê và số ngày trọ
	 * 
	 * @param sc dùng cho việc đọc data từ ban phím
	 */
	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin(sc);

		System.out.print("Nhập số ngày trọ: ");
		this.soNgaytro = sc.nextInt();

		sc.nextLine();
		System.out.print("Nhập loại phòng trọ: ");
		this.loaiP = sc.nextLine();

		System.out.print("Nhập giá phòng: ");
		this.giaP = sc.nextDouble();
		sc.nextLine();
	}

	/**
	 * Hiển thị tất cả thông tin của phòng trọ bao gồm thông tin người trọ và loại phòng
	 * trọ
	 */
	public void hienThongTin() {
		nguoi.hienThongTin();
		System.out.println("Số ngày trọ: " + this.soNgaytro);
		System.out.println("Loại phòng: " + this.loaiP);
		System.out.println("Giá phòng: " + this.giaP);
	}

	/**
	 * Tính số tiền đã ở tọ
	 * 
	 * @return tổng tiền ở tọ
	 */
	public double thanhTien() {
		return this.soNgaytro * this.giaP;
	}

	/**
	 * Get thông tin khách hàng đang ở trọ hiện tại
	 * 
	 * @return người ở trọ
	 */
	public Nguoi getKhach() {
		return this.nguoi;
	}

	/**
	 * Hàm xóa thông tin của người thuê trọ khi trả phòng
	 */
	public void xoaThongTinPhongTro() {
		this.nguoi = null;
		this.soNgaytro = 0;
		this.loaiP = null;
		this.giaP = 0;
	}

}
