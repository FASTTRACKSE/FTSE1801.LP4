package lap3;

import java.util.Scanner;

public class Bai1_SanPham {
	private String tenSP;
	private double donGia;
	private double giamGia;

	Bai1_SanPham(String tenSP, double donGia, double giamGia) {
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public Bai1_SanPham(String tenSP, double donGia) {
		this(tenSP, donGia, 0);
	}

	public Bai1_SanPham() {

	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getThueNhapKhau() {
		return (donGia * 10) / 100;
	}

	public void nhap(Scanner input) {
		System.out.print("Nhập tên sản phẩm : ");
		String tenSP = input.nextLine();
		System.out.print("Nhập đơn giá của sp : ");
		double donGia = input.nextDouble();
		System.out.print("Nhập giảm giá của sp : ");
		double giamGia = input.nextDouble();
		input.nextLine();
		System.out.println();

		this.tenSP = tenSP;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public void xuat() {

		System.out.println("Tên sản phẩm   : " + tenSP);
		System.out.println("Đơn giá        : " + donGia);
		System.out.println("Giảm giá       : " + giamGia);
		System.out.println("Thuế nhập khẩu : " + getThueNhapKhau());
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Bài 1 + bài 4 :nhập sp từ bàn phím dùng get set để lưu và in
		System.out.print("Nhập tên sản phẩm : ");
		String tenSP = input.nextLine();
		System.out.print("Nhập đơn giá của sp : ");
		double donGia = input.nextDouble();
		System.out.print("Nhập giảm giá của sp : ");
		double giamGia = input.nextDouble();
		input.nextLine();
		System.out.println();

		Bai1_SanPham sp1 = new Bai1_SanPham();
		sp1.setTenSP(tenSP);
		sp1.setDonGia(donGia);
		sp1.setGiamGia(giamGia);
		System.out.println("Nhập giá trị từ bàn phím và dùng phương thức getter và setter ");
		System.out.println("Tên sản phẩm   : " + sp1.getTenSP());
		System.out.println("Đơn giá        : " + sp1.getDonGia());
		System.out.println("Giảm giá       : " + sp1.getGiamGia());
		System.out.println("Thuế nhập khẩu : " + sp1.getThueNhapKhau());
		System.out.println();

		// Bài 2 dùng phương thức gọi 2 sản phẩm
		System.out.println("Tạo 2 sản phẩm nhập giá trị từ bàn phím ");
		Bai1_SanPham sp = new Bai1_SanPham();
		sp.nhap(input);
		sp.xuat();

		Bai1_SanPham sp2 = new Bai1_SanPham();
		sp2.nhap(input);
		sp2.xuat();

		// bài 3 : dùng 2 hàm tạo để tạo sp
		System.out.println("Dùng hàm tạo tạo 2 sản phẩm ");
		Bai1_SanPham sp3 = new Bai1_SanPham("trà xanh", 20000);
		sp3.xuat();

		Bai1_SanPham sp4 = new Bai1_SanPham("Cà phê", 25000, 2000);
		sp4.xuat();

		input.close();

	}

}
