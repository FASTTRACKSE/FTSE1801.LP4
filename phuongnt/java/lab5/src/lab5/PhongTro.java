package lab5;

import java.util.Scanner;

/**
 * 
 * 
 * @author Phươngnt
 *
 */
public class PhongTro {
	private int soNgaytro;
	private int loaiP;
	private double giaP;
	Nguoi nguoi;

	public PhongTro() {

	}

	public PhongTro(int soNgaytro, int loaiP, double giaP, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiP = loaiP;
		this.giaP = giaP;
		this.nguoi = nguoi;
	}

	/**
	 * Xet thong tin nguoi thue va so ngay tro
	
	 */
	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapThongTin(sc);

		System.out.print("Nhập số ngày trọ: ");
		this.soNgaytro = sc.nextInt();

		sc.nextLine();
		System.out.print("Nhập loại phòng trọ(1, 2, 3): ");
		this.loaiP = sc.nextInt();

		System.out.print("Nhập giá phòng trọ(1000, 500, 200): ");
		this.giaP = sc.nextDouble();
		sc.nextLine();
	}

	/**
	 * Hien thi tat ca thong tin cua phong tro Bao gom thong nguoi tro va loai phong
	 * tro
	 */
	public void hienThongTin() {
		
		nguoi.hienThongTin();
		System.out.println("Số ngày trọ: " + this.soNgaytro);
		System.out.println("Loại phòng: " + this.loaiP);
		System.out.println("Giá phòng: " + this.giaP);
		System.out.println("Số tiền phải trả: "+thanhTien());
		
		System.out.printf("%20s | %10s | %10s | %12s | %12s | %12s | %12s \n","Họ tên khách hàng","Ngày sinh", "Số CMND", "Số ngày trọ", "Loại phòng", "Giá phòng", "Thành tiền");
		System.out.printf("%20s | %10s | %10s | %12s | %12s | %12s | %12s \n",getKhach().getHoTen(), getKhach().getNgaySinh(), getKhach().getSoCMND(), soNgaytro, loaiP, giaP, thanhTien());
	}

	/**
	 * Tinh so tien da o tro
	 * 
	 * @return tong tien o tro
	 */
	public double thanhTien() {
		return this.soNgaytro * this.giaP;
	}

	/**
	 * Get thong tin khach hang dang o phong tro hien tai
	 * 
	 * @return nguoi o tro
	 */
	public Nguoi getKhach() {
		return this.nguoi;
	}

	/**
	 * Ham xoa thong tin cua nguoi thue tro khi tra phong
	 */
	public void xoaThongTinPhongTro() {
		this.nguoi = null;
		this.soNgaytro = 0;
		this.loaiP = 0;
		this.giaP = 0;
	}

}