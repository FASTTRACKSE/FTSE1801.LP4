package quanlytiendien.model.entity;

public class Quan {
	private int maQuan;
	private String nameQuan;

	public Quan() {
	}

	public Quan(int maQuan, String nameQuan) {
		this.maQuan = maQuan;
		this.nameQuan = nameQuan;
	}

	public int getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(int maQuan) {
		this.maQuan = maQuan;
	}

	public String getNameQuan() {
		return nameQuan;
	}

	public void setNameQuan(String nameQuan) {
		this.nameQuan = nameQuan;
	}

	public String toString() {
		return nameQuan;
	}
}
