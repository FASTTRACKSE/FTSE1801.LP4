import java.io.Serializable;

/**
 * CanBo class
 * 
 * @author CongMT
 *
 */
public class CanBo implements Serializable {
	
	private String hoTen;
	private double heSoLuong;
	public int phuCap;
	private String nganh;
	


	public CanBo() {
	}

	public CanBo(String hoTen, double heSoLuong, int phuCap) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public long tinhLuong() {
		return 0;
	}

	public void nhap() {

	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	
	

	
	

	

}
