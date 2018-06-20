package java_unit3;

import java.util.Scanner;

public class nhanVien {
	// thuộc tính (Properties)
	String ten;
	int tuoi;
	String diaChi;
	String gioiTinh;
	double luong;

	nhanVien(){
		ten = "Mạnh";
		tuoi = 12;
		diaChi = "Chư Sê";
		gioiTinh = "Nam";
		luong = 10000;
	}
	
	nhanVien(String ten, int tuoi){
		this.ten = ten;
		this.tuoi = tuoi;
	}
	// phương thức (method)
	void setName(String ten) {
		this.ten = ten;
	}

	void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	void setgioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	void setLuong(double luong) {
		this.luong = luong;
	}

	String getName() {
		return ten;
	}

	int getTuoi() {
		return tuoi;
	}

	String getDiaChi() {
		return diaChi;
	}

	String getGioiTinh() {
		return gioiTinh;
	}

	double getLuong() {
		return luong;
	}

	String getXepLuong() {
		if (this.luong > 10000) {
			return "Lương cao";
		} else {
			return "Lương thấp";
		}
	}

	public static void main(String[] args) {
		String name, add, sex;
		int old;
		double salary;
		// overload
		mayTinh mt = new mayTinh();
		System.out.println("Tông a + b = " + mt.sum(3, 5));
		System.out.println("Tông a + b + c = " + mt.sum(3, 5, 7) + "\n\n\n");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập tên nhân viên : ");
		name = input.nextLine();
		System.out.print("Nhập tuổi nhân viên : ");
		old = input.nextInt();
		input.nextLine();
		System.out.print("Nhập địa chỉ nhân viên : ");
		add = input.nextLine();
		System.out.print("Nhập giới tính nhân viên : ");
		sex = input.nextLine();
		System.out.print("Nhập lương nhân viên : ");
		salary = input.nextDouble();
		input.close();
		
		nhanVien nv = new nhanVien();
		
		nhanVien nv2 = new nhanVien("Luân", 23);
		
		nhanVien nv1 = new nhanVien();
		nv1.setName(name);
		nv1.setDiaChi(add);
		nv1.setgioiTinh(sex);
		nv1.setTuoi(old);
		nv1.setLuong(salary);
		
		System.out.println("Không có đối số : ");
		System.out.println(nv.getName() + " | " + nv.getTuoi() + " | " + nv.getGioiTinh() + " | " + nv.getDiaChi()
		+ " | " + nv.getLuong() + " | " + nv.getXepLuong() + "\n");
		
		System.out.println("Có đối số : ");
		System.out.println(nv2.getName() + " | " + nv2.getTuoi() + " | " + nv2.getGioiTinh() + " | " + nv2.getDiaChi()
		+ " | " + nv2.getLuong() + " | " + nv2.getXepLuong() + "\n");
		
		System.out.println("Nhập từ bàn phím : ");
		System.out.println(nv1.getName() + " | " + nv1.getTuoi() + " | " + nv1.getGioiTinh() + " | " + nv1.getDiaChi()
				+ " | " + nv1.getLuong() + " | " + nv1.getXepLuong() + "\n");
		
		


	}
}
