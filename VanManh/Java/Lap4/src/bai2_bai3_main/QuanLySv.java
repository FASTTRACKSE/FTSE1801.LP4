package bai2_bai3_main;

import bai2_bai3_children.*;

public class QuanLySv {
	public static void main(String[] args) {
		//In ra thông tin sinh viên It
		SinhVienIT SvIT = new SinhVienIT("Mạnh", "IT", 5, 6, 6);
		SvIT.xuat();
		//In ra thông tin sinh viên Biz
		System.out.println();
		SinhVienBiz SvBiz = new SinhVienBiz("Nam", "Biz", 6, 7);
		SvBiz.xuat();
	}
}
