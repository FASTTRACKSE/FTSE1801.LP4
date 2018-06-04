package hello;

import java.util.Scanner;

public class sosanh {
    public static void main(String[]args) {
    	int a, b, c, x, y;
    	
    	Scanner myInput = new Scanner(System.in);
    	
    	System.out.print("nhập vào số a : ");
    	a = myInput.nextInt();
    	
    	System.out.print("nhập vào số b : ");
    	b = myInput.nextInt();
    	
    	System.out.print("nhập vào số c : ");
    	c = myInput.nextInt();
    	
    	x = Math.min(a, Math.min(c, b));
    	y = Math.max(a, Math.max(c, b));
    	System.out.println("số nhỏ nhất là : "+x);
    	System.out.println("số lớn nhất là : "+y);
    }
}
