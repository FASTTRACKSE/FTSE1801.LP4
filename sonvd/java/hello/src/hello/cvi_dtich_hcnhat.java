package hello;

import java.util.Scanner;

public class cvi_dtich_hcnhat {
	public static void main (String[] args) {
		double dai, rong, chuvi, dientich, canhnho;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Nhập chiều dài: ");
		dai = input.nextDouble();
		
		System.out.println("Nhập chiều rộng: ");
		rong = input.nextDouble();
		
		chuvi = (dai+rong)*2;
		dientich = dai*rong;
		
		System.out.println("Chu vi hình chữ nhật: (" +dai+ " + " +rong+ ") * 2 =" +chuvi);
		System.out.println("Diện tích hình chữ nhật: " +dai+ " * " +rong+ " = " +dientich);
		canhnho = Math.min(dai, rong);
		System.out.println("Cạnh nhỏ nhất hình chữ nhật: " +canhnho);
	}

}
