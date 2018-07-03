import java.io.Serializable;

public class NhanVien implements Serializable {
	private String hoTen;
	private String email;
	private String sdt;
	private String cmnd;
	public NhanVien(String hoTen, String email, String sdt, String cmnd) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.cmnd = cmnd;
	}
	public String toString() {
		return (hoTen + "\n" + email + "\n" + sdt + "\n" + cmnd + "\n");
	}
}
