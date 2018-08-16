package java_d6_huongdoituong;

public class NhanVien {
    private String HoTen;
    private double Luong;

	 
    public  double getthueThuNhap() {
    	
		return 12*Luong;
    	
    }
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	
	
}
