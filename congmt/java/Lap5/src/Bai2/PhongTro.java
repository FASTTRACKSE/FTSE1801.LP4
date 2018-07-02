package Bai2;

public class PhongTro {
	private int soNgaytro;
	private int loaiP;
	Nguoi nguoi;
	public PhongTro() {

	}

	public PhongTro(int soNgaytro, int loaiP, Nguoi nguoi) {
		this.soNgaytro = soNgaytro;
		this.loaiP = loaiP;
        this.nguoi=nguoi;

	}

	public int getSoNgaytro() {
		return soNgaytro;
	}

	public void setSoNgaytro(int soNgaytro) {
		this.soNgaytro = soNgaytro;
	}

	public int getLoaiP() {

		return loaiP;
	}

	public void setLoaiP(int loaiP) {
		this.loaiP = loaiP;
	}

	public int getGiaP() {
		if (getLoaiP() == 1) {
			return 100000;
		} else if (getLoaiP() == 2) {
			return 80000;
		} else if (getLoaiP() == 3) {
			return 60000;
		} else {
			System.out.println("Không có loại phòng này.!");
		}
		return getGiaP();

	}

	public double getThanhTien() {
		return getSoNgaytro() * getGiaP();
	}
    public Nguoi getKhach()
    {
    	nguoi=new Nguoi();
        return this.nguoi;
    }


}
