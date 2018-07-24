package quanlytruonghoc.entity;

public class MonHoc {

	private String idMonHoc;
	private String tenMonHoc;
	private String tinChi;
	private String thoiLuongHoc;
	
	public MonHoc() {
		
	}
	public MonHoc(String idMonHoc, String tenMonHoc, String tinChi, String thoiLuongHoc) {
		this.idMonHoc = idMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.tinChi = tinChi;
		this.thoiLuongHoc = thoiLuongHoc;
	}
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
	
	
}
