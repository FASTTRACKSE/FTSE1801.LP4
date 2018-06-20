package java_d2;

import java.util.Scanner;

public class songuyento {
	public static void main(String[] args) {
		/*Chuyen doi int thanh Integer  
		int a=20;
		Integer i=Integer.valueOf(a);//Chuyen doi int thanh Integer  
		Integer j=a;//Day la autoboxing, bay gio compiler se viet la Integer.valueOf(a)  
		  
		System.out.println(a+" "+i+" "+j);
		
		//Chuyen doi Integer thanh int    
		Integer b=new Integer(3);    
		int x=b.intValue();//Chuyen doi Integer thanh int 
		int y=b;//Day la unboxing, bay gio compiler se viet la a.intValue()    
		    
		System.out.println(b+" "+x+" "+y);*/
		
//		int n;
//		int dem=0;
//		Scanner sc=new Scanner(System.in);
//		System.out.print("Nhập N= ");
//		n=sc.nextInt();
//		if(n<=2) {
//			System.out.println("N là số nguyên tố");
//		}else {
//			for(int i=2;i<=(n/2); i++) {
//				if(n%i==0) {
//					dem++;
//				}
//			}if(dem==0) {
//				System.out.println("N là số nguyên tố");
//			}else {
//				System.out.println("N không phải số nguyên tố");
//			}
//		}
		
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhập N= ");
		n=sc.nextInt();
		sc.close();

		songuyen(n);
	}
	public static void songuyen(int n) {
		for(int i=1;i<=n;i++) {
			if(i<=3) {
				System.out.print(i+",");
			}else {
				for(int j=2; j<=i/2;j++) {
					if(i%j==0) {
						break;
					}else if(j==i/2){
						System.out.print(i+",");
					}
				}
			}
		}

	}

}
