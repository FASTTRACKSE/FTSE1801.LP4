package javaday2;

public class vidu1 {
	public static void main(String[] args) {
		//chuyển đổi int thành integer
		int a=20;  
		Integer i=Integer.valueOf(a);//Chuyen doi int thanh Integer  
		Integer j=a;//Day la autoboxing, bay gio compiler se viet la Integer.valueOf(a)  
		  
		System.out.println(a+" "+i+" "+j);
	}
}
