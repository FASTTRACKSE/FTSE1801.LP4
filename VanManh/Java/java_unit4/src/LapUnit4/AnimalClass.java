package LapUnit4;

import java.util.Scanner;

public class AnimalClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap ten nhện: ");
		String name=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak=sc.nextLine();
		System.out.println();
		
		Nhen nhen=new Nhen();
		nhen.setTen(name);
		nhen.setSoChan(foot);
		nhen.setSoMat(eyes);
		nhen.setTiengKeu(speak);
		nhen.in();
		sc.nextLine();
		
		System.out.print("Nhap ten cua: ");
		String name1=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot1=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes1=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak1=sc.nextLine();
		System.out.print("Nhap so càng: ");
		int cang=sc.nextInt();
		System.out.println();
		
		
		Cua cua=new Cua();
		cua.setTen(name1);
		cua.setSoChan(foot1);
		cua.setSoMat(eyes1);
		cua.setTiengKeu(speak1);
		cua.setSoCang(cang);
		cua.in();
		sc.nextLine();
		
		System.out.print("Nhap ten cá: ");
		String name2=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot2=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes2=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak2=sc.nextLine();
		System.out.print("Nhap so vây: ");
		int vay=sc.nextInt();
		System.out.println();
		
		
		Ca ca=new Ca();
		ca.setTen(name2);
		ca.setSoChan(foot2);
		ca.setSoMat(eyes2);
		ca.setTiengKeu(speak2);
		ca.setSoVay(vay);
		ca.in();
		sc.nextLine();
		
		System.out.print("Nhap ten mèo: ");
		String name3=sc.nextLine();
		System.out.print("Nhap so chan: ");
		int foot3=sc.nextInt();
		System.out.print("Nhap so mat: ");
		int eyes3=sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap tieng keu: ");
		String speak3=sc.nextLine();
		System.out.print("Nhap so vây: ");
		int rau=sc.nextInt();
		System.out.println();
		
		
		Meo meo=new Meo();
		meo.setTen(name3);
		meo.setSoChan(foot3);
		meo.setSoMat(eyes3);
		meo.setTiengKeu(speak3);
		meo.setSoRau(rau);
		meo.in();
		sc.nextLine();
	}
}
