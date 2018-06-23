package java_day9_keThua;

public class myClass {
	public static void main(String[] args) {
		ChuNhat cn = new ChuNhat(4,5);
		cn.xuat();
		
		Vuong vu = new Vuong(4.0);
		vu.xuat();
		
		
		System.out.println("Bang tien luong: ");
		nhanvien nv = new nhanvien();
		nv.setHoTen("Son");
		nv.setLuong(1000);
		System.out.println("Nhan vien: "+nv.getHoTen()+" " + nv.getLuong()+" "+nv.getThuNhap());
		
		TruongPhong tp = new TruongPhong();
		tp.setHoTen("Hoi");
		tp.setLuong(1000);
		tp.setTrachNhiem(1000);
		System.out.println("Truong phong: "+tp.getHoTen()+" "+tp.getLuong()+" "+tp.getThuNhap());
		
		LaoCong lc=new LaoCong();
		lc.setHoTen("Thien");
		lc.setLuong(1000);
		lc.setTienLamThem(200);
		System.out.println("lao cong: "+lc.getHoTen()+" "+lc.getLuong()+" "+lc.getThuNhap());
		
		
	}
	
}
