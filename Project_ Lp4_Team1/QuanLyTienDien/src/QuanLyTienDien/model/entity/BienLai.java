package QuanLyTienDien.model.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class BienLai {
	private String maBienLai;
	private CongToDien maCongTo;
	private Date ngayNhap;
	private String chuKyNhap;
	private String chiSoCongTo;
	private KhachHang khachHang;

	public BienLai() {
	}

	public String getChuKyNhap() {
		return chuKyNhap;
	}

	public void setChuKyNhap(String chuKyNhap) {
		this.chuKyNhap = chuKyNhap;
	}

	public BienLai(String maBienLai, CongToDien maCongTo, Date ngayNhap, String chuKyNhap, String chiSoCongTo,
			KhachHang khachHang) {
		super();
		this.maBienLai = maBienLai;
		this.maCongTo = maCongTo;
		this.ngayNhap = ngayNhap;
		this.chuKyNhap = chuKyNhap;
		this.chiSoCongTo = chiSoCongTo;
		this.khachHang = khachHang;
	}

	public String getMaBienLai() {
		return maBienLai;
	}

	public void setMaBienLai(String maBienLai) {
		this.maBienLai = maBienLai;
	}

	public CongToDien getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(CongToDien maCongTo) {
		this.maCongTo = maCongTo;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getChiSoCongTo() {
		return chiSoCongTo;
	}

	public void setChiSoCongTo(String chiSoCongTo) {
		this.chiSoCongTo = chiSoCongTo;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

}
