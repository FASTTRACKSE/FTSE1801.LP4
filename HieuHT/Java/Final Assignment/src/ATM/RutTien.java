package ATM;

public class RutTien {

	private String ID, matKhau;
	private double sodu = 0;
	public static int count = 0;

	public RutTien() {
	System.out.println("Welcome to ATM");
	}

	public RutTien(String ID, double sodu) {
	setID(ID.trim());
	setSodu(sodu);
	}

	public RutTien(String ID, String matKhau) {
	setID(ID.trim());
	setmatKhau(matKhau.trim());
	}

	public void guiTien(double tien) {
		setSodu(getSodu() + tien);
		System.out.println("Ban vua nap : " + tien + " VND");
	}

	public void rutTien(double tien) {
		setSodu(getSodu() - tien);
		System.out.println("Ban vua rut : " + tien + " VND");
	}

	public void xemSoDu() {
		System.out.println("So du hien tai : " + getSodu() + " VND");
	}

	public boolean dangNhap(String ID, String matKhau) {
		if (getID().equals(ID) && getMatKhau().equals(matKhau)) {
			System.out.println("Dang nhap thanh cong vao tai khoan " + getID());
			return true;
		} else {
			System.out.println("Dang nhap khong thanh cong");
			return false;
		}
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setmatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public double getSodu() {
		return sodu;
	}

	public void setSodu(double sodu) {
		this.sodu = sodu;
	}
}