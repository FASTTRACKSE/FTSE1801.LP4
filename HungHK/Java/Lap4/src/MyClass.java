

import java.util.Scanner;

public class MyClass {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		SanPham sp1 = new SanPham("tivi", 10);
//		addSp(sp1);
//		SanPham sp2 = new SanPham("điện thoại ", 6);
//		addSp(sp2);
//		showListSp();
//		scanner.close();
		
		ChuNhat cn = new ChuNhat(7,5);
		cn.xuat();
		ChuNhat v = new Vuong(6);
		v.xuat();
		
//		DongVat dv = new DongVat("Gà", 2, 2, "ò ó o");
//		dv.in();
//		Meo m = new Meo("Mèo", 4, 2, "meo meo", 12);
//		m.in();
		
//		Tron t = new Tron(10);
//		t.xuat();
		
//		DongVat2 cho = new Cho();
//		DongVat2 meo = new Meo2();
//		DongVat2 vit = new Vit();
//		cho.speak();
//		meo.speak();
//		vit.speak();
		
		SinhVienIT sv = new SinhVienIT("Hưng", "IT", 6, 7, 7);
		sv.xuat();
		SinhVienFpt sv2 = new SinhVienBiz("Phương", "Biz", 8, 7);
		sv2.xuat();
	}

}
