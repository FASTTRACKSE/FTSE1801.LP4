package java_day8;

import java.util.Scanner;

public class SanPham2 {
	private String tenSp;
	private double donGia;
	private double giamGia;
	
	public SanPham2(String tenSp,double donGia,double giamGia){
		this.tenSp = tenSp;
		this.donGia =  donGia;
		this.giamGia = giamGia;
	}
	
	public SanPham2(String tenSp,double donGia) {
		this.tenSp = tenSp;
		this.donGia = donGia;
	}
	
	public SanPham2() {
	}
	
	public double getThueNhapKhau(){		
		return donGia*10/100;
	}
	
	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
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

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên sản phẩm: ");
		tenSp = sc.nextLine();
		System.out.println("Nhập giá sản phẩm: ");
		donGia = sc.nextDouble();
		System.out.println("Sản phẩm giảm giá: ");
		giamGia = sc.nextDouble();
		sc.nextLine();
	}
	public void xuat() {	
		System.out.printf("%20s| %10s| %10s| %10s| \n","Tên sản phẩm","Đơn giá","Giảm giá","Thuế Nk");
		System.out.printf("%20s| %10s| %10s| %10s| \n",tenSp,donGia,giamGia,getThueNhapKhau());
	}
	public static void main(String[] args) {
		SanPham2 sp = new SanPham2();
		sp.nhap();
		sp.xuat();
		SanPham2 sp1 = new SanPham2();
		sp1.nhap();		
		sp1.xuat();
		SanPham2 sp2 = new SanPham2("vở",5000,1000);
		sp2.xuat();
		SanPham2 sp3 = new SanPham2("Bút",3000);
		sp3.xuat();
	}
}
