package Lap1;

import java.util.Scanner;

/**
 * Bai tap 1
 * 
 * @author SonVD
 *
 */
public class Bai1 {
	public static void main(String[] args) {
		String hoTen;
		float diemTrungBinh;

		Scanner input = new Scanner(System.in);
		System.out.println("Nhập họ và tên sinh viên: ");
		hoTen = input.nextLine();
		System.out.println("Nhập điểm trung bình: ");
		diemTrungBinh = input.nextFloat();

		System.out.println();
		System.out.printf("%s %.2f", hoTen, diemTrungBinh);
	}
}
