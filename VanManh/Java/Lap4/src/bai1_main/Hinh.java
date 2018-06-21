package bai1_main;

import java.util.Scanner;
import bai1_children.HinhVuong;
import bai1_parent.ChuNhat;
public class Hinh {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		//Tính chu vi diện tích hình chữ nhật
		System.out.println("Nhập chiều dài hình chữ nhật : ");
		double chieuDai = input.nextDouble();
		System.out.println("Nhập chiều rộng hình chữ nhật : ");
		double chieuRong = input.nextDouble();
		System.out.println();
		ChuNhat chuNhat = new ChuNhat(chieuDai, chieuRong);
		chuNhat.xuat();
		System.out.println();
		
		//Tính chu vi diện tích hình chữ vuông
		System.out.println("Nhập cạnh hình vuông : ");
		double canh = input.nextDouble();
		System.out.println();
		HinhVuong hinhVuong = new HinhVuong(canh);
		hinhVuong.xuat();
		input.close();

	}
}
