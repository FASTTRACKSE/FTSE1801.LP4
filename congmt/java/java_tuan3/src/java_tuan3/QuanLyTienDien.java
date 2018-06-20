package java_tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTienDien {
	private ArrayList<BienLai> listBienLai;
	public QuanLyTienDien() {
		listBienLai=new ArrayList<BienLai>();
	}
	 /**
     * add student to studentList
     * 
     * @param student
     */
	public void add(BienLai bienlai) {
		listBienLai.add(bienlai);
		
	}
	public void soTienPhaiTra()  {	
		int size= listBienLai.size();
		for(int i=0; i<size;i++){	
			listBienLai.get(i).setSoTienPhaiTra=(listBienLai.get(i).getChiSoMoi()-listBienLai.get(i).getChiSoCu()*750);
		}
	}
	public void show(BienLai bienlai) {
    	
        System.out.printf("%-3s| %-20s| %-6s| %-10s| %-10s| %-10s| %-10s| \\n","STT", "Họ và tên", "Số nhà", "MS Công tơ" ,"Chỉ số cũ","Chỉ số mới","Số tiền" );
		System.out.println();

		for(BienLai bienlai1:listBienLai) {
			System.out.printf(" %-3s| %-20s| %-6s| %-10s| %-10s| %-10s| %-10s| \n",bienlai1.getHoTen(),bienlai1.getSoNha(),bienlai1.getMaSoCongTo(),bienlai1.getChiSoCu(),bienlai1.getChiSoMoi());

		System.out.println();
		}
		
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		QuanLyTienDien qltd=new QuanLyTienDien();
		 while (true) {
	            int choose = sc.nextInt();
	            
				switch (choose) {
	            case 1:
	            	int tt;
					do {
						BienLai bienlai=new BienLai();
						
						
	 	                System.out.println("- Nhập tên khách hàng:");
	 	                String hoTen=sc.nextLine();
	 	               bienlai.setHoTen(hoTen);;
	 	        
	 	                System.out.println("- Nhập số nhà khách hàng:");
	 	                int soNha=sc.nextInt();
	 	                sc.nextLine();
	 	               bienlai.setSoNha(soNha);
	 	                System.out.println("- Nhập mã số công tơ:");
	 	                int maSoCongTo =sc.nextInt();
	 	                bienlai.setMaSoCongTo(maSoCongTo);
	 	                System.out.println("- Nhập chỉ số cũ:");
	 	               int chiSoCu=sc.nextInt();
	 	               bienlai.setChiSoCu(chiSoCu);
	 	              System.out.println("- Nhập chỉ số mới:");
	 	               int chiSoMoi=sc.nextInt();
	 	               bienlai.setChiSoMoi(chiSoMoi);
	 	        
						qltd.add(bienlai);
						System.out.println();
						System.out.print("Bạn có muốn nhập tiếp không (0:không | 1:Có) ");
						tt = sc.nextInt();
						System.out.println();
					} while (tt == 1);
					
					break;
	        
				case 2:
				
					qltd.show(null);
					break;
				
				case 0:
					sc.close();
					System.out.println("Kết thúc chương trình!!! ");
					System.exit(0);
					break;
					
				default:
					System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
					break;
				}
	            // show menu
	            showMenu();
	        }
	    }
	 
	    /**
	     * create menu
	     */
	    public static void showMenu() {
	        System.out.println("-----------menu------------");
	        System.out.println("1. Thêm tên khách hàng.");
	        System.out.println("2. Hiện thông tin khách hàng.");
	        System.out.println("0. exit.");
	        System.out.println("---------------------------");
	        System.out.print("Please choose: ");
	    }
		
	}

