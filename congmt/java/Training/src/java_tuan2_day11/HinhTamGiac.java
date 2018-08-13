package java_tuan2_day11;

public class HinhTamGiac extends Hinh {
	private double chieuCao;
	private double canhDay;
	private double canhA;
	private double canhB;
	
	public HinhTamGiac(double chieuCao, double canhDay, double canhA, double canhB) {
		super();
		this.chieuCao = chieuCao;
		this.canhDay = canhDay;
		this.canhA = canhA;
		this.canhB = canhB;
	}


	public double getChieuCao() {
		return chieuCao;
	}


	public void setChieuCao(double chieuCao) {
		this.chieuCao = chieuCao;
	}


	public double getCanhDay() {
		return canhDay;
	}


	public void setCanhDay(double canhDay) {
		this.canhDay = canhDay;
	}

	public double getCanhA() {
		return canhA;
	}


	public void setCanhA(double canhA) {
		this.canhA = canhA;
	}


	public double getCanhB() {
		return canhB;
	}


	public void setCanhB(double canhB) {
		this.canhB = canhB;
	}
	@Override
	public double chuVi() {
		
		return canhA + canhB + canhDay ;
	}

	@Override
	public double dienTich() {
	
		return chieuCao*canhDay/2;
	}
	
	void xuat() {
		System.out.println("- Đâylà hìn tam giac:");
		System.out.println("- Co chieu cao:" + getChieuCao());
		System.out.println("- Co canh day:" + getCanhDay());
		System.out.println("- Co canh A:" + getCanhA());
		System.out.println("- Co canh B:" + getCanhB());
		System.out.println("- Dien tích:" + dienTich());
		System.out.println("- Chu vi:" + chuVi());
	}

}
