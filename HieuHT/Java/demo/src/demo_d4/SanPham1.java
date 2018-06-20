package demo_d4;

import java.util.Scanner;

public class SanPham1 {
	public static SanPham[] ListSanPham = new SanPham[100];
	public static int soLuongSp = 0;

	public void addSp(SanPham sanPham) {
		ListSanPham[soLuongSp] = sanPham;
		soLuongSp = soLuongSp + 1;
	}

	public void showListSp() {
		for (int i = 0; i < soLuongSp; i++) {
			ListSanPham[i].xuat();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SanPham1 mc = new SanPham1();
		SanPham sp1 = new SanPham("iphoneX", 30000000);
		mc.addSp(sp1);
		SanPham sp2 = new SanPham("iphone8", 24000000);
		mc.addSp(sp2);
		mc.showListSp();

		scanner.close();
	}
}