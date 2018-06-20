package java_d2;
/**
 * @author Luan 1801
 */
import java.util.*;
public class ass1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập số N=  ");
		int n=input.nextInt();
		input.close();
		int ng = n/1000;
		int tr =(n%1000)/100;
		int ch=((n%1000)%100)/10;
		int dv= n%10;
		String m=String.valueOf(n);
		int l=m.length();
			if(l==4) {
				switch(ng) {
				case 1:System.out.print("một ngàn ");break;
				case 2:System.out.print("Hai ngàn ");break;
				case 3:System.out.print("Ba ngàn ");break;
				case 4:System.out.print("bốn ngàn ");break;
				case 5:System.out.print("năm ngàn ");break;
				case 6:System.out.print("sáu ngàn ");break;
				case 7:System.out.print("bảy ngàn ");break;
				case 8:System.out.print("tám ngàn ");break;
				case 9:System.out.print("chín ngàn ");break;
				
				}
				switch(tr) {
				case 0:System.out.print("không trăm ");break;
				case 1:System.out.print("một trăm ");break;
				case 2:System.out.print("Hai trăm ");break;
				case 3:System.out.print("Ba trăm ");break;
				case 4:System.out.print("bốn trăm ");break;
				case 5:System.out.print("năm trăm ");break;
				case 6:System.out.print("sáu trăm ");break;
				case 7:System.out.print("bảy trăm ");break;
				case 8:System.out.print("tám trăm ");break;
				case 9:System.out.print("chín trăm ");break;
				}
				switch(ch) {
				case 0:System.out.print("lẻ ");break;
				case 1:System.out.print("Mười ");break;
				case 2:System.out.print("Hai mươi ");break;
				case 3:System.out.print("Ba mươi ");break;
				case 4:System.out.print("bốn mươi ");break;
				case 5:System.out.print("năm mươi ");break;
				case 6:System.out.print("sáu mươi ");break;
				case 7:System.out.print("bảy mươi ");break;
				case 8:System.out.print("tám mươi ");break;
				case 9:System.out.print("chín mươi ");break;
				}
				switch(dv) {
				case 1:System.out.print("một ");break;
				case 2:System.out.print("Hai ");break;
				case 3:System.out.print("Ba ");break;
				case 4:System.out.print("bốn ");break;
				case 5:System.out.print("năm ");break;
				case 6:System.out.print("sáu ");break;
				case 7:System.out.print("bảy ");break;
				case 8:System.out.print("tám ");break;
				case 9:System.out.print("chín");break;
				}
			}else if(l==3) {
				switch(tr) {
				case 1:System.out.print("một trăm ");break;
				case 2:System.out.print("Hai trăm ");break;
				case 3:System.out.print("Ba trăm ");break;
				case 4:System.out.print("bốn trăm ");break;
				case 5:System.out.print("năm trăm ");break;
				case 6:System.out.print("sáu trăm ");break;
				case 7:System.out.print("bảy trăm ");break;
				case 8:System.out.print("tám trăm ");break;
				case 9:System.out.print("chín trăm ");break;
				}
				switch(ch) {
				case 0:System.out.print("lẻ ");break;
				case 1:System.out.print("Mười ");break;
				case 2:System.out.print("Hai mươi ");break;
				case 3:System.out.print("Ba mươi ");break;
				case 4:System.out.print("bốn mươi ");break;
				case 5:System.out.print("năm mươi ");break;
				case 6:System.out.print("sáu mươi ");break;
				case 7:System.out.print("bảy mươi ");break;
				case 8:System.out.print("tám mươi ");break;
				case 9:System.out.print("chín mươi ");break;
				}
				switch(dv) {
				case 1:System.out.print("một ");break;
				case 2:System.out.print("Hai ");break;
				case 3:System.out.print("Ba ");break;
				case 4:System.out.print("bốn ");break;
				case 5:System.out.print("năm ");break;
				case 6:System.out.print("sáu ");break;
				case 7:System.out.print("bảy ");break;
				case 8:System.out.print("tám ");break;
				case 9:System.out.print("chín");break;
				}
			}else if(l==2) {
				switch(ch) {
				case 1:System.out.print("Mười ");break;
				case 2:System.out.print("Hai mươi ");break;
				case 3:System.out.print("Ba mươi ");break;
				case 4:System.out.print("bốn mươi ");break;
				case 5:System.out.print("năm mươi ");break;
				case 6:System.out.print("sáu mươi ");break;
				case 7:System.out.print("bảy mươi ");break;
				case 8:System.out.print("tám mươi ");break;
				case 9:System.out.print("chín mươi ");break;
				}
				switch(dv) {
				case 1:System.out.print("một ");break;
				case 2:System.out.print("Hai ");break;
				case 3:System.out.print("Ba ");break;
				case 4:System.out.print("bốn ");break;
				case 5:System.out.print("năm ");break;
				case 6:System.out.print("sáu ");break;
				case 7:System.out.print("bảy ");break;
				case 8:System.out.print("tám ");break;
				case 9:System.out.print("chín");break;
				}
			}else if(l==1) {
				switch(dv) {
				case 1:System.out.print("một ");break;
				case 2:System.out.print("Hai ");break;
				case 3:System.out.print("Ba ");break;
				case 4:System.out.print("bốn ");break;
				case 5:System.out.print("năm ");break;
				case 6:System.out.print("sáu ");break;
				case 7:System.out.print("bảy ");break;
				case 8:System.out.print("tám ");break;
				case 9:System.out.print("chín");break;
				}
			}
		}

	
}