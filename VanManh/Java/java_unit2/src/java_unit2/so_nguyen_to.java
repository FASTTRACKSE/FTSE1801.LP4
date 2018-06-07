package java_unit2;
import java.util.Scanner;

public class so_nguyen_to {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập n =");
		int n = input.nextInt();
		if(n<=3) {
			System.out.print(n+" là số nguyên tố");
		}else {
			for(int i=2; i<=n/2; i++) {
				if (n%i==0) {
					System.out.print(n + " Không là số nguyên tố");
					break;
				}else if(i==n/2){
					System.out.print(n + "  là số nguyên tố");	
				}
				
			}
		}
		
		
	}
}
