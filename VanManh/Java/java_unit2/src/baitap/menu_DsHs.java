package baitap;
/*
 * Vũ Văn Mạnh
 * 
 * Danh sách sinh viên
 */
import java.util.Scanner;

public class menu_DsHs {
	static String[] tenSV = new String[3];
	static int cssv=0;
	static double[][] diem = new double[3][3];
	static double[] dtb = new double[3];
	static String[] xl = new String[3];
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		String name;
		double lp1;
		double lp2;
		double lp3;
		int tiep_tuc;
		
		System.out.println("------Menu-------");
		System.out.println("Phím 1: Thêm Sinh Viên");
		System.out.println("Phím 2: Hiển thị danh sách sinh viên");
		System.out.println("Phím 3: Kết thúc chương trình");
		int mn = sc.nextInt();
		switch(mn) {
			case 1:
				do {
					System.out.print("Tên sinh viên : ");
					name = sc.next();
					System.out.print("Điểm lp1 : ");
					lp1 = sc.nextDouble();
					System.out.print("Điểm lp2 : ");
					lp2 = sc.nextDouble();
					System.out.print("Điểm lp3 : ");
					lp3 = sc.nextDouble();
					themSV(name, lp1, lp2, lp3);
					System.out.println("Bạn có muốn nhập tiếp không (0:Không | 1:Có)");
					tiep_tuc = sc.nextInt();
				}while(tiep_tuc==1);
				menu();//Tạo 1 hàm menu riêng.
				break;
			case 2:System.out.println("Danh sách sinh viên");
				    hienDS();
				    System.out.println();
				    System.out.println();
				    System.out.println("Bạn có muốn tiếp tục không (0:Không | 1:Có)");
				    tiep_tuc = sc.nextInt();
				    if(tiep_tuc==1) {
				    System.out.println();
				    System.out.println();
				    System.out.println();
				    menu();
				    }else {
				    	System.out.println("Chương trình kết thúc!!!");
				    	System.exit(0);
				    }
			break;
			case 3:
				sc.close();
				System.out.println("Chương trình kết thúc");break;
			default:
				System.out.println("Nhập sai, mời bạn nhập lại.");
				break;
		}
	}
	
	public static void themSV(String name, double lp1, double lp2, double lp3) {
		tenSV[cssv]=name;
		diem[cssv][0] = lp1;
		diem[cssv][1] = lp2;
		diem[cssv][2] = lp3;
		cssv++;
		dtb();
	}
	
	
	public static double[] dtb() {
		for(int i=0;i<tenSV.length;i++) {
			dtb[i] = (diem[i][0] + diem[i][1] + diem[i][2])/3;
		}
		xep_loai(dtb);
		return dtb;
	}
	
	public static String[] xep_loai(double[] diem) {
		for(int i = 0; i<diem.length;i++) {
			if(diem[i]<5) {
				xl[i] = "Yếu";
			}else if(diem[i]<6.5) {
				xl[i] = "Trung bình";
			}else if(diem[i]<7.5) {
				xl[i] = "Khá";
			}else if(diem[i]<9) {
				xl[i] = "Giỏi";
			}else {
				xl[i] = "Xuất sắc";
			}
		}
		return xl;
	}
	
	public static void hienDS() {
		System.out.printf("%-5s %-20s %-6s %-6s %-6s %-6s %-10s","STT", "Tên", "LP1", "LP2" ,"LP3","ĐTB","Xếp loại" );
		for(int i=0;i<cssv;i++) {
			System.out.printf("\n %-4s %-20s %-6s %-6s %-6s %-6.2f %-10s",i,tenSV[i],diem[i][0],diem[i][1],diem[i][2],dtb[i],xl[i] );
		}
	}
	

	public static void main(String[] args) {
		menu();
	
	}
}
