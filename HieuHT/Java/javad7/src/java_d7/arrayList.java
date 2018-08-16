package java_d7;

import java.util.ArrayList;

public class arrayList {
    public static void main(String[]args) {
    	ArrayList<String> listString = new ArrayList<String>();
    	
    	
    	
      if(listString.isEmpty()) {
    	 System.out.println("k có phần tử nàm hết: ");
      }else {
    	  System.out.println("hình như có phần tử: ");
      }
      
      //
      listString.add("Vui 1");
      
      if(listString.isEmpty()) {
     	 System.out.println("k có phần tử nàm hết: ");
       }else {
     	  System.out.println("hình như có phần tử: ");
       }
      
      listString.add("Vui 2");
      listString.add("Vui 3");
      listString.add("Vui 4");
      listString.add("Vui 5");
      
      for(int i = 0; i < listString.size(); i++) {
    	  System.out.println(listString.get(i));
      }
      System.out.println("-------------------");
      
      // xóa;
      listString.remove(3);
      
      for(String String:listString) {
    	  System.out.println(String);
      }
      System.out.println("Số phần tử còn lại: "+listString.size());
      
      
    //sữa;
      listString.set(2, new String("Yêu 5"));
      for(String String:listString) {
    	  System.out.println(String);
      }
      
    }
    
    
}
