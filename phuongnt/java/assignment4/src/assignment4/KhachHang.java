package assignment4;

public class KhachHang {
	private String name;
	private String address;
	private String Maso;
	private double ChiSoCu;
	private double ChiSoMoi;
    private double TienDienTra;
	public KhachHang(String name, String address, String maso, double chiSoCu, double chiSoMoi) {
		super();
		this.name = name;
		this.address = address;
		Maso = maso;
		ChiSoCu = chiSoCu;
		ChiSoMoi = chiSoMoi;
	}
	public KhachHang() {
		
	}

	public double getTienDienTra() {
		return TienDienTra;
	}


	public void setTienDienTra(double tienDienTra) {
		TienDienTra = tienDienTra;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaso() {
		return Maso;
	}

	public void setMaso(String maso) {
		Maso = maso;
	}

	public double getChiSoCu() {
		return ChiSoCu;
	}

	public void setChiSoCu(double chiSoCu) {
		ChiSoCu = chiSoCu;
	}

	public double getChiSoMoi() {
		return ChiSoMoi;
	}

	public void setChiSoMoi(double chiSoMoi) {
		ChiSoMoi = chiSoMoi;
	}
}


