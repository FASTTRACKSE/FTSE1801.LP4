import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Person Class
 * @author CôngMT
 *
 */
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
	/**
	 * Show Person
	 */
	public void show() {
		System.out.printf("%-3s|%-20s|%-10s|%-20s \n","STT","Họ và tên","Tuổi","Địa chỉ");
		int size= listPerson.size();
		for(int i=0; i<size;i++) {
			System.out.printf("%-3s|%-20s|%-10s|%-20s \n",(i+1),listPerson.get(i).getName(),listPerson.get(i).getAge(),listPerson.get(i).getAddress());
			
		}
	}
	/**
	 * Sắp xếp tên từ A-->Z
	 */
	public void sapXepTenAZ() {
		Collections.sort(listPerson, new SortPersonByName());
	}
	/**
	 * Sắp xếp ngẫu nhiên
	 */
	public void xuatNgauNhien() {
		Collections.shuffle(listPerson);
		this.show();
	}
	/**
	 * delete person by name
	 * 
	 * @param name:
	 *            
	 */
	public void deletelPerson(String name) {

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
	/**
	 * create showMenu
	 */
	public static void showMenu() {
		System.out.println("-----------MENU------------");
		System.out.println("1. Nhập họ và tên.");
		System.out.println("2. Xuất danh sách ngẫu nhiên.");
		System.out.println("3. Xóa danh sách theo tên.");
		System.out.println("4. Sắp xếp theo tên.");
		System.out.println("5. Hiển thị danh sách person");
		System.out.println("0. Exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
		
	}
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		QuanLyPerson quanly=new QuanLyPerson();
		int choose, tiepTuc;
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
					tiepTuc = sc.nextInt();
					System.out.println();
				} while (tiepTuc == 1);

				break;
			case 2:
				quanly.xuatNgauNhien();
				break;

			case 3:
				System.out.println();
				System.out.print("Nhập ten can xoa : ");
				System.out.println();
				sc.nextLine();
				String idDelete = sc.nextLine();
				quanly.deletelPerson(idDelete);
				quanly.showMenu();
				break;
			case 4:	
				quanly.sapXepTenAZ();
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

	

}
