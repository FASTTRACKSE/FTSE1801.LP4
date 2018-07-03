package Assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyBienLaiTienDien {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		BienLai bienLai;
		ArrayList<BienLai> listBienLai = new ArrayList<BienLai>();
		
		  System.out.print("Nhập số hộ gia đình: ");
	        n = scanner.nextInt();
	         
	        for (int i = 0; i < n; i++) {
	            bienLai = new BienLai();
	            System.out.println("Nhập thông tin biên lai của hộ gia đình thứ " + (i + 1) + ": ");
	            bienLai.nhapBienLai();
	            listBienLai.add(bienLai);
	        }
	         
	        System.out.println("Thông tin biên lai của các hộ gia đình: ");
	        for (int i = 0; i <listBienLai.size(); i++) {
	            System.out.println("Thông tin biên lai hộ gia đình thứ " + (i + 1) + ": ");
	            listBienLai.get(i).hienThiBienLai();
	    }
	        scanner.close();
	}
}
