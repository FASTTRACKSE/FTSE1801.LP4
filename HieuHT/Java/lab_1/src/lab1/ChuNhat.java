package lab1;

import java.util.Scanner;

public class ChuNhat {
	double dai;
	double rong;

	public ChuNhat(double dai, double rong) {
		this.dai = dai;
		this.rong = rong;
	}

	public double getchuVi() {
		return (dai + rong) * 2;
	}

	public double getdienTich() {
		return dai * rong;
	}

	public void xuat() {
		System.out.println("Hình chữ nhật:");
		System.out.println("Chu Vi: " + getchuVi());
		System.out.println("diện tích: " + getdienTich());
		
	}
}
