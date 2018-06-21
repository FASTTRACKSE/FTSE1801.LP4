package bai1;

import java.util.Comparator;

public class Sort implements Comparator<People>{
	public int compare(People person1, People person2) {
		return person2.getName().compareTo(person1.getName());
	}
}
