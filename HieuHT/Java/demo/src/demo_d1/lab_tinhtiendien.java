package demo_d1;

import java.util.Scanner;

public class lab_tinhtiendien {
	public static void  main(String[] args) {
		int sd;
		Scanner input = new Scanner(System.in);
		System.out.println("Nháº­p sá»‘ tiá»�n:  ");
		sd = input.nextInt();
		int st;
		if(sd<=50) {
			st = sd*1000;
			System.out.println("Sá»‘ tiá»�n Ä‘iá»‡n lÃ : " + st);
		}else {
			st=50*1000 + (sd-50)*1200;
			System.out.println("Sá»› tiá»�n Ä‘iá»‡n lÃ : " + st);
		}
	}
}