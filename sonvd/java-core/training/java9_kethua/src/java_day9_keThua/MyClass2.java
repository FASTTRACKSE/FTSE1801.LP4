package java_day9_keThua;

public class MyClass2 {
	public static void main(String[] args) {
		Nhen nhen = new Nhen();
		nhen.setTen("Con Nhện");
		nhen.setSoChan(8);
		nhen.setSoMat(6);
		nhen.setTiengKeu("nhen nhen");
		nhen.in();
		
		Cua cua= new Cua();
		cua.setTen("Con cua");
		cua.setSoCang(2);
		cua.setSoChan(8);
		cua.setSoMat(2);
		cua.setTiengKeu("cua cua");
		cua.in();
		
		Ca ca= new Ca();
		ca.setTen("Con cá");
		ca.setSoChan(0);
		ca.setSoMat(2);
		ca.setTiengKeu("ca ca");
		ca.setSoVay(6);
		ca.in();
		
		Meo meo = new Meo();
		meo.setTen("Con ca");
		meo.setSoChan(4);
		meo.setSoMat(2);
		meo.setTiengKeu("Meo meo");
		meo.setSoRau(16);
		meo.in();

	}

}
