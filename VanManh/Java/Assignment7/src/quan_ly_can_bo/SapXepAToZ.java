package quan_ly_can_bo;

import java.util.Comparator;

public class SapXepAToZ implements Comparator<CanBo> {
	public int compare(CanBo s1, CanBo s2) {
		return s1.getTen().compareTo(s2.getTen());
	}
}
