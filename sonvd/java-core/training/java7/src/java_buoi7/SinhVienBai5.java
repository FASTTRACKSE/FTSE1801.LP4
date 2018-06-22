package java_buoi7;

import java.util.Scanner;

public class SinhVienBai5 {
	private String tenSp;
	private double donGia;
	private double giamGia;
	public String getTenSp() {
		return tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	public double getDonGia() {
		return donGia;
	}
	public double getThueNhapKhau(){		
		return donGia*10/100;
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
		Scanner sc = new Scanner(System.in);
		SinhVienBai5 sp1 = new SinhVienBai5();	
		System.out.println("Nhập tên sản phẩm: ");
		sp1.setTenSp(sc.nextLine());
		System.out.println("Nhập giá sản phẩm: ");
		sp1.setDonGia(sc.nextDouble());
		System.out.println("Nhập giảm giá: ");
		sp1.setGiamGia(sc.nextDouble());
		System.out.printf("%20s| %10s| %10s| %10s| \n","Tên sản phẩm","Đơn giá","Giảm giá","Thuế Nk");
		System.out.printf("%20s| %10s| %10s| %10s| \n",sp1.getTenSp(),sp1.getDonGia(),sp1.getGiamGia(),sp1.getThueNhapKhau());
	}
}
