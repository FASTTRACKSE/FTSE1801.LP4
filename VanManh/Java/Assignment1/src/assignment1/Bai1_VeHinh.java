package assignment1;

import java.util.Scanner;

public class Bai1_VeHinh {
	public static void main(String[] args) {
		int hinh;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập kí hiệu hình:");
		hinh = input.nextInt();
		input.close();
		//Nhập hinh<0 ra chữ love, hinh=0 ra con gấu, hinh>0 ra trái tim
		if(hinh<0) {
			System.out.println("____@@@___@@@@@@__-@@___@@__@@@@@ ");
			System.out.println("____@@@___@@__@@___@@__@@___@@  ");
			System.out.println("____@@@___@@__@@____@@@@____@@@@  ");
			System.out.println("____@@@___@@__@@____@@@_____@@  ");
			System.out.println("____@@@@@_@@@@@@_____@______@@@@@ ");
		}else if(hinh==0) {
			System.out.println("________________d88888b_____________d888b\n" + 
					"_______________d88888888b__________d888888b\n" + 
					"_______________d8888888b\"\"\"\"\"\"\"\"\"\"\"\"88888888b\n" + 
					"________88\"\"\"\"\"\"\"888P\"_________________88888P\n" + 
					"______888____,888_______________________8P,\n" + 
					"____888____8888_________________________\"8,\n" + 
					"___88_____8888_______88888_______________\"8,\n" + 
					"__888____d88888_____8888888______88888____\"8,\n" + 
					"_8888____8888888_____888888_____8888888___\"8\n" + 
					"_88888___8888888______888_______888888___\"8,\n" + 
					"_888888___88888I88_______________888____\"8,\n" + 
					"__888888___888I888888_____88888________88,\n" + 
					"___8888888__8888888888888__\"\"\"'''___8888888,\n" + 
					"___888888888_88888888888888_\"\"_88888888888\n" + 
					"___8888888888888888888888888888888Id888888\n" + 
					"____888888888888888888888888888888888888b\n" + 
					"_____888888888_8888888888b____88888888888\n" + 
					"______88888888__8888888888_____8888888888\n" + 
					"_______8888888__8888888888_____ad8888888\n" + 
					"________888888b__888888888______8888888\n" + 
					"__________________88888888 \n");
		}else{
			System.out.println("_________$$$$$$$$_______$$$$$$$$\n" + 
								"_______$$$$$$$$$$$$__$$$$$$$$$$$$$\n" + 
								"______$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" + 
								"_____$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" + 
								"______$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" + 
								"________$$$$$$$$$$$$$$$$$$$$$$$$$\n" + 
								"__________$$$$$$$$$$$$$$$$$$$$$\n" + 
								"____________$$$$$$$$$$$$$$$$$\n" + 
								"______________$$$$$$$$$$$$$\n" + 
								"________________$$$$$$$$$\n" + 
								"__________________$$$$$\n" + 
								"____________________$\n");
		}
	}
}