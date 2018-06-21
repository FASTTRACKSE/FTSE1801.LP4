

public class BienLai extends KhachHang {
	private double chiSoCu;
	private double chiSoMoi;
	public BienLai(String hoTen, String diaChi, String maSoCongTo, double chiSoCu, double chiSoMoi) {
		super(hoTen, diaChi, maSoCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
	}
	
	public double getChiSoCu() {
		return chiSoCu;
	}
	public void setChiSoCu(double chiSoCu) {
		this.chiSoCu = chiSoCu;
	}
	public double getChiSoMoi() {
		return chiSoMoi;
	}
	public void setChiSoMoi(double chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}
	
}
