package lap1;

import java.util.Scanner;

public class Bai2_ChuVi_DienTich {
	public static void main(String[] args) {
		double chieu_dai, chieu_rong, chu_vi, dien_tich, canh_nn;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập chiều dài:");
		chieu_dai = input.nextDouble();
		
		System.out.print("Nhập chiều rộng:");
		chieu_rong = input.nextDouble();
		
		//Tính chu vi diện tích
		chu_vi = (chieu_dai + chieu_rong)*2;
		dien_tich = chieu_dai*chieu_rong;
		
		//Tìm cạnh nhỏ nhất
		canh_nn = Math.min(chieu_dai, chieu_rong);
		input.close();
		//in ra kết quả
		System.out.printf("Chu vi hình chữ nhật là:" + "%.1f %n", chu_vi);
		System.out.printf("Diện tích hình chữ nhật là:"+"%.1f %n", dien_tich);
		System.out.printf("Cạnh nhỏ nhất là:"+"%.1f %n", canh_nn);
	}
}
