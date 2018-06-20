package baitap;

import java.util.Scanner;

	public class day_soNguyenTo {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.print("Nhập n =");
			int n = input.nextInt();
			input.close();
			day_snt(n);
		}
		public static void day_snt(int n){
			for(int i= 1; i<=n; i++) {
				if(i<=3) {
					System.out.print(i+"  ");
				}else {
					for(int j=2; j<=i/2; j++) {
						if (i%j==0) {
							break;
						}else if(j==i/2){
							System.out.print(i+"  ");	
						}				
					}
				}
			}
		}
}
