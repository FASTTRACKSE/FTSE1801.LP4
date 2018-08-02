package quanly_thuvien.model.entity;

public class TheLoaiSach {
     private int maTheLoaiSach;
     private String TheLoaiSach;
     
     public TheLoaiSach() {
    	 
     }

	public TheLoaiSach(int maTheLoaiSach, String theLoaiSach) {
		super();
		this.maTheLoaiSach = maTheLoaiSach;
		TheLoaiSach = theLoaiSach;
	}

	public int getMaTheLoaiSach() {
		return maTheLoaiSach;
	}

	public void setMaTheLoaiSach(int maTheLoaiSach) {
		this.maTheLoaiSach = maTheLoaiSach;
	}

	public String getTheLoaiSach() {
		return TheLoaiSach;
	}

	public void setTheLoaiSach(String theLoaiSach) {
		TheLoaiSach = theLoaiSach;
	}
     
     
}
