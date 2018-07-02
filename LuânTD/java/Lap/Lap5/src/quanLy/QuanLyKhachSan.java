package quanLy;

import java.util.ArrayList;
import java.util.Scanner;

import khachSan.KhachSan;

public class QuanLyKhachSan {
//	private ArrayList<KhachSan> listKhachSan;
//	
//	public QuanLyKhachSan() {
//		listKhachSan=new ArrayList<KhachSan>();
//	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<KhachSan> ds;
		int n;
		System.out.println("Nhap so luong khach");
		n=sc.nextInt();
		ds=new ArrayList<KhachSan>(n);
		KhachSan b;
		for(int i=0;i<n;i++) {
			b=new KhachSan();
			b.addInformation(sc);
			ds.add(b);
		}
		
		System.out.println("Danh sach khach tro:");
		for(int i=0;i<ds.size();i++) 
			ds.get(i).showInformation();
		
        String tim;
        System.out.print("Nhap so CMND cua khach hang can thanh toan: ");
        sc.nextLine();
        tim=sc.nextLine();
        for(int i=0;i<ds.size();i++) 
          if(ds.get(i).getKhach().getIdCMND().equals(tim))
               System.out.println("Tien phai thanh toan: "+ds.get(i).bill());  
		
		
		
	}
	
}
