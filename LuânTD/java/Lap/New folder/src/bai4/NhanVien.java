package bai4;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class NhanVien implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String address;
	
	public NhanVien() {
	}
	
	public NhanVien(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String toString(){
		return (name+" "+age+" "+address);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		boolean kiemtra;
		String ten=null;
		String tuoi=null;
		String diaChi=null;
		int age = 0;
		int tieptuc;
		ArrayList<NhanVien> listNhanVien= new ArrayList<NhanVien>();
		Scanner sc = new Scanner(System.in);
		// ho ten
		do {
		do {
			System.out.println("Nhap ten");
			ten = sc.nextLine();
			String patter = "([A-Z][a-z]* )*[A-Z][a-z]*";
			// String patter="([A-Za-z]* )*";
			if (ten.matches(patter)) {
				System.out.println("dung ten roi");
				kiemtra = false;
			} else {
				System.out.println("sai cmnr");
				kiemtra = true;
			}
		} while (kiemtra);

		// ho ten
		do {
			System.out.println("Nhap tuoi");
			tuoi = sc.nextLine();
			String patter = "[1-6]\\d";
			if (tuoi.matches(patter)) {
				System.out.println("dung tuoi roi");
				kiemtra = false;
				age = Integer.parseInt(tuoi);
			} else {
				System.out.println("sai cmnr");
				kiemtra = true;
			}
		} while (kiemtra);
		
		// dia chi
				do {
					System.out.println("Nhap dia chi");
					diaChi = sc.nextLine();
					String patter = "(\\w+ )*\\w+";
					if (diaChi.matches(patter)) {
						System.out.println("dung dia chi roi");
						kiemtra = false;
					} else {
						System.out.println("sai cmnr");
						kiemtra = true;
					}
				} while (kiemtra);
				
				NhanVien nhanVien=new NhanVien(ten,age, diaChi);
				listNhanVien.add(nhanVien);
				System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
				tieptuc = sc.nextInt();
				System.out.println();
				sc.close();
		}while(tieptuc==1);
		//tao doi tuong va lien ket nguon du lieu
		FileOutputStream fos=new FileOutputStream("nhanvien.bin");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		//ghi du lieu vao file
		oos.writeObject(listNhanVien);
		//dong luong du lieu
		oos.close();
		fos.close();
		
		//tao doi tuong va lien ket nguon du lieu
		FileInputStream fis= new FileInputStream("nhanvien.bin");
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList<NhanVien> list= (ArrayList) ois.readObject();
		for(Object x: list) {
			System.out.println(x.toString());
		}
		
		//dong luong du lieu
		ois.close();
		fis.close();
		
		
		
		
	}
	
	
	
	
	
}
