package demo.demo2;

public class Employee {
	private String fullName;
	double salary;

	public Employee(String fullName, double salary) {
		this.fullName = fullName;
		this.salary = salary;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	void output() {
		System.out.println("Nhan vien : " + fullName + " - co luong la : " + salary);
	}

	public static void main(String[] args) {
/*		ArrayList<Person> list = new ArrayList<Person>();
		Staff staff = new Staff();
		staff.setName("Thang");
		staff.setOld(13);
		list.add(staff);

		Student student2 = new Student();
		student2.setName("Anna Lyn");
		student2.setOld(3);
		list.add(student2);

		Student student = new Student();
		student.setName("Phuong");
		student.setOld(10);
		list.add(student);

		for (Person person : list) {
			System.out.println(person.getName() + " - " + person.getOld());
		}

		System.out.println("======================");

		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getOld() - o2.getOld();
			}
		});

		for (Person person : list) {
			System.out.println(person.getName() + " - " + person.getOld());
		}*/
		
		// =======================================
		
	}
}
