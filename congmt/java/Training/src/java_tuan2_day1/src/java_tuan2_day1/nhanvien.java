package java_tuan2_day1;

import java.util.Scanner;

public class nhanvien {
	//thuộc tính
	String ten;
	int tuoi;
	String diachi;
	String gioitinh;
	double luong;
	String xepluong;
	nhanvien(){
		ten="Mai Thành Công";
		tuoi=25;
		diachi="Đà Nẵng";
		gioitinh="Nam";
		luong=1000000;
		
	}
	nhanvien(String ten,int tuoi, String gioitinh,String diachi, double luong){
		this.ten=ten;
		this.tuoi=tuoi;
		this.diachi=diachi;
		this.gioitinh=gioitinh;
		this.luong=luong;
	}
	
	//Phương thức:
	void setten(String ten) {
		this.ten=ten;
	}
	void settuoi(int tuoi) {
		this.tuoi=tuoi;	
	}
	void setdiachi(String diachi) {
		this.diachi=diachi;
	}
	void setgioitinh(String gioitinh) {
		this.gioitinh=gioitinh;	
	}
	void setluong(double luong) {
		this.luong=luong;
	}
	
	String getten() {
		return ten;
	}
	int gettuoi() {
		return tuoi;
	}
	String getdiachi() {
		return diachi;
	}
	String getgioitinh() {
		return gioitinh;
	}
	double getluong() {
		return luong;
	}
	String xepluong() {
		if(luong>10000000) {
			xepluong="Cao";
		}
		else {
			xepluong="Thấp";
		}
		return xepluong;
	}
	public double getThuNhap() {
		return 12*luong;
	}
	public void xuat() {
		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s|%-15s \n","STT","Họ và tên","Tuổi","Địa chỉ","Giới tính","Lương","Thu nhập","Xếp lương");
		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s|%-15s \n","1." ,getten() , gettuoi(), getdiachi(),getgioitinh(), getluong(),getThuNhap(),xepluong());

	}
	public static void main(String[]args) {
		nhanvien nv1=new nhanvien();
		Scanner sc=new Scanner(System.in);
		//System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s \n","STT","Họ và tên","Tuổi","Địa chỉ","Giới tính","Lương","Xếp lương");
//		nv1.setten("Mai Thành Công");
//		nv1.settuoi(25);
//		nv1.setdiachi("Ngũ Hành Sơn-Đà Nẵng");
//		nv1.setgioitinh("Nam");
//		nv1.setluong(10000000);
//		
//		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s \n","1." ,nv1.getten() , nv1.gettuoi(), nv1.getdiachi(),nv1.getgioitinh(), nv1.getluong(),nv1.xepluong());
//		System.out.println("Nhập tên nhân viên:");
//		String ten= sc.nextLine();
//		nv1.setten(ten);
//		System.out.println("Nhập tuổi nhân viên:");
//		int tuoi=sc.nextInt();
//		nv1.settuoi(tuoi);
//		sc.nextLine();
//		System.out.println("Nhập địa chỉ nhân viên:");
//		String diachi= sc.nextLine();
//		nv1.setdiachi(diachi);
//		System.out.println("Nhập giới tính nhân viên:");
//		String gioitinh= sc.nextLine();
//		nv1.setgioitinh(gioitinh);
//		System.out.println("Nhập lương nhân viên:");
//		double luong= sc.nextDouble();
//		nv1.setluong(luong);
//		
//		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s \n","STT","Họ và tên","Tuổi","Địa chỉ","Giới tính","Lương","Xếp lương");
//		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s \n","1." ,nv1.getten() , nv1.gettuoi(), nv1.getdiachi(),nv1.getgioitinh(), nv1.getluong(),nv1.xepluong());
//		nhanvien nv2=new nhanvien();
//		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s \n","2." ,nv2.getten() , nv2.gettuoi(), nv2.getdiachi(),nv2.getgioitinh(), nv2.getluong(),nv2.xepluong());
//		nhanvien nv3= new nhanvien("công", 25, "nam", "da nang",1000000);
//		System.out.printf("%-3s|%-20s|%-5s|%-30s|%-10s|%-15s|%-15s \n","3." ,nv3.getten() , nv3.gettuoi(), nv3.getdiachi(),nv3.getgioitinh(), nv3.getluong(),nv3.xepluong());
	maytinh mt=new maytinh();
	System.out.println("- Tổng a + b = " + mt.sum(3, 5));
	System.out.println("- Tổng a + b + c = " + mt.sum(3, 5, 6));
	}

	
}
