package java_unit1;

import java.util.Scanner;

public class theTich_lab1 {
	public static void main(String[] args) {
		double canh, the_tich;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập cạnh khối lập phương:");
		canh = input.nextDouble();
		
		//Tính thể tích
		the_tich = Math.pow(canh,3);
		
		//In ra kết quả
		System.out.printf("Thể tích khối lập phương là:" + "%.1f %n", the_tich);
	}
}
