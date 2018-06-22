import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyPerson {
	private ArrayList<Person> listPerson;
	public QuanLyPerson() {
		listPerson=new ArrayList<Person>();
	}
	/**
	 * add person to PersonList
	 * 
	 * @param person
	 */
	public void add(Person person) {
		listPerson.add(person);

	}
	public void show() {
		System.out.printf("%-3s|%-20s|%-10s|%-20s \n","STT","Họ và tên","Tuổi","Địa chỉ");
		int size= listPerson.size();
		for(int i=0; i<size;i++) {
			System.out.printf("%-3s|%-20s|%-10s|%-20s \n",(i+1),listPerson.get(i).getName(),listPerson.get(i).getAge(),listPerson.get(i).getAddress());
			
		}
	}
	public void sapxepten() {
		Collections.sort(listPerson, new SortPersonByName());
	}
	public void xuatngaunhien() {
		Collections.shuffle(listPerson);
		this.show();
	}
	/**
	 * delete person by name
	 * 
	 * @param name:
	 *            
	 */
	public void deletel(String name) {
//		int size = listPerson.size();
//		for (int i = 0; i < size; i++) {
//			if (listPerson.get(i).getName().equals(name) ) {
//				listPerson.remove(i);
//				break;
//			}	
//		}
		Person person = null;
		int size = listPerson.size();
		for (int i = 0; i < size; i++) {
			if (listPerson.get(i).getName().equals(name)) {
				person = listPerson.get(i);
				break;
			}
		}
		if (person != null) {
			listPerson.remove(person);
		
		} else {
			System.out.printf("name = %d not existed.\n", name);
		}
			
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		QuanLyPerson quanly=new QuanLyPerson();
		int choose, tt;
		showMenu();
		while (true) {
			choose = sc.nextInt();

			switch (choose) {
			case 1:
				do {
					Person person1 = new Person();
					sc.nextLine();
					System.out.println("- Nhập tên:");
					String name = sc.nextLine();
					person1.setName(name);
				
					System.out.println("- Nhập tuổi :");
					byte age = sc.nextByte();
					sc.nextLine();
					person1.setAge(age);
					System.out.println("- Nhập địa chỉ:");
					String address = sc.nextLine();
					person1.setAddress(address);
					quanly.add(person1);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);

				break;
			case 2:
				quanly.xuatngaunhien();
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập ten can xoa : ");
				System.out.println();
				sc.nextLine();
				String idDelete = sc.nextLine();
				quanly.deletel(idDelete);
				quanly.showMenu();
				break;
			case 4:
				quanly.sapxepten();
				break;
			case 5:
				quanly.show();
				break;

			case 0:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
			
		}
	}

	/**
	 * create menu
	 */
	public static void showMenu() {
		System.out.println("-----------menu------------");
		System.out.println("1. Nhập họ và tên.");
		System.out.println("2. Xuất danh sách ngẫu nhiên.");
		System.out.println("2. Xóa danh sách theo tên.");
		System.out.println("4. Sắp xếp theo tên.");
		System.out.println("5. Hiển thị danh sách person");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose:  ");
		
	}
	

}
