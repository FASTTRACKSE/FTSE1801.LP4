package lab4;

import java.util.Comparator;

public class SortListPersonByOldIncrease implements Comparator<Person> {
	public int compare(Person o1, Person o2) {
		return o1.getOld() - o2.getOld();
	}
}
