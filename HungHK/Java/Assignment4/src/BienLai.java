

public class BienLai {
	private String hoTen;
	private String diaChi;
	private String maSoCongTo;
	private double chiSoCu;
	private double chiSoMoi;
	public BienLai(String hoTen, String diaChi, String maSoCongTo, double chiSoCu, double chiSoMoi) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.maSoCongTo = maSoCongTo;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
	}
	public BienLai() {
		// TODO Auto-generated constructor stub
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
