package java_d2;

import java.util.*;
public class ass1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập số N=  ");
		int n=input.nextInt();
		int ng = n/1000;
		int tr =(n%1000)/100;
		int ch=((n%1000)%100)/10;
		int dv= n%10;
		String m=String.valueOf(n);
		int l=m.length();
		if((ng==1)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Một ngàn ");
		else if((ng==2)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Hai ngàn ");
		else if((ng==3)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Ba ngàn ");
		else if((ng==4)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Bốn ngàn ");
		else if((ng==5)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Năm ngàn ");
		else if((ng==6)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Sáu ngàn ");
		else if((ng==7)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Bảy ngàn ");
		else if((ng==8)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Tám ngàn ");
		else if((ng==9)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Chín ngàn ");
		
		else if((ng==0)&&(tr==1)&&(ch==0)&&(dv==0))
		System.out.print("Một trăm ");
		else if((ng==0)&&(tr==2)&&(ch==0)&&(dv==0))
		System.out.print("Hai trăm ");
		else if((ng==0)&&(tr==3)&&(ch==0)&&(dv==0))
		System.out.print("Ba  trăm");
		else if((ng==0)&&(tr==4)&&(ch==0)&&(dv==0))
		System.out.print("bốn trăm ");
		else if((ng==0)&&(tr==5)&&(ch==0)&&(dv==0))
		System.out.print("năm trăm ");
		else if((ng==0)&&(tr==6)&&(ch==0)&&(dv==0))
		System.out.print("sáu trăm ");
		else if((ng==0)&&(tr==7)&&(ch==0)&&(dv==0))
		System.out.print("bảy trăm ");
		else if((ng==0)&&(tr==8)&&(ch==0)&&(dv==0))
		System.out.print("tám trăm ");
		else if((ng==0)&&(tr==9)&&(ch==0)&&(dv==0))
		System.out.print("chín trăm ");
		
		else if((ng==0)&&(tr==0)&&(ch==1)&&(dv==0))
		System.out.print(" Mười ");
		else if((ng==0)&&(tr==0)&&(ch==2)&&(dv==0))
		System.out.print("Hai mươi ");
		else if((ng==0)&&(tr==0)&&(ch==3)&&(dv==0))
		System.out.print("Ba mươi ");
		else if((ng==0)&&(tr==0)&&(ch==4)&&(dv==0))
		System.out.print("bốn mươi ");
		else if((ng==0)&&(tr==0)&&(ch==5)&&(dv==0))
		System.out.print("năm mươi ");
		else if((ng==0)&&(tr==0)&&(ch==6)&&(dv==0))
		System.out.print("sáu mươi ");
		else if((ng==0)&&(tr==0)&&(ch==7)&&(dv==0))
		System.out.print("bảy mươi ");
		else if((ng==0)&&(tr==0)&&(ch==8)&&(dv==0))
		System.out.print("tám mươi ");
		else if((ng==0)&&(tr==0)&&(ch==9)&&(dv==0))
		System.out.print("chín mươi ");
		
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==0))
		System.out.print("Không ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==1))
		System.out.print("một ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==2))
		System.out.print("Hai ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==3))
		System.out.print("Ba ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==4))
		System.out.print("bốn ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==5))
		System.out.print("năm ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==6))
		System.out.print("sáu ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==7))
		System.out.print("bảy ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==8))
		System.out.print("tám ");
		else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==9))
		System.out.print("chín ");
		
		else{
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
				case 1:System.out.print("mười ");break;
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
				case 1:System.out.print("mười ");break;
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
				case 1:System.out.print("mười ");break;
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
}
	
