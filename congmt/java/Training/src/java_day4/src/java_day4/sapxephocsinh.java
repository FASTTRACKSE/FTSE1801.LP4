package java_day4;

public class sapxephocsinh {
	public static void main(String[] args) {
		String[] hotenHS= {"Mai Thành Công", "Nguyễn Tuấn Phương", "Phạm Khánh Hưng"};
		double[] diemlp1= {8,7,8};
		double[] diemlp2= {9,7,8};
		double[] diemlp3= {10,7,8};
		double[] diemTB=new double [3];
		String[] xeploai=new String[3];
		int tam;
		int[] vitri= {0,1,2};
		
		for (int i = 0; i < hotenHS.length; i++) {

			diemTB[i] = (diemlp1[i] + diemlp2[i] + diemlp3[i])/3;

				if(diemTB[i] <5){
					xeploai[i]= " Yếu";

				}
				else if(diemTB[i]<7){
					xeploai[i]= "Trung bình";
				}
				else if(diemTB[i]<7.5){
					xeploai[i] = "Khá";
				}
				else if(diemTB[i]<9){
					xeploai[i] = "Giỏi";
				}
				else {xeploai[i] = "Xuất sắc";}

		}
	
		for (int i = 0; i <diemTB.length; i++) {
			for (int j = i+1; j< diemTB.length; j++) {

				if (diemTB[vitri[i]]< diemTB[vitri[j]]) {
						tam=vitri[i];
						vitri[i]=vitri[j];
						vitri[j]=tam;
				}
				
			}
		}
		System.out.printf("STT   Họ và tên \t  Lp1 \tLp2 \t Lp3   \t ĐiemTB \t\t Xeploai");
		for (int i = 0; i <=diemTB.length- 1; i++) {
			
			System.out.println("\n"+(i+1)+".   " + hotenHS[vitri[i]]+ "\t "  + diemlp1[vitri[i]] +"\t"+ 
					+ diemlp2[vitri[i]]+"\t "+ diemlp3[vitri[i]] +"\t  " + diemTB[vitri[i]]+"     \t \t "+ xeploai[vitri[i]]	);
//			System.out.println("- Điểm lp1:" + diemlp1[vitri[i]]);
//			System.out.println("- Điểm lp2:" + diemlp2[vitri[i]]);
//			System.out.println("- Điểm lp3:" + diemlp3[vitri[i]]);
//			System.out.println("- Điểm TB:" + diemTB[vitri[i]]);
//			System.out.println("- Xếp loại" + xeploai[vitri[i]]);
		}
	}
}
