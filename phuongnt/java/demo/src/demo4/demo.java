package demo4;

import java.util.Scanner;

public class demo {
	public static String giaiPTB1() {
		double a, b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập giá trị a: ");
		a= sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b= sc.nextDouble();
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm");
			}
		}else {
			double x=-b/a;
			System.out.println("Phương trình có nghiệm x="+x);
		}
		return giaiPTB1();
	}
	
	public static void sosanh10(int a) {
		if(a > 10) {
			System.out.println("Lớn hơn 10");
		} else {
			System.out.println("Nhỏ hơn 10");
		}
	}
	
	public static void hienthiMang(int[] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(""+ a[i]+" - ");
		}
	}
	
	public static int hamsoBacNhat(int x){
		int y = 2*x;
		return y;
	}
	public static void main (String[] args) {
		int[] a= {1, 2, 3, 4, 5};
		hienthiMang(a);
		
		System.out.println("");
		
		int[] b= {6, 7, 8, 9, 10};
		hienthiMang(b);
		
		System.out.println("");
		
		int[] c= {11, 12, 13, 14, 15};
		hienthiMang(c);
		
		int x = 12;
		System.out.println("\n"+hamsoBacNhat(x));
		sosanh10(hamsoBacNhat(x));
		
		x = 4;
		System.out.println("\n"+hamsoBacNhat(x));
		sosanh10(hamsoBacNhat(x));
		
		int d = 8;
		System.out.println("\n"+hamsoBacNhat(d));
		sosanh10(d);
		
		int e = 3;
		System.out.println("\n"+hamsoBacNhat(e));
		sosanh10(hamsoBacNhat(e));
		
		giaiPTB1();
	}
}
