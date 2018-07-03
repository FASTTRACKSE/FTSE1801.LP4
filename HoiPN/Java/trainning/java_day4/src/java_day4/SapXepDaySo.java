package java_day4;

public class SapXepDaySo {
	public static void main(String[] args) {
		int n = 5;
		Integer[] mang = {1,2,3,4,5,6,7,8,9};
		int max=mang[0];
		for(int i=0;i<mang.length;i++) {
			if(mang[i] >max) {
				max = mang[i];
			}
		}
		System.out.println(max);
	}
}
