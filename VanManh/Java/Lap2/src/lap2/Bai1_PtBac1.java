package lap2;

import java.util.Scanner;

public class Bai1_PtBac1 {
	public static void main(String[] args) {
		double a, b;
		// Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);

		System.out.print("Nhập giá trị a:");
		a = input.nextDouble();

		System.out.print("Nhập giá trị b:");
		b = input.nextDouble();
		input.close();
		// Giải phương trình bậc nhất và in ra kết quả
		if (a == 0) {
			if (b == 0) {
				System.out.print("Pt vô số nghiệm");
			} else {
				System.out.print("Pt vô nghiệm");
			}
		} else {
			double x = -b / a;
			System.out.print("Pt có nghiệm là:" + x);
		}
	}
}
