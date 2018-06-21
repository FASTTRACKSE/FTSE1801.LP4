package BaiTap;

import java.util.HashMap;
import java.util.Scanner;



public class MyClass {
	public static void main(String[] args) {
		HashMap<String, SinhVien> mapSinhVien = new HashMap<String, SinhVien>();
		
		SinhVien sv1 = new SinhVien("ffse1", "Hiệu 1", 12, "Quãng Nam", 10);
		SinhVien sv2 = new SinhVien("ffse2", "Hiệu 2", 12, "Quãng Nam", 10);
		SinhVien sv3 = new SinhVien("ffse3", "Hiệu 3", 12, "Quãng Nam", 10);
		
		mapSinhVien.put(sv1.getId(), sv1);
		mapSinhVien.put(sv2.getId(), sv2);
		mapSinhVien.put(sv3.getId(), sv3);
		
		SinhVien sv4 = mapSinhVien.get("Sinh viên 2");
		if(sv4 != null)
			System.out.println(sv4.getName() +  " - " + sv4.getId());
		String key = "ffse2";
		SinhVien sv5 = mapSinhVien.get(key);
		if(sv5 != null)
			System.out.println(sv5.getName() +  " - " + sv5.getId());
	}
}
