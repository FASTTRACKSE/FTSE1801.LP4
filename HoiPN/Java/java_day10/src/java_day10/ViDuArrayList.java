package java_day10;

import java.util.ArrayList;

public class ViDuArrayList {
	public static void main(String[] args) {
		ArrayList<String> listString = new ArrayList<String>();
		if(listString.isEmpty()) {
			System.out.println("Khong co phan tu nao het");
		}else {
			System.out.println("hinh nhu co phan tu nao het");
		}
		
		listString.add("Hoi 1");
		
		if(listString.isEmpty()) {
			System.out.println("Khong co phan tu nao het");
		}else {
			System.out.println("Co phan tu la: ");
		}
		
		listString.add("Hợi 2");
		listString.add("Hợi 3");
		listString.add("Hợi 4");
		listString.add("Hợi 5");
		for( int i=0;i<listString.size();i++) {
			System.out.println(listString.get(i));
		}
		
		System.out.println("");
		
		listString.remove(3);
		
		for(String string:listString) {
			System.out.println(string);
		}
		
		System.err.println("So phan tu con lai la: " + listString.size());
		System.out.println("");
		listString.set(3,"Buon 5");
		
		for(String string:listString) {
			System.out.println(string);
		}
		System.out.println("");
		listString.clear();
		
		
	}
}
