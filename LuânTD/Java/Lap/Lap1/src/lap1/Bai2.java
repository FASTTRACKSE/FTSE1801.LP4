package lap1;

import java.util.Scanner;

public class Bai2 {
	
	public static void main(String[] args){
		int dai,rong;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Chiều dài = ");
		dai= myInput.nextInt();
		System.out.print("Chiều rộng = ");
		rong= myInput.nextInt();
		myInput.close();
		int chuvi=(dai+rong)*2;
		int dientich=dai*rong;
		int x= Math.min(dai, rong);
		System.out.println("Chu vi hình chữ nhật= "+chuvi);
		System.out.println("Diện tích hình chữ nhật= "+dientich);
		System.out.println("Cạnh nhỏ nhất="+x);
		
	}
	

}
