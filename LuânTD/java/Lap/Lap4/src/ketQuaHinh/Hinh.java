package ketQuaHinh;

import java.util.Scanner;

import hinh.HinhChuNhat;
import hinh.HinhVuong;

public class Hinh {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap chieu dai: ");
		double d=sc.nextDouble();
		System.out.print("Nhap chieu rong: ");
		double r=sc.nextDouble();
		HinhChuNhat cn=new HinhChuNhat(d,r);
		cn.xuat();
		System.out.println();
		System.out.print("Nhap chieu canh: ");
		double c=sc.nextDouble();
		HinhVuong v=new HinhVuong(c);
		v.xuat();
		sc.close();
		
		
		
	}
	
	
	
	
}
