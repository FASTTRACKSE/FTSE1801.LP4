package lap5;

import java.util.Scanner;
import java.util.Date;
public class KhachSan {
    private int soNgaytro;
    private String loaiP;
    private double giaP;
    Nguoi nguoi;
    
    public KhachSan()
    {
        
    }
    public KhachSan(int soNgaytro, String loaiP,double giaP, Nguoi nguoi)
    {
        this.soNgaytro=soNgaytro;
        this.loaiP=loaiP;
        this.giaP=giaP;
        this.nguoi=nguoi;
    }
    
    public void nhapThongTin(Scanner sc)
    {
        nguoi=new Nguoi();
        this.nguoi.nhapThongTin(sc);
        System.out.print("Nhap so ngay tro: ");
        this.soNgaytro=sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap loai phong tro: ");
        this.loaiP=sc.nextLine();
        System.out.print("Nhap gia phong: ");
        this.giaP=sc.nextDouble();sc.nextLine();
    }
    public void hienThongTin()
    {
        nguoi.hienThongTin();
        System.out.println("So ngay tro: "+this.soNgaytro);
        System.out.println("Loai phong: "+this.loaiP);
        System.out.println("Gia phong: "+this.giaP);
    }
    public double thanhTien()
    {
        return this.soNgaytro*this.giaP;
    }
    
    public Nguoi getKhach()
    {
        return this.nguoi;
    }
    public void xoa()
    {
        this.nguoi=new Nguoi();// xoa thong tin ve nguoi
        this.soNgaytro=0;
        this.loaiP=null;
        this.giaP=0;
    }
}
