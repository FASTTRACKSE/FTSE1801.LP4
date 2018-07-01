package Lap1;

import java.util.Scanner;

/**
 * Bai tap 2
 * 
 * @author SonVD
 *
 */
public class Bai2 {
	public static void main(String[] args) {
		int chieuDaiChuNhat;
		int chieuRongChuNhat;
		double canhNhoNhat;
		double chuVi;
		double dienTich;

		Scanner input = new Scanner(System.in);
		System.out.println("Nhập chiều dài: ");
		chieuDaiChuNhat = input.nextInt();
		System.out.println("Nhập chiều rộng: ");
		chieuRongChuNhat = input.nextInt();

		chuVi = (chieuDaiChuNhat + chieuRongChuNhat) * 2;
		dienTich = chieuDaiChuNhat * chieuRongChuNhat;
		canhNhoNhat = Math.min(chieuDaiChuNhat, chieuRongChuNhat);

		System.out.println("Chu vi hình chữ nhật: " + chuVi);
		System.out.println("Diện tích hình chữ nhật: " + dienTich);
		System.out.println("Cạnh nhỏ nhất hình chữ nhật: " + canhNhoNhat);
	}
}
