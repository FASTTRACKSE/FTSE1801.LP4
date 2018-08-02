package quanlytruonghoc.entity;
/**
 * MonHoc Class
 * @author CongMT
 *
 */
public class MonHoc {

	private String idMonHoc;
	private String tenMonHoc;
	private String tinChi;
	private String thoiLuongHoc;
	private double diem;

	public String getIdMonHoc() {
		return idMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		this.idMonHoc = idMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getTinChi() {
		return tinChi;
	}

	public void setTinChi(String tinChi) {
		this.tinChi = tinChi;
	}

	public String getThoiLuongHoc() {
		return thoiLuongHoc;
	}

	public void setThoiLuongHoc(String thoiLuongHoc) {
		this.thoiLuongHoc = thoiLuongHoc;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

}
