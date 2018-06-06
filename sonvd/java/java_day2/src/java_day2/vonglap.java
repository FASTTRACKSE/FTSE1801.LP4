package java_day2;

import java.util.*;

public class vonglap {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		int n;
		int i=1;
		do {
			System.out.println("STT-"+i+": Xin chào");
			System.out.println("Bạn có muốn tiếp tục in không (1:Yes|0:No)");
			n = input.nextInt();
			i++;
		} while (n==1);
	}
}
