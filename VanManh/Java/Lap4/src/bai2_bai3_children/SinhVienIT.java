package bai2_bai3_children;

import bai2_bai3_parent.SinhVienFpt;

public class SinhVienIT extends SinhVienFpt {
	private double java;
	private double html;
	private double css;

	public SinhVienIT(String hoTen, String nganh, double java, double html, double css) {
		super(hoTen, nganh);
		this.java = java;
		this.html = html;
		this.css = css;
	}

	public double getDiem() {
		return (2 * java + html + css) / 4;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Điểm java là : " + java);
		System.out.println("Điểm html là : " + html);
		System.out.println("Điểm css là : " + css);
		System.out.println("Điểm trung bình là : " + getDiem());
		System.out.println("Xếp loại : " + super.getHocLuc(getDiem()));
	}

}
