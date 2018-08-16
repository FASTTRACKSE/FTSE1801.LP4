package java_d6_huongdoituong;

import java.util.Scanner;

public class SanPham {
     private String tenSP;
     private double donGia;
     private double giamGia;
     
     private double getThueNhapKhau() {
    	 return donGia*10/100;
    	 
     }
     public SanPham(String tenSP, double donGia, double giamGia) {
    	 this.tenSP = tenSP;
    	 this.donGia = donGia;
    	 this.giamGia = giamGia;
     }
    public SanPham(String tenSP, double donGia) {
    	this(tenSP, donGia, 0);
    }
    SanPham(){
    	
    }
     
     public void nhap() {
    	 Scanner sc = new Scanner(System.in);
    	
    	 System.out.println("Nhập tên sản phẩm: ");
    	 tenSP = sc.nextLine();
    	 System.out.println("Nhập giá sản phẩm: ");
    	 donGia = sc.nextDouble();
    	 System.out.println("Giảm giá sản phẩm: ");
    	 giamGia = sc.nextDouble();
     }
     public void xuat() {
    	 System.out.println("Tên sản phẩm: "+ tenSP);
    	 System.out.println("Giá sản phẩm: "+ donGia);
    	 System.out.println("Giảm giá sản phẩm: "+ giamGia);
    	 System.out.println("Thuế nhập khẩu: "+ getThueNhapKhau());
     }
     public static void main(String[]args) {
    	 SanPham SP = new SanPham();
    	 SP.nhap();
    	 SP.xuat();
    	 SP.getThueNhapKhau();
    	 SanPham SP1 = new SanPham();
    	 SP1.nhap();
    	 SP1.xuat();
    	 SP.getThueNhapKhau();
    	 
    	 
    	 //bài 3
    	 SanPham SP2 = new SanPham("xe hơi", 120000, 1000);
    	 
    	 SP2.xuat();
    	 SP2.getThueNhapKhau();
    	 
    	 
    	 SanPham SP3 = new SanPham("xe máy", 150000);
    	 SP3.xuat();
    	 SP3.getThueNhapKhau();
     }
}
