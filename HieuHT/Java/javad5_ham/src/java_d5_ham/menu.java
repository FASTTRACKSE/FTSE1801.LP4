package java_d5_ham;

import java.util.Scanner;

public class menu {
	static String[] tenSV = new String[100];
	static int cssv=0;
	static int[] tuoiSv = new int[2];
	static double[][] diemSv = new double[3][3];
	static double[] diemTB = new double[3];
	static String[] xeploaiSv = new String[100];
	
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
		System.out.println("Nhập tuoi sv:");
		int tuoi = sc.nextInt();
		tuoiSv[cssv]=tuoi;
		System.out.println("nhập điểm sv:");
		System.out.println("LP0");
		double LP0 = sc.nextInt();
		diemSv[cssv][0]=LP0;
		System.out.println("LP1");
		double LP1 = sc.nextInt();
		diemSv[cssv][1]=LP1;
		System.out.println("LP2");
		double LP2 = sc.nextInt();
		diemSv[cssv][2]=LP2;
		diemTB();
		xeploaiSv(diemTB());
		cssv++;
		if(yesNo()==false) {
			themSV();
		}
		
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
	public static double[] diemTB() {
		for(int i=0;i<tenSV.length;i++) {
			diemTB[i]=(diemSv[i][1]+diemSv[i][2]+diemSv[i][3])/3;
		}
		return diemTB;
	}
	public static String[] xeploaiSv(double[]diemTB) {
		 for(int i=0;i<tenSV.length;i++) {
			
			   if(diemTB[i]<5) {
				   xeploaiSv[i]="yếu";
			   }else if(diemTB[i]<6.5) {
				   xeploaiSv[i]="trung bình";
			   }else if(diemTB[i]<7.5) {
				   xeploaiSv[i]="khá";
			   }else if(diemTB[i]<9) {
				   xeploaiSv[i]="giỏi";
			   }else {
				   xeploaiSv[i]="xuất sắc";
			   }
		   }
		 return xeploaiSv;
	}
	
	public static void hienDS() {
		for(int i=0;i<cssv;i++) {
			System.out.println(tenSV[i]+"\n"+ tuoiSv[i]+"\n"+diemSv[i][0]+"\n"+diemSv[i][1]+"\n"+diemSv[i][2]+"\n"+diemTB[i]+xeploaiSv[i]);
		}
		if(yesNo()==false) {
			hienDS();
		}
	}
	public static void main(String[] args) {
		menu();
	
	}
	
}
