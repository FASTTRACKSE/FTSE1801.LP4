import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Danh sách quản lý sinh viên (ArrayList)
 * @author Admin Phạm Ngọc Hợi
 *
 */
public class QlSinhVien {
	
	private ArrayList<SinhVien> listSV;

	public QlSinhVien() {
		listSV = new ArrayList<SinhVien>();
	}
	
	private boolean isExistSinhVien(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void menu() {
		int tt, so;
		QlSinhVien quanLy = new QlSinhVien();
		while (true) {
			System.out.println("/****************************************/");
			System.out.println("1.Thêm sinh viên.");
			System.out.println("2.Cập nhật thông tin sinh viên theo ID.");
			System.out.println("3.Xóa sinh viên theo ID.");
			System.out.println("4.Sắp xếp sinh viên theo tên.");
			System.out.println("5.Hiển thị danh sách sinh viên");
			System.out.println("0.Kết thúc chương trình.");
			System.out.println("/****************************************/");
			System.out.println("Lựa chọn của bạn: ");
			Scanner sc = new Scanner(System.in);
			so = sc.nextInt();
			System.out.println();
			switch (so) {
			case 1:
				do {
					int id = 0;
					boolean check = false;
					String stt = sc.nextLine();
					do {
						check = false;
						try {
							System.out.println("Nhập id: ");
							stt = sc.nextLine();
							if(stt.isEmpty() == true) 
								throw new Exception("Id không được để trống");
							
							id = Integer.parseInt(stt);
							
							if(quanLy.isExistSinhVien(id)) {
								check = true;
								throw new Exception("Id đã tồn tại.");
							}else {
								System.out.println("Có thể sử dụng Id này.");
							}
						}catch(NumberFormatException er) {
							System.out.println("Vui lòng nhập số.");
						}catch(Exception e) {
							check = true;
							System.out.println(e.getMessage());
						}
						
					}while(check);
					
					sc.nextLine();
					
					String name=null;
					do {
						check = false;
						try {
							System.out.println("Nhập họ tên: ");
							name = sc.nextLine();
							if(name.isEmpty()) {
								throw new Exception("Tên không được để trống");
							}
							else {
								for(int i=0;i<name.length();i++) {	
									if(!Character.isLetter(name.charAt(i)) && !Character.isWhitespace(name.charAt(i))) {
										throw new Exception("Tên chỉ được nhập chữ và khoảng trắng.");
									}
									
								}
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
							check = true;
						}
					}while(check);
					
					int age = 0;
					String tuoi = sc.nextLine();
					do {
						check = false;
						try {
							System.out.println("Nhập tuổi: ");
							tuoi = sc.nextLine();
							if(tuoi.isEmpty() == true) 
								throw new Exception("Tuổi không được để trống");
							
							age = Integer.parseInt(tuoi);
							
							if(age<0 || age>100) {
								throw new Exception("Tuổi không đúng");
							}
						}catch(NumberFormatException er) {
							System.out.println("Vui lòng nhập số.");
							check = true;
						}catch(Exception e) {
							System.out.println(e.getMessage());
							check = true;
						}
						
					}while(check);
					
					sc.nextLine();
					
					String address=null;
					do {
						check = false;
						try {
							System.out.println("Nhập địa chỉ: ");
							address = sc.nextLine();
							if(address.isEmpty()) {
								throw new Exception("Địa chỉ không được để trống");
							}
							else {
								for(int i=0;i<address.length();i++) {	
									if(!Character.isLetter(address.charAt(i)) && !Character.isWhitespace(address.charAt(i))) {
										throw new Exception("Địa chỉ chỉ được nhập chữ và khoảng trắng.");
									}
									
								}
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
							check = true;
						}
					}while(check);
					
					double gpa = 0;
					String diem = sc.nextLine();
					do {
						check = false;
						try {
							System.out.println("Nhập điểm: ");
							diem = sc.nextLine();
							if(diem.isEmpty() == true) 
								throw new Exception("Điểm không được để trống");
							
							gpa = Double.parseDouble(diem);
							
							if(gpa<0 || gpa>10) {
								throw new Exception("Điểm không đúng");
							}
						}catch(NumberFormatException er) {
							System.out.println("Vui lòng nhập số.");
							check = true;
						}catch(Exception e) {
							System.out.println(e.getMessage());
							check = true;
						}
						
					}while(check);
					
					SinhVien sinhVien = new SinhVien();
					sinhVien.setId(id);
					sinhVien.setName(name);
					sinhVien.setAge(age);
					sinhVien.setAddress(address);
					sinhVien.setGpa(gpa);
					quanLy.addSV(sinhVien);
					
					System.out.println();
					System.out.println("Bạn muốn tiếp tục 0 - không | 1 - có");
					tt = sc.nextInt();
					System.out.println();
				} while (tt == 1);
				break;
			case 2:
				System.out.println("Nhập id cần sửa: ");
				int idUpdate = sc.nextInt();			
				quanLy.updateSV(idUpdate);
				break;
			case 3:
				System.out.println("Nhập id cần xóa:  ");
				int idDelete = sc.nextInt();		
				quanLy.deleteSV(idDelete);
				break;
			case 4:
				quanLy.sortSV();
			case 5:
				
				quanLy.showSV();
			}
		}
	}

	public void addSV(SinhVien sinhvien) {
		listSV.add(sinhvien);
	}

	public void updateSV(int id) {
		SinhVien update = new SinhVien();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getId() == id) {
				sc.nextLine();
				System.out.println("nhập họ tên: ");
				String name = sc.nextLine();
				listSV.get(i).setName(name);
				System.out.println("Nhập tuổi: ");
			 	int age = sc.nextInt();
			 	listSV.get(i).setAge(age);
				sc.nextLine();
				System.out.println("Nhập địa chỉ: ");
				String address = sc.nextLine();
				listSV.get(i).setAddress(address);
				System.out.println("Nhập điểm: ");
				double gpa = sc.nextDouble(); 
				listSV.get(i).setGpa(gpa);

				update.setName(name);
				update.setAge(age);
				update.setAddress(address);
				update.setGpa(gpa);
			}
		}
	}

	public void deleteSV(int idDelete) {
		for (int i = 0; i < listSV.size(); i++) {
			if (listSV.get(i).getId() == idDelete) {
				listSV.remove(idDelete);
				break;
			}
		}

	}

	public void sortSV() {
		Collections.sort(listSV, new Comparator<SinhVien>() {
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	public void showSV() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (SinhVien sinhVien: listSV) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", sinhVien.getId(), sinhVien.getName(),
					sinhVien.getAge(),sinhVien.getAddress(),sinhVien.getGpa());
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		QlSinhVien ql = new QlSinhVien();
		ql.menu();
	}
}
