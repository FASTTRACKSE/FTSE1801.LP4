package Assignment4;

public class KhachHang {
	private String hoTen;
	private String soNha;
	private String Maso;
	private double ChiSoCu;
	private double ChiSoMoi;
    private double TienDien;
	public KhachHang(String hoTen, String soNha, String maso, double chiSoCu, double chiSoMoi) {
		super();
		this.hoTen = hoTen;
		this.soNha = soNha;
		Maso = maso;
		ChiSoCu = chiSoCu;
		ChiSoMoi = chiSoMoi;
	}
	public KhachHang() {
		
	}

	public double getTienDien() {
		return TienDien;
	}


	public void setTienDien(double tienDien) {
		TienDien = tienDien;
	}


	public String gethoTen() {
		return hoTen;
	}

	public void sethoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getsoNha() {
		return soNha;
	}

	public void setAddress(String address) {
		this.soNha = soNha;
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
	public void setsoNha(String soNha2) {
		// TODO Auto-generated method stub
		
	}
}