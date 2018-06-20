package demo5;

public class nhanvien {
	//thuộc tính(properties)
	String ten;
	 int tuoi;
	String diachi;
	String gioitinh;
	long luong;
	
	//phương thức(method)
	void setten(String ten) {
		this.ten = ten;
	}
	void settuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	void setdiachi(String diachi) {
		this.diachi = diachi;
	}
	void setgioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	void setluong(long luong) {
		this.luong = luong;
	}
	
	String getten() {
		return ten;
	}
	int gettuoi() {
		return tuoi;
	}
	String getdiachi() {
		return diachi;
	}
	String getgioitinh() {
		return gioitinh;
	}
	long getluong() {
		return luong;
	}
	
	public static void main(String[] args) {
		nhanvien nv1 = new nhanvien();
		nv1.setten("Nguyễn Tuấn Phương");
		nv1.settuoi(23);
		nv1.setdiachi("Đà Nẵng");
		nv1.setgioitinh("Nam");
		nv1.setluong(5000000);
//		System.out.println("Tên nhân viên là: "+nv1.getten());
//		System.out.println("Tuổi: "+nv1.gettuoi());
//		System.out.println("Địa chỉ: "+nv1.getdiachi());
//		System.out.println("Giới tính: "+nv1.getgioitinh());
//		System.out.println("Lương: "+nv1.getluong());
		
		nhanvien nv2 = new nhanvien();
		nv2.setten("Hồ Tấn Hiệu");
		nv2.settuoi(22);
		nv2.setdiachi("Quảng Nam");
		nv2.setgioitinh("Nam");
		nv2.setluong(5000000);
//		System.out.println("Tên nhân viên là: "+nv2.getten());
//		System.out.println("Tuổi: "+nv2.gettuoi());
//		System.out.println("Địa chỉ: "+nv2.getdiachi());
//		System.out.println("Giới tính: "+nv2.getgioitinh());
//		System.out.println("Lương: "+nv2.getluong());
		
		nhanvien nv3 = new nhanvien();
		nv3.setten("Huỳnh Khánh Ông Già");
		nv3.settuoi(29);
		nv3.setdiachi("Đà Nẵng");
		nv3.setgioitinh("Nam");
		nv3.setluong(5000000);
//		System.out.println("Tên nhân viên là: "+nv3.getten());
//		System.out.println("Tuổi: "+nv3.gettuoi());
//		System.out.println("Địa chỉ: "+nv3.getdiachi());
//		System.out.println("Giới tính: "+nv3.getgioitinh());
//		System.out.println("Lương: "+nv3.getluong());
		
		System.out.printf("%-25s | %4s | %10s | %10s | %10s \n","Họ và tên", "Tuổi", "Địa chỉ", "Giới tính", "Lương");
		System.out.printf("%-25s | %4s | %10s | %10s | %10s \n",nv1.getten(), nv1.gettuoi(), nv1.getdiachi(), nv1.getgioitinh(), nv1.getluong());
		System.out.printf("%-25s | %4s | %10s | %10s | %10s \n",nv2.getten(), nv2.gettuoi(), nv2.getdiachi(), nv2.getgioitinh(), nv2.getluong());
		System.out.printf("%-25s | %4s | %10s | %10s | %10s \n",nv3.getten(), nv3.gettuoi(), nv3.getdiachi(), nv3.getgioitinh(), nv3.getluong());
	}
}
