package demo;

public class BieuThucChinhQuy {

	public static void main(String[] args) {
		String pattern = "[A-Z][a-z]*( [A-Z][a-z]*)+";
		String patternEmail = "\\w+@\\w+(\\.\\w+){1,2}";
		System.out.println("A Phu : " + "A Phu".matches(pattern));
		System.out.println("a Phu : " + "a Phu".matches(pattern));
		System.out.println("A A : " + "A A".matches(pattern));
		System.out.println("A a : " + "A a".matches(pattern));
		System.out.println("A : " + "A".matches(pattern));
		System.out.println("Aaa : " + "Aaa".matches(pattern));
		System.out.println("aAA : " + "aAA".matches(pattern));
		System.out.println("Tran Van An : " + "Tran Van An".matches(pattern));
		System.out.println("Tran Van An : " + "Tran Van AA".matches(pattern));
		System.out.println("lsnfs@ljdlf.df : " + "lsnfs@ljdlf.df".matches(patternEmail));
		System.out.println("lsnfs@ljdlf.df : " + "lsnfs@ljdlf.df ".matches(patternEmail));
		BieuThucChinhQuy bieuThucChinhQuy = new BieuThucChinhQuy();
	}
}