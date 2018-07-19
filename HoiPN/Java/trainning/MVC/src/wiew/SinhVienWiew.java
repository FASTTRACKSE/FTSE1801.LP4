package wiew;

import java.util.Scanner;

public class SinhVienWiew {
	Scanner sc = new Scanner(System.in);
	
	public String menu() {
		System.out.println("1. Thêm sinh viên mới.");
		System.out.println("2. Sửa điểm sinh viên.");
		System.out.println("3. Sưả thông tin sinh viên theo mã sinh viên.");
		System.out.println("4. Xóa sinh viên theo mã.");
		System.out.println("5. xóa điểm sinh viên theo mã môn học.");
		System.out.println("6. Hiển thi tất cả sinh viên.");
		System.out.println("7. Hiển thị sinh viên theo tên.");
		System.out.println("0. Kết thúc chương trình.");
		
		return sc.nextLine();
	}
}
