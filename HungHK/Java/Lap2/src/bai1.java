
import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		double a, b;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap gia tri a: ");
		a=sc.nextDouble();
		System.out.println("Nhap gia tri b: ");
		b=sc.nextDouble();
		
		if(a==0) {
			if(b==0) {
				System.out.println("Phuong trinh co vo so nghiem");
			}
			else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}
		else {
			double x = -b/a;
			System.out.print("Phuong trinh co nghiem la x = " +x);
		}
	}
}