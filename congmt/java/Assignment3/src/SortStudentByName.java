
import java.util.Comparator;

/**
 * SortStudentByName class
 * 
 * @author viettuts.vn
 */
public class SortStudentByName implements Comparator<SinhVien> {
	@Override
	public int compare(SinhVien student1, SinhVien student2) {
		return student1.getName().compareTo(student2.getName());
	}
}
