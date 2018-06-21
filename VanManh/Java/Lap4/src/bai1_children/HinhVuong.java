package bai1_children;

import bai1_parent.ChuNhat;

public class HinhVuong extends ChuNhat{
	
	public HinhVuong(double canh) {
		super(canh,canh);
	}
	// override phương thức từ hình chữ nhật
	public void xuat() {
		System.out.print("Cạnh hình vuông là : ");
		System.out.println(getChieuDai());
		System.out.print("Chu vi hình vuông là : ");
		System.out.println(getChuVi());
		System.out.print("Diện tích vuông là : ");
		System.out.println(getDienTich());
	}
}
