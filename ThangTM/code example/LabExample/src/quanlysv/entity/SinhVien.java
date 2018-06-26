package quanlysv.entity;

public class SinhVien {
	private String id;
	private String name;
	private int old;
	private float dtb;

	public SinhVien() {
	}

	public SinhVien(String id, String name, int old, float dtb) {
		this.id = id;
		this.name = name;
		this.old = old;
		this.dtb = dtb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public float getDtb() {
		return dtb;
	}

	public void setDtb(float dtb) {
		this.dtb = dtb;
	}

}
