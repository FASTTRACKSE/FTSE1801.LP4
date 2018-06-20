package demo_d2;

import java.util.Scanner;

public class vd_traveham {
	public static void main(String[] args) {
		System.out.println(ptbacnhat());
	}
	public static int ptbacnhat() {
		int a = 3;
		int b = 4;
		Scanner sc = new Scanner(System.in);
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm");
			}
		}else {
			int ptbacnhat= -b/a;
			return ptbacnhat;
		}
		return 0;
	}
}
