package baiHoc;

import java.util.Scanner;

public class AniClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap ten dong vat: ");
		String name=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak=sc.nextLine();
		
		
		Nhen n=new Nhen();
		n.setTen(name);
		n.setSoChan(foot);
		n.setSoMat(eyes);
		n.setTiengKeu(speak);
		n.in();
		sc.nextLine();
		
		System.out.print("Nhap ten dong vat: ");
		String name1=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot1=sc.nextInt();
		System.out.print("Nhap so cang: ");
		int cang=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes1=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak1=sc.nextLine();
		
		Cua c= new Cua();
		c.setTen(name1);
		c.setSoChan(foot1);
		c.setSoCang(cang);
		c.setSoMat(eyes1);
		c.setTiengKeu(speak1);
		System.out.printf(c.getTen()+" | "+c.getSoChan()+" | "+c.getSoCang()+" | "+c.getSoMat()+" | "+c.getTiengKeu());
		System.out.println();
		sc.nextLine();
		
		System.out.print("Nhap ten dong vat: ");
		String name2=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot2=sc.nextInt();
		System.out.print("Nhap so vay: ");
		int vay=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes2=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak2=sc.nextLine();
		
		Ca ca= new Ca();
		ca.setTen(name2);
		ca.setSoChan(foot2);
		ca.setSoVay(vay);
		ca.setSoMat(eyes2);
		ca.setTiengKeu(speak2);
		System.out.printf(ca.getTen()+" | "+ca.getSoChan()+" | "+ca.getSoVay()+" | "+ca.getSoMat()+" | "+ca.getTiengKeu());
		System.out.println();
		sc.nextLine();
		
		System.out.print("Nhap ten dong vat: ");
		String name3=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot3=sc.nextInt();
		System.out.print("Nhap so rau: ");
		int rau=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes3=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak3=sc.nextLine();
		
		Meo m= new Meo();
		m.setTen(name3);
		m.setSoChan(foot3);
		m.setSoRau(rau);
		m.setSoMat(eyes3);
		m.setTiengKeu(speak3);
		System.out.printf(m.getTen()+" | "+m.getSoChan()+" | "+m.getSoRau()+" | "+m.getSoMat()+" | "+m.getTiengKeu());
		System.out.println();
		
		
		
		sc.close();
	}
}
