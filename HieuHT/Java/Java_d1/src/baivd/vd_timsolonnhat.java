package baivd;

public class vd_timsolonnhat {
	public static void main(String args[]) {
		int n=5;
		Integer[] ar_songuyen = {1,5,11,7,9};
		int max=ar_songuyen[0];
		for(int i = 1; i <ar_songuyen.length; i++) {
			if(ar_songuyen[i]>max) {
				max=ar_songuyen[i];
			}
		}
		System.out.println(max);
	}

}
