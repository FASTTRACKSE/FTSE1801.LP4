package baiHoc;

public class MyClassHinh {
	public static void main(String[] args) {
		
		ChuNhat cn=new ChuNhat(10, 5);
		System.out.println("chieu dai= "+cn.dai+" chieu rong= "+cn.rong);
		System.out.println("Chu vi hinh chu nhat= "+cn.chuVi());
		System.out.println("Dien tich hinh chu nhat= "+cn.dienTich());
		System.out.println();
		
		Vuong v=new Vuong(10);
		System.out.println("chieu dai canh= "+v.canh);
		System.out.println("Chu vi hinh vuong= "+v.chuVi());
		System.out.println("Dien tich hinh vuong= "+v.dienTich());
		System.out.println();
		
		Tron t=new Tron(8);
		System.out.println("Ban kinh= "+t.bankinh);
		System.out.println("Chu vi hinh tron= "+t.chuVi());
		System.out.println("Dien tich hinh tron= "+t.dienTich());
		System.out.println();

	}

}
