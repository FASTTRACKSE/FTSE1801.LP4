package java_d2;


import java.util.Scanner;

public class lap2bai6 {
	static String[] tenSV = new String[100];
	static int[] tuoiSV= new int[100];
	static double[] diemSV=new double[100];
	static String[] xl=new String[100];
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
		Scanner sc = new Scanner(System.in);	
		System.out.print("Nhập tên sv:");
		String name = sc.nextLine();
		tenSV[cssv]=name;
		System.out.print("Nhập tuổi sv:");
		int year = sc.nextInt();
		tuoiSV[cssv]=year;
		System.out.print("Nhập điểm sv:");
		double point = sc.nextDouble();
		diemSV[cssv]=point;
		cssv++;
		xeploai(diemSV);
		
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
	public static void hienDS() {
		System.out.printf("%5s|%-30s|%5s|%5s|%15s%n","STT","Tên Sinh viên","Tuổi","Điểm","Xếp loại");
		for(int i=0;i<cssv;i++) {
			System.out.printf("%n%5s|%-30s|%5s|%5s|%15s",i+1,tenSV[i],tuoiSV[i],diemSV[i],xl[i]);
		}
		if(yesNo()==false) {
			hienDS();
		}
	}
	public static void main(String[] args) {
		menu();
	
	}
	public static String[] xeploai(double[] diem) {
		for(int i=0;i<tenSV.length;i++) {
			if(diem[i]<5) {
			 xl[i]="Yếu";
			}else if(diem[i]<6.5) {
				xl[i]="Trung bình";
			}else if(diem[i]<8.5) {
				xl[i]="Khá";
			}else if(diem[i]<9) {
				xl[i]="Giỏi";
			}else{
				xl[i]="Xuất sắc";
			}
			
		}return xl;
	}
		

}
