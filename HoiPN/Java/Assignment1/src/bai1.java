import java.util.Scanner;
/**
 * Assignment 1 
 * @author Phạm Ngọc Hợi
 *
 */
public class bai1 {
	public static void main(String[] args) {	
		int a;
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextInt();
		if(a==0) {
			System.out.println(
					"____@@@___@@@@@___@@___@@___@@@@@ \r\n" + 
					"____@@@__@@___@@___@@__@@___@@ \r\n" + 
					"____@@@__@@___@@____@@_@@___@@@@ \r\n" + 
					"____@@@__@@___@@_____@@@____@@ \r\n" + 
					"____@@@@@_@@@@________@@____@@@@@\r\n");
		}else if(a%2==0){
			System.out.println(
					"________________d88888b_____________d888b\r\n" + 
							"_______________d88888888b__________d888888b\r\n" + 
							"_______________d8888888b\"\"\"\"\"\"\"\"\"\"\"8888 8888b\r\n" + 
							"________88\"\"\"\"\"\"\"888P\"_________________88888P\r\n" + 
							"______888____,888_______________________8P,\r\n" + 
							"____888____8888_________________________\"8,\r\n" + 
							"___88_____8888_______88888_______________\"8,\r\n" + 
							"__888____d88888_____8888888______88888____\"8,\r\n" + 
							"_8888____8888888_____888888_____8888888___\"8\r\n" + 
							"_88888___8888888______888_______888888___\"8,\r\n" + 
							"_888888___88888I88_______________888____\"8,\r\n" + 
							"__888888___888I888888_____88888________88,\r\n" + 
							"___8888888__8888888888888__\"\"\"'''___8888888,\r\n" + 
							"___888888888_88888888888888_\"\"_88888888888\r\n" + 
							"___8888888888888888888888888888888Id888888\r\n" + 
							"____888888888888888888888888888888888888b\r\n" + 
							"_____888888888_8888888888b____88888888888\r\n" + 
							"______88888888__8888888888_____8888888888\r\n" + 
							"_______8888888__8888888888_____ad8888888\r\n" + 
							"________888888b__888888888______8888888\r\n" + 
							"__________________88888888 \r\n");
		}else {
			System.out.println(	"_________$$$$$$$$_______$$$$$$$$\r\n" + 
					"_______$$$$$$$$$$$$__$$$$$$$$$$$$$\r\n" + 
					"______$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \r\n" + 
					"_____$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \r\n" + 
					"______$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\r\n" + 
					"________$$$$$$$$$$$$$$$$$$$$$$$$$\r\n" + 
					"__________$$$$$$$$$$$$$$$$$$$$$\r\n" + 
					"____________$$$$$$$$$$$$$$$$$\r\n" + 
					"______________$$$$$$$$$$$$$\r\n" + 
					"________________$$$$$$$$$\r\n" + 
					"__________________$$$$$\r\n" + 
					"____________________$\r\n" + 
					"");
		}

	}
}
