package MangArrayList;

import java.util.ArrayList;

public class ViDu {
	ArrayList<String> listString;
	public ViDu() {
		listString = new ArrayList<String>();
	}
	
	//Thêm phần tử
	public void addSV(String ten) {
		listString.add(ten);
	}
	
	// Đếm số lượng phần tử
	public void soLuongPhanTu() {
		System.out.println("Số lượng phần tử là : " + listString.size());
	}
	
	public void deleteSV(int index) {
		listString.remove(index);
	}
	
	//Xet xem mảng có phần tử nào không
	public void xetMang() {
		if(listString.isEmpty()) {
			System.out.println("Mảng không có phần tử nào");
		}else {
			System.out.println("Mảng đã có phần tử");
		}
	}
	
	//In ra danh sách của vị trí hiện tại
	public void inGet(int index) {
		listString.get(index);
	}
	
	//In ra all danh sach
	public void showAll() {
		for(int i = 0; i < listString.size() ;i++) {
			System.out.println(listString.get(i));
		}
			
	}
	
	//Sửa phần tử
	public void setSV(int index, String element) {
		listString.set(index, element);

	}
	
	public static void main(String[] args) {
		ViDu vd = new ViDu();
		vd.soLuongPhanTu();
		vd.xetMang();
		vd.addSV("Nam");
		vd.xetMang();
		vd.addSV("Mạnh");
		vd.addSV("Luân");
		vd.addSV("Công");
		vd.showAll();
		vd.soLuongPhanTu();
		vd.deleteSV(2);
		vd.showAll();
		vd.soLuongPhanTu();
		vd.setSV(0, "Hợi");
		vd.showAll();
		
	}
}
