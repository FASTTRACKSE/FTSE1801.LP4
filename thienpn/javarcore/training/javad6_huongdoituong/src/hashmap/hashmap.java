package hashmap;
import java.util.HashMap;

import quanlysv.quanly.SinhVien;
public class hashmap {
	public static void main(String[] args) {
		 HashMap<Integer, SinhVien> mapSinhVien = new HashMap<Integer, SinhVien>();
		    SinhVien sv1 = new SinhVien(1, "vui1", 12, "dn", 7);
		    SinhVien sv2 = new SinhVien(2, "vui2", 13, "dn", 7);
		    SinhVien sv3 = new SinhVien(3, "vui3", 14, "dn", 7);
		    SinhVien sv4 = new SinhVien(4, "vui4", 15, "dn", 7);
		    SinhVien sv5 = new SinhVien(5, "vui5", 16, "dn", 7);
		    mapSinhVien.put(sv1.getId(),sv1 );
		    mapSinhVien.put(sv2.getId(),sv2 );
		    mapSinhVien.put(sv3.getId(),sv3 );
		    mapSinhVien.put(sv4.getId(),sv4 );
		    mapSinhVien.put(sv5.getId(),sv5 );
		    
		    
		    SinhVien sv6 = mapSinhVien.get("sinh viên 2");
		    if(sv6 !=null)
		    	System.out.println(sv6.getName()+ "-"+ sv6.getId());
		    
		    
		    // cách 2
		    int key = 3;
		    SinhVien sv7 = mapSinhVien.get(key);
		    if(sv7 !=null)
		    	System.out.println(sv7.getName()+ "-"+ sv7.getId());	
		    
	}
    
}
