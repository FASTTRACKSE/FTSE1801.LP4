package java_day4;

public class SapXep_TangDan_Ham {
	public static Integer[] tang_dan(Integer[] sapxep) {
		for(int i=0;i<sapxep.length-1;i++) {
			for(int j =i;j<sapxep.length;j++) {
				if(sapxep[i] >sapxep[j]) {
					int tam;
					tam = sapxep[i];
					sapxep[i] = sapxep[j];
					sapxep[j] = tam;
				}			
			}		
		}
		return sapxep;
	}
	public  static void main(String[] args) {
		Integer[] mang = {1,5,8,4,2,6,9,3,7};
		mang = tang_dan(mang);
		for(int i =0;i<mang.length;i++) {
			System.out.println(mang[i]+" ");
		}

	}
}
