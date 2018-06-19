package lap;

import java.util.Scanner;

public class SanPham {
	
	private String tenSp;
	private double donGia;
	private double giamGia;
	
	private double getThueNhapKhau() {
		
		return donGia*10/100;
		
		
	}
	public void nhap(Scanner sc) {
		
		System.out.print("Nhap ten san pham: ");
		tenSp=sc.nextLine();
		System.out.print("Gia san pham: ");
		donGia=sc.nextDouble();
		System.out.print("Giam gia: ");
		giamGia=sc.nextDouble();
		sc.nextLine();
		
		
		
	}
	public void xuat() {
		System.out.println("ten san pham: "+tenSp);
		System.out.println("gia san pham: "+donGia);
		System.out.println("giam gia: "+giamGia);
		System.out.println("thue san pham: "+getThueNhapKhau());
		System.out.println();
	
		
	}
	
	public SanPham(String tenSp, double donGia, double giamGia){ 
		this.tenSp = tenSp;
		this.donGia= donGia;
		this.giamGia=giamGia;
	}
	
	public SanPham(String tenSp, double donGia){
		
		this(tenSp, donGia, 0);
		
	}
	public SanPham(){
		
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
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SanPham sp1=new SanPham();
		sp1.nhap(sc);
		sp1.xuat();
		System.out.println();
		SanPham sp2=new SanPham();
		sp2.nhap(sc);
		sp2.xuat();
		System.out.println();
		
		
		SanPham sp3=new SanPham("hoa",10000,100);
		sp3.xuat();
		SanPham sp4=new SanPham("hoa",10000);
		sp4.xuat();
		
		
		SanPham sp5= new SanPham();
		System.out.print("Nhap ten san pham: ");
		String name=sc.nextLine();
		System.out.print("Gia san pham: ");
		double cost=sc.nextDouble();
		System.out.print("Giam gia: ");
		double costdown=sc.nextDouble();
		sp5.setTenSp(name);
		sp5.setDonGia(cost);
		sp5.setGiamGia(costdown);
		sc.close();
		sp5.xuat();
		
		
		
		
		
	}
	
	

	

}
