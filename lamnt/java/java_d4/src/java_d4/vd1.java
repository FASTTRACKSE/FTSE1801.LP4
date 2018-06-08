package java_d4;

import java.util.Scanner;

public class vd1 {

	public static Integer[] tang_dan(Integer[] dauvao) {
		for(int i=0;i<dauvao.length-1;i++) {
			for(int j=i+1;j<dauvao.length;j++) {
				if(dauvao[i]>dauvao[j]) {
					int hv;
					hv=dauvao[i];
					dauvao[i]=dauvao[j];
					dauvao[j]=hv;
				}
			}
		}
		return dauvao;
	}
	public static void fibonaci(int n) {
		int t1,t2;
		t1=0;
		t2=1;
		if(n<=2) {
			System.out.println("0 1");
		}else {
			System.out.print("0-1");
			for(int i = 2;i<n;i++) {
				int so = t1+t2;
				System.out.print("-"+so);
				t1=t2;
				t2=so;
			}
		}
	}
	public static String get_Fibonaci(int n) {
		int t1,t2;
		t1=0;
		t2=1;
		String rs="";
		if(n<=2) {
			return "0 1";
		}else {
			rs="0-1";
			for(int i = 2;i<n;i++) {
				int so = t1+t2;
				rs= rs +"-"+ so;
				t1=t2;
				t2=so;
			}
		}
		return rs;
	}
	
	public static int[] day_Fibonaci(int n) {
		int t1,t2;
		t1=0;
		t2=1;
		int[] rs= new int[n];
		rs[0]=0;
		rs[1]=1;
		if(n>2) {
			for(int i = 2;i<n;i++) {
				int so = t1+t2;
				rs[i]= so;
				t1=t2;
				t2=so;
			}
		}
		return rs;
	}
	public static int so_Fibonaci(int n) {
		int t1,t2,so = 0;
		t1=0;
		t2=1;
		if(n<2) {
			return 0;
		}else {
			if(n==2) {
				return 1;
			}else {
				for(int i = 1;i<n-1;i++) {
					 so = t1+t2;
					t1=t2;
					t2=so;
				}
			}
		}
		return so;
	
	}
	
	
	public static void main(String args[]) {
		int tuoi=20;
		System.out.printf("%3s| %-30s| %4s| %4s| \n","STT","Ho ten","Tuoi","Diem");
		System.out.printf("%3s| %-30s| %4s|%5.2f| \n","1","Nguyen Van Nam",20,10.127);
		System.out.printf("%3s| %-30s| %4s|%5.2f|\n","1","Nguyen Van Nam",20,7.123);
		System.out.printf("%3s| %-30s| %4s|%5.2f| \n","123","Nguyen Van Nam",20,7.123);
	}
}
