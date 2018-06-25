package demo;

import java.util.Comparator;

public class SortListPersonByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o2.getName().compareToIgnoreCase(o1.getName());
	}

}
