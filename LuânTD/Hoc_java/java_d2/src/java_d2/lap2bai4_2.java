package java_d2;
import java.util.Scanner;

import java_d2.ham;

public class lap2bai4_2 {
	public static void main(String[] args) {
		
		System.out.println("+---------------------------------------------------+\r\n" + 
				"1.	Giải phương trình bậc nhất\n" + 
				"2.	Giải phương trình bậc 2\n" + 
				"3.	Tính tiền điện\n" + 
				"4.	Kết thúc\r\n" + 
				"+---------------------------------------------------+\n");
		int n;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.print("Chọn chức năng: ");
			n=sc.nextInt();
			switch(n) {
				case 1:
				ham.PT_bac1(args);
				break;
				case 2:
				ham.PT_bac2(args);
				break;
				case 3:
				ham.tiendien(args);
				break;
				case 4:
				System.out.println("Kết thúc chương trình");
				break;
				default:
				System.out.println("Nhập sai");
			}
			
		}while(n>4);
		
		
		
	}

}
