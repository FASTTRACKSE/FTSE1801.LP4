package LapUnit4;

import java.util.Scanner;

public class Hinh {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Nhập chiều dài hình chữ nhật : ");
		double chieuDai = input.nextDouble();
		System.out.println("Nhập chiều rộng hình chữ nhật : ");
		double chieuRong = input.nextDouble();
		System.out.println();
		ChuNhat cn = new ChuNhat(chieuDai, chieuRong);
		cn.xuat();
		System.out.println();
		System.out.println("Nhập cạnh hình vuông : ");
		double canh = input.nextDouble();
		System.out.println();
		HinhVuong vu = new HinhVuong(canh);
		vu.xuat();
		input.close();

	}
}
