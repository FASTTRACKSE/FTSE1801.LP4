package java_unit2;

import java.util.Scanner;

public class bang_diem {
	public static void main(String[] args) {
		String[] hoTen = new String[20];
		double[] diemHS1 = new double[30];
		double[] diemHS2 = new double[30];
		double[] diemtb = new double[20];
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập họ tên HS1:");
		hoTen[0] = input.nextLine();
		System.out.print("Nhập điểm LP1:");
		diemHS1[0] = input.nextDouble();
		System.out.print("Nhập điểm LP2:");
		diemHS1[1] = input.nextDouble();
		System.out.print("Nhập điểm LP3:");
		diemHS1[2] = input.nextDouble();
		diemtb[0] = (diemHS1[0]+diemHS1[1]+diemHS1[2])/3;
		System.out.println("Điểm trung bình:"+ diemtb[0]);
		
		System.out.print("Nhập họ tên HS2:");
		hoTen[1] = input.nextLine();
		System.out.print("Nhập điểm LP1:");
		diemHS2[0] = input.nextDouble();
		System.out.print("Nhập điểm LP2:");
		diemHS2[1] = input.nextDouble();
		System.out.print("Nhập điểm LP3:");
		diemHS2[2] = input.nextDouble();
		diemtb[1] = (diemHS2[0]+diemHS2[1]+diemHS2[2])/3;
		System.out.print("Điểm trung bình:"+ diemtb[1]);
	}
}
