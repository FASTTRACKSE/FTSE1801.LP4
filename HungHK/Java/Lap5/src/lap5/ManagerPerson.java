package lap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerPerson {
	private ArrayList<Person> listPerson;
		
	public ManagerPerson() {
		listPerson = new ArrayList<Person>();
	}
	
	public void nhap(Person person) {
		listPerson.add(person);
	}
	
	public void xuat() {
		System.out.printf("%-12s %-5s\n", "Tên", "Tuổi");
		for (Person person : listPerson) {
			System.out.printf("%-12s %-5s\n", person.getHoTen(), person.getTuoi());
//			person.printPerson();
		}
	}
	
	public void sapxep() {
		Collections.sort(listPerson, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
			}
		});
	}
	
	public void ngaunhien() {
		Collections.shuffle(listPerson);
	}
	
	public void xoa(String hoTen) {
		Object name = null;
		for (int i=0; i<listPerson.size(); i++) {
			if (listPerson.get(i).getHoTen().equals(hoTen)) {
				name = listPerson.get(i);
				break;
			}
		}
		if (name != null) {
			listPerson.remove(name);
		}else {
			System.out.println("Bạn đã nhập sai!");
		}
	}
	
	public void menu() {
		int chooseMenu;
		Scanner sc = new Scanner(System.in);
		ManagerPerson mp = new ManagerPerson();
		System.out.println("Mời bạn chon menu!");
		
		while (true) {
			System.out.println("1. Thêm vào danh sách");
			System.out.println("2. Hiển thị danh sách");
			System.out.println("3. Sắp xếp danh sách");
			System.out.println("4. Hiển thị danh sách ngẫu nhiên");
			System.out.println("5. Xóa người trong danh sách");
			System.out.println("6. Chương trình kết thúc");
			
			chooseMenu = sc.nextInt();
			switch (chooseMenu) {
			case 1:
				Person per = new Person();
				sc.nextLine();
				System.out.print("Nhập họ tên: ");
				String hoTen = sc.nextLine();
				per.setHoTen(hoTen);
				
				System.out.print("Nhập tuổi: ");
				int tuoi = sc.nextInt();
				per.setTuoi(tuoi);
				
				mp.nhap(per);
				break;
				
			case 2:
				mp.xuat();
				break;
				
			case 3:
				mp.sapxep();
				mp.xuat();
				break;
				
			case 4:
				mp.ngaunhien();
				mp.xuat();
				break;
				
			case 5:
				System.out.print("Nhập họ tên cần xóa: ");
				sc.nextLine();
				String hoTen1 = sc.nextLine();
				mp.xoa(hoTen1);
				mp.xuat();
				break;
				
			case 6:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;
				
			default:
				System.out.println("\n\n********Menu not exist feature********");
				break;
			}
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		ManagerPerson mn = new ManagerPerson();
		mn.menu();
	}
}
