

public class QuanLySinhVien {
	private SinhVien2[] listSv;
	private static int soLuongSv;
	
	public QuanLySinhVien() {
		listSv = new SinhVien2[100];
		soLuongSv = 0;
	}
	
	public void addSv(SinhVien2 sv) {
		listSv[soLuongSv] = sv;
		soLuongSv += 1;
	}
	
	public void updateSv(String id) {
		for (int i=0; i<soLuongSv; i++) {
			if(listSv[i].getId().equals(id)) {
				listSv[i].setId("ftse5");
				break;
			}
		}
	}
	
	public void deleteSv(String id) {
		for (int i=0; i<listSv.length-1; i++) {
			if(listSv[i].getId().equals(id)) {
				for (int j=i; j<listSv.length-1; j++) {
					listSv[j] = listSv[j+1];
				}
			}
		}
		listSv[listSv.length-1] = null;
		soLuongSv -=1;
	}
	public void displayAllsv() {
		for (int i=0; i<soLuongSv; i++) {
			System.out.format("%-7s|%-20s|%-7s|%-12s|%-7s|%n", listSv[i].getId(), listSv[i].getName(), listSv[i].getAge(), listSv[i].getAddress(), listSv[i].getGpa());
		}
	}
	
	public static void main(String[] args) {
		QuanLySinhVien qlsv = new QuanLySinhVien();
		SinhVien2 sv = new SinhVien2("ftse1", "Hưng", 28, "Đà Nẵng", 7);
		qlsv.addSv(sv);
		sv = new SinhVien2("ftse2", "Phuong", 22, "Đà Nẵng", 7);
		qlsv.addSv(sv);
		sv = new SinhVien2("ftse3", "Hieu", 22, "Quảng Nam", 7);
		qlsv.addSv(sv);
		qlsv.displayAllsv();
		qlsv.updateSv("ftse3");
		System.out.println(soLuongSv);
		qlsv.displayAllsv();
		qlsv.deleteSv("ftse1");
		qlsv.displayAllsv();
		
	}
}
