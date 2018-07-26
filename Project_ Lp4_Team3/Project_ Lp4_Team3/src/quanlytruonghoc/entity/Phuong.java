package quanlytruonghoc.entity;

public class Phuong {
	private String idPhuong;
	private String namePhuong;
	
	public Phuong() {}
	public Phuong(String idPhuong, String namePhuong) {


		this.idPhuong = idPhuong;
		this.namePhuong = namePhuong;
	}
	public String getIdPhuong() {
		return idPhuong;
	}
	public void setIdPhuong(String idPhuong) {
		this.idPhuong = idPhuong;
	}
	public String getNamePhuong() {
		return namePhuong;
	}
	public void setNamePhuong(String namePhuong) {
		this.namePhuong = namePhuong;
	}
	
	
}
