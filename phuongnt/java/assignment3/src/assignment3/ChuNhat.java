package assignment3;

import java.util.Scanner;

public class ChuNhat {
	private double rong;
	private double dai;

	public ChuNhat(double rong, double dai) {
		super();
		this.rong = rong;
		this.dai = dai;
	}

	public double getRong() {
		return rong;
	}

	public void setRong(double rong) {
		this.rong = rong;
	}

	public double getDai() {
		return dai;
	}

	public void setDai(double dai) {
		this.dai = dai;
	}

	public double getChuVi() {
		return (rong + dai) * 2;
	}

	public double getDienTich() {
		return rong * dai;
	}

	public void xuat() {

		System.out.println("Chu vi: " + getChuVi());
		System.out.println("Diện tích: " + getDienTich());
	}

}
