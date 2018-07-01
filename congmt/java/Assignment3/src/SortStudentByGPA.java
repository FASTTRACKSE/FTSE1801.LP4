
import java.util.Comparator;

/**
 * SortStudentByGPA class
 * 
 * 
 */
public class SortStudentByGPA implements Comparator<SinhVien> {
	@Override
	public int compare(SinhVien student1, SinhVien student2) {
		return (int) (student1.getDiemTb() - student2.getDiemTb());

	}
}
