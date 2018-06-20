package java_day4;

import java.util.Scanner;

public class vidudssv {
	static String[] tenSV = new String[100];
	static Integer[] tuoiSV= new Integer[100];
	static float[] diemlp1= new float[100];
	static float[] diemlp2= new float[100];
	static float[] diemlp3= new float[100];
	static float[] diemTB= new float[100];
	static String[] xeploai= new String[100];
	
	static int cssv=0;
	public static void menu() {
		System.out.println("------Menu-------");
		System.out.println("Phần 1: Thêm sinh viên");
		System.out.println("Phần 2: Hiển thị danh sách sinh viên");
		System.out.println("Phần 3: Kết thúc chương trình");
		Scanner sc = new Scanner(System.in);
		int mn = sc.nextInt();
		switch(mn) {
			case 1:System.out.println("Thêm sinh viên");
					themSV();
			break;
			case 2:System.out.println("Danh sách sinh viên");
				    hienDS();
			break;
			case 3:System.out.println("Chương trình kết thúc!!");break;
		}
	}
	
	public static void themSV() {
		System.out.println("Nhập tên sinh viên:");
	
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		tenSV[cssv]=name;
		System.out.println("Nhập tuổi sinh viên:");
		Scanner sc1 = new Scanner(System.in);
		Integer tuoi=sc1.nextInt();
		tuoiSV[cssv]=tuoi;
		System.out.println("Nhập điểm LP1:");
		Scanner sc11 = new Scanner(System.in);
		Integer diem1=sc11.nextInt();
		diemlp1[cssv]=diem1;
		System.out.println("Nhập điểm LP2:");
		Scanner sc111 = new Scanner(System.in);
		Integer diem2=sc111.nextInt();
		diemlp2[cssv]=diem2;
		System.out.println("Nhập điểm LP3:");
		Scanner sc1111 = new Scanner(System.in);
		Integer diem3=sc1111.nextInt();
		diemlp3[cssv]=diem3;
		diemTB();
		xeploai(diemTB);
		cssv++;
		if(yesNo()==false) {
			themSV();
		}
		
	}
	public static boolean yesNo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Bạn có muốn tiếp tục : (0:Không | 1: Có)");
		int mn = sc.nextInt();
		if(mn==0) {
			menu();
			return true;
		}
		return false;
	}
	public static void hienDS() {
		System.out.printf("%-3s| %-20s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s| \n","STT","Họ và tên","Tuổi","ĐiểmLp1","ĐiểmLP2","ĐiểmLp3","ĐiêmTB","Xếp loại");
		for(int i=0;i<cssv;i++) {
			System.out.printf("%-3s| %-20s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s| \n",(i+1),tenSV[i] ,tuoiSV[i] , diemlp1[i],diemlp2[i],diemlp3[i],diemTB[i], xeploai[i]);
			
		}
		
		if(yesNo()==false) {
			hienDS();
		}
	}
	public static void main(String[] args) {
		menu();
	
	}
	public static float[] diemTB() {
		for(int i=0;i<tenSV.length;i++) {
		diemTB[i]= (diemlp1[i] + diemlp2[i] + diemlp3[i])/3;
		}
		return diemTB;
	}
	public static String[] xeploai(float[]diemTB) {
		for (int i = 0; i < diemTB.length; i++) {

				if(diemTB[i] <5){
					xeploai[i]= " Yếu";

				}
				else if(diemTB[i]<7){
					xeploai[i]= "Trung bình";
				}
				else if(diemTB[i]<7.5){
					xeploai[i] = "Khá";
				}
				else if(diemTB[i]<9){
					xeploai[i] = "Giỏi";
				}
				else {xeploai[i] = "Xuất sắc";}

		}
		return xeploai;
	}
}
