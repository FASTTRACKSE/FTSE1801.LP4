package baitap;

import java.util.Scanner;

public class bang_diem {
	public static void main(String[] args) {
		
		String[] hoTen = {"Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", "Nguyễn Văn D"};
		double[][] diemHS = {{5, 6, 7}, {2, 8, 5}, {5, 7, 9}, {9, 9, 9}};
		double[] dtb = new double[4];
		String[] xeploai = new String[4];
		int[] chiso = {0,1,2,3};
		int g;
		for(int i = 0; i<hoTen.length;i++) {
			dtb[i] = (diemHS[i][0]+diemHS[i][1]+diemHS[i][2])/3 ;
			if(dtb[i]<5) {
				xeploai[i] = "Yếu";
			}else if(dtb[i]<6.5) {
				xeploai[i] = "Trung bình";
			}else if(dtb[i]<7.5) {
				xeploai[i] = "Khá";
			}else if(dtb[i]<9) {
				xeploai[i] = "Giỏi";
			}else {
				xeploai[i] = "Xuất sắc";
			}
		}

		for(int j=0; j<dtb.length; j++) {
			for(int k=j+1; k<dtb.length; k++) {
				if(dtb[j]>dtb[k]) {
					g=chiso[j];
					chiso[j]=chiso[k];
					chiso[k]=g;
					
				}
			}
		}
		System.out.printf("%-3s %-15s %-5s %-5s %-5s %-5s %-20s %n","STT","Họ và tên", "LP1", "LP2", "LP3", "ĐTB","Xếp loại"+"\n");
		for(int l = 0; l<hoTen.length;l++) {
			System.out.printf("%-3s %-15s %-5s %-5s %-5s %-5s %-20s %n", l,hoTen[chiso[l]],diemHS[chiso[l]][0],diemHS[chiso[l]][1],diemHS[chiso[l]][2],dtb[chiso[l]],xeploai[chiso[l]]);
//			System.out.println("Họ tên"+hoTen[chiso[l]]);
//			System.out.println("Điểm Lp1:"+ diemHS[chiso[l]][0]+ "\nĐiểm Lp2:"+diemHS[chiso[l]][1] + "\nĐiểm Lp3:" +diemHS[chiso[l]][2]);
//			System.out.println("Điểm trung bình: " +dtb[chiso[l]]);
//			System.out.println("Xếp loại: " + xeploai[chiso[l]]+"\n");
		}
	}
}
