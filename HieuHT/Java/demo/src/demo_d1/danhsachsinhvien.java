package demo_d1;

import java.util.Scanner;

public class danhsachsinhvien {
	static String[] tenSV = new String[100];
	static int[] diemSV = new int[2];
	static String[] xlSV = new String[20];
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
		System.out.println("Nhập �?iểm sv:");
		int diem = sc.nextInt();
		diemSV[cssv]=diem;
		System.out.println("Nhập xếp loại sv:");
		sc.nextLine();
		String xl=sc.nextLine();
		xlSV[cssv]=xl;
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
	public static void hienDS() {
		System.out.printf("%-25s| %6s| %8s| \n", "H�? Và Tên","�?iểmTB","Xếp loại");
		for(int i=0;i<cssv;i++) {
			System.out.printf("%-25s| %6s| %8s| \n",tenSV[i],diemSV[i],xlSV[i]);
		}
		if(yesNo()==false) {
			hienDS();
		}
	}
	public static void main(String[] args) {
		menu();
	
	}
}