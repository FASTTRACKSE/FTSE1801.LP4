package lab2;

import java.util.Scanner;

public class xl_sinhvien {
	public static void main(String[] args) {
		System.out.printf("%3s| %-25s| %4s| %4s| %4s| %-3s| %-10s| \n","STT","Ho Ten","LP1","LP2","LP3","TB","XL");
		//Khá»Ÿi tao máº£ng
		String ten[] = {"Phạm Ngọc Hợi", "Nguyễn Tuấn Phương", "Hồ Tấn Hiệu"};
		double lp1[] = {9,7,7};
		double lp2[] = {9,7,5};
		double lp3[] = {9,8,6};		
		double dtb[] = new double[3];
		String xl[] = new String[3];
		for(int i =0;i<ten.length;i++) {
			dtb[i] = (lp1[i] + lp2[i]+ lp3[i])/3;
			if(dtb[i]>=9) {
				xl[i] = "Xuất sắt";
			}else if(dtb[i]>=7.5){
				xl[i]= "Giỏi";
			}else if(dtb[i]>=6.5){
				xl[i]= "Khá";
			}else if(dtb[i]>5){
				xl[i]= "Trung bình";
			}else {
				xl[i]="Yếu";
			}
		}
		for(int i=0;i<ten.length-1;i++) {		
			for(int j =i;j<dtb.length;j++) {	
				int[] vitri = {0,1,2};
				if(dtb[vitri[i]] <dtb[vitri[j]]) {
					int tam;
					tam = vitri[i];
					vitri[i] = vitri[j];
					vitri[j] = tam;
				}	
				System.out.printf("%3s| %-25s| %4s| %4s| %4s| %2s| %-10s| \n","1",ten[vitri[i]],lp1[i],lp2[i],lp3[i],dtb[vitri[i]],xl[vitri[i]]);
			}
		}
	}
}