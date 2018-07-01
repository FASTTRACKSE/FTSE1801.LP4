package java_day2;

import java.util.Scanner;

public class vidu1{  
public static void main(String args[]){  
//Chuyen doi int thanh Integer  
//int a=20;  
//int b=20;
////int c=(a<b)?30:100;
//System.out.println("- Giá trị của c là :" + c);
//Integer i=Integer.valueOf(a);//Chuyen doi int thanh Integer  
//Integer j=a;//Day la autoboxing, bay gio compiler se viet la Integer.valueOf(a)  
//  
//System.out.println(a +" "+ i +" "+ j);  
	int n;
	
	Scanner sc=new Scanner(System.in);
	System.out.println("- Nhập n:");
	n=sc.nextInt();
	if(n<2) {
		if(n==1&n==2) {
		System.out.println("N =" + n + " là số nguyên tố");}
	}
	
	int dem=0;
	for(int i=2;i<(n-1);i++) {
		if(n%i==0)
		dem++;}
		
		if(dem==0) {
		System.out.println("N =" + n + "  là số nguyên tố");}
		else {
		System.out.println("N =" + n + " không phải là số nguyên tố");
		}
//	Scanner sc=new Scanner(System.in);
//	int n;
//	int i=1;
//	do {
//		System.out.println("STT-" +i+ ": Xin chào");
//		System.out.println("- Bạn có mún tiếp tục không(1|0)");
//		n= sc.nextInt();
//		i++;
//	}while(n==1);
//	
	
	
	
}}  