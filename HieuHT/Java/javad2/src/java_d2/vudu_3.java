package java_d2;

import java.util.Scanner;

public class vudu_3 {
    public static void main(String[]args) {
    	Scanner sc = new Scanner(System.in);
    	int n;
    	int i=1;
    	do {
    		System.out.println("STT-"+i+" :Xin chào");
    		System.out.println("bạn có muốn tiếp tục in thư mục không (yes:1|no:0)");
    		n = sc.nextInt();
    		i++;
    		
    	}while(n==1);
    }
}
