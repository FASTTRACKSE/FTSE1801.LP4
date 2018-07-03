package khachSan;

import java.util.Scanner;

import khach.Khach;

public class KhachSan {
	private int dayStay;
	private String typeRoom;
	private int priceRoom;
	Khach people;
	
	public KhachSan() {
	}
	
	public KhachSan(int dayStay, String typeRoom, int priceRoom, Khach people) {
		this.dayStay = dayStay;
		this.typeRoom = typeRoom;
		this.priceRoom = priceRoom;
		this.people = people;
	}
	/**
	 * Nhap thong tin khach thue phong 
	 * @param sc	scanner
	 */
	public void addInformation(Scanner sc) {
		people=new Khach();
		people.addPeople(sc);
		sc.nextLine();
		System.out.print("Nhap so ngay thue tro: ");
		dayStay=sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap loai phong: ");
		typeRoom=sc.nextLine();
		System.out.println("Nhap gia phong tro: ");
		priceRoom=sc.nextInt();
		
	}
	/**
	 * hien thi thong tin khach thue phong
	 */
	public void showInformation() {
		people.showPeople();
		System.out.println("so ngay thue phong: "+dayStay);
		System.out.println("Loai phong: "+typeRoom);
		System.out.println("Gia phong: "+priceRoom);
	}
	/**
	 * Thanh toan tien thue phong
	 * @return
	 */
	public int bill() {
		return dayStay*priceRoom;
	}
	/**
	 * 
	 * @return
	 */
	public Khach getKhach() {
		return this.people;
	}
	
    public void delete()
    {
        people=new Khach();// xoa thong tin ve Khach
        dayStay=0;
        typeRoom=null;
        priceRoom=0;
    }
}
