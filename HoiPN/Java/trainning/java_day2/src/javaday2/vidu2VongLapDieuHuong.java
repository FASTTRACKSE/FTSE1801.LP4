package javaday2;

import java.util.Scanner;

public class vidu2VongLapDieuHuong {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);		
		int n;
		int i=1;
		do{
			System.out.println("STT-"+i+" : Xin chào");
			System.out.println("Bạn có muốn tiếp tục (1|0)");
			n= sc.nextInt();
			i++;
		}while(n==1);
	}
}
