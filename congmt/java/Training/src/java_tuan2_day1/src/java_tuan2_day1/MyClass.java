package java_tuan2_day1;

import java.util.Scanner;

public class MyClass {
	private SanPham[] listSanPham=new SanPham[100];
	private int soluongSp=0;
	public  void addSp(SanPham sanPham) {
		listSanPham[soluongSp]=sanPham;
		soluongSp=soluongSp+1;
	}
	public  void showListSp() {
		for (int i=0;i<soluongSp;i++) {
			listSanPham[i].xuat();
		}
	}
	public static  void main(String[]args) {
		MyClass mc=new MyClass();
		Scanner sc=new Scanner(System.in);
		SanPham sp1=new SanPham("Mèo", 200000);
		mc.addSp(sp1);
		SanPham sp2=new SanPham("Chó", 120000, 20000);
		mc.addSp(sp2);
		mc.showListSp();
		sc.close();
		
	}
}
