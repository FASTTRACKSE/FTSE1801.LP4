package java_day10_TruuTuong;

public class MyClass {
	public static void main(String[] args) {
		CHuNhat cn = new CHuNhat(2,3);
		System.out.println("chu vi la: " +cn.chuVi());
		System.out.println("dien tich la:" +cn.dienTich());
		
		Tron tron =  new Tron();
		tron.setBanKinh(5);
		
		SinhVienFpt svit =  new SinhVienIt("Hợi", "It",2,2,3);
		svit.xuat();
		
		SinhVienFpt svbiz = new SinhVienBiz("Sơn","maketing",4,4);
		svbiz.xuat();
	}
}
