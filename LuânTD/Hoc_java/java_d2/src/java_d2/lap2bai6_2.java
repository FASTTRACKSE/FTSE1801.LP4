package java_d2;

public class lap2bai6_2 {
	public static void main(String[] args) {
		
		String[] hoten= {"Nguyễn Văn A","Nguyễn Văn B","Trần Văn C"};
		double[] lp1= {7,8,6};
		double[] lp2= {8,5,7};
		double[] lp3= {9,6,7};
		double[] diem= new double[3];
		String[] xl= new String[3];
		int g;
		int chiso[]= {0,1,2};
		for(int i=0;i<hoten.length;i++) {
			diem[i]=(lp1[i]+lp2[i]+lp3[i])/3;
			
			if(diem[i]<5) {
			 xl[i]="Yếu";
			}else if(diem[i]<6.5) {
				xl[i]="Trung bình";
			}else if(diem[i]<8.5) {
				xl[i]="Khá";
			}else if(diem[i]<9) {
				xl[i]="Giỏi";
			}else{
				xl[i]="Xuất sắc";
			}
			
		}
		for(int j=0;j<diem.length;j++) {
			for(int i=1; i<diem.length;i++) {
				
				if(diem[i]>diem[j]) {
					g=chiso[i];
					chiso[i]=chiso[j];
					chiso[j]=g;
				}
			}
			
		}
		for(int i=0; i<diem.length;i++) {
			System.out.println("Họ và tên: "+hoten[chiso[i]]);
			System.out.println("Điểm LP1: "+lp1[chiso[i]]);
			System.out.println("Điểm LP2: "+lp2[chiso[i]]);
			System.out.println("Điểm LP3: "+lp3[chiso[i]]);
			System.out.println("Điểm trung bình: "+diem[chiso[i]]);
			System.out.println("Xếp loại: "+xl[chiso[i]]+"\n");
		}
		
	}
}
