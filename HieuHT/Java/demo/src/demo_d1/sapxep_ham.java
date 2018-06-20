package demo_d1;

public class sapxep_ham {
	public static Integer[] giam_dan(Integer[] songuyen) {
		for(int i = 0; i<songuyen.length-1; i++) {
			for(int j=i+1;j<songuyen.length;j++) {
				if(songuyen[i]<songuyen[j]) {
					int tam;
					tam = songuyen[j];
					songuyen[j] = songuyen[i];
					songuyen[i] = tam;
				}
			}
		}
		return songuyen;
	}
	public static void main(String args[]) {
		Integer[] songuyen= {1,6,3,8,4,9,6};
		songuyen=giam_dan(songuyen);
		for(int i = 0; i<songuyen.length;i++) {
			System.out.print(songuyen[i] + "  ");
		}
	}
}
