package lap;

import java.util.Scanner;

public class Menu {
	
	public  void menu() {
		int tt, luaChon;
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("/***********************************/");
			System.out.println("1. Nhập danh sách sinh viên.");
			System.out.println("2. Hiển thị danh sách sinh viên  .");
			System.out.println("3. Hiển thị danh sách sinh viên học lực giỏi .");
			System.out.println("4. Sắp xếp danh sách sinh viên theo điểm .");
			System.out.println("5. Kết thúc chương trình .");
			System.out.println("/***********************************/");
			
			System.out.print("Mời bạn nhập lựa chọn : ");
			luaChon = input.nextInt();
			System.out.println();
			switch (luaChon) {
			case 1:
				do {
					MangSinhVien msv = new MangSinhVien();

					input.nextLine();
					System.out.print("Nhập tên SV : ");
					String name = input.nextLine();

					System.out.print("Nhập điểm trung bình : ");
					double gpa = input.nextDouble();

					msv.setName(name);
					msv.setGpa(gpa);
					System.out.println();
					System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
					tt = input.nextInt();
					System.out.println();
				} while (tt == 1);

				break;
			case 2:
				
				
			case 3:
			

			case 4:
				

			case 5:
				input.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}
		}
	}
}
