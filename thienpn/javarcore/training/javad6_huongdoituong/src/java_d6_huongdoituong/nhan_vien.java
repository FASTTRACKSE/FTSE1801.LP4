package java_d6_huongdoituong;

import java.util.Scanner;

public class nhan_vien {
	// thuộc tính
   String ten;
   int tuoi;
   String gioitinh;
   String diachi;
   
   nhan_vien(){
	    ten = "phương";
	    tuoi = 21;
	    gioitinh = "nam";
	    diachi = "Đà Nẵng";
   }
   
   nhan_vien(String ten, int tuoi, String gioitinh, String diachi){
	   this.ten = ten;
	   this.tuoi = tuoi;
	   this.gioitinh = gioitinh;
	   this.diachi = diachi;
   }
   
   //phương thức
   void setten(String ten) {
	   this.ten = ten;
   }
   void settuoi(int tuoi) {
	   this.tuoi = tuoi;
   }
   void setgioitinh(String gioitinh) {
	   this.gioitinh = gioitinh;
   }
   void setdiachi(String diachi) {
	   this.diachi = diachi;
   }
   //
  String getten() {
	  return ten;
  }
  int gettuoi() {
	  return tuoi;
  }
  String getgioitinh() {
	  return gioitinh;
  }
  String getdiachi() {
	  return diachi;
  }

  public static void main(String[]args) {
	  // phần nhập giá trị từ bàn phím.//
//	  Scanner sc = new Scanner(System.in);
//	  nhan_vien nv1 = new nhan_vien();
//	  
//	  System.out.println("Moi ban nhap ten nhân vien: ");
//	  String ten = sc.nextLine();
//	  nv1.setten(ten);
//	  
//	  System.out.println("Moi ban nhap tuổi nhân vien: ");
//	  int tuoi = sc.nextInt();
//	  nv1.settuoi(tuoi);
//	  sc.nextLine();
//	  
//	  System.out.println("Moi ban nhap Giới tính nhân vien: ");
//	  String gioitinh = sc.nextLine();
//	  nv1.setgioitinh(gioitinh);
//	  
//	  System.out.println("Moi ban nhap địa chỉ nhân vien: ");
//	  String diachi = sc.nextLine();
//	  nv1.setdiachi(diachi);
//	  
//	 
//	  
//	  System.out.println("Tên nhân viên là : "+ nv1.getten()+ nv1.gettuoi()+nv1.getgioitinh()+nv1.getdiachi());
//	  nhan_vien nv2 = new nhan_vien();
//	  System.out.println("Tên nhân viên : "+ nv2.ten);
//      System.out.println("Tuổi nhân viên : "+ nv2.tuoi);
//      System.out.println("Giới tính nhân viên : "+ nv2.gioitinh);
//      System.out.println("Địa chỉ nhân viên : "+ nv2.diachi);
//	  
//	  
//	  
//      nhan_vien nv3 = new nhan_vien("hợi", 21, "nam", "nghệ an");
//      System.out.println("Tên nhân viên : "+ nv3.getten());
//      System.out.println("Tuổi nhân viên : "+ nv3.gettuoi());
//      System.out.println("Giới tính nhân viên : "+ nv3.getgioitinh());
//      System.out.println("Địa chỉ nhân viên : "+ nv3.getdiachi());
	  
	  May_Tinh mt = new May_Tinh();
      System.out.println("tong a+b =  "+ mt.sumAB(2, 6));
      System.out.println("tong a+b+c =  "+ mt.sumAB(2, 6, 3));
  }
        
}
