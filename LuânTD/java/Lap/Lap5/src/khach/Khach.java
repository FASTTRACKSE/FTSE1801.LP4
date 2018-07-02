package khach;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Khach {
	private String name;
	private Date birthDay;
	private String idCMND;
	
	public Khach() {}
	
	public String getIdCMND() {
		return idCMND;
	}

	public Khach(String name, Date birthDay, String idCMND) {
		super();
		this.name = name;
		this.birthDay = birthDay;
		this.idCMND = idCMND;
	}
	/**
	 * chuyen kieu String thanh Date
	 * @param str String
	 * @return
	 */
	public Date chuyenStringDate(String str) {
		Date ns=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			ns=sdf.parse(str);
		}catch (Exception e) {
			System.out.println("loi dinh dang thoi gian");
		}
		return ns;
	}
	/**
	 * them thong tin khach
	 * @param sc scanner
	 */
	public void addPeople(Scanner sc) {
		System.out.print("Nhap ho ten: ");
		this.name=sc.nextLine();
		sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		String ns=sc.nextLine();
		this.birthDay=chuyenStringDate(ns);
		System.out.println("Nhap so CMND: ");
		this.idCMND=sc.nextLine();
	}
	/**
	 * hien thong tin khach
	 */
	public void showPeople() {
		System.out.println("Ho va ten: "+this.name);
		System.out.println("Ngay sinh: "+this.birthDay);
		System.out.println("So CMND: "+this.idCMND);
	}
	
	
	
	
	

}
