package java_d6_huongdoituong;

import java.util.Scanner;

public class SanPham_3 {
	private String tenSP;
    private double donGia;
    private double giamGia;
    
    private double getThueNhapKhau() {
   	 return donGia*10/100;
   	 
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
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		SanPham_3 sp = new SanPham_3();
		System.out.print("nhập tên sp: ");
		String tenSP = sc.nextLine();
		sp.setTenSP(tenSP);
		
		System.out.print("nhập giá sp: ");
		int donGia = sc.nextInt();
		sp.setDonGia(donGia);
		System.out.print("giam giá sp: ");
		int giamGia = sc.nextInt();
		sp.setGiamGia(giamGia);
	    
		System.out.println("tên sản phẩm: "+sp.getTenSP());
		System.out.println("giá sản phẩm: "+sp.getDonGia());
		System.out.println("giảm giá sản phẩm: "+sp.getGiamGia());
		System.out.println("tên sản phẩm: "+sp.getThueNhapKhau());
	}
	
	
}
