package lap2;

import java.util.Scanner;

public class Bai4 {
	
	/** array for save student name list */
	public static String[] studentNameArray = new String[100];
	/** array for save student year old list */
	public static int[] studentYearOldArray = new int[100];
	/* aray for save student point list */
	public static int[] studentpointArray = new int[100];
	/** student total in array */
	public static int studentTotal = 0;


	/**
	 * This function for add new student name to array student name list
	 * @param studentName name of student
	 */
	public static void addStudent(String studentName, int yearOld, int point) {
		studentNameArray[studentTotal] = studentName;
		studentYearOldArray[studentTotal] = yearOld;
		studentpointArray[studentTotal] = point;
		studentTotal += 1;
	}

	/**
	 * This function for display all student name
	 */
	public static void displayStudent() {
		if (studentTotal != 0) {
			System.out.format("%3s|%-20s|%9s|%9s%n","stt", "Student name", "year old", "point");

			for (int i = 0; i < studentTotal; i++) {
				System.out.format("%3d|%-20s|%9s|%9s%n",i+1 ,studentNameArray[i], studentYearOldArray[i], studentpointArray[i]);
			}

		} else {
			System.out.println("Student name list is empty");
		}
	}

	/**
	 * Menu for program manager student name list 
	 */
	public static void menu() {

		int chooseMenu;
		Scanner scanner = new Scanner(System.in);
		String studentName;
		int yearOld;
		int point;

		while (true) {
			System.out.println("*********** Manager student name list - Menu ***********");
			System.out.println("* 1 - nhập tên học sinh                                *");
			System.out.println("* 2 - hiển thị danh sách học sinh                      *");
			System.out.println("* 3 - kết thúc chương trình                            *");
			System.out.println("********************************************************");

			chooseMenu = scanner.nextInt();

			switch (chooseMenu) {
			case 1:
				System.out.println("Nhập tên học sinh :");
				studentName = scanner.next();
				System.out.println("Nhập tuổi học sinh :");
				yearOld = scanner.nextInt();
				System.out.println("Nhập điểm học sinh :");
				point = scanner.nextInt();
				addStudent(studentName, yearOld, point);
				break;

			case 2:
				displayStudent();
				break;

			case 3:
				scanner.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;

			default:
				System.out.println("\n\n\n\n********Menu not exist feature********");
				break;
			}

			System.out.println("\n\n\n\n\n");
		}
	}


	public static void main(String[] args) {
		menu();
	}
	
	
	
	

}
