package javaday2;

public class lap_bai6_1 {
	public static void main(String[] args) {
		//Khởi tao mảng
		String ten[] = {"Phạm Ngọc Hợi", "Mai Thành công", "Hồ Tấn Hiệu"};
		double Lp1[] = {8,7,9};
		double Lp2[] = {9,7,5};
		double Lp3[] = {9,8,9};		
		double dtb[] = new double[3];
		String xl[] = new String[3];
		
		for(int i =0;i<ten.length;i++) {
			dtb[i] = (Lp1[i] + Lp2[i]+ Lp3[i])/3;
			if(dtb[i]>=9) {
				xl[i] = "Xuất sắc";
			}else if(dtb[i]>=7.5){
				xl[i]= "Giỏi";
			}else if(dtb[i]>=6.5){
				xl[i]= "Khá";
			}else if(dtb[i]>5){
				xl[i]= "Trung bình";
			}else {
				xl[i]="Yếu";
			}
		}
		for(int i=0;i<ten.length-1;i++) {		
			for(int j =i;j<dtb.length;j++) {	
				int[] vitri = {0,1,2};
				if(dtb[vitri[i]] <dtb[vitri[j]]) {
					int tam;
					tam = vitri[i];
					vitri[i] = vitri[j];
					vitri[j] = tam;
				}	
			}
		}
		for(int i=0;i<3;i++) {
			int[] vitri = null;
			System.out.println(ten[vitri[i]]+" "+dtb[vitri[i]]+" "+xl[vitri[i]]+".");
		}
	}
}
