package vd_ham;
import java.util.Scanner;
public class ham_mang_fibonacci {
	public static Integer[] fibonacci_mang(int n) {
		int t1,t2;
		t1 =0;
		t2=1;
		Integer [] rs = new Integer[n];
		rs[0]=0;
		rs[1]=1;
		if(n>2) {
			for(int i = 2;i<n;i++) {
				int so = t1+t2;
				rs[i]= so;
				t1=t2;
				t2=so;
			}
		}
		return rs;
	}

	public static void main(String args[]) {
		System.out.println("Xin mời nhập số n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] day_so=fibonacci_mang(n);
		for(int x:day_so) {
			System.out.print(x + " ");
		}
	}
}
