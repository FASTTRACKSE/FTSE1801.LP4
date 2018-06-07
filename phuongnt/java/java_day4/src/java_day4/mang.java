package java_day4;

public class mang {
	public static Integer[] tang_dan(Integer[] ar_songuyen) {
		for(int i=0;i<=ar_songuyen.length-1;i++){
			for(int j=i+1;j<ar_songuyen.length;j++){
				if(ar_songuyen[i]<ar_songuyen[j]){
					Integer tam = ar_songuyen[i];
					ar_songuyen[i]=ar_songuyen[j];
					ar_songuyen[j]=tam;
				}
			}
		}
		return ar_songuyen;
	}
	public static void main(String[] args) {
		Integer[] ar_songuyen = {1, 5, 11, 8, 9};
		ar_songuyen = tang_dan(ar_songuyen);
		
		for(int i = 0; i<ar_songuyen.length; i++) {
			System.out.println(ar_songuyen[i]);
		}

		//		int min=ar_songuyen[0];
//		
//		for(int i=1; i<ar_songuyen.length; i++) {
//			if(ar_songuyen[i]<min) {
//				min=ar_songuyen[i];
//			}
//		}
//		System.out.println(min);
		
//		for(int i=0;i<=ar_songuyen.length-1;i++){
//			for(int j=i+1;j<ar_songuyen.length;j++){
//				if(ar_songuyen[i]>ar_songuyen[j]){
//					Integer tam = ar_songuyen[i];
//					ar_songuyen[i]=ar_songuyen[j];
//					ar_songuyen[j]=tam;
//				}
//			}
//		}
//		for(int i = 0;i<ar_songuyen.length;i++){
//			System.out.println(ar_songuyen[i]);
//		}
	}
}
