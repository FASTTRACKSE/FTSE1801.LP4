package lap5;

//Lop Nguoi
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Nguoi
{
 private String hoTen;
 private Date ngaySinh;
 private String soCMND;
 public Nguoi()
 {
    
 }
 public Nguoi( String hoTen,Date ngaySinh,String soCMND)
 {
     this.hoTen=hoTen;
     this.ngaySinh=ngaySinh;
     this.soCMND=soCMND;
 }
 public void nhapThongTin(Scanner sc)
 {
     System.out.print("Nhap ho va ten khach hang: ");
     this.hoTen=sc.nextLine();
     System.out.println("Nhap ngay sinh(dd-mm-yyyy): ");
     String ns=sc.nextLine();
     this.ngaySinh=chuyenStringDate(ns);
     System.out.print("Nhap so chung minh nhan dan: ");
     this.soCMND=sc.nextLine();
 }
 public void hienThongTin()
 {
     System.out.println("Ho va Ten: "+this.hoTen);
     System.out.println("Ngay sinh: "+this.ngaySinh);
     System.out.println("So chung minh nhan dan: "+this.soCMND);
 }
 public Date chuyenStringDate(String str)
 {
     Date ns=null;
     SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
     try
     {
         ns=sdf.parse(str);
     }
     catch(Exception e)
     {
        System.out.println("Loi dinh dang thoi gian.!");
     }
     return ns;
 }
 public String getSoCMND()
  {
      return this.soCMND;
  }
}
