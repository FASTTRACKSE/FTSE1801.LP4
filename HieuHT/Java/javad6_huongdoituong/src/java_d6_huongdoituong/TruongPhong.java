package java_d6_huongdoituong;

public class TruongPhong extends NhanVien{

	
     private double trachNhiem;
     public  double getthueThuNhap() {
 		return super.getthueThuNhap() + trachNhiem;
     }
     
     public double getTrachNhiem() {
		return trachNhiem;
	}
     
	public void setTrachNhiem(double trachNhiem) {
		this.trachNhiem = trachNhiem;
	}
	
   
   
}
