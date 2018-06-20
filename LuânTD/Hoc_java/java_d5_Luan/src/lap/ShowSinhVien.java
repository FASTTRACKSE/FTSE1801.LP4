package lap;

public class ShowSinhVien extends MangSinhVien {
	public void show() {
		System.out.printf("%-5s %-20s %-6s %-20s %-6s", "ID", "Tên", "Tuổi", "Địa chỉ", "ĐTB");
		System.out.println();
		for (int i = 0; i < listSinhVien.length; i++) {
			System.out.printf("\n %-4s %-20s %-6s %-20s %-6.2f", (i + 1), listSinhVien[i].getName(),listSinhVien[i].getGpa());
		}
		System.out.println();
		System.out.println();
	}

}
