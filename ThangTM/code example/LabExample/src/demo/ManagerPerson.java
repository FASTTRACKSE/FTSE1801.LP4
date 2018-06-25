package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class using for manager person
 * 
 * @author GaLonTon
 *
 */
public class ManagerPerson {

	// kieu moi
	private ArrayList<Person> listPerson;

	// kieu cu
	private Person[] personList;
	private int size;

	public ManagerPerson() {
		// kieu moi
		listPerson = new ArrayList<Person>();

		// kieu cu
		personList = new Person[2];
		size = 0;
	}

	/**
	 * Add new some person to list person
	 * 
	 * @param person
	 */
	public void addPerson(Person person) {
		// kieu moi
		listPerson.add(person);

		// kieu cu
		personList[size] = person;
		size += 1;
	}

	/**
	 * Sort list person by name a -> z
	 */
	public void sortListPersonByNameAZ() {
		// cach moi
		Collections.sort(listPerson, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});

		// cach cu
		for (int i = 0; i < personList.length; i++) {
			for (int j = 1; j < personList.length - i; j++) {
				if (personList[j - 1].getName().compareToIgnoreCase(personList[j].getName()) > 0) {
					Person person = personList[j - 1];
					personList[j - 1] = personList[j];
					personList[j] = person;
				}
			}
		}
	}

	/**
	 * Sort list person by name z -> a
	 */
	public void sortListPersonByNameZA() {
		// cach moi
		Collections.sort(listPerson, new SortListPersonByName());

		// cach cu
		for (int i = 0; i < personList.length; i++) {
			for (int j = 1; j < personList.length - i; j++) {
				if (personList[j - 1].getName().compareToIgnoreCase(personList[j].getName()) < 0) {
					Person person = personList[j - 1];
					personList[j - 1] = personList[j];
					personList[j] = person;
				}
			}
		}
	}

	/**
	 * Sort list person by old decrease
	 */
	public void sortListPersonByOldDecrease() {
		// cach moi
		Collections.sort(listPerson, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o2.getOld() - o1.getOld();
			}
		});

		// cach cu
		for (int i = 0; i < personList.length; i++) {
			for (int j = 1; j < personList.length - i; j++) {
				if (personList[j - 1].getOld() < personList[j].getOld()) {
					Person person = personList[j - 1];
					personList[j - 1] = personList[j];
					personList[j] = person;
				}
			}
		}
	}

	/**
	 * Sort list person by old increase
	 */
	public void sortListPersonByOldIncrease() {
		// cach moi
		Collections.sort(listPerson, new SortListPersonByOldIncrease());

		// cach cu
		for (int i = 0; i < personList.length; i++) {
			for (int j = 1; j < personList.length - i; j++) {
				if (personList[j - 1].getOld() > personList[j].getOld()) {
					Person person = personList[j - 1];
					personList[j - 1] = personList[j];
					personList[j] = person;
				}
			}
		}
	}

	/**
	 * Remove some person out of list person
	 * 
	 * @param name
	 *            name of student need remove
	 */
	public void removePerson(String name) {
		// cach moi
		for (int i = 0; i < listPerson.size(); i++) {
			if (listPerson.get(i).getName().equals(name)) {
				listPerson.remove(i);
			}
		}

		// cach cu
		for (int i = 0; i < personList.length - 1; i++) {
			if (personList[i].getName().equals(name)) { // name.equal(personList[i].getName());
				for (int j = i; j < personList.length - 1; j++) {
					personList[j] = personList[j + 1];
				}
			}
		}
		personList[personList.length - 1] = null;
		size -= 1;
	}

	/**
	 * Display all list person
	 */
	public void printListPerson() {
		// cach moi
		System.out.println("* Cach moi:");
		for (Person person : listPerson) {
			System.out.print(person.getName() + " - " + person.getOld() + " - ");
			person.printPerson();
		}

		// cach cu
		System.out.println("* Cach cu:");
		for (int i = 0; i < size; i++) {
			System.out.print(personList[i].getName() + " - " + personList[i].getOld() + " - ");
			personList[i].printPerson();
		}
	}

	public static void main(String[] args) {
		ManagerPerson managerPerson = new ManagerPerson();
		// add 1 thang sinh vien
		Student std1 = new Student();
		std1.setName("Vui");
		std1.setOld(25);

		managerPerson.addPerson(std1);

		// add 1 thang quan ly
		Staff st1 = new Staff();
		st1.setName("Buon");
		st1.setOld(26);
		managerPerson.addPerson(st1);

		// sort theo ten tu a->z
		managerPerson.printListPerson();
		System.out.println("---------------\nsap xep theo ten tu a -> z");
		managerPerson.sortListPersonByNameAZ();
		managerPerson.printListPerson();

		// sort theo ten tu z->a
		System.out.println("---------------\nsap xep theo ten tu z -> a");
		managerPerson.sortListPersonByNameZA();
		managerPerson.printListPerson();

		// sort theo tuoi giam dan
		System.out.println("---------------\nsap xep theo tuoi giam dan");
		managerPerson.sortListPersonByOldDecrease();
		managerPerson.printListPerson();

		// sort theo tuoi tang dan
		System.out.println("---------------\nsap xep theo tuoi tang dan");
		managerPerson.sortListPersonByOldIncrease();
		managerPerson.printListPerson();

		// xoa 1 phan tu co ten tuong ung
		System.out.println("---------------\nxoa phan tu co ten Vui");
		managerPerson.removePerson("Vui");
		managerPerson.printListPerson();
	}

}
