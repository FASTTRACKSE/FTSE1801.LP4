package sap_xep;

public class sapXep {
	public static Integer[] sapxep_tangdan(Integer[] songuyen ) {

		for(int i=0;i<=songuyen.length-1;i++) {
			for(int j=i +1;j<songuyen.length;j++) {
				if (songuyen[i]< songuyen[j]) {
					int tam=songuyen[i];
					songuyen[i]=songuyen[j];
					songuyen[j]=tam;
				}
			}
		}
		
		return songuyen;
	}
	
	public static Integer[] sapxep_giamdan(Integer[] songuyen ) {

		for(int i=0;i<=songuyen.length-1;i++) {
			for(int j=i +1;j<songuyen.length;j++) {
				if (songuyen[i]> songuyen[j]) {
					int tam=songuyen[i];
					songuyen[i]=songuyen[j];
					songuyen[j]=tam;
				}
			}
		}
		
		return songuyen;
	}
}
