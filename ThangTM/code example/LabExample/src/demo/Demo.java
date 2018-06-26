package demo;

import java.util.HashMap;
import java.util.Scanner;

import quanlysv.sinhvien.SinhVien;

/**
 * Manager student name list
 * 
 * @author GaLonTon
 *
 */
public class Demo {

	/** array for save student name list */
	public static String[] studentNameArray = new String[100];
	/** array for save student year old list */
	public static int[] studentYearOldArray = new int[100];
	/** student total in array */
	public static int studentTotal = 0;


	/**
	 * This function for add new student name to array student name list
	 * @param studentName name of student
	 */
	public static void addStudent(String studentName, int yearOld) {
		studentNameArray[studentTotal] = studentName;
		studentYearOldArray[studentTotal] = yearOld;
		studentTotal += 1;
	}

	/**
	 * This function for display all student name
	 */
	public static void displayStudent() {
		if (studentTotal != 0) {
			System.out.format("%3s|%-30s|%9s%n","stt", "Student name", "year old");

			for (int i = 0; i < studentTotal; i++) {
				System.out.format("%3d|%-30s|%3d%n",i+1 ,studentNameArray[i], studentYearOldArray[i]);
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

		while (true) {
			System.out.println("*********** Manager student name list - Menu ***********");
			System.out.println("* 1 - Add student name                                 *");
			System.out.println("* 2 - Dislay all student name                          *");
			System.out.println("* 3 - Exit program                                     *");
			System.out.println("********************************************************");

			chooseMenu = scanner.nextInt();

			switch (chooseMenu) {
			case 1:
				System.out.println("Input name student :");
				studentName = scanner.next();
				System.out.println("Input year old student :");
				yearOld = scanner.nextInt();
				addStudent(studentName, yearOld);
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
		//menu();
		
		HashMap<String, SinhVien> mapSinhVien = new HashMap<String, SinhVien>();
		
		SinhVien sv1 = new SinhVien("ffse1", "Vui1", 12, 10);
		SinhVien sv2 = new SinhVien("ffse2", "Vui2", 12, 10);
		SinhVien sv3 = new SinhVien("ffse3", "Vui3", 12, 10);
		SinhVien sv4 = new SinhVien("ffse4", "Vui4", 12, 10);
		SinhVien sv5 = new SinhVien("ffse5", "Vui5", 12, 10);
		
		mapSinhVien.put(sv1.getId(), sv1);
		mapSinhVien.put(sv2.getId(), sv2);
		mapSinhVien.put(sv3.getId(), sv3);
		mapSinhVien.put(sv4.getId(), sv4);
		mapSinhVien.put(sv5.getId(), sv5);

		
		SinhVien sv6 = mapSinhVien.get("sinh vien 2");
		if (sv6 != null)
			System.out.println(sv6.getName() + " - " + sv6.getId());

		String key = "ffse5";
		SinhVien sv7 = mapSinhVien.get(key);
		if (sv7 != null)
			System.out.println(sv7.getName() + " - " + sv7.getId());
	}
}
