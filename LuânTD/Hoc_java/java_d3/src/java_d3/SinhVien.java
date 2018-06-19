package java_d3;

import java.util.Scanner;

public class SinhVien {
	
	String hoTen;
	double diemTB;
	String xepLoai;
	
	SinhVien(String hoten, double diemTB){
		this.hoTen=hoten;
		this.diemTB=diemTB;
		this.xepLoai=xepLoai;
	}
	
	void setHoTen(String hoTen){
		this.hoTen=hoTen;
	}
	
	void setDiemTB(double diemTB){
		this.diemTB=diemTB;
	}
	
	
	String getHoTen() {
		return hoTen;
	}
	double getDiemTB() {
		return diemTB;
	}
	
	
	
	String xepLoai(double diemTB) {
		if(diemTB<5) {
			xepLoai = "Yeu";
		}else if(diemTB<6.5) {
			xepLoai= "Trung Binh";
		}else if(diemTB<7.5) {
			xepLoai="Kha";
		}else if(diemTB<8.5) {
			xepLoai="gioi";
		}else {
			xepLoai="xuat sac";
		}
		
		return xepLoai;
	}
	
	public static void main(String[] args) {
		String name;
		double point;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("add name: ");
		name=sc.nextLine();
		System.out.print("add point: ");
		point=sc.nextDouble();
		sc.close();
		
		SinhVien sv=new SinhVien("Luan",7);
		
		SinhVien sv1= new SinhVien(name, point);
		sv1.setHoTen(name);
		sv1.setDiemTB(point);
		
		System.out.println(sv.getHoTen()+"|"+sv.getDiemTB()+"|"+sv.xepLoai(point));
		System.out.println(sv1.getHoTen()+"|"+sv1.getDiemTB()+"|"+sv1.xepLoai(sv1.getDiemTB()));
		
		
	}
	

}
