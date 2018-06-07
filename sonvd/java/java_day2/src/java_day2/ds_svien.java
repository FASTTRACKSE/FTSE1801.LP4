package java_day2;


public class ds_svien {
	public static void main (String[] args) {
		String[] hoten = {"Nguyễn Văn A","Nguyễn Văn B","Nguyễn Văn C"};
		double[] diemLP0 = {6,10,9};
		double[] diemLP1 = {7,10,10};
		double[] diemLP2 = {2,10,9};
		double [] diemTB = new double[3];
		String[] xeploai = new String[3];
		 

		for (int i=0;i<hoten.length;i++) {
			diemTB[i] =(diemLP0[i]+diemLP1[i]+diemLP2[i])/3;
		}
		
		
		for (int i = 0; i<hoten.length; i++) {
			if (diemTB[i]<5) {
				xeploai[i] = "Yếu";
			} else if (diemTB[i]<6.5) {
				xeploai[i] = "Trung bình";
			} else if (diemTB[i]<7.5) {
				xeploai[i] = "Khá";
			} else if (diemTB[i]<9) {
				xeploai[i] = "Giỏi";
			} else {
				xeploai[i] = "Xuất sắc";
			}
		}
		
		int vitri[] = {0,1,2};
		int tg;
		for (int i = 0; i<hoten.length;i++) {
			for (int j = i+1; j<hoten.length;j++) {
				if (diemTB[vitri[i]]<diemTB[vitri[j]]) {
					tg = vitri[i];
					vitri[i] = vitri[j];
					vitri[j] = tg;
				}
			}
		}
		
		for (int i = 0; i<3; i++) {
			System.out.println("Tên sinh viên: "+hoten[vitri[i]]);
			System.out.println("Điểm LP0: "+diemLP0[vitri[i]]);
			System.out.println("Điểm LP1: "+diemLP1[vitri[i]]);
			System.out.println("Điểm LP2: "+diemLP2[vitri[i]]);
			System.out.println("Điểm trung bình: "+diemTB[vitri[i]]);
			System.out.println("Xếp loại: "+xeploai[vitri[i]]);
		}
	}
}
