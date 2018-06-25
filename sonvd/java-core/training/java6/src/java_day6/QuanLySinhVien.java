package java_day6;

import java.util.Scanner;

public class QuanLySinhVien {
	static String[] tenSV = new String[100];
	static int[] tuoiSV = new int[100];
	static double[] diemlp1 = new double[100];
	static double[] diemlp2 = new double[100];
	static double[] diemlp3 = new double[100];
	static double[] dtb = new double[100];
	static String[] xl = new String[100];


	static int cssv=0;
	public static void menu() {
		System.out.println("------Menu-------");
		System.out.println("Phím 1: Thêm Sinh Viên");
		System.out.println("Phím 2: Hiển thị danh sách sinh viên");
		System.out.println("Phím 3: Kết thúc chương trình");
		Scanner sc = new Scanner(System.in);
		int mn = sc.nextInt();
		switch(mn) {
			case 1:System.out.println("Thêm sinh viên");
					themSV();
			break;
			case 2:System.out.println("Danh sách sinh viên");
				    hienDS();
			break;
			case 3:System.out.println("Chương trình kết thúc");break;
		}
	}
	
	public static void themSV() {
		System.out.println("Nhập tên sv:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		tenSV[cssv]=name;
		
		System.out.println("Nhập tuổi sv:");
		Scanner sc1 = new Scanner(System.in);
		int tuoi = sc1.nextInt();
		tuoiSV[cssv]=tuoi;
		
		System.out.println("Nhập điểm LP1:");
		Scanner sc2 = new Scanner(System.in);
		double diem1 = sc2.nextDouble();
		diemlp1[cssv]=(int) diem1;
		System.out.println("Nhập điểm LP2:");
		Scanner sc3 = new Scanner(System.in);
		int diem2 = sc3.nextInt();
		diemlp2[cssv]=diem2;
		System.out.println("Nhập điểm LP3:");
		Scanner sc4 = new Scanner(System.in);
		int diem3 = sc4.nextInt();
		diemlp3[cssv]=diem3;
		DTB();
		xeploai(dtb);
		cssv++;
		
		if(yesNo()==false) {
			themSV();
		}		
	}
	public static double[] DTB() {
		for(int i =0; i<tenSV.length; i++) {
			dtb[i]=(diemlp1[i]+diemlp2[i]+diemlp3[i])/3;
		}
		return dtb;
	}
	public static String[] xeploai(double[] a) {
		for(int i = 0;i<a.length;i++) {
			if(a[i]>8) {
				xl[i] = "Giỏi";
			}else if(a[i]>7) {
				xl[i]="Khá";
			}else if(a[i]>5) {
				xl[i]="TB";
			}else {
				xl[i]="Yếu";
			}
		}
		return xl;

	}
	public static boolean yesNo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Bạn có muốn tiếp tục (0:Không | 1: Có)");
		int mn = sc.nextInt();
		if(mn==0) {
			menu();
			return true;
		}
		return false;
	}
	public static void hienDS() {
		System.out.printf("%3s|  %-20s| %10s| %10s| %10s| %10s| %20s| %10s| \n","STT","Họ Tên","Tuổi","LP1","LP2","LP3","ĐTB","XL");
		for(int i=0;i<cssv;i++) {
			System.out.printf("%3s|  %-20s| %10s| %10s| %10s| %10s| %20s| %10s| \n",i,tenSV[i],tuoiSV[i],diemlp1[i],diemlp2[i],diemlp3[i],dtb[i],xl[i]);
		}
		if(yesNo()==false) {
			hienDS();
		}
	}
	public static void main(String[] args) {
		menu();
	
	}
}
