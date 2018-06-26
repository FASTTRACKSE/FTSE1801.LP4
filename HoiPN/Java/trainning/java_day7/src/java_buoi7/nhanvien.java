package java_buoi7;

import java.util.Scanner;

public class nhanvien {
	String Ten;
	int Tuoi;
	String DiaChi;
	String GioiTinh;
	int Luong;
	String CaoThap;
	//Phương thức
	
	nhanvien(){
		Ten = "Vui";
		Tuoi = 20;
		DiaChi = "NA";
		GioiTinh = "Bê đê";
		Luong =  1;
	}
	
	nhanvien(String Ten,int Tuoi,String DiaChi,String GioiTinh,int Luong){
		this.Ten=Ten;
		this.Tuoi=Tuoi;
		this.DiaChi=DiaChi;
		this.GioiTinh=GioiTinh;
		this.Luong=Luong;		
	}
	
	void setTen(String Ten) {
		this.Ten = Ten;
	}
	void setTuoi(int Tuoi) {
		this.Tuoi = Tuoi;
	}
	void setDiaChi(String DiaChi) {
		this.DiaChi=DiaChi;
	}
	void setGioiTinh(String GioiTinh) {
		this.GioiTinh=GioiTinh;
	}
	void setLuong(int Luong) {
		this.Luong = Luong;
	}
	
	String getTen() {
		return Ten;
	}
	int getTuoi() {
		return Tuoi;
	}
	String getDiaChi() {
		return DiaChi;
	}
	String getGioiTinh() {
		return GioiTinh;
	}
	int getLuong() {
		return Luong;
	}
	String CaoThap() {
		if(Luong>10000000) {
			CaoThap = "Cao";
		}else {
			CaoThap = "Thấp";
		}
		return CaoThap;
	}
	public static void main(String[] args) {
		nhanvien nv1 = new nhanvien();	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập tên: ");
		nv1.setTen(sc.nextLine());
		
		System.out.println("Nhập tuổi: ");
		nv1.setTuoi(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Nhập địa chỉ: ");
		nv1.setDiaChi(sc.nextLine());
		
		System.out.println("Nhập giới tính: ");
		nv1.setGioiTinh(sc.nextLine());
		
		System.out.println("Nhập Lương: ");
		nv1.setLuong(sc.nextInt());
		
		System.out.printf("%3s|  %-20s| %10s| %10s| %10s| %10s| %10s| \n","STT","Họ Tên","Tuổi","Địa chỉ","Giới tính","Lương", "Xếp lương");
		System.out.printf("%3s|  %-20s| %10s| %10s| %10s| %10s| %10s| \n","1",nv1.getTen(),nv1.getTuoi(),nv1.getDiaChi(),nv1.getGioiTinh(),nv1.getLuong(),nv1.CaoThap());
		
		nhanvien nv2 = new nhanvien();	
		System.out.printf("%3s|  %-20s| %10s| %10s| %10s| %10s| %10s| \n","2",nv2.getTen(),nv2.getTuoi(),nv2.getDiaChi(),nv2.getGioiTinh(),nv2.getLuong(),nv2.CaoThap());

		nhanvien nv3 = new nhanvien("Buồn", 19, "NA", "Nữ",2);
		System.out.printf("%3s|  %-20s| %10s| %10s| %10s| %10s| %10s| \n","2",nv3.getTen(),nv3.getTuoi(),nv3.getDiaChi(),nv3.getGioiTinh(),nv3.getLuong(),nv3.CaoThap());
		
	}
}
