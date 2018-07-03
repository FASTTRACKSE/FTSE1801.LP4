package javaday2;

public class lap_bai5 {
	public static void main(String[] args) {
		int i; 
		int j;
		System.out.println("Bảng cửu chương");
		for(j=1; j<= 9; j++){
			for( i = 2; i <= 8; i++ ){
				System.out.print(i + " * " + j + " = " + i*j+"\t  ");
			}
			System.out.println(i + " * " + j + " = " + i*j+"\t  ");
		}
	}
}
