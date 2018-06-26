package java_day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class QuanLySv {
	private ArrayList<SinhVien> listSV;

	public QuanLySv() {
		listSV = new ArrayList<SinhVien>();
	}

	// Thêm sinh viên
	public void addSV(SinhVien sv) { 
		listSV.add(sv);
	}

	// delete sinh vien
	public void deledteSV(String ten) {
		for(int i =0 ; i<listSV.size();i++) {
			if(listSV.get(i).getName().equals(ten)) {				
				listSV.remove(i);
				break;
			}
		}
	}
	

	// update sinh vien
	public void updateSV(int id) {
		for(int i =0 ; i<listSV.size();i++) {
			if(listSV.get(i).getId() == id) {
				SinhVien sv = new SinhVien(1, "Olala", 24, "Nghe An", 7);
				listSV.set(i, sv);
				break;
			}
		}
	}

	// sap xep sinh vien theo tuoi
	public void sortSV2() {
		Collections.sort(listSV, new Comparator<SinhVien>() {
			public int compare(SinhVien arg0, SinhVien arg1) {
				// TODO Auto-generated method stub
				return arg0.getOld() - arg1.getOld();
			}
			
		});
	}
	
	// sap xep sinh vien theo ten
		public void sortSV() {
			Collections.sort(listSV, new Comparator<SinhVien>() {
				public int compare(SinhVien arg0, SinhVien arg1) {
					// TODO Auto-generated method stub
					return arg0.getName().compareToIgnoreCase(arg1.getName());
				}
				
			});
		}

	// hien thi sinh vien
	public void displaySV() {
		for (SinhVien sinhvien : listSV) {
			System.out.print(" "+sinhvien.getId());
			System.out.print(" "+sinhvien.getName());
			System.out.print(" "+sinhvien.getOld());
			System.out.print(" "+sinhvien.getAddress());
			System.out.print(" "+sinhvien.getGpa());
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		QuanLySv qlsv = new QuanLySv();
		
		SinhVien sv = new SinhVien(1, "Pham", 24, "Nghe An", 7);
		qlsv.addSV(sv);
		sv = new SinhVien(2, "Pham Ngoc", 23, "Nghe An", 8);
		qlsv.addSV(sv);
		sv = new SinhVien(3, "Pham Ngoc Hoi", 22, "Nghe An", 9);
		qlsv.addSV(sv);
		qlsv.displaySV();
		
		System.out.println("");
		
		qlsv.deledteSV("Pham Ngoc");
		qlsv.displaySV();
		
		System.out.println("");
		
		qlsv.updateSV(1);
		qlsv.displaySV();
		
		System.out.println("");
		
		qlsv.sortSV();
		qlsv.displaySV();
		
		System.out.println("");
		
		qlsv.sortSV2();
		qlsv.displaySV();

	}
}
