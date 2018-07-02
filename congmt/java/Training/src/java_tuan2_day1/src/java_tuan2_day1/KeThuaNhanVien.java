package java_tuan2_day1;

public class KeThuaNhanVien extends nhanvien {
	private double tienTrachNhiem;
//	public KeThuaNhanVien(String ten, double luong, double trachNhiem) {
//		this.ten = ten;
//		this.luong =luong;
//		this.tienTrachNhiem=trachNhiem;
//	}
	
	public double getTienTrachNhiem() {
		return tienTrachNhiem;
	}

	public void setTienTrachNhiem(double tienTrachNhiem) {
		this.tienTrachNhiem = tienTrachNhiem;
	}

//	public void xuat() {
//		
//		ten="Công";
//		luong=100000;
//		super.xuat();
//		xepluong();
//	}
	public double getThuNhap() {
		return super.getThuNhap()+ tienTrachNhiem;
	}
	public void KeThuaNhanVien() {}

}
