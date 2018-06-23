package java_day5;

public class vidu1_Ham {
	public static void hienthimang(int[] a) {
		for(int i=0; i<a.length;i++) {
			System.out.print("" +a[i]+" ");
		}
	}
	
	public static int vd2(int x) {
		int y = 2*x;
		return y;
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,3,4};
		hienthimang(a);
		int x =3;
		System.out.println("/n" + vd2(x));
	}
}
