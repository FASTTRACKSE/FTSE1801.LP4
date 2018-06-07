package java_day2;
import java.util.Scanner;
//import quanly.*;
public class menu {
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		myMenu();
	}
	public static void myMenu() {
		while (true) {
			System.out.println("+------------------------+");
			System.out.println("1. Giải phương trình bậc 1");
			System.out.println("2. Giải phương trình bậc 2");
			System.out.println("3. Tính tiền điện");
			System.out.println("4. Kết thúc");
			System.out.println("+------------------------+");
			System.out.println("Lựa chọn chức năng bạn muốn: ");
			
			int myOption = myScanner.nextInt();
			
			if (myOption == 1) {
				model.giaiPTB1();
			} else if (myOption == 2) {
				model.giaiPTB2();
			} else if (myOption == 3) {
				model.tinhtiendien();
			} else if (myOption == 4) {
				model.ketthuc();
			}
		}
	}
}