package quanLySv.quanLy;

import java.util.ArrayList;

import quanLySv.sinhVien.SinhVien;

public class quanLySinhVien {
	// private SinhVien[] listSinhVien;
	// private int soLuongSv;
	//
	// public quanLySinhVien() {
	// listSinhVien = new SinhVien[100];
	// soLuongSv = 0;
	// }
	//
	//
	// public void addSv(SinhVien sv) {
	// listSinhVien[soLuongSv] = sv;
	// soLuongSv += 1;
	// }
	//
	// public void updateSv(String id) {
	// for(int i = 0; i < soLuongSv; i++) {
	// if(listSinhVien[i].getId().equals(id)) {
	// listSinhVien[i].setName("ABC");
	// break;
	// }
	// }
	// }
	//
	// public void displayAllSv() {
	// for (int i = 0; i < soLuongSv; i++) {
	// System.out.println(listSinhVien[i].getId()+" - " +listSinhVien[i].getName() +
	// " - " + listSinhVien[i].getOld()+ " - " + listSinhVien[i].getAddress()+" -
	// "+listSinhVien[i].getGpa());
	// }
	// }
	//
	// public static void main(String[] args) {
	// quanLySinhVien quanLySv = new quanLySinhVien();
	//
	// SinhVien sv1 = new SinhVien("ffse1", "Vui", 20, "Quảng Nam", 10);
	// quanLySv.addSv(sv1);
	// SinhVien sv2 = new SinhVien("ffse2", "Buon", 20,"Đà Nẵng", 7);
	// quanLySv.addSv(sv2);
	// SinhVien sv3 = new SinhVien("ffse3", "phuong", 20,"Đà Nẵng", 7);
	// quanLySv.addSv(sv3);
	//
	// quanLySv.displayAllSv();
	// quanLySv.updateSv("ffse2");
	// quanLySv.displayAllSv();
	// }

	public static void main(String[] args) {
//		ArrayList<String> listString = new ArrayList<String>();
//
//		if (listString.isEmpty()) {
//			System.out.println("k có phần tử nàm hết: ");
//		} else {
//			System.out.println("hình như có phần tử: ");
//		}
//
//		//
//		listString.add("Vui 1");
//
//		if (listString.isEmpty()) {
//			System.out.println("k có phần tử nàm hết: ");
//		} else {
//			System.out.println("hình như có phần tử: ");
//		}
//
//		listString.add("Vui 2");
//		listString.add("Vui 3");
//		listString.add("Vui 4");
//		listString.add("Vui 5");
//
//		for (int i = 0; i < listString.size(); i++) {
//			System.out.println(listString.get(i));
//		}
//		System.out.println("-------------------");
//		listString.remove(3);
//
//		for (String String : listString) {
//			System.out.println(String);
//		}
//		System.out.println("Số phần tử còn lại: " + listString.size());
//
//		System.out.println("-----------------");
//		listString.set(3, new String("buon 4"));
//		for (String string : listString) {
//			System.out.println(string);
//		}
//		System.out.println("-----------------");
//		listString.clear();
		
		SinhVien sinhVien = new SinhVien();
		ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();
		if(listSv.isEmpty()) {
			System.out.println("Khong co sinh vien nao");
		} else {
			System.out.println("Danh sach sinh vien");
		}
		listSv.add(sinhVien);
		
			if(listSv.isEmpty()) {
				System.out.println("Khong co sinh vien nao");
			} else {
				System.out.println("Danh sach sinh vien");
			}
			listSv.add(sinhVien);
			listSv.add(sinhVien);
			listSv.add(sinhVien);
			listSv.add(sinhVien);
			
			for(int i = 0; i < listSv.size(); i++) {
				System.out.print(listSv.get(i));
			}
			System.out.println("-------------------");
			listSv.remove(2);
			
			for(SinhVien Sv:listSv) {
				System.out.println(Sv);
			}
			System.out.println("So phan tu con lai: "+listSv.size());
			System.out.println("-------------------");
			
			listSv.set(3, new SinhVien());
			for(SinhVien Sv:listSv) {
				System.out.println(Sv);		
			}
}
}
