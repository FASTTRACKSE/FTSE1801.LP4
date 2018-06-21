package lap1;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		String hoten;
		float lp1, lp2, lp3;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập Họ và tên: ");
		hoten = sc.nextLine();
		
		System.out.print("Nhập điểm LP1= ");
		lp1 = sc.nextInt();
		System.out.print("Nhập điểm LP2= ");
		lp2 = sc.nextInt();
		System.out.print("Nhập điểm LP3= ");
		lp3 = sc.nextInt();
		float diemtb = (lp1 + lp2 + lp3) / 3;
		sc.close();
		System.out.print("<<" + hoten + ">>");
		System.out.print("<<" + lp1 + "," + lp2 + "," + lp3 + ">>");
		System.out.print(diemtb);

	}
}
