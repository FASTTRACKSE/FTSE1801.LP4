package demo_d1;

public class sapxepdayso_mang {
	public static void main(String[] args) {
		int n = 7;
		Integer[] dayso = {1,5,3,9,7,4,8};
		int sapxep=dayso[0];
		for(int i = 0; i<dayso.length-1; i++) {
			for(int j=i;j<dayso.length;j++) {
				if(dayso[i]>dayso[j]) {
					int tam;
					tam = dayso[j];
					dayso[j] = dayso[i];
					dayso[i] = tam;
				}
			}
		}
		for(int i = 0; i<dayso.length;i++) {
			System.out.print(dayso[i] + "  ");
		}
	}
}
