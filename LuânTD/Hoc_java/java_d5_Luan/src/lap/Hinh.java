package lap;

import java.util.Scanner;

public class Hinh {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap chieu dai: ");
		double d=sc.nextDouble();
		System.out.print("Nhap chieu rong: ");
		double r=sc.nextDouble();
		ChuNhat cn=new ChuNhat(d,r);
		cn.xuat();
		System.out.println();
		System.out.print("Nhap chieu canh: ");
		double c=sc.nextDouble();
		Vuong v=new Vuong(c);
		v.xuat();
		sc.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
