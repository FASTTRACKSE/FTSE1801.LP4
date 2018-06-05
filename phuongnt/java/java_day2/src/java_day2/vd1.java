package java_day2;

import java.util.Scanner;

public class vd1 {
	public static void main(String[] args) {
//		System.out.println("Bạn muốn lặp bao nhiêu lần: ");
		Scanner sc= new Scanner(System.in);
//		int n=sc.nextInt();

//		for(int i = 0; i<=5; i++) {
//			System.out.println("STT-"+i+": Xin chào");
//		}
		
		int i=1;
		int n;
		do {
			System.out.println("STT-"+i+": Xin chào");
			System.out.println("Bạn có muốn tiếp tục in không");
			n=sc.nextInt();
			i++;
		}while(n==1);
	}
}

