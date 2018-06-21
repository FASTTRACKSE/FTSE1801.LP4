import java.util.Scanner;

public class Bt3 {
	public static void main(String[] args) {
		int canh, thetichlapphuong;
		Scanner sc = new Scanner(System.in);
		System.out.println("- Nhập cạnh:");
		canh = sc.nextInt();
		thetichlapphuong = canh * canh * canh;
		System.out.println("- Thể tích hình lập phương:" + thetichlapphuong);

	}
}
