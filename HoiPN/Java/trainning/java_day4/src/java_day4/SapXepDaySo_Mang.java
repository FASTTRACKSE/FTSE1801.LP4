package java_day4;

public class SapXepDaySo_Mang {
	public static void main(String[] args) {	
		Integer[] mang = {1,5,8,4,2,6,9,3,7};
		for(int i=0;i<mang.length-1;i++) {
			for(int j =i;j<mang.length;j++) {
				if(mang[i] >mang[j]) {
					int tam;
					tam = mang[i];
					mang[i] = mang[j];
					mang[j] = tam;
				}			
			}		
		}
		for(int i =0;i<mang.length;i++) {
			System.out.println(mang[i]+" ");
		}
	}
}
