
public class BienLai {
	private double chiSoCu;
	private double chiSoMoi;
	private double tongTien;

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
	public double getTongTien() {
		return (chiSoMoi - chiSoCu) * 750;
	}
}
