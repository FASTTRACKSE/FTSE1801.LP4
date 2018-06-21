package bai2_bai3_children;

import bai2_bai3_parent.SinhVienFpt;

public class SinhVienBiz extends SinhVienFpt {
	private double marketing;
	private double sales;

	public SinhVienBiz(String hoTen, String nganh, double marketing, double sales) {
		super(hoTen, nganh);
		this.marketing = marketing;
		this.sales = sales;
	}

	public double getDiem() {
		return (2 * marketing + sales) / 3;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Điểm marketing là : " + marketing);
		System.out.println("Điểm sales là : " + sales);
		System.out.println("Điểm trung bình là : " + getDiem());
		System.out.println("Xếp loại : " + super.getHocLuc(getDiem()));
	}

}
