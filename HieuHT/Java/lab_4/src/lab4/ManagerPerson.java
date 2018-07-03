package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManagerPerson {
	// Kieu moi
	private ArrayList<Person> listPerson;

	// Kieu cu
	private Person[] personList;
	private int size;

	public ManagerPerson() {
		// Kieu moi
		listPerson = new ArrayList<Person>();

		// Kieu cu
		personList = new Person[2];
		size = 0;
	}

	public void addPerson(Person person) {
		// Kieu moi
		listPerson.add(person);

		// Kieu cu
		personList[size] = person;
		size += 1;
	}

	public void sortListPersonByNameAZ() {
		// Cach moi
		Collections.sort(listPerson, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});

		// Cach cu
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

	public void sortListPersonByNameZA() {
		// cach moi
		Collections.sort(listPerson, new SortListPersonByName());

		// Cach cu
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

	public void sortListPersonByOldDecrease() {
		// Cach moi
		Collections.sort(listPerson, new Comparator<Person>() {

			public int compare(Person o1, Person o2) {
				return o2.getOld() - o1.getOld();
			}
		});

		// Cach cu
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

	public void sortListPersonByOldIncrease() {
		Collections.sort(listPerson, new SortListPersonByOldIncrease());

		// Cach cu
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

	public void removePerson(String name) {
		// cach moi
		for (int i = 0; i < listPerson.size(); i++) {
			if (listPerson.get(i).getName().equals(name)) {
				listPerson.remove(i);
			}
		}
		// cach cu
		for (int i = 0; i < personList.length - 1; i++) {
			if (personList[i].getName().equals(name)) {
				for (int j = i; j < personList.length - 1; j++) {
					personList[j] = personList[j + 1];
				}
			}
		}
		personList[personList.length - 1] = null;
		size -= 1;
	}

	public void printListPerson() {
		System.out.println("cach moi");
		for (Person person : listPerson) {
			System.out.println(person.getName() + "-" + person.getOld() + "-");
			person.printPerson();
		}
		System.out.println("Cach cu");
		for (int i = 0; i < size; i++) {
			System.out.println(personList[i].getName() + "-" + personList[i].getOld() + "-");
			personList[i].printPerson();
		}
	}

	public static void main(String[] args) {
		ManagerPerson managerPerson = new ManagerPerson();
		// add 1 sinh vien
		Student std1 = new Student();
		std1.setName("Phuong");
		std1.setOld(22);

		managerPerson.addPerson(std1);

		// add 1 quan ly
		staff st1 = new staff();
		st1.setName("Hieu");
		st1.setOld(22);
		managerPerson.addPerson(st1);

		// add theo ten tu a-->z
		managerPerson.printListPerson();
		System.out.println("----------------\n Sap xep theo ten tu a --> z");
		managerPerson.sortListPersonByNameAZ();
		managerPerson.printListPerson();

		// add theo ten tu a-->z
		managerPerson.printListPerson();
		System.out.println("----------------\n Sap xep theo ten tu z --> a");
		managerPerson.sortListPersonByNameZA();
		managerPerson.printListPerson();

		// add theo tuoi giam dan
		managerPerson.printListPerson();
		System.out.println("----------------\n Sap xep theo tuoi giam dan");
		managerPerson.sortListPersonByOldDecrease();
		managerPerson.printListPerson();

		// add theo tuoi tang dan
		managerPerson.printListPerson();
		System.out.println("----------------\n Sap xep theo tuoi tang dan");
		managerPerson.sortListPersonByOldIncrease();
		managerPerson.printListPerson();

		// xoa 1 phan tu co ten tuong ung
		System.out.println("-----------------\n xoa phan tu co ten Hieu");
		managerPerson.removePerson("Hieu");
		managerPerson.printListPerson();
	}
}