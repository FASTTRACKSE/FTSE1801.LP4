package ham;

public class sapxep {
	
	public static void tangdan(double[] diem) {
		int[] chiso= {0,1,2};
		int g;
		for(int j=0;j<diem.length;j++) {
			for(int i=1; i<diem.length;i++) {
				if(diem[i]<diem[j]) {
					g=chiso[i];
					chiso[i]=chiso[j];
					chiso[j]=g;
				}
			}
			
		}
		
	}
	
	public static void giamdan(double[] diem) {
		int[] chiso= {0,1,2};
		int g;
		for(int j=0;j<diem.length;j++) {
			for(int i=1; i<diem.length;i++) {
				if(diem[i]>diem[j]) {
					g=chiso[i];
					chiso[i]=chiso[j];
					chiso[j]=g;
				}
			}
			
		}
		
		
	}

	
	
}
