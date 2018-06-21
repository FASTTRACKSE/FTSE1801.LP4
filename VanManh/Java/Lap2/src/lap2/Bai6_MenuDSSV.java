package lap2;

import java.util.Scanner;

public class Bai6_MenuDSSV {
	static String[] tenSV = new String[3];
	static int cssv = 0;
	static double[][] diem = new double[3][3];
	static double[] dtb = new double[3];
	static String[] xl = new String[3];
	static int[] chiSo = { 0, 1, 2, 3 };

	// In ra menu
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		String name;
		double lp1;
		double lp2;
		double lp3;
		int tiep_tuc;
		while (true) {
			System.out.println("------Menu-------");
			System.out.println("Phím 1: Thêm Sinh Viên");
			System.out.println("Phím 2: Hiển thị danh sách sinh viên");
			System.out.println("Phím 3: Sắp xếp danh sách sinh viên theo điểm");
			System.out.println("Phím 4: Kết thúc chương trình");
			System.out.println();
			System.out.print("Nhập lựa chọn : ");
			int mn = sc.nextInt();
			switch (mn) {
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
				} while (tiep_tuc == 1);
				break;
			case 2:
				System.out.println("Danh sách sinh viên");
				hienDS();
				break;
			case 3:
				System.out.println("Danh sách sinh viên đã được sắp xếp");
				sapXep();
				hienDS();
				break;
			case 4:
				System.out.println("Chương trình kết thúc");
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("Nhập sai, mời bạn nhập lại.");
				break;
			}
		}
	}

	// Thêm sinh viên
	public static void themSV(String name, double lp1, double lp2, double lp3) {
		tenSV[cssv] = name;
		diem[cssv][0] = lp1;
		diem[cssv][1] = lp2;
		diem[cssv][2] = lp3;
		cssv++;
		dtb();
	}

	// Tính điểm trung bình
	public static void dtb() {
		for (int i = 0; i < tenSV.length; i++) {
			dtb[i] = (diem[i][0] + diem[i][1] + diem[i][2]) / 3;
		}
		xep_loai(dtb);

	}

	// Xếp loại
	public static void xep_loai(double[] diem) {
		for (int i = 0; i < diem.length; i++) {
			if (diem[i] < 5) {
				xl[i] = "Yếu";
			} else if (diem[i] < 6.5) {
				xl[i] = "Trung bình";
			} else if (diem[i] < 7.5) {
				xl[i] = "Khá";
			} else if (diem[i] < 9) {
				xl[i] = "Giỏi";
			} else {
				xl[i] = "Xuất sắc";
			}
		}
	}

	// Hiển thị danh sách sinh viên
	public static void hienDS() {
		System.out.printf("%-5s %-20s %-6s %-6s %-6s %-6s %-10s", "STT", "Tên", "LP1", "LP2", "LP3", "ĐTB", "Xếp loại");
		for (int i = 0; i < cssv; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-6s %-6s %-6.2f %-10s", i, tenSV[chiSo[i]], diem[chiSo[i]][0],
					diem[chiSo[i]][1], diem[chiSo[i]][2], dtb[chiSo[i]], xl[chiSo[i]]);
		}
		System.out.println();
	}

	// Sáp xếp sinh viên theo điểm trung bình từ thấp đến cao
	public static void sapXep() {
		for (int i = 0; i < tenSV.length - 1; i++) {
			for (int j = 1; j < tenSV.length; j++) {
				if (dtb[chiSo[i]] > dtb[chiSo[j]]) {
					int tam = chiSo[i];
					chiSo[i] = chiSo[j];
					chiSo[j] = tam;

				}
			}
		}
	}

	public static void main(String[] args) {
		menu();

	}
}
