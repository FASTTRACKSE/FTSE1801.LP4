/**
 * GiangVien Class
 * @author CongMT
 *
 */
public class GiangVien extends CanBo{
	private String khoa;
	private String trinhDo;
	private int soTietDay;
	public GiangVien() {
		super();
		
	}
	public GiangVien(String khoa, String trinhDo, int soTietDay) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	public long tinhLuong() {
        return  (long) (this.getHeSoLuong() * 730000 + this.getPhuCap() + this.getSoTietDay() * 45);
    }
}