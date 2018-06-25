package lap5;

public class Person {
	private String hoTen;
	private int tuoi;
	public Person(String hoTen, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
//	public abstract void printPerson();
}
