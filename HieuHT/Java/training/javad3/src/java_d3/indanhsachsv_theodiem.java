package java_d3;

import java.util.Scanner;

public class indanhsachsv_theodiem {
  public static void main(String[]args) {
	 
     
	  SinhVien a[] = new SinhVien[3];
      String ten;
      int tuoi;
      int diem;
      Scanner sc = new Scanner(System.in);
      for(int i = 0 ; i <3 ; i ++){
           a[i] = new SinhVien();
          System.out.println("Moi ban nhap ten sinh vien");
          ten = sc.nextLine();
          a[i].setTen(ten);
          System.out.println("Moi ban nhap tuoi cho sinh vien");
          tuoi = sc.nextInt();
          a[i].setTuoi(tuoi);
          System.out.println("Moi ban nhap diem cho sinh vien");
          diem = sc.nextInt();
          a[i].setDiem(diem);
          sc.nextLine();
      }
      for(int i = 0; i < 3; i ++){
          for(int j = i + 1; j < 3 ; j ++){
              if(a[i].getDiem() < a[j].getDiem()){
                  SinhVien temp = new SinhVien();
                  temp = a[i];
                  a[i] = a[j];
                  a[j] = temp;
              }
          }
      }
      System.out.println("Thong tinh sinh vien sau khi sap xep la : ");
      for(int i = 0; i < 3; i ++){
          System.out.println("Ten cua sinh vien la : " +a[i].getTen());
          System.out.println("Tuoi cua sinh vien la : "+ a[i].getTuoi());
          System.out.println("Diem cua sinh vien la : "+ a[i].getDiem());
      }
  }
}
class SinhVien{
    private String ten;
    private int tuoi;
    private int diem;
    public void setTen ( String ten) {
        this.ten = ten;
    }
    public String getTen(){
        return ten;
    }
    public void setTuoi(int tuoi){
        this.tuoi = tuoi;
    }
    public int getTuoi(){
        return tuoi;
    }
    public void setDiem(int diem){
        this.diem= diem;
    }
    public int getDiem (){
        return diem;
    }
        }