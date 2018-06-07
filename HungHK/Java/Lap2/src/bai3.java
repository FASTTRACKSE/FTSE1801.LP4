import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số điện đã sử dụng: ");
		a=sc.nextInt();
		if (a<=50) {
			System.out.println("Số tiền phải trả là: " +a*1000);
		}
		else {
			System.out.println("Số tiền phải trả là: " +(50*1000+(a-50)*1200));
		}
	}
}
