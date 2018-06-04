package java_day1;

import java.util.Scanner;

public class Lap2 {
	public static void main(String[]args) {
		int chieudai, chieurong, chuvi, dientich, canhnhonhat;
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("Chiều dài: "); 
		chieudai = myInput.nextInt();
		System.out.println("- Chiều rộng: ");
		chieurong = myInput.nextInt();
		chuvi = (chieudai + chieurong)*2;
		dientich = chieudai*chieurong;
		canhnhonhat= Math.min(chieudai, chieurong);
		System.out.println("- Chu vi hình chữ nhật là: " + chuvi);	
		System.out.println("Diện tích hình chữ nhật:" + dientich);
		System.out.println("Cạnh nhỏ nhất:" + canhnhonhat);
	}
	
}
