package java_day8;

import java.util.Scanner;

public class MyClass {
	public static SanPham2[] listSanPham = new SanPham2[100];
	public static int soluongSP = 0;
	public static void addSp(SanPham2 sanPham) {
		listSanPham[soluongSP] =  sanPham;
		soluongSP = soluongSP + 1;
	}
	public static void showListSp() {
		for (int i = 0;i<soluongSP;i++) {
			listSanPham[i].xuat();
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		SanPham2 sp1 = new SanPham2("bút",10000);
		addSp(sp1);
		showListSp();
	}
}

