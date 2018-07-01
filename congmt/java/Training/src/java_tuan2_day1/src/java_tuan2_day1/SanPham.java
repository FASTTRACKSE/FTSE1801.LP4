package java_tuan2_day1;

import java.util.Scanner;

public class SanPham {
	private String tenSP;
	private double donGia;
	private double giamGia;
	private double thue;
	public SanPham(String tenSP, double donGia, double giamGia) {
		super();
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}
	public SanPham(String tenSP, double donGia) {
		super();
		this.tenSP = tenSP;
		this.donGia = donGia;
		
	}
	public SanPham() {}
	
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
	
	public double getThue() {
		return  donGia*10/100;
	}
	public  void nhap(Scanner sc) {
		
		System.out.println("- Nhập ten sản phẩm:");
		 tenSP=sc.nextLine();
		System.out.println("- Nhập đơn giá:");
		donGia=sc.nextDouble();
		System.out.println("- Nhập giảm giá:");
		giamGia=sc.nextDouble();
		sc.nextLine();
	}
	public  void xuat() {
		System.out.printf("%-3s|%-20s|%-15s|%-15s|%-10s \n","STT","Tên sản phẩm","Đơn giá","Giảm giá","Thuế");
		System.out.printf("%-3s|%-20s|%-15s|%-15s|%-10s \n","1.",getTenSP(),getDonGia(),getGiamGia(),getThue());
	}
	public static void main(String[]args) {
//		Bài 2
//		Scanner sc=new Scanner(System.in);
//		SanPham sp=new SanPham();
//		sp.nhap(sc);
//		sp.xuat();
//		SanPham sp1=new SanPham();
//		sp.nhap(sc);
//		sp.xuat();
//		sc.close();
		//Bài 3
//		SanPham sp2=new SanPham("Chó",1000000,10);
//		sp2.xuat();
//		SanPham sp3=new SanPham("Mèo",2000000);
//		sp3.xuat();
		//Bài 4
		SanPham sp1=new SanPham();
		Scanner sc= new Scanner(System.in);
		System.out.println("-Nhập tên sản phẩm:");
		 String tenSP=sc.nextLine();
		 sp1.setTenSP(tenSP);
		System.out.println("- Nhập đơn giá:");
		double donGia=sc.nextDouble();
		sp1.setDonGia(donGia);
		System.out.println("- Nhập giảm giá:");
		double giamGia=sc.nextDouble();
		sp1.setGiamGia(giamGia);
		sc.nextLine();
		System.out.printf("%-3s|%-20s|%-15s|%-15s|%-10s \n","STT","Tên sản phẩm","Đơn giá","Giảm giá","Thuế");
		
		System.out.printf("%-3s|%-20s|%-15s|%-15s|%-10s \n","1.",sp1.getTenSP(),sp1.getDonGia(),sp1.getGiamGia(),sp1.getThue());
		
	}
	

}
