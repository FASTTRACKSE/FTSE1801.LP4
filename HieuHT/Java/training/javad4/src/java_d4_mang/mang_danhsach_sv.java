package java_d4_mang;

public class mang_danhsach_sv {
   public static void main(String[]args) {
	   //khai báo biến
	   String[] ten= {"nguyễn văn an","trần anh tuấn","quách tuấn du"};
	   double[] lp0= {7,6.5,8};
	   double[] lp1= {7.5,6,9};
	   double[] lp2= {9,8,10};
	   double[] dtb=new double[3];
	   String[] xeploai=new String[3];
	   for(int i=0;i<ten.length;i++) {
		   dtb[i]=(lp0[i]+lp1[i]+lp2[i])/3;
		   if(dtb[i]<5) {
			   xeploai[i]="yếu";
		   }else if(dtb[i]<6.5) {
			   xeploai[i]="trung bình";
		   }else if(dtb[i]<7.5) {
			   xeploai[i]="khá";
		   }else if(dtb[i]<9) {
			   xeploai[i]="giỏi";
		   }else {
			   xeploai[i]="xuất sắc";
		   }
	   }
	   int[] vitri= {0,1,2};
	   int sapxep;
	   for(int i=0;i<ten.length-1;i++) {
		   for(int j=i+1;j<ten.length;j++) {
			   if(dtb[vitri[i]]<dtb[vitri[j]]) {
				   sapxep=vitri[j];
				   
				   vitri[j]=vitri[i];
				   vitri[i]=sapxep;
			   }
			   
		   }
	   }
	   System.out.println("Danh sách Sinh viên, điểm và xếp loại");
	   for(int i=0;i<ten.length;i++) {
		   System.out.println("tên SV: "+ten[vitri[i]]);
		   System.out.println("điểm LP0 SV: "+lp0[vitri[i]]);
		   System.out.println("Điểm LP1 SV: "+lp1[vitri[i]]);
		   System.out.println("Điểm LP2 SV: "+lp2[vitri[i]]);
		   System.out.println("Điểm TB SV: "+dtb[vitri[i]]);
		   System.out.println("Xếp loai SV: "+xeploai[vitri[i]]);
	   }
   }
}
