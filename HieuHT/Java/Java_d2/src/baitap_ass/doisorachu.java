package baitapass;

import java.util.Scanner;

public class doisorachu {
	public static void  main(String[] args) {
		int so;
		Scanner input = new Scanner(System.in);
		System.out.print("Dãy số: ");
		so = input.nextInt();
		System.out.print("Thành chữ là: ");
		int nghin = (so/1000)%10; 
		switch(nghin) {
			case 1:
				System.out.print("Một nghìn ");
				break;
			case 2:
				System.out.print("Hai nghìn ");
				break;
			case 3:
				System.out.print("Ba nghìn ");
				break;
			case 4:
				System.out.print("Bốn nghìn ");
				break;
			case 5:
				System.out.print("Năm nghìn ");
				break;
			case 6:
				System.out.print("Sáu nghìn ");
				break;
			case 7:
				System.out.print("Bảy nghìn ");
				break;
			case 8:
				System.out.print("Tám nghìn ");
				break;
			case 9:
				System.out.print("Chín nghìn ");
				break;
		}
		int tram = (so/100)%10; 
		switch(tram) {
			case 1:
				System.out.print("Một trăm ");
				break;
			case 2:
				System.out.print("Hai trăm");
				break;
			case 3:
				System.out.print("Ba trăm ");
				break;
			case 4:
				System.out.print("Bốn trăm ");
				break;
			case 5:
				System.out.print("Năm trăm ");
				break;
			case 6:
				System.out.print("Sáu trăm ");
				break;
			case 7:
				System.out.print("Bảy trăm ");
				break;
			case 8:
				System.out.print("Tám trăm ");
				break;
			case 9:
				System.out.print("Chín trăm ");
				break;
		}
		int chuc = (so/10)%10; 
		switch(chuc) {
			case 1:
				System.out.print("Mười ");
				break;
			case 2:
				System.out.print("Hai mươi ");
				break;
			case 3:
				System.out.print("Ba mươi ");
				break;
			case 4:
				System.out.print("Bốn mươi ");
				break;
			case 5:
				System.out.print("Năm mươi ");
				break;
			case 6:
				System.out.print("Sáu mươi ");
				break;
			case 7:
				System.out.print("Bảy mươi ");
				break;
			case 8:
				System.out.print("Tám mươi ");
				break;
			case 9:
				System.out.print("Chín mươi ");
				break;
		}
		int donvi = so%10; 
		switch(donvi) {
			case 1:
				System.out.print("Một");
				break;
			case 2:
				System.out.print("Hai");
				break;
			case 3:
				System.out.print("Ba");
				break;
			case 4:
				System.out.print("Bốn");
				break;
			case 5:
				System.out.print("Năm");
				break;
			case 6:
				System.out.print("Sáu");
				break;
			case 7:
				System.out.print("Bảy");
				break;
			case 8:
				System.out.print("Tám");
				break;
			case 9:
				System.out.print("Chín");
				break;
		}
	}
}
