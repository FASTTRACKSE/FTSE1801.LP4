
public class CanBo {
	private String hoTen;
	private float heSoLuong;
	private String donVi;
	protected String capBac;
	private int thoiGianLamViec;
	private int phuCap;
	private double luong;
	
	public CanBo() {
	}
	public CanBo(String hoTen, float heSoLuong, String donVi, String capBac, int thoiGianLamViec, int phuCap,
			double luong) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.donVi = donVi;
		this.capBac = capBac;
		this.thoiGianLamViec = thoiGianLamViec;
		this.phuCap = phuCap;
		this.luong = luong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getCapBac() {
		return capBac;
	}
	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}
	public int getThoiGianLamViec() {
		return thoiGianLamViec;
	}
	public void setThoiGianLamViec(int thoiGianLamViec) {
		this.thoiGianLamViec = thoiGianLamViec;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
}