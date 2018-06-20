package bai1_quan_ly_sinh_vien_arrayList;

import java.util.Comparator;

class SapXepArray implements Comparator<SinhVienArray> {
	public int compare(SinhVienArray s1, SinhVienArray s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
