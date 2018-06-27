
import java.util.Comparator;

/**
 * SortStudentByName class
 * 
 * @author viettuts.vn
 */
public class SortPersonByName implements Comparator<Person> {
	@Override
	public int compare(Person person1, Person person2) {
		return person1.getName().compareTo(person2.getName());
	}
}
