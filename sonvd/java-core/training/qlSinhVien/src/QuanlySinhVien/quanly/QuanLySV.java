package QuanlySinhVien.quanly;

import java.awt.List;
import java.util.Scanner;

import QuanlySinhVien.sinhvien.SinhVien;

public class QuanLySV{
	private  SinhVien[] listSV;
	private int soluongSV;
	
	public QuanLySV() {
		listSV = new SinhVien[100];
		soluongSV = 0;
	}
	//Thêm sinh viên
	public void addSV(SinhVien sv){
		listSV[soluongSV] = sv;
		soluongSV += 1;
	}
	//delete sinh vien
	public void deledteSV(int id) {
		for(int i =0;i<soluongSV;i++) {
			if(listSV[i].getId() == id) {
				listSV[i] = listSV[i+1];
				soluongSV -=1;
			}
			
			
		}
	}
	//update sinh vien
	public void updateSV(int id) {
		for(int i =0 ; i<soluongSV;i++) {
			if(listSV[i].getId() == id) {
				listSV[i].setName("Olala");
				break;
			}
		}
		
	}
	//sap xep sinh vien theo ten
	public void sortSV() {	
		for(int i = 0;i<soluongSV-1;i++) {
			for(int j =i+1;j<soluongSV;j++) {
				if(listSV[i].getOld()<listSV[j].getOld()) {
//					ql = listSV[i];
//					listSV[i] = listSV[j];
//					listSV [j] = ql;
					
				}
			}
		}
	}
	//hien thi sinh vien
	public void displaySV() {
		for (int i= 0;i < soluongSV; i++) {
			System.out.println(listSV[i].getId()+" "+ listSV[i].getName() +" "+ listSV[i].getOld()+" "+listSV[i].getAddress()+" "+listSV[i].getGpa());
		}
	}
		public static void main(String[] args) {
		QuanLySV qlsv = new QuanLySV();
		SinhVien sv = new SinhVien(1,"Pham",24,"Nghe An",7);
		qlsv.addSV(sv);
		sv = new SinhVien(2,"Pham Ngoc ",23,"Nghe An",8);
		qlsv.addSV(sv);
		sv = new SinhVien(3,"Pham Ngoc Hoi",22,"Nghe An",9);
		
		qlsv.addSV(sv);
		qlsv.displaySV();
		System.out.println("\n");
		qlsv.updateSV(2);
		qlsv.displaySV();
		System.out.println("\n");
		qlsv.deledteSV(2);
		qlsv.displaySV();

	}
}
