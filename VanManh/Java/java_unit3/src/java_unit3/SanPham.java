package java_unit3;

import java.util.Scanner;

public class SanPham {
	private String tenSP;
	private double donGia;
	private double giamGia;
	
	 SanPham(String tenSP, double donGia, double giamGia){
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}
	
	public SanPham(String tenSP, double donGia){
		this(tenSP, donGia, 0);
	}
	
	public SanPham(){
		
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
		return (donGia*10)/100;
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
		
		System.out.print("Nhập tên sản phẩm : ");
		String tenSP = input.nextLine();
		System.out.print("Nhập đơn giá của sp : ");
		double donGia = input.nextDouble();
		System.out.print("Nhập giảm giá của sp : ");
		double giamGia = input.nextDouble();
		input.nextLine();
		System.out.println();
		
		SanPham sp1 = new SanPham();
		sp1.setTenSP(tenSP);
		sp1.setDonGia(donGia);
		sp1.setGiamGia(giamGia);
		input.close();
		
		System.out.println("Tên sản phẩm   : " + sp1.getTenSP());
		System.out.println("Đơn giá        : " + sp1.getDonGia());
		System.out.println("Giảm giá       : " + sp1.getGiamGia());
		System.out.println("Thuế nhập khẩu : " + sp1.getThueNhapKhau());
		System.out.println();
		
		
		
//		SanPham sp = new SanPham();
//		sp.nhap(input);
//	
//		SanPham sp2 = new SanPham();
//		sp2.nhap(input);
//		
//		sp2.xuat();
//		sp.xuat();
//		input.close();
//		
		
	}
	
}
