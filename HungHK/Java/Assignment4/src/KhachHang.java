

public class KhachHang {
	private String hoTen;
	private String diaChi;
	private String maSoCongTo;
	
	public KhachHang(String hoTen, String diaChi, String maSoCongTo) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.maSoCongTo = maSoCongTo;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMaSoCongTo() {
		return maSoCongTo;
	}
	public void setMaSoCongTo(String maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}
	
}
