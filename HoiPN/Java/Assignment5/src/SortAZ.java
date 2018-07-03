import java.util.Comparator;

public class SortAZ implements Comparator<CanBo> {
	public int compare(CanBo s1, CanBo s2) {
		return s1.getHoTen().compareTo(s2.getHoTen());
	}
}