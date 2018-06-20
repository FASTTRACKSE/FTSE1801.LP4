package java_d3;

import java.util.Scanner;

public class nhanvien {

		// thuộc tính(properties)
		String name;
		int yearold;
		String add;
		String sex;
		double salary;
		
		nhanvien(){
			name="luan";
			yearold=23;
			add="Hoian";
			sex="male";
			salary=5000;
		}
		nhanvien(String name,int yearold,String add, String sex,double salary){
			this.name=name;
			this.yearold=yearold;
			this.add=add;
			this.sex=sex;
			this.salary=salary;
		}
		
		
		//Phương thức (method)
		
		
		void setName(String name){
			this.name=name;
		}
		
		void setYearold(int yearold) {
			this.yearold=yearold;
		}
		
		void setAdd(String add) {
			this.add=add;
		}
		
		void setSex(String sex){
			this.sex=sex;
		}
		
		void setSalary(double salary) {
			this.salary=salary;
		}
		
		String getName() {
			return name;
			
		}
		
		int getYearold() {
			return yearold;
		}
		
		String getAdd() {
			return add;
		}
		
		String getSex() {
			return sex;
		}
		
		double getSalary() {
			return salary;
		}
		
		String xepluong() {
			if(salary<10000) {
				return "Low";
			}else {
				return "High";
			}
		}
		
		
		
		
		
		
		
		public static void main(String[] args) {
			
			
			MayTinh mt=new MayTinh();
			
			System.out.println("Sum a+b= "+mt.sum(1, 5));
			System.out.println("Sum a+b+c= "+mt.sum(2, 4, 5));
			
			
			
			
			
			String ten,diachi,gioitinh;
			int tuoi;
			double luong;
			Scanner sc= new Scanner(System.in);
			
			System.out.print("Add name: ");
			ten=sc.next();
			System.out.print("Add yearOld: ");
			tuoi=sc.nextInt();
			System.out.print("Add Address: ");
			diachi=sc.next();
			System.out.print("Add Sex: ");
			gioitinh=sc.next();
			System.out.print("Add Salary: ");
			luong=sc.nextDouble();
			sc.close();
			
			nhanvien nv=new nhanvien();
			
			nhanvien nv2=new nhanvien("manh",21,"chuse","female",10000);
			
			nhanvien nv1=new nhanvien();
			nv1.setName(ten);
			nv1.setYearold(tuoi);
			nv1.setAdd(diachi);
			nv1.setSex(gioitinh);
			nv1.setSalary(luong);
			System.out.println(nv1.getName()+"|"+nv1.getYearold()+"|"+nv1.getAdd()+"|"+nv1.getSex()+"|"+nv1.getSalary()+"|"+nv1.xepluong());
			
			System.out.println(nv.getName()+"|"+nv.getYearold()+"|"+nv.getAdd()+"|"+nv.getSex()+"|"+nv.getSalary()+"|"+nv.xepluong());
			
			System.out.println(nv2.getName()+"|"+nv2.getYearold()+"|"+nv2.getAdd()+"|"+nv2.getSex()+"|"+nv2.getSalary()+"|"+nv2.xepluong());
			
			
			
			
			
		}
		
	

}
