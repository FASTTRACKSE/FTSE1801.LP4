package java_buoi7;

import java.util.Scanner;

public class DanhSachTuong {
		String tenTuong;
		int chiSoCH;
		int chiSoVo;
		int chiSoTri;
		String kyNang;
		String chuc;
		void settenTuong(String tenTuong) {
			this.tenTuong= tenTuong;
		}
		void setchiSoCH(int chiSoCH) {
			this.chiSoCH= chiSoCH;
		}
		void setchiSoVo(int chiSoVo) {
			this.chiSoVo=chiSoVo;
		}
		void setchiSoTri(int chiSoTri) {
			this.chiSoTri=chiSoTri;
		}
		void setkyNang(String kyNang) {
			this.kyNang= kyNang;
		}
		void setchuc(String chuc) {
			this.chuc =  chuc;
		}
		String gettenTuong() {
			return tenTuong;
		}
		int getchiSoCH() {
			return chiSoCH;
		}
		int getchiSoVo() {
			return chiSoVo;
		}
		int getchiSoTri() {
			return chiSoTri;
		}
		String getkyNang() {
			return kyNang;
		}
		String getchuc() {
			return chuc;
		}
		public static void main(String[] args) {
			DanhSachTuong t1 = new DanhSachTuong();
			Scanner sc=new Scanner(System.in);
			System.out.println("Nhập tên tướng: ");
			t1.settenTuong(sc.nextLine());
			System.out.println("Nhập chỉ số chỉ huy: ");
			t1.setchiSoCH(sc.nextInt());
			System.out.println("Nhập chỉ số võ: ");
			t1.setchiSoVo(sc.nextInt());
			System.out.println("Nhập chỉ số trí: ");
			t1.setchiSoTri(sc.nextInt());
			sc.nextLine();
			System.out.println("Nhập kỹ năng: ");
			t1.setkyNang(sc.nextLine());
			System.out.println("Nhập chức: ");
			t1.setchuc(sc.nextLine());
			System.out.printf("%3s| %-20s| %10s| %10s| %10s| %20s| %10s| \n", "STT","Tên tướng","Chỉ số CH", "Chỉ số võ","Chỉ số trí","Kỹ năng","Chức");
			System.out.printf("%3s| %-20s| %10s| %10s| %10s| %20s| %10s| \n", "1",t1.gettenTuong(),t1.getchiSoCH(), t1.getchiSoVo(),t1.getchiSoTri(),t1.getkyNang(),t1.getchuc());

		}
		

}
