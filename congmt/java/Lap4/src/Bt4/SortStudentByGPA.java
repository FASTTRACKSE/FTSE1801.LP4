package Bt4;

import java.util.Comparator;

/**
 * SortStudentByGPA class
 * 
 * 
 */
public class SortStudentByGPA implements Comparator<Student> {
	@Override
	public int compare(Student student1, Student student2) {
		return (int) (student1.getGpa() - student2.getGpa());

	}
}
