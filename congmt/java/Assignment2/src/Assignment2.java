

import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhập N: ");
		n = sc.nextInt();
		System.out.print("N được đọc là : ");
		int nghin =(n/1000)%10;
		int tram =(n/100)%10;
		int chuc =(n/10)%10;
		int donvi =n%10;
		String m=String.valueOf(n);
		int l=m.length();
		if(l==4) {
			switch(nghin){
				case 1:System.out.print("Một nghìn ");break;
				case 2:System.out.print("Hai nghìn ");break;
				case 3:System.out.print("Ba nghìn ");break;
				case 4:System.out.print("Bốn nghìn ");break;
				case 5:System.out.print("Năm nghìn ");break;
				case 6:System.out.print("Sáu nghìn ");break;
				case 7:System.out.print("Bảy nghìn ");break;
				case 8:System.out.print("Tám nghìn ");break;
				case 9:System.out.print("Chín nghìn ");break;
			}
			switch(tram){
				case 0:System.out.print("Không trăm" );break;
				case 1:System.out.print("Một trăm ");break;
				case 2:System.out.print("Hai trăm ");break;
				case 3:System.out.print("Ba Trăm ");break;
				case 4:System.out.print("Bốn trăm ");break;
				case 5:System.out.print("Năm trăm ");break;
				case 6:System.out.print("Sáu trăm ");break;
				case 7:System.out.print("Bảu trăm ");break;
				case 8:System.out.print("Tám trăm ");break;
				case 9:System.out.print("Chín trăm ");break;
			}
			switch(chuc){
				case 0:System.out.print("linh ");break;
				case 1:System.out.print("mười ");break;
				case 2:System.out.print("Hai mươi ");break;
				case 3:System.out.print("Ba mươi ");break;
				case 4:System.out.print("Bốn mươi ");break;
				case 5:System.out.print("Năm mươi ");break;
				case 6:System.out.print("Sáu mươi ");break;
				case 7:System.out.print("Bảy mươi ");break;
				case 8:System.out.print("Tám mươi ");break;
				case 9:System.out.print("Chín mươi ");break;
			}
			switch(donvi){
				case 0:System.out.print(" ");break;
				case 1:System.out.print("một");break;
				case 2:System.out.print("Hai");break;
				case 3:System.out.print("Ba");break;
				case 4:System.out.print("Bốn");break;
				case 5:System.out.print("Năm");break;
				case 6:System.out.print("Sáu");break;
				case 7:System.out.print("Bảy");break;
				case 8:System.out.print("Tám");break;
				case 9:System.out.print("Chín");break;
			}
			
		}
		else if(l==3) {
			switch(tram){
				case 0:System.out.print("Không Trăm ");break;
				case 1:System.out.print("Một Trăm ");break;
				case 2:System.out.print("Hai Trăm ");break;
				case 3:System.out.print("Ba Trăm ");break;
				case 4:System.out.print("Bốn Trăm ");break;
				case 5:System.out.print("Năm Trăm ");break;
				case 6:System.out.print("Sáu Trăm ");break;
				case 7:System.out.print("Bảy Trăm ");break;
				case 8:System.out.print("Tám Trăm ");break;
				case 9:System.out.print("Chín Trăm ");break;
			}
			switch(chuc){
				case 0:System.out.print("linh ");break;
				case 1:System.out.print("mười ");break;
				case 2:System.out.print("Hai mươi ");break;
				case 3:System.out.print("Ba mươi ");break;
				case 4:System.out.print("Bốn mươi ");break;
				case 5:System.out.print("Năm mươi ");break;
				case 6:System.out.print("Sáu mươi ");break;
				case 7:System.out.print("Bảy mươi ");break;
				case 8:System.out.print("Tám mươi ");break;
				case 9:System.out.print("Chín mươi ");break;
				}
			switch(donvi){
				case 0:System.out.print(" ");break;
				case 1:System.out.print("một");break;
				case 2:System.out.print("Hai");break;
				case 3:System.out.print("Ba");break;
				case 4:System.out.print("Bốn");break;
				case 5:System.out.print("Năm");break;
				case 6:System.out.print("Sáu");break;
				case 7:System.out.print("Bảy");break;
				case 8:System.out.print("Tám");break;
				case 9:System.out.print("Chín");break;
			}
		}
		else if(l==2) {
			switch(chuc){
				case 0:System.out.print("linh ");break;
				case 1:System.out.print("mười ");break;
				case 2:System.out.print("Hai mươi ");break;
				case 3:System.out.print("Ba mươi ");break;
				case 4:System.out.print("Bốn mươi ");break;
				case 5:System.out.print("Năm mươi ");break;
				case 6:System.out.print("Sáu mươi ");break;
				case 7:System.out.print("Bảy mươi ");break;
				case 8:System.out.print("Tám mươi ");break;
				case 9:System.out.print("Chín mươi ");break;
				}
			switch(donvi){
				case 0:System.out.print(" ");break;
				case 1:System.out.print("một");break;
				case 2:System.out.print("Hai");break;
				case 3:System.out.print("Ba");break;
				case 4:System.out.print("Bốn");break;
				case 5:System.out.print("Năm");break;
				case 6:System.out.print("Sáu");break;
				case 7:System.out.print("Bảy");break;
				case 8:System.out.print("Tám");break;
				case 9:System.out.print("Chín");break;
			}
		}
		else if(l==1){
			switch(donvi){
				case 0:System.out.print(" ");break;
				case 1:System.out.print("một");break;
				case 2:System.out.print("Hai");break;
				case 3:System.out.print("Ba");break;
				case 4:System.out.print("Bốn");break;
				case 5:System.out.print("Năm");break;
				case 6:System.out.print("Sáu");break;
				case 7:System.out.print("Bảy");break;
				case 8:System.out.print("Tám");break;
				case 9:System.out.print("Chín");break;
			}
		}
}
}
	