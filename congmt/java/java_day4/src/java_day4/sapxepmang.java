package java_day4;

import java.util.Scanner;

public class sapxepmang {
	
	public static void main(String[] args) {
	// Khởi tạo mảng
//		int n=5;
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		String[] songuyen= new String[n];
//		songuyen[1]="a";
//		songuyen[2]="b";
//		songuyen[3]="c";
//		songuyen[4]="d";
//		for(int i=1;i<=4;i++) {
//		System.out.println(songuyen[i]);
//		}
//		Integer[] songuyen = {1,5,6,3,9};
//		int max=songuyen[0];
//		for(int i=1;i<songuyen.length;i++) {
//			if(songuyen[i]>max) {// mún tìm số nhỏ nhất thì songuyen[i]<min;
//				max=songuyen[i];
//			}
//		}
//		System.out.println(max);
		
		Integer[] songuyen = {1,5,6,3,9};
		songuyen=sapxep(songuyen);
//		for(int i=0;i<=songuyen.length-1;i++) {
//			for(int j=i +1;j<songuyen.length;j++) {
//				if (songuyen[i]> songuyen[j]) {
//					Integer tam=songuyen[i];
//					songuyen[i]=songuyen[j];
//					songuyen[j]=tam;
//
//				}
//			}
//		}
			for(int i=0;i<songuyen.length;i++) {
			System.out.println(songuyen[i]);}
		
	}
	public static Integer[] sapxep(Integer[] songuyen ) {

		for(int i=0;i<=songuyen.length-1;i++) {
			for(int j=i +1;j<songuyen.length;j++) {
				if (songuyen[i]< songuyen[j]) {
					Integer tam=songuyen[i];
					songuyen[i]=songuyen[j];
					songuyen[j]=tam;

				}
			}
		}
		
		return songuyen;
	}
	
	}
	

