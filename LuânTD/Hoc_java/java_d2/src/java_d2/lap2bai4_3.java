package java_d2;

import java.util.Scanner;
import ham.*;
public class lap2bai4_3 {
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
			sc.close();
			switch(n) {
				case 1:
				PT_bac1.PT_b1();
				break;
				case 2:
				PT_bac2.PT_b2();
				break;
				case 3:
				tiendien.dien();
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
