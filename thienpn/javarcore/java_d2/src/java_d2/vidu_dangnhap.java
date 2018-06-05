package java_d2;

import java.util.Scanner;

public class vidu_dangnhap {
    public static void main(String[]args){
    	//khai báo biến
    	System.out.println("---Login---");
    	String pass,i;
    	
    	
    	
    	String name;
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Username: ");
    	name = sc.nextLine();
    	
    	do {
    		System.out.print("Password: ");
    		pass = sc.nextLine();
    		
    		
        	
    	}while(!"ngocthien123".equals(pass));
    	System.out.println("Đăng nhập thành công");
    	
    }
}
