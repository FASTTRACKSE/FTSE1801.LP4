package java_unit2;

public class lop_wrapper {
	public static void main(String[] args) {
		//Chuyen doi int thanh Integer  
		int a=20;  
		Integer i=Integer.valueOf(a);//Chuyen doi int thanh Integer  
		Integer j=a;//Day la autoboxing, bay gio compiler se viet la Integer.valueOf(a)  
		  
		System.out.println(a+" "+i+" "+j);  
		
		//Chuyen doi Integer thanh int    
		Integer b=new Integer(3);    
		int h=b.intValue();//Chuyen doi Integer thanh int 
		int k=b;//Day la unboxing, bay gio compiler se viet la a.intValue()    
		    
		System.out.println(b+" "+h+" "+k);    
	}
}
