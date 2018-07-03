package sinhVien;

import java.util.Comparator;

public class SortSinhVienByNameFromZToA implements Comparator<SinhVien> {
	public int compare(SinhVien sv1, SinhVien sv2) {
		return sv2.getLastName().compareTo(sv1.getLastName());
	}

}
