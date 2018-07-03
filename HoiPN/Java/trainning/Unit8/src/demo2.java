import java.util.Scanner;
/**
 * 
 * @author Phạm Ngọc Hợi
 *
 */
public class demo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Nhập số điện thoại: ");
			String numberPhone = sc.nextLine();
			String pattern = "0[0-9]{9,10}";
			//String pattern = "0\\d{9,10}";
			if(numberPhone.matches(pattern)) {
				System.out.println("Đúng");
			}else {
				System.out.println("Sai");
			}
			
			System.out.println("Nhập biển số xe: ");
			String bsx = sc.nextLine();
			String a = "5\\d-[A-Z]\\d-((\\d{4})|(\\d{3}\\.\\d{2}))";
			if(bsx.matches(a)) {
				System.out.println("Đúng");
			}else {
				System.out.println("Sai");
			}
		}
	}
}
