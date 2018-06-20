package java_d2;
import java.util.*;
public class Assignment_chuyendoisothanhchu {
  public static void main(String[]args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("nhap vao một so co 4 chu so: ");
	  int n=input.nextInt();
	  int ng = n/1000;
	  int tr =(n%1000)/100;
	  int ch=((n%1000)%100)/10;
	  int dv= n%10;
      String l = String.valueOf(n);
      int b = l.length();
	  
	  if((ng==1)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("một Ngàn ");
	  else if((ng==2)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Hai Ngàn ");
	  else if((ng==3)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Ba Ngàn ");
	  else if((ng==4)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("bốn Ngàn ");
	  else if((ng==5)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Năm Ngàn ");
	  else if((ng==6)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Sáu Ngàn ");
	  else if((ng==7)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Bảy Ngàn ");
	  else if((ng==8)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Tám Ngàn ");
	  else if((ng==9)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print("Chín Ngàn ");
 
	  
	  else if((ng==0)&&(tr==1)&&(ch==0)&&(dv==0))
	  System.out.print("một Trăm ");
	  else if((ng==0)&&(tr==2)&&(ch==0)&&(dv==0))
	  System.out.print("Hai Trăm ");
	  else if((ng==0)&&(tr==3)&&(ch==0)&&(dv==0))
	  System.out.print("Ba Trăm ");
	  else if((ng==0)&&(tr==4)&&(ch==0)&&(dv==0))
	  System.out.print("bốn Trăm ");
	  else if((ng==0)&&(tr==5)&&(ch==0)&&(dv==0))
	  System.out.print("Năm Trăm ");
	  else if((ng==0)&&(tr==6)&&(ch==0)&&(dv==0))
	  System.out.print("Sáu Trăm ");
	  else if((ng==0)&&(tr==7)&&(ch==0)&&(dv==0))
	  System.out.print("Bảy Trăm ");
	  else if((ng==0)&&(tr==8)&&(ch==0)&&(dv==0))
	  System.out.print("Tám Trăm ");
	  else if((ng==0)&&(tr==9)&&(ch==0)&&(dv==0))
	  System.out.print("Chín Trăm ");

	  
	  else if((ng==0)&&(tr==0)&&(ch==1)&&(dv==0))
	  System.out.print(" Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==2)&&(dv==0))
	  System.out.print("Hai Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==3)&&(dv==0))
	  System.out.print("Ba Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==4)&&(dv==0))
	  System.out.print("bốn Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==5)&&(dv==0))
	  System.out.print("Năm Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==6)&&(dv==0))
	  System.out.print("Sáu Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==7)&&(dv==0))
	  System.out.print("Bảy Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==8)&&(dv==0))
	  System.out.print("Tám Mươi ");
	  else if((ng==0)&&(tr==0)&&(ch==9)&&(dv==0))
	  System.out.print("Chín Mươi ");

	  
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==0))
	  System.out.print(" Không ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==1))
	  System.out.print(" một ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==2))
	  System.out.print("Hai ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==3))
	  System.out.print("Ba ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==4))
	  System.out.print("bốn ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==5))
	  System.out.print("Năm ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==6))
	  System.out.print("Sáu ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==7))
	  System.out.print("Bảy ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==8))
	  System.out.print("Tám ");
	  else if((ng==0)&&(tr==0)&&(ch==0)&&(dv==9))
	  System.out.print("Chín ");

	  
	  else
	  {
	  if(b==4) {
		  switch(ng) {
		  case 1:System.out.print("một Ngàn ");break;
		  case 2:System.out.print("Hai Ngàn ");break;
		  case 3:System.out.print("Ba Ngàn ");break;
		  case 4:System.out.print("bốn Ngàn ");break;
		  case 5:System.out.print("Năm Ngàn ");break;
		  case 6:System.out.print("Sáu Ngàn ");break;
		  case 7:System.out.print("Bảy Ngàn ");break;
		  case 8:System.out.print("Tám Ngàn ");break;
		  case 9:System.out.print("Chín Ngàn ");break;

		  }
		  switch(tr) {
		  case 0:System.out.print("Lẻ ");break;
		  case 1:System.out.print("một Trăm ");break;
		  case 2:System.out.print("Hai Trăm ");break;
		  case 3:System.out.print("Ba Trăm ");break;
		  case 4:System.out.print("bốn Trăm ");break;
		  case 5:System.out.print("Năm Trăm ");break;
		  case 6:System.out.print("Sáu Trăm ");break;
		  case 7:System.out.print("Bảy Trăm ");break;
		  case 8:System.out.print("Tám Trăm ");break;
		  case 9:System.out.print("Chín Trăm ");break;
		  }
		  switch(ch) {
		  case 0:System.out.print("Lẻ ");break;
		  case 1:System.out.print("Mươi ");break;
		  case 2:System.out.print("Hai Mươi ");break;
		  case 3:System.out.print("Ba Mươi ");break;
		  case 4:System.out.print("bốn Mươi ");break;
		  case 5:System.out.print("Năm Mươi ");break;
		  case 6:System.out.print("Sáu Mươi ");break;
		  case 7:System.out.print("Bảy Mươi ");break;
		  case 8:System.out.print("Tám Mươi ");break;
		  case 9:System.out.print("Chín Mươi ");break;
		  }
		  switch(dv) {

		  case 1:System.out.print("một ");break;
		  case 2:System.out.print("Hai ");break;
		  case 3:System.out.print("Ba ");break;
		  case 4:System.out.print("bốn ");break;
		  case 5:System.out.print("Năm ");break;
		  case 6:System.out.print("Sáu ");break;
		  case 7:System.out.print("Bảy ");break;
		  case 8:System.out.print("Tám ");break;
		  case 9:System.out.print("Chín");break;
		  }
		  
	      }
	      else if(b==3) {
	    	  switch(tr) {
			  case 0:System.out.print("Lẻ ");break;
			  case 1:System.out.print("một Trăm ");break;
			  case 2:System.out.print("Hai Trăm ");break;
			  case 3:System.out.print("Ba Trăm ");break;
			  case 4:System.out.print("bốn Trăm ");break;
			  case 5:System.out.print("Năm Trăm ");break;
			  case 6:System.out.print("Sáu Trăm ");break;
			  case 7:System.out.print("Bảy Trăm ");break;
			  case 8:System.out.print("Tám Trăm ");break;
			  case 9:System.out.print("Chín Trăm ");break;
			  }
			  switch(ch) {
			  case 0:System.out.print("Lẻ ");break;
			  case 1:System.out.print("Mươi ");break;
			  case 2:System.out.print("Hai Mươi ");break;
			  case 3:System.out.print("Ba Mươi ");break;
			  case 4:System.out.print("bốn Mươi ");break;
			  case 5:System.out.print("Năm Mươi ");break;
			  case 6:System.out.print("Sáu Mươi ");break;
			  case 7:System.out.print("Bảy Mươi ");break;
			  case 8:System.out.print("Tám Mươi ");break;
			  case 9:System.out.print("Chín Mươi ");break;
			  }
			  switch(dv) {

			  case 1:System.out.print("một ");break;
			  case 2:System.out.print("Hai ");break;
			  case 3:System.out.print("Ba ");break;
			  case 4:System.out.print("bốn ");break;
			  case 5:System.out.print("Năm ");break;
			  case 6:System.out.print("Sáu ");break;
			  case 7:System.out.print("Bảy ");break;
			  case 8:System.out.print("Tám ");break;
			  case 9:System.out.print("Chín");break;
			  }
			   
	          }
	      else if(b==2) {
	    	  switch(ch) {
			  case 0:System.out.print("Lẻ ");break;
			  case 1:System.out.print("Mươi ");break;
			  case 2:System.out.print("Hai Mươi ");break;
			  case 3:System.out.print("Ba Mươi ");break;
			  case 4:System.out.print("bốn Mươi ");break;
			  case 5:System.out.print("Năm Mươi ");break;
			  case 6:System.out.print("Sáu Mươi ");break;
			  case 7:System.out.print("Bảy Mươi ");break;
			  case 8:System.out.print("Tám Mươi ");break;
			  case 9:System.out.print("Chín Mươi ");break;
			  }
			  switch(dv) {

			  case 1:System.out.print("một ");break;
			  case 2:System.out.print("Hai ");break;
			  case 3:System.out.print("Ba ");break;
			  case 4:System.out.print("bốn ");break;
			  case 5:System.out.print("Năm ");break;
			  case 6:System.out.print("Sáu ");break;
			  case 7:System.out.print("Bảy ");break;
			  case 8:System.out.print("Tám ");break;
			  case 9:System.out.print("Chín");break;
			  }
	      }
	      else if(b==1){
	    	  switch(dv) {

			  case 1:System.out.print("một ");break;
			  case 2:System.out.print("Hai ");break;
			  case 3:System.out.print("Ba ");break;
			  case 4:System.out.print("bốn ");break;
			  case 5:System.out.print("Năm ");break;
			  case 6:System.out.print("Sáu ");break;
			  case 7:System.out.print("Bảy ");break;
			  case 8:System.out.print("Tám ");break;
			  case 9:System.out.print("Chín");break;
			  }
	      }
	  }

  }
}
