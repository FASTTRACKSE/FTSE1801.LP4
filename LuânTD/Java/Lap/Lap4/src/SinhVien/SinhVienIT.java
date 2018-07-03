package SinhVien;

public class SinhVienIT extends SinhVienFpt {
	
	private double diemJava;
	private double diemCss;
	private double diemHtml;
	
	public SinhVienIT(String hoTen,String nganh,double diemJava,double diemCss,double diemHtml) {
		
		super(hoTen,nganh);
		this.diemJava=diemJava;
		this.diemCss=diemCss;
		this.diemHtml=diemHtml;
		
		
	}

	public double getDiem() {
		
		return (2*diemJava+diemCss+diemHtml)/4;
	}
	
	public void xuat() {
		super.xuat();
		System.out.println("Diem trung binh: "+getDiem());
		System.out.println("Xep loai: "+super.getHocLuc(getDiem()));
		
		
	}


	
	

}

