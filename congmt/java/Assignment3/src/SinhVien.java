/**
 * SinhVien Class
 * @author CongMT
 *
 */
public class SinhVien {
	private String id;
	private String name;
	private int age;
	private String address;
	private double diemTb;

	public SinhVien(String id, String name, int age, String address, double diemTb) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.diemTb = diemTb;
	}

	public SinhVien() {
	};

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getDiemTb() {
		return diemTb;
	}

	public void setDiemTb(double diemTb) {
		this.diemTb = diemTb;
	}

}
