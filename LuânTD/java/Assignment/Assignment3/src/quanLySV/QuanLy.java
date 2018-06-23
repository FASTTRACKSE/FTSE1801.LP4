package quanLySV;

import java.util.Scanner;

import sinhVien.SinhVien;

public class QuanLy {
	// danh sach sinh vien
		private SinhVien[] listSinhVien;
		public static int id;
		
		public QuanLy() {
			listSinhVien =new SinhVien[100];
			id = 0;
		}
		
		//sắp xếp sinh viên theo tuổi
			public void SortSV() {
				SinhVien SortSv=new SinhVien();
				for(int i=0; i<id-1;i++) {
					for(int j=1; j<id; j++) {
						if(listSinhVien[i].getGpa()>listSinhVien[j].getGpa()) {
							SortSv=listSinhVien[i];
							listSinhVien[i]=listSinhVien[j];
							listSinhVien[j]=SortSv;
						}
					}
				}
				
			}

			//mang sinh vien
			public void addSV(SinhVien sinhVien) {
				listSinhVien[id] = sinhVien;
				id++;
			}

			//xóa sinh vien theo id
			public void deleteSV(int idDelete) {
				for (int i = idDelete; i < id; i++) {
					listSinhVien[i - 1] = listSinhVien[i];
				}
				id = id - 1;
			}

			//hiển thị sinh vien 
			public void show() {
				System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
				System.out.println();
				for (int i = 0; i < id; i++) {
					System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSinhVien[i].getName(),
							listSinhVien[i].getAge(), listSinhVien[i].getAddress(), listSinhVien[i].getGpa());
				}
				System.out.println();
				System.out.println();
			}

			//cập nhật sinh viên
			public void repairSV(Scanner input, String ten) {
				for(int i=0; i<id;i++) {
				if(listSinhVien[i].getName().equals(ten)) {
				System.out.print("Nhập tên SV : ");
				String name = input.nextLine();

				System.out.print("Nhập tuổi : ");
				int age = input.nextInt();

				input.nextLine();
				System.out.print("Nhập địa chỉ : ");
				String address = input.nextLine();

				System.out.print("Nhập điểm trung bình : ");
				double gpa = input.nextDouble();

				listSinhVien[i].setName(name);
				listSinhVien[i].setAge(age);
				listSinhVien[i].setAddress(address);
				listSinhVien[i].setGpa(gpa);
				break;
				}
				System.out.println("tên bạn nhập không có trong danh sách");
				System.out.println();
				}
				
			}

			// menu
			public static void main(String[] args) {
				

				int tiepTuc, luaChon;
				QuanLy quanly = new QuanLy();
				while (true) {
					Scanner input = new Scanner(System.in);
					System.out.println("/***********************************/");
					System.out.println("1. Thêm sinh viên.");
					System.out.println("2. Cập nhật thông tin sinh viên theo ID.");
					System.out.println("3. Xóa sinh viên theo ID  .");
					System.out.println("4. Sắp sếp sinh viên theo điểm .");
					System.out.println("5. Hiển thị danh sách sinh viên .");
					System.out.println("0. Kết thúc chương trình .");
					System.out.println("/***********************************/");

					System.out.print("Mời bạn nhập lựa chọn : ");
					luaChon = input.nextInt();
					System.out.println();
					switch (luaChon) {
					case 1:
						do {
							SinhVien msv = new SinhVien();

							input.nextLine();
							System.out.print("Nhập tên SV : ");
							String name = input.nextLine();

							System.out.print("Nhập tuổi : ");
							int age = input.nextInt();

							input.nextLine();
							System.out.print("Nhập địa chỉ : ");
							String address = input.nextLine();

							System.out.print("Nhập điểm trung bình : ");
							double gpa = input.nextDouble();

							msv.setName(name);
							msv.setAge(age);
							msv.setAddress(address);
							msv.setGpa(gpa);
							quanly.addSV(msv);
							System.out.println();
							System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
							tiepTuc = input.nextInt();
							System.out.println();
						} while (tiepTuc == 1);

						break;
					case 2:
						System.out.println();
						System.out.print("Nhập tên cần sửa : ");
						input.nextLine();
						String name = input.nextLine();
						System.out.println();
						
						quanly.repairSV(input, name);
						break;

					case 3:
						System.out.println();
						System.out.print("Nhập ID cần xóa : ");
						System.out.println();
						int idDelete = input.nextInt();
						
						quanly.deleteSV(idDelete);
						break;

					case 4:
						
						quanly.SortSV();
						quanly.show();
						break;
						
					case 5:
						
						quanly.show();
						break;

					case 0:
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
