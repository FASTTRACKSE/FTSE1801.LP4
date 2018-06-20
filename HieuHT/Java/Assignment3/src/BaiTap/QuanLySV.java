package BaiTap;

import java.util.ArrayList;
import java.util.Scanner;

import BaiTap.SinhVien;

public class QuanLySV {
	// Phần đổi tên sinh viên:
	 private SinhVien[] listSinhVien;
	 private int soLuongSv;
	
	 public QuanLySV() {
	 listSinhVien = new SinhVien[100];
	 soLuongSv = 0;
	 }
	
	
	 public void addSv(SinhVien sv) {
	 listSinhVien[soLuongSv] = sv;
	 soLuongSv += 1;
	 }
	
	 public void updateSv(String id) {
	 for(int i = 0; i < soLuongSv; i++) {
	 if(listSinhVien[i].getId().equals(id)) {
	 listSinhVien[i].setName("ABC");
	 break;
	 }
	 }
	 }
	
	 public void displayAllSv() {
	 for (int i = 0; i < soLuongSv; i++) {
	 System.out.println(listSinhVien[i].getId()+" - " +listSinhVien[i].getName() +
	 " - " + listSinhVien[i].getOld()+ " - " + listSinhVien[i].getAddress()+" - "+listSinhVien[i].getGpa());
	 }
	 }
	
	 public static void main(String[] args) {
	 QuanLySV quanLySv = new QuanLySV();
	
	 SinhVien sv1 = new SinhVien("ffse1", "Vui", 20, "Quảng Nam", 10);
	 quanLySv.addSv(sv1);
	 SinhVien sv2 = new SinhVien("ffse2", "Hiệu", 20,"Quảng Nam ", 7);
	 quanLySv.addSv(sv2);
	 SinhVien sv3 = new SinhVien("ffse3", "Phương", 20,"Đà Nẵng", 7);
	 quanLySv.addSv(sv3);
	
	 quanLySv.displayAllSv();
	 quanLySv.updateSv("ffse2");
	 quanLySv.displayAllSv();
	 }

	// Phần ArrayList
//	public static void main(String[] args) {
//		ArrayList<String> listString = new ArrayList<String>();
//		if (listString.isEmpty()) {
//			System.out.println("Không có phần tử nào hết");
//		} else {
//			System.out.println("Hinh nhu co phan tu nao het");
//		}
//
//		listString.add("Vui 1");
//		if (listString.isEmpty()) {
//			System.out.println("Không có phần tử nào hết");
//		} else {
//			System.out.println("Có phần tử");
//		}
//		listString.add("vui 2");
//		listString.add("vui 3");
//		listString.add("vui 4");
//		listString.add("vui 5");
//		for (int i = 0; i < listString.size(); i++) {
//			System.out.println(listString.get(i));
//		}
//		System.out.println("-------------");
//		listString.remove(3);
//		for (String string : listString) {
//			System.out.println(string);
//		}
//		System.out.println("Số phần tử còn lại là: " + listString.size());
//		System.out.println("-----------");
//		listString.set(3, new String("Buon 4"));
//		for (String string : listString) {
//			System.out.println(string);
//		}
//	}
}
