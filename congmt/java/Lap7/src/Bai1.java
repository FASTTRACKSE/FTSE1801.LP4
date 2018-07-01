import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		String ten = null;
		Scanner sc = new Scanner(System.in);
		boolean kiemTra = true;
		// Nhap va kiem tra sdt
		while (kiemTra) {
			System.out.println("moi nhap so:");
			String nuberPhone = sc.nextLine();
			String pattern = "0[0-9]{9,10}";
			// String pattern= "0\\9{9,10}";
			if (nuberPhone.matches(pattern)) {
				System.out.println(nuberPhone + ": So dien thoai nay co the dung.");
				kiemTra = false;
			} else {
				System.out.println("Sai cm no so roi!");
				sc.close();
			}
		}
		// Nhap ten

		do {
			String pantter = "([A-Z][a-z]* )*([A-Z][a-z]*)";
			System.out.println("Nhap ten : ");
			ten = sc.nextLine();
			if (ten.matches(pantter)) {
				System.out.println("chuc mung ban da nhap dung.");
				kiemTra = false;
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);

		// Nhap tuoi
		String ageStr;
		int age;
		do {
			String pantter = "[1-6]\\d";
			System.out.println("Nhap tuoi : ");
			ageStr = sc.nextLine();
			if (ageStr.matches(pantter)) {
				System.out.println("chuc mung ban da nhap dung.");
				kiemTra = false;
				age = Integer.parseInt(ageStr);
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);
		// Nhap email
		String email;
		do {
			String remail = "\\w+@+\\w+\\.\\w+{1,2}";
			System.out.println("Nhap email:");
			email = sc.nextLine();
			if (email.matches(remail)) {
				System.out.println("Ban co the dung email nay!");
				kiemTra = false;
			} else {
				System.out.println("Nhap sai cmnr, nhap lai.");
				kiemTra = true;
			}
		} while (kiemTra);

	}

}
