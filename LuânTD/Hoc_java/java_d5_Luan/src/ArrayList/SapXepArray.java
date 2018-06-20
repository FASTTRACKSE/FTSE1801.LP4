package ArrayList;

import java.util.Comparator;

public class SapXepArray implements Comparator<SinhVienArray> {
	public int compare(SinhVienArray s1, SinhVienArray s2) {
		return s1.getName().compareTo(s2.getName());
	}

}
