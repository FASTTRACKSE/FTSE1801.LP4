package java_d6_huongdoituong;

public class LaoCong extends NhanVien{
     private double tienLamThem;
     public  double getthueThuNhap() {
	    	
			return super.getthueThuNhap() + tienLamThem;
	    	
	    }

	public double getTienLamThem() {
		return tienLamThem;
	}

	public void setTienLamThem(double tienLamThem) {
		this.tienLamThem = tienLamThem;
	}
	
}
