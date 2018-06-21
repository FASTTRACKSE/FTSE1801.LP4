

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SinhVien {
	private String name;
	private int age;

	public SinhVien(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name + "  -  " + age;
	}

	public static void main(String[] args) {
		ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();
		SinhVien sv1 = new SinhVien("Hưng", 28);
		SinhVien sv2 = new SinhVien("Phương", 23);
		SinhVien sv3 = new SinhVien("An", 21);
		SinhVien sv4 = new SinhVien("Hiệu", 22);
		SinhVien sv5 = new SinhVien("Công", 25);
		listSv.add(sv1);
		listSv.add(sv2);
		listSv.add(sv3);
		listSv.add(sv4);
		listSv.add(sv5);

		for (SinhVien sv : listSv) {
			System.out.println(sv.toString());
		}
		
		System.out.println("\nSắp xếp sinh viên theo tên:");
		Collections.sort(listSv, new Comparator<SinhVien>() {
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (SinhVien sv : listSv) {
			System.out.println(sv.toString());
		}
		
		System.out.println("\nSắp xếp sinh viên theo tuổi:");
		Collections.sort(listSv, new Comparator<SinhVien>() {
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		for (SinhVien sv : listSv) {
			System.out.println(sv.toString());
		}
		
		System.out.println("\nXóa sinh viên theo tên:");
		String name = "Phương";
		for (int i=0; i<listSv.size(); i++) {
			if (listSv.get(i).getName().equals(name)) {
				listSv.remove(i);
			}
		}
		for (SinhVien sv : listSv) {
			System.out.println(sv.toString());
		}
	}
}
