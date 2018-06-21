package Baitap_tienDien;

import java.util.ArrayList;
import java.util.Scanner;

public class BienLai {
     private ArrayList<KhachHang> listKH;
     
     public BienLai() {
    	 listKH = new ArrayList<KhachHang>();
     }
     // tính ti�?n Kh
     public void TienDienTra() {
    	 for(int i=0; i<listKH.size(); i++) {
    		listKH.get(i).setTienDien((listKH.get(i).getChiSoMoi()-listKH.get(i).getChiSoCu())*750);
    	 }
     }
     // thêm khách hàng
     public void addKH(KhachHang kh) {
    	 listKH.add(kh);
     }
     // in danh sách khách hàng.
     public void printKH() {
   	 System.out.printf("%20s|%-20s|%20s|%-20s|%20s|%20s%n", "Tên KH","�?ịa Chỉ",
   			 "Số Công Tơ","Số �?iện Cũ","Số �?iện Mới","Ti�?n điên");
    	 for(int i = 0; i<listKH.size();  i++) {
//    		 System.out.println("Ten"+ listKH.get(i).getName());
//    		 System.out.println("Ten"+ listKH.get(i).getAddress());
//    		 System.out.println("Ten"+ listKH.get(i).getMaso());
//    		 System.out.println("Ten"+ listKH.get(i).getChiSoCu());
//    		 System.out.println("Ten"+ listKH.get(i).getChiSoMoi());
//    		 System.out.println("Ten"+ listKH.get(i).getTienDienTra());
   		 System.out.printf("%20s|%-20s|%20s|%-20s|%20s|%20s%n", listKH.get(i).gethoTen(),listKH.get(i).getsoNha(),
        			 listKH.get(i).getMaso(),listKH.get(i).getChiSoCu(),listKH.get(i).getChiSoMoi(),listKH.get(i).getTienDien());
    	 }
     }
     public void menu() {
    	 int chooseMenu;
			Scanner sc = new Scanner(System.in);
			BienLai bl = new BienLai();
			
			
		
			while (true) {
				
				System.out.println(" 1 - Thêm thông tin Khách Hàng");
				
				System.out.println( "2- Hiển thị danh sách Khách Hàng");
			
				                                    
				System.out.println(" 3 - Exit program");
				System.out.println("--------------------------------");
		
				chooseMenu = sc.nextInt();
		
				switch (chooseMenu) {
				case 1:
					
					KhachHang kh1 = new KhachHang();
					
					System.out.println("Nhập tên KH :");
					sc.nextLine();
					String hoTen = sc.nextLine();
					kh1.sethoTen(hoTen);
					
					System.out.println("Nhập địa chỉ KH :");
					String soNha = sc.nextLine();
					kh1.setsoNha(soNha);
					System.out.println("Nhập điểm số Công tơ :");
					String maso = sc.nextLine();
					kh1.setMaso(maso);
					
					System.out.println("Nhập chỉ số tiêu dùng cũ :");
					double ChiSoCu = sc.nextDouble();
					kh1.setChiSoCu(ChiSoCu);
					System.out.println("Nhập chỉ số tiêu dùng mới :");
					double ChiSoMoi = sc.nextDouble();
					kh1.setChiSoMoi(ChiSoMoi);
					
					bl.addKH(kh1);
					break;
		
				
				case 2:
					bl.TienDienTra();
					bl.printKH();
					break;
				
				case 3:
					sc.close();
					System.out.println("===============");
					System.exit(0);
					break;
		
				default:
					System.out.println("__________________");
					break;
				}
		
				System.out.println("\n\n\n\n\n");
			}
		}

     public static void main(String[] args) {
		BienLai tt = new BienLai();
		tt.menu();
	}
}